package com.netbrasoft.gnuob.api.setting;

import static com.netbrasoft.gnuob.api.Rule.DELETE_ACCESS;
import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.SETTING_DATA_PROVIDER_NAME;
import static org.junit.Assert.assertEquals;
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
public class SettingDataProviderTest {

  @Deployment
  public static Archive<?> createDeployment() {
    return Utils.createDeployment();
  }

  @Autowired
  @Qualifier(SETTING_DATA_PROVIDER_NAME)
  private AbstractGenericTypeDataProvider<Setting> settingDataProvider;

  private Setting setting;

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Before
  public void setUp() throws Exception {
    setting = new Setting();
    setting.setActive(true);
    setting.setId(0L);
    setting.setVersion(0);
    setting.setProperty("Folly words widow one downs few age every seven.");
    setting.setValue("Folly words widow one downs few age every seven.");
    setting.setDescription("Folly words widow one downs few age every seven.");
    setting.setPermission(new Permission());
    setting.getPermission().setId(0L);
    setting.getPermission().setVersion(0);
    setting.getPermission().setOwner(DELETE_ACCESS);
    setting.getPermission().setGroup(DELETE_ACCESS);
    setting.getPermission().setOthers(DELETE_ACCESS);
    settingDataProvider.setUser("root");
    settingDataProvider.setPassword("root");
    settingDataProvider.setSite("domain");
    settingDataProvider.getType().setActive(true);
    setting = settingDataProvider.persist(setting);
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testSizeAsRoot() {
    settingDataProvider.setUser("root");
    settingDataProvider.setPassword("root");
    assertEquals("Size", 2L, settingDataProvider.size());
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testSizeAsAdministrator() {
    settingDataProvider.setUser("administrator");
    settingDataProvider.setPassword("administrator");
    assertEquals("Size", 2L, settingDataProvider.size());
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testSizeAsManager() {
    settingDataProvider.setUser("manager");
    settingDataProvider.setPassword("manager");
    assertEquals("Size", 2L, settingDataProvider.size());
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testSizeAsEmployee() {
    settingDataProvider.setUser("employee");
    settingDataProvider.setPassword("employee");
    assertEquals("Size", 2L, settingDataProvider.size());
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testSizeAsGuest() {
    settingDataProvider.setUser("guest");
    settingDataProvider.setPassword("guest");
    assertEquals("Size", 2L, settingDataProvider.size());
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testSizeAsStudent() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [student] doesn't have the right access to read this entity object, verify that the given user has access (ERR01)");
    settingDataProvider.setUser("student");
    settingDataProvider.setPassword("student");
    settingDataProvider.size();
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testIteratorAsRoot() {
    settingDataProvider.setUser("root");
    settingDataProvider.setPassword("root");
    assertTrue("Iterator", settingDataProvider.iterator(0, 1).hasNext());
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testIteratorAsAdministrator() {
    settingDataProvider.setUser("administrator");
    settingDataProvider.setPassword("administrator");
    assertTrue("Iterator", settingDataProvider.iterator(0, 1).hasNext());
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testIteratorAsManager() {
    settingDataProvider.setUser("manager");
    settingDataProvider.setPassword("manager");
    assertTrue("Iterator", settingDataProvider.iterator(0, 1).hasNext());
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testIteratorAsEmployee() {
    settingDataProvider.setUser("employee");
    settingDataProvider.setPassword("employee");
    assertTrue("Iterator", settingDataProvider.iterator(0, 1).hasNext());
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testIteratorAsGuest() {
    settingDataProvider.setUser("guest");
    settingDataProvider.setPassword("guest");
    assertTrue("Iterator", settingDataProvider.iterator(0, 1).hasNext());
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testIteratorAsStudent() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [student] doesn't have the right access to read this entity object, verify that the given user has access (ERR01)");
    settingDataProvider.setUser("student");
    settingDataProvider.setPassword("student");
    settingDataProvider.iterator(0, 1);
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testFindByIdAsRoot() {
    settingDataProvider.setUser("root");
    settingDataProvider.setPassword("root");
    assertNotNull("FindById", settingDataProvider.findById(setting));
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testFindByIdAsAdministrator() {
    settingDataProvider.setUser("administrator");
    settingDataProvider.setPassword("administrator");
    assertNotNull("FindById", settingDataProvider.findById(setting));
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testFindByIdAsManager() {
    settingDataProvider.setUser("manager");
    settingDataProvider.setPassword("manager");
    assertNotNull("FindById", settingDataProvider.findById(setting));
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testFindByIdAsEmployee() {
    settingDataProvider.setUser("employee");
    settingDataProvider.setPassword("employee");
    assertNotNull("FindById", settingDataProvider.findById(setting));
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testFindByIdAsGuest() {
    settingDataProvider.setUser("guest");
    settingDataProvider.setPassword("guest");
    assertNotNull("FindById", settingDataProvider.findById(setting));
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testFindByIdAsStudent() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [student] doesn't have the right access to read this entity object, verify that the given user has access (ERR01)");
    settingDataProvider.setUser("student");
    settingDataProvider.setPassword("student");
    settingDataProvider.findById(setting);
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testPersist() {

  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testMergeAsRoot() {
    settingDataProvider.setUser("root");
    settingDataProvider.setPassword("root");
    assertNotNull("Merge", settingDataProvider.merge(setting));
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testMergeAsAdministrator() {
    settingDataProvider.setUser("administrator");
    settingDataProvider.setPassword("administrator");
    assertNotNull("Merge", settingDataProvider.merge(setting));
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testMergeAsManager() {
    settingDataProvider.setUser("manager");
    settingDataProvider.setPassword("manager");
    assertNotNull("Merge", settingDataProvider.merge(setting));
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testMergeAsEmployee() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [employee] doesn't have the right access to update this entity object, verify that the given user has access (ERR01)");
    settingDataProvider.setUser("employee");
    settingDataProvider.setPassword("employee");
    assertNotNull("Merge", settingDataProvider.merge(setting));
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testMergeAsGuest() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [guest] doesn't have the right access to update this entity object, verify that the given user has access (ERR01)");
    settingDataProvider.setUser("guest");
    settingDataProvider.setPassword("guest");
    settingDataProvider.merge(setting);
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testMergeAsStudent() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [student] doesn't have the right access to update this entity object, verify that the given user has access (ERR01)");
    settingDataProvider.setUser("student");
    settingDataProvider.setPassword("student");
    settingDataProvider.merge(setting);
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testRefreshAsRoot() {
    settingDataProvider.setUser("root");
    settingDataProvider.setPassword("root");
    assertNotNull("Refresh", settingDataProvider.refresh(setting));
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testRefreshAsAdministrator() {
    settingDataProvider.setUser("administrator");
    settingDataProvider.setPassword("administrator");
    assertNotNull("Refresh", settingDataProvider.refresh(setting));
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testRefreshAsManager() {
    settingDataProvider.setUser("manager");
    settingDataProvider.setPassword("manager");
    assertNotNull("Refresh", settingDataProvider.refresh(setting));
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testRefreshAsEmployee() {
    settingDataProvider.setUser("employee");
    settingDataProvider.setPassword("employee");
    assertNotNull("Refresh", settingDataProvider.refresh(setting));
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testRefreshAsGuest() {
    settingDataProvider.setUser("guest");
    settingDataProvider.setPassword("guest");
    assertNotNull("Refresh", settingDataProvider.refresh(setting));
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testRefreshAsStudent() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [student] doesn't have the right access to read this entity object, verify that the given user has access (ERR01)");
    settingDataProvider.setUser("student");
    settingDataProvider.setPassword("student");
    settingDataProvider.refresh(setting);
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testRemoveAsRoot() {
    settingDataProvider.setUser("root");
    settingDataProvider.setPassword("root");
    settingDataProvider.remove(setting);
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testRemoveAsAdministrator() {
    settingDataProvider.setUser("administrator");
    settingDataProvider.setPassword("administrator");
    settingDataProvider.remove(setting);
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testRemoveAsManager() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [manager] doesn't have the right access to delete this entity object, verify that the given user has access (ERR01)");
    settingDataProvider.setUser("manager");
    settingDataProvider.setPassword("manager");
    settingDataProvider.remove(setting);
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testRemoveAsEmployee() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [employee] doesn't have the right access to delete this entity object, verify that the given user has access (ERR01)");
    settingDataProvider.setUser("employee");
    settingDataProvider.setPassword("employee");
    settingDataProvider.remove(setting);
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testRemoveAsGuest() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [guest] doesn't have the right access to delete this entity object, verify that the given user has access (ERR01)");
    settingDataProvider.setUser("guest");
    settingDataProvider.setPassword("guest");
    settingDataProvider.remove(setting);
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testRemoveAsStudent() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [student] doesn't have the right access to delete this entity object, verify that the given user has access (ERR01)");
    settingDataProvider.setUser("student");
    settingDataProvider.setPassword("student");
    settingDataProvider.remove(setting);
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testRemoveAsStudentWrongPassword() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [student] doesn't have the right access, verify that the given user has access (ERR02)");
    settingDataProvider.setUser("student");
    settingDataProvider.setPassword("wrong");
    settingDataProvider.remove(setting);
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testRemoveAsWrongUser() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [wrong] doesn't have the right access, verify that the given user has access (ERR03)");
    settingDataProvider.setUser("wrong");
    settingDataProvider.setPassword("wrong");
    settingDataProvider.remove(setting);
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testRemoveAsStudentUnknownSite() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given site [wrong] doesn't have the right access, verify that the given site has access (ERR01)");
    settingDataProvider.setUser("student");
    settingDataProvider.setPassword("student");
    settingDataProvider.setSite("wrong");
    settingDataProvider.remove(setting);
  }

  @Test
  @ApplyScriptBefore({"scripts/scriptsToExecuteBeforeTest.sql"})
  @UsingDataSet("datasets/settings.xml")
  public void testRemoveAsStudentWrongSite() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [student] doesn't have the right access for site [dummy], verify that the given user have access to the site (ERR04)");
    settingDataProvider.setUser("student");
    settingDataProvider.setPassword("student");
    settingDataProvider.setSite("dummy");
    settingDataProvider.remove(setting);
  }
}
