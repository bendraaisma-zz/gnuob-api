/*
 * Copyright 2016 Netbrasoft
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.netbrasoft.gnuob.api.setting;

import static com.netbrasoft.gnuob.api.Rule.DELETE_ACCESS;
import static com.netbrasoft.gnuob.api.Rule.NONE_ACCESS;
import static com.netbrasoft.gnuob.api.Rule.READ_ACCESS;
import static com.netbrasoft.gnuob.api.Rule.UPDATE_ACCESS;
import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.SETTING_DATA_PROVIDER_NAME;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.ApplyScriptBefore;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.spring.integration.test.annotation.SpringWebConfiguration;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.netbrasoft.gnuob.api.Permission;
import com.netbrasoft.gnuob.api.Setting;
import com.netbrasoft.gnuob.api.generic.AbstractGenericTypeDataProvider;
import com.netbrasoft.gnuob.api.generic.GNUOpenBusinessApplicationException;
import com.netbrasoft.gnuob.generic.utils.Utils;

@RunWith(Arquillian.class)
@SpringWebConfiguration()
public class SettingDataProviderOldTest {

  @Deployment
  public static Archive<?> createDeployment() {
    return Utils.createDeployment();
  }

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  private Setting setting;

  @Autowired
  @Qualifier(SETTING_DATA_PROVIDER_NAME)
  private AbstractGenericTypeDataProvider<Setting> settingDataProvider;

  @Before
  public void setUp() {
    setting = new Setting();
    setting.setActive(true);
    setting.setId(400L);
    setting.setVersion(0);
    setting.setProperty("Folly words widow one downs few age every seven.");
    setting.setValue("Folly words widow one downs few age every seven.");
    setting.setDescription("Folly words widow one downs few age every seven.");
    setting.setPermission(new Permission());
    setting.getPermission().setId(400L);
    setting.getPermission().setVersion(0);
    setting.getPermission().setOwner(DELETE_ACCESS);
    setting.getPermission().setGroup(READ_ACCESS);
    setting.getPermission().setOthers(READ_ACCESS);
    settingDataProvider.setUser("administrator");
    settingDataProvider.setPassword("administrator");
    settingDataProvider.setSite("localhost");
    settingDataProvider.getType().setActive(true);
  }

  @After
  public void tearDown() {}

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testFindSettingByIdAndGetNoEntityFoundExceptionOne() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage("No entity found by the given id and type (ERR01)");
    Setting settingById = new Setting();
    settingById.setId(401L);
    settingDataProvider.findById(settingById);
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testFindSettingByIdAndGetNoAccessExceptionOne() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [guest] doesn't have the right access to read this entity object, verify that the given user has access (ERR01)");
    Setting settingById = new Setting();
    settingById.setId(400L);
    settingDataProvider.setUser("guest");
    settingDataProvider.setPassword("guest");
    settingDataProvider.findById(settingById);
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testFindSettingByIdAsUserWithGroupOwnerShipAccess() {
    Setting settingById = new Setting();
    settingById.setActive(true);
    settingById.setId(400L);
    settingDataProvider.setUser("employee");
    settingDataProvider.setPassword("employee");
    Setting detachedSetting = settingDataProvider.findById(settingById);
    assertEquals("Property", "Folly words widow one downs few age every seven.", detachedSetting.getProperty());
    assertEquals("Description", "Folly words widow one downs few age every seven.", detachedSetting.getDescription());
    assertEquals("Value", "Folly words widow one downs few age every seven.", detachedSetting.getValue());
    assertTrue("Id", detachedSetting.getId() != 0);
    assertTrue("Permission.Id", detachedSetting.getPermission().getId() != 0);
    assertEquals("Permission.Owner", DELETE_ACCESS, detachedSetting.getPermission().getOwner());
    assertEquals("Permission.Group", READ_ACCESS, detachedSetting.getPermission().getGroup());
    assertEquals("Permission.Others", READ_ACCESS, detachedSetting.getPermission().getOthers());
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testFindSettingByIdAsRootUser() {
    Setting settingById = new Setting();
    settingById.setActive(true);
    settingById.setId(400L);
    Setting detachedSetting = settingDataProvider.findById(settingById);
    assertEquals("Property", "Folly words widow one downs few age every seven.", detachedSetting.getProperty());
    assertEquals("Description", "Folly words widow one downs few age every seven.", detachedSetting.getDescription());
    assertEquals("Value", "Folly words widow one downs few age every seven.", detachedSetting.getValue());
    assertTrue("Id", detachedSetting.getId() != 0);
    assertTrue("Permission.Id", detachedSetting.getPermission().getId() != 0);
    assertEquals("Permission.Owner", DELETE_ACCESS, detachedSetting.getPermission().getOwner());
    assertEquals("Permission.Group", READ_ACCESS, detachedSetting.getPermission().getGroup());
    assertEquals("Permission.Others", READ_ACCESS, detachedSetting.getPermission().getOthers());
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testIteratorSetting() {
    Setting detachedSetting = settingDataProvider.iterator(0, 1).next();
    assertEquals("Property", "Folly words widow one downs few age every seven.", detachedSetting.getProperty());
    assertEquals("Description", "Folly words widow one downs few age every seven.", detachedSetting.getDescription());
    assertEquals("Value", "Folly words widow one downs few age every seven.", detachedSetting.getValue());
    assertTrue("Id", detachedSetting.getId() != 0);
    assertTrue("Permission.Id", detachedSetting.getPermission().getId() != 0);
    assertEquals("Permission.Owner", DELETE_ACCESS, detachedSetting.getPermission().getOwner());
    assertEquals("Permission.Group", READ_ACCESS, detachedSetting.getPermission().getGroup());
    assertEquals("Permission.Others", READ_ACCESS, detachedSetting.getPermission().getOthers());
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testIteratorSettingAndGetNotExtractResultSetException() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage("could not extract ResultSet");
    assertFalse("Iterator", settingDataProvider.iterator(1, 1).hasNext());
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testMergeSettingAsUserWithGroupOwnerShipAccess() {
    setting.setId(0L);
    setting.setVersion(0);
    setting.setPermission(null);
    Setting detachedSetting = settingDataProvider.persist(setting);
    detachedSetting.getPermission().setGroup(UPDATE_ACCESS);
    detachedSetting.setDescription(".neves yreve ega wef snwod eno wodiw sdrow ylloF");
    detachedSetting = settingDataProvider.merge(detachedSetting);
    detachedSetting.getPermission().setGroup(DELETE_ACCESS);
    detachedSetting.getPermission().setOthers(UPDATE_ACCESS);
    detachedSetting.setProperty(".neves yreve ega wef snwod eno wodiw sdrow ylloF");
    settingDataProvider.setUser("employee");
    settingDataProvider.setPassword("employee");
    detachedSetting = settingDataProvider.merge(detachedSetting);
    assertEquals("Property", ".neves yreve ega wef snwod eno wodiw sdrow ylloF", detachedSetting.getProperty());
    assertEquals("Description", ".neves yreve ega wef snwod eno wodiw sdrow ylloF", detachedSetting.getDescription());
    assertEquals("Value", "Folly words widow one downs few age every seven.", detachedSetting.getValue());
    assertTrue("Id", detachedSetting.getId() != 0);
    assertTrue("Version", detachedSetting.getVersion() > 0);
    assertTrue("Permission.Id", detachedSetting.getPermission().getId() != 0);
    assertTrue("Permission.Version", detachedSetting.getPermission().getVersion() > 0);
    assertEquals("Permission.Owner", DELETE_ACCESS, detachedSetting.getPermission().getOwner());
    assertEquals("Permission.Group", DELETE_ACCESS, detachedSetting.getPermission().getGroup());
    assertEquals("Permission.Others", UPDATE_ACCESS, detachedSetting.getPermission().getOthers());
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testMergeSettingAndGetNoAccessExceptionOne() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [guest] doesn't have the right access to update this entity object, verify that the given user has access (ERR01)");
    setting.setId(0L);
    setting.setVersion(0);
    setting.setPermission(null);
    Setting detachedSetting = settingDataProvider.persist(setting);
    detachedSetting.getPermission().setOthers(UPDATE_ACCESS);
    detachedSetting.setDescription(".neves yreve ega wef snwod eno wodiw sdrow ylloF");
    detachedSetting = settingDataProvider.merge(detachedSetting);
    detachedSetting.setPermission(null);
    detachedSetting.setProperty(".neves yreve ega wef snwod eno wodiw sdrow ylloF");
    settingDataProvider.setUser("guest");
    settingDataProvider.setPassword("guest");
    detachedSetting = settingDataProvider.merge(detachedSetting);
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testMergeSettingAsUserWithOthersOwnerShipAccess() {
    setting.setId(0L);
    setting.setVersion(0);
    setting.setPermission(null);
    Setting detachedSetting = settingDataProvider.persist(setting);
    detachedSetting.getPermission().setOthers(UPDATE_ACCESS);
    detachedSetting.setDescription(".neves yreve ega wef snwod eno wodiw sdrow ylloF");
    detachedSetting = settingDataProvider.merge(detachedSetting);
    detachedSetting.setPermission(null);
    detachedSetting.setProperty(".neves yreve ega wef snwod eno wodiw sdrow ylloF");
    settingDataProvider.setUser("employee");
    settingDataProvider.setPassword("employee");
    detachedSetting = settingDataProvider.merge(detachedSetting);
    assertEquals("Property", ".neves yreve ega wef snwod eno wodiw sdrow ylloF", detachedSetting.getProperty());
    assertEquals("Description", ".neves yreve ega wef snwod eno wodiw sdrow ylloF", detachedSetting.getDescription());
    assertEquals("Value", "Folly words widow one downs few age every seven.", detachedSetting.getValue());
    assertTrue("Id", detachedSetting.getId() != 0);
    assertTrue("Version", detachedSetting.getVersion() > 0);
    assertTrue("Permission.Id", detachedSetting.getPermission().getId() != 0);
    assertTrue("Permission.Version", detachedSetting.getPermission().getVersion() > 0);
    assertEquals("Permission.Owner", DELETE_ACCESS, detachedSetting.getPermission().getOwner());
    assertEquals("Permission.Group", READ_ACCESS, detachedSetting.getPermission().getGroup());
    assertEquals("Permission.Others", UPDATE_ACCESS, detachedSetting.getPermission().getOthers());
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testMergeSettingAsRootUser() {
    setting.setId(0L);
    setting.setVersion(0);
    setting.setPermission(null);
    Setting detachedSetting = settingDataProvider.persist(setting);
    detachedSetting.getPermission().setGroup(READ_ACCESS);
    detachedSetting.setDescription(".neves yreve ega wef snwod eno wodiw sdrow ylloF");
    detachedSetting = settingDataProvider.merge(detachedSetting);
    assertEquals("Property", "Folly words widow one downs few age every seven.", detachedSetting.getProperty());
    assertEquals("Description", ".neves yreve ega wef snwod eno wodiw sdrow ylloF", detachedSetting.getDescription());
    assertEquals("Value", "Folly words widow one downs few age every seven.", detachedSetting.getValue());
    assertTrue("Id", detachedSetting.getId() != 0);
    assertTrue("Version", detachedSetting.getVersion() == 1);
    assertTrue("Permission.Id", detachedSetting.getPermission().getId() != 0);
    assertTrue("Permission.Version", detachedSetting.getPermission().getVersion() == 1);
    assertEquals("Permission.Owner", DELETE_ACCESS, detachedSetting.getPermission().getOwner());
    assertEquals("Permission.Group", READ_ACCESS, detachedSetting.getPermission().getGroup());
    assertEquals("Permission.Others", READ_ACCESS, detachedSetting.getPermission().getOthers());
  }


  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testMergeSettingAndGetNoAccessExceptionTwo() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [employee] doesn't have the right access to update this entity object, verify that the given user has access (ERR02)");
    setting.setId(0L);
    setting.setVersion(0);
    setting.setPermission(null);
    settingDataProvider.setUser("employee");
    settingDataProvider.setPassword("employee");
    Setting detachedSetting = settingDataProvider.persist(setting);
    detachedSetting.getPermission().setOwner(NONE_ACCESS);
    detachedSetting.getPermission().setGroup(NONE_ACCESS);
    detachedSetting.getPermission().setOthers(NONE_ACCESS);
    detachedSetting = settingDataProvider.merge(detachedSetting);
    detachedSetting = settingDataProvider.merge(detachedSetting);
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testMergeSettingAsUserWithOwnerOwnerShipAccess() {
    setting.setId(0L);
    setting.setVersion(0);
    setting.setPermission(null);
    settingDataProvider.setUser("employee");
    settingDataProvider.setPassword("employee");
    Setting detachedSetting = settingDataProvider.persist(setting);
    detachedSetting.setDescription(".neves yreve ega wef snwod eno wodiw sdrow ylloF");
    detachedSetting = settingDataProvider.merge(detachedSetting);
    assertEquals("Property", "Folly words widow one downs few age every seven.", detachedSetting.getProperty());
    assertEquals("Description", ".neves yreve ega wef snwod eno wodiw sdrow ylloF", detachedSetting.getDescription());
    assertEquals("Value", "Folly words widow one downs few age every seven.", detachedSetting.getValue());
    assertTrue("Id", detachedSetting.getId() != 0);
    assertTrue("Version", detachedSetting.getVersion() == 1);
    assertTrue("Permission.Id", detachedSetting.getPermission().getId() != 0);
    assertTrue("Permission.Version", detachedSetting.getPermission().getVersion() == 1);
    assertEquals("Permission.Owner", DELETE_ACCESS, detachedSetting.getPermission().getOwner());
    assertEquals("Permission.Group", READ_ACCESS, detachedSetting.getPermission().getGroup());
    assertEquals("Permission.Others", READ_ACCESS, detachedSetting.getPermission().getOthers());
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testPersistSettingAndGetNoAccessExceptionOne() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [guest] doesn't have the right access to create this entity object, verify that the given user has access (ERR01)");
    setting.setId(0L);
    setting.setVersion(0);
    setting.setPermission(null);
    settingDataProvider.setUser("guest");
    settingDataProvider.setPassword("guest");
    settingDataProvider.persist(setting);
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testPersistSettingWithNullPermissionAsRootUser() {
    setting.setId(0L);
    setting.setVersion(0);
    setting.setPermission(null);
    Setting detachedSetting = settingDataProvider.persist(setting);
    assertEquals("Property", "Folly words widow one downs few age every seven.", detachedSetting.getProperty());
    assertEquals("Description", "Folly words widow one downs few age every seven.", detachedSetting.getDescription());
    assertEquals("Value", "Folly words widow one downs few age every seven.", detachedSetting.getValue());
    assertTrue("Id", detachedSetting.getId() != 0);
    assertNotNull("Permission", detachedSetting.getPermission());
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testPersistSettingWithPermissionAsUserWithGroupOwnerShipAccess() {
    setting.setId(0L);
    setting.setVersion(0);
    setting.getPermission().setId(0L);
    settingDataProvider.setUser("employee");
    settingDataProvider.setPassword("employee");
    setting.getPermission().setVersion(0);
    Setting detachedSetting = settingDataProvider.persist(setting);
    assertEquals("Property", "Folly words widow one downs few age every seven.", detachedSetting.getProperty());
    assertEquals("Description", "Folly words widow one downs few age every seven.", detachedSetting.getDescription());
    assertEquals("Value", "Folly words widow one downs few age every seven.", detachedSetting.getValue());
    assertTrue("Id", detachedSetting.getId() != 0);
    assertTrue("Permission.Id", detachedSetting.getPermission().getId() != 0);
    assertEquals("Permission.Owner", DELETE_ACCESS, detachedSetting.getPermission().getOwner());
    assertEquals("Permission.Group", READ_ACCESS, detachedSetting.getPermission().getGroup());
    assertEquals("Permission.Others", READ_ACCESS, detachedSetting.getPermission().getOthers());
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testRefresh() {
    // fail("Not yet implemented");
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testRemoveSettingAndGetNoEntityFoundExceptionOne() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage("Entity object is not found in database, access is denied (ERR03)");
    setting.setId(11111L);
    setting.setVersion(0);
    setting.setPermission(null);
    settingDataProvider.remove(setting);
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testRemoveSettingAsUserWithGroupOwnerShipAccessAndGetNoEntityFoundExceptionOne() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage("No entity found by the given id and type (ERR01)");
    setting.setId(0L);
    setting.setVersion(0);
    setting.setPermission(null);
    Setting detachedSetting = settingDataProvider.persist(setting);
    detachedSetting.getPermission().setGroup(DELETE_ACCESS);
    detachedSetting = settingDataProvider.merge(detachedSetting);
    settingDataProvider.setUser("employee");
    settingDataProvider.setPassword("employee");
    settingDataProvider.remove(detachedSetting);
    settingDataProvider.findById(detachedSetting);
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testRemoveWithNoAccess() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [guest] doesn't have the right access to delete this entity object, verify that the given user has access (ERR01)");
    setting.setId(0L);
    setting.setVersion(0);
    setting.setPermission(null);
    Setting detachedSetting = settingDataProvider.persist(setting);
    settingDataProvider.setUser("guest");
    settingDataProvider.setPassword("guest");
    settingDataProvider.remove(detachedSetting);
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testRemoveWithNoDeleteAccess() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [employee] doesn't have the right access to delete this entity object, verify that the given user has access (ERR02)");
    setting.setId(0L);
    setting.setVersion(0);
    setting.setPermission(null);
    Setting detachedSetting = settingDataProvider.persist(setting);
    detachedSetting = settingDataProvider.merge(detachedSetting);
    settingDataProvider.setUser("employee");
    settingDataProvider.setPassword("employee");
    settingDataProvider.remove(detachedSetting);
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testRemoveWithNoRootAccess() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage("No entity found by the given id and type (ERR01)");
    setting.setId(0L);
    setting.setVersion(0);
    setting.setPermission(null);
    settingDataProvider.setUser("employee");
    settingDataProvider.setPassword("employee");
    Setting detachedSetting = settingDataProvider.persist(setting);
    settingDataProvider.remove(detachedSetting);
    settingDataProvider.findById(detachedSetting);
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testRemoveWithOthersAccess() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage("No entity found by the given id and type (ERR01)");
    setting.setId(0L);
    setting.setVersion(0);
    setting.setPermission(null);
    Setting detachedSetting = settingDataProvider.persist(setting);
    detachedSetting.getPermission().setOthers(DELETE_ACCESS);
    detachedSetting = settingDataProvider.merge(detachedSetting);
    settingDataProvider.setUser("employee");
    settingDataProvider.setPassword("employee");
    settingDataProvider.remove(detachedSetting);
    settingDataProvider.findById(detachedSetting);
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testRemoveWithRootAccess() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage("No entity found by the given id and type (ERR01)");
    setting.setId(0L);
    setting.setVersion(0);
    setting.setPermission(null);
    Setting detachedSetting = settingDataProvider.persist(setting);
    settingDataProvider.remove(detachedSetting);
    settingDataProvider.findById(detachedSetting);
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testSizeSettingIsBiggerThenZeroWithRootAccess() {
    assertEquals("Size", 1L, settingDataProvider.size());
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testSizeSettingIsZeroWithRootAccess() {
    settingDataProvider.getType().setActive(false);
    assertEquals("Size", 0L, settingDataProvider.size());
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testSizeSettingWithNoSiteAccess() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [manager] doesn't have the right access for site [localhost], verify that the given user have access to the site (ERR04)");
    settingDataProvider.setUser("manager");
    settingDataProvider.setPassword("manager");
    settingDataProvider.size();
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testSizeSettingWithWrongSiteName() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given site [WrongSiteName] doesn't have the right access, verify that the given site has access (ERR01)");
    settingDataProvider.setSite("WrongSiteName");
    settingDataProvider.size();
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testSizeSettingWithWrongUserName() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [WrongUserName] doesn't have the right access, verify that the given user has access (ERR03)");
    settingDataProvider.setUser("WrongUserName");
    settingDataProvider.size();
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testSizeSettingWithWrongUserPassword() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [administrator] doesn't have the right access, verify that the given user has access (ERR02)");
    settingDataProvider.setPassword("WrongPassword");
    settingDataProvider.size();
  }
}
