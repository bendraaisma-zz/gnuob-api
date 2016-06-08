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

package com.netbrasoft.gnuob.api.generic;

import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.ADMINISTRATOR;
import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.DATASETS_SETTINGS_XML;
import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.EMPLOYEE;
import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.GUEST;
import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.MANAGER;
import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.ROOT;
import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL;
import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.STUDENT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.persistence.ApplyScriptBefore;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.netbrasoft.gnuob.api.AbstractType;
import com.netbrasoft.gnuob.api.generic.GNUOpenBusinessApplicationException;
import com.netbrasoft.gnuob.api.generic.IGenericTypeDataProvider;
import com.netbrasoft.gnuob.api.generic.utils.Utils;

public abstract class AbstractGenericTypeDataProviderTest<T extends AbstractType> {

  @Deployment
  public static Archive<?> createDeployment() {
    return Utils.createDeployment();
  }

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  public abstract IGenericTypeDataProvider<T> getGenericTypeProvider();

  public abstract T getType();

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testSizeAsRoot() {
    getGenericTypeProvider().setUser(ROOT);
    getGenericTypeProvider().setPassword(ROOT);
    getGenericTypeProvider().setType(getType());
    assertEquals("Size", 1L, getGenericTypeProvider().size());
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testSizeAsAdministrator() {
    getGenericTypeProvider().setUser(ADMINISTRATOR);
    getGenericTypeProvider().setPassword(ADMINISTRATOR);
    getGenericTypeProvider().setType(getType());
    assertEquals("Size", 1L, getGenericTypeProvider().size());
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testSizeAsManager() {
    getGenericTypeProvider().setUser(MANAGER);
    getGenericTypeProvider().setPassword(MANAGER);
    getGenericTypeProvider().setType(getType());
    assertEquals("Size", 1L, getGenericTypeProvider().size());
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testSizeAsEmployee() {
    getGenericTypeProvider().setUser(EMPLOYEE);
    getGenericTypeProvider().setPassword(EMPLOYEE);
    getGenericTypeProvider().setType(getType());
    assertEquals("Size", 1L, getGenericTypeProvider().size());
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testSizeAsGuest() {
    getGenericTypeProvider().setUser(GUEST);
    getGenericTypeProvider().setPassword(GUEST);
    getGenericTypeProvider().setType(getType());
    assertEquals("Size", 1L, getGenericTypeProvider().size());
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testSizeAsStudent() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [student] doesn't have the right access to read this entity object, verify that the given user has access (ERR01)");
    getGenericTypeProvider().setUser(STUDENT);
    getGenericTypeProvider().setPassword(STUDENT);
    getGenericTypeProvider().size();
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testIteratorAsRoot() {
    getGenericTypeProvider().setUser(ROOT);
    getGenericTypeProvider().setPassword(ROOT);
    getGenericTypeProvider().setType(getType());
    assertTrue("Iterator", getGenericTypeProvider().iterator(0, 1).hasNext());
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testIteratorAsAdministrator() {
    getGenericTypeProvider().setUser(ADMINISTRATOR);
    getGenericTypeProvider().setPassword(ADMINISTRATOR);
    getGenericTypeProvider().setType(getType());
    assertTrue("Iterator", getGenericTypeProvider().iterator(0, 1).hasNext());
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testIteratorAsManager() {
    getGenericTypeProvider().setUser(MANAGER);
    getGenericTypeProvider().setPassword(MANAGER);
    getGenericTypeProvider().setType(getType());
    assertTrue("Iterator", getGenericTypeProvider().iterator(0, 1).hasNext());
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testIteratorAsEmployee() {
    getGenericTypeProvider().setUser(EMPLOYEE);
    getGenericTypeProvider().setPassword(EMPLOYEE);
    getGenericTypeProvider().setType(getType());
    assertTrue("Iterator", getGenericTypeProvider().iterator(0, 1).hasNext());
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testIteratorAsGuest() {
    getGenericTypeProvider().setUser(GUEST);
    getGenericTypeProvider().setPassword(GUEST);
    getGenericTypeProvider().setType(getType());
    assertTrue("Iterator", getGenericTypeProvider().iterator(0, 1).hasNext());
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testIteratorAsStudent() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [student] doesn't have the right access to read this entity object, verify that the given user has access (ERR01)");
    getGenericTypeProvider().setUser(STUDENT);
    getGenericTypeProvider().setPassword(STUDENT);
    getGenericTypeProvider().iterator(0, 1);
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testFindByIdAsRoot() {
    getGenericTypeProvider().setUser(ROOT);
    getGenericTypeProvider().setPassword(ROOT);
    assertNotNull("FindById", getGenericTypeProvider().findById(getType()));
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testFindByIdAsAdministrator() {
    getGenericTypeProvider().setUser(ADMINISTRATOR);
    getGenericTypeProvider().setPassword(ADMINISTRATOR);
    assertNotNull("FindById", getGenericTypeProvider().findById(getType()));
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testFindByIdAsManager() {
    getGenericTypeProvider().setUser(MANAGER);
    getGenericTypeProvider().setPassword(MANAGER);
    assertNotNull("FindById", getGenericTypeProvider().findById(getType()));
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testFindByIdAsEmployee() {
    getGenericTypeProvider().setUser(EMPLOYEE);
    getGenericTypeProvider().setPassword(EMPLOYEE);
    assertNotNull("FindById", getGenericTypeProvider().findById(getType()));
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testFindByIdAsGuest() {
    getGenericTypeProvider().setUser(GUEST);
    getGenericTypeProvider().setPassword(GUEST);
    assertNotNull("FindById", getGenericTypeProvider().findById(getType()));
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testFindByIdAsStudent() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [student] doesn't have the right access to read this entity object, verify that the given user has access (ERR01)");
    getGenericTypeProvider().setUser(STUDENT);
    getGenericTypeProvider().setPassword(STUDENT);
    getGenericTypeProvider().findById(getType());
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testPersistAsRoot() {
    getGenericTypeProvider().setUser(ROOT);
    getGenericTypeProvider().setPassword(ROOT);
    assertNotNull("Persist", getGenericTypeProvider().persist(getType()));
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testPersistAsAdministrator() {
    getGenericTypeProvider().setUser(ADMINISTRATOR);
    getGenericTypeProvider().setPassword(ADMINISTRATOR);
    assertNotNull("Persist", getGenericTypeProvider().persist(getType()));
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testPersistAsManger() {
    getGenericTypeProvider().setUser(MANAGER);
    getGenericTypeProvider().setPassword(MANAGER);
    assertNotNull("Persist", getGenericTypeProvider().persist(getType()));
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testPersistAsEmployee() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [employee] doesn't have the right access to update this entity object, verify that the given user has access (ERR01)");
    getGenericTypeProvider().setUser(EMPLOYEE);
    getGenericTypeProvider().setPassword(EMPLOYEE);
    assertNotNull("Persist", getGenericTypeProvider().persist(getType()));
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testPersistAsGuest() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [guest] doesn't have the right access to update this entity object, verify that the given user has access (ERR01)");
    getGenericTypeProvider().setUser(GUEST);
    getGenericTypeProvider().setPassword(GUEST);
    assertNotNull("Persist", getGenericTypeProvider().persist(getType()));
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testPersistAsStudent() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [student] doesn't have the right access to update this entity object, verify that the given user has access (ERR01)");
    getGenericTypeProvider().setUser(STUDENT);
    getGenericTypeProvider().setPassword(STUDENT);
    assertNotNull("Persist", getGenericTypeProvider().persist(getType()));
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testMergeAsRoot() {
    getGenericTypeProvider().setUser(ROOT);
    getGenericTypeProvider().setPassword(ROOT);
    assertNotNull("Merge", getGenericTypeProvider().merge(getType()));
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testMergeAsAdministrator() {
    getGenericTypeProvider().setUser(ADMINISTRATOR);
    getGenericTypeProvider().setPassword(ADMINISTRATOR);
    assertNotNull("Merge", getGenericTypeProvider().merge(getType()));
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testMergeAsManager() {
    getGenericTypeProvider().setUser(MANAGER);
    getGenericTypeProvider().setPassword(MANAGER);
    assertNotNull("Merge", getGenericTypeProvider().merge(getType()));
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testMergeAsEmployee() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [employee] doesn't have the right access to update this entity object, verify that the given user has access (ERR01)");
    getGenericTypeProvider().setUser(EMPLOYEE);
    getGenericTypeProvider().setPassword(EMPLOYEE);
    assertNotNull("Merge", getGenericTypeProvider().merge(getType()));
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testMergeAsGuest() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [guest] doesn't have the right access to update this entity object, verify that the given user has access (ERR01)");
    getGenericTypeProvider().setUser(GUEST);
    getGenericTypeProvider().setPassword(GUEST);
    getGenericTypeProvider().merge(getType());
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testMergeAsStudent() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [student] doesn't have the right access to update this entity object, verify that the given user has access (ERR01)");
    getGenericTypeProvider().setUser(STUDENT);
    getGenericTypeProvider().setPassword(STUDENT);
    getGenericTypeProvider().merge(getType());
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testRefreshAsRoot() {
    getGenericTypeProvider().setUser(ROOT);
    getGenericTypeProvider().setPassword(ROOT);
    assertNotNull("Refresh", getGenericTypeProvider().refresh(getType()));
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testRefreshAsAdministrator() {
    getGenericTypeProvider().setUser(ADMINISTRATOR);
    getGenericTypeProvider().setPassword(ADMINISTRATOR);
    assertNotNull("Refresh", getGenericTypeProvider().refresh(getType()));
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testRefreshAsManager() {
    getGenericTypeProvider().setUser(MANAGER);
    getGenericTypeProvider().setPassword(MANAGER);
    assertNotNull("Refresh", getGenericTypeProvider().refresh(getType()));
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testRefreshAsEmployee() {
    getGenericTypeProvider().setUser(EMPLOYEE);
    getGenericTypeProvider().setPassword(EMPLOYEE);
    assertNotNull("Refresh", getGenericTypeProvider().refresh(getType()));
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testRefreshAsGuest() {
    getGenericTypeProvider().setUser(GUEST);
    getGenericTypeProvider().setPassword(GUEST);
    assertNotNull("Refresh", getGenericTypeProvider().refresh(getType()));
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testRefreshAsStudent() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [student] doesn't have the right access to read this entity object, verify that the given user has access (ERR01)");
    getGenericTypeProvider().setUser(STUDENT);
    getGenericTypeProvider().setPassword(STUDENT);
    getGenericTypeProvider().refresh(getType());
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testRemoveAsRoot() {
    getGenericTypeProvider().setUser(ROOT);
    getGenericTypeProvider().setPassword(ROOT);
    getGenericTypeProvider().remove(getType());
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testRemoveAsAdministrator() {
    getGenericTypeProvider().setUser(ADMINISTRATOR);
    getGenericTypeProvider().setPassword(ADMINISTRATOR);
    getGenericTypeProvider().remove(getType());
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testRemoveAsManager() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [manager] doesn't have the right access to delete this entity object, verify that the given user has access (ERR01)");
    getGenericTypeProvider().setUser(MANAGER);
    getGenericTypeProvider().setPassword(MANAGER);
    getGenericTypeProvider().remove(getType());
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testRemoveAsEmployee() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [employee] doesn't have the right access to delete this entity object, verify that the given user has access (ERR01)");
    getGenericTypeProvider().setUser(EMPLOYEE);
    getGenericTypeProvider().setPassword(EMPLOYEE);
    getGenericTypeProvider().remove(getType());
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testRemoveAsGuest() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [guest] doesn't have the right access to delete this entity object, verify that the given user has access (ERR01)");
    getGenericTypeProvider().setUser(GUEST);
    getGenericTypeProvider().setPassword(GUEST);
    getGenericTypeProvider().remove(getType());
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testRemoveAsStudent() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [student] doesn't have the right access to delete this entity object, verify that the given user has access (ERR01)");
    getGenericTypeProvider().setUser(STUDENT);
    getGenericTypeProvider().setPassword(STUDENT);
    getGenericTypeProvider().remove(getType());
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testRemoveAsStudentWrongPassword() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [student] doesn't have the right access, verify that the given user has access (ERR02)");
    getGenericTypeProvider().setUser(STUDENT);
    getGenericTypeProvider().setPassword("wrong");
    getGenericTypeProvider().remove(getType());
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testRemoveAsWrongUser() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [wrong] doesn't have the right access, verify that the given user has access (ERR03)");
    getGenericTypeProvider().setUser("wrong");
    getGenericTypeProvider().setPassword("wrong");
    getGenericTypeProvider().remove(getType());
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testRemoveAsStudentUnknownSite() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given site [wrong] doesn't have the right access, verify that the given site has access (ERR01)");
    getGenericTypeProvider().setUser(STUDENT);
    getGenericTypeProvider().setPassword(STUDENT);
    getGenericTypeProvider().setSite("wrong");
    getGenericTypeProvider().remove(getType());
  }

  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testRemoveAsStudentWrongSite() {
    expectedException.expect(GNUOpenBusinessApplicationException.class);
    expectedException.expectMessage(
        "Given user [student] doesn't have the right access for site [dummy], verify that the given user have access to the site (ERR04)");
    getGenericTypeProvider().setUser(STUDENT);
    getGenericTypeProvider().setPassword(STUDENT);
    getGenericTypeProvider().setSite("dummy");
    getGenericTypeProvider().remove(getType());
  }
}
