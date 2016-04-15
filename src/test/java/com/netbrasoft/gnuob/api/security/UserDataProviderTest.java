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

package com.netbrasoft.gnuob.api.security;

import static com.netbrasoft.gnuob.api.Rule.DELETE_ACCESS;
import static com.netbrasoft.gnuob.api.Rule.READ_ACCESS;
import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.USER_DATA_PROVIDER_NAME;
import static org.junit.Assert.assertEquals;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.ApplyScriptBefore;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.spring.integration.test.annotation.SpringWebConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.netbrasoft.gnuob.api.Group;
import com.netbrasoft.gnuob.api.Permission;
import com.netbrasoft.gnuob.api.Site;
import com.netbrasoft.gnuob.api.User;
import com.netbrasoft.gnuob.api.generic.AbstractGenericTypeDataProvider;
import com.netbrasoft.gnuob.api.generic.IGenericTypeDataProvider;
import com.netbrasoft.gnuob.generic.AbstractGenericTypeDataProviderTest;

import de.rtner.security.auth.spi.SimplePBKDF2;

@RunWith(Arquillian.class)
@SpringWebConfiguration()
public class UserDataProviderTest extends AbstractGenericTypeDataProviderTest<User> {

  @Autowired
  @Qualifier(USER_DATA_PROVIDER_NAME)
  private AbstractGenericTypeDataProvider<User> userDataProvider;

  private User user;

  @Before
  public void setUp() throws Exception {
    user = new User();
    user.setActive(true);
    user.setId(0L);
    user.setVersion(0);
    user.setAccess(READ_ACCESS);
    user.setDescription("Folly words widow one downs few age every seven.");
    user.setName("dba");
    user.setPassword(new SimplePBKDF2().deriveKeyFormatted("dba"));
    user.setPermission(new Permission());
    user.getPermission().setId(0L);
    user.getPermission().setVersion(0);
    user.getPermission().setOwner(DELETE_ACCESS);
    user.getPermission().setGroup(DELETE_ACCESS);
    user.getPermission().setOthers(DELETE_ACCESS);
    final Site site = new Site();
    site.setActive(true);
    site.setId(0L);
    site.setVersion(0);
    site.setName("Folly words widow one downs few age every seven.");
    site.setDescription("Folly words widow one downs few age every seven.");
    site.setPermission(new Permission());
    site.getPermission().setId(0L);
    site.getPermission().setVersion(0);
    site.getPermission().setOwner(DELETE_ACCESS);
    site.getPermission().setGroup(DELETE_ACCESS);
    site.getPermission().setOthers(DELETE_ACCESS);
    user.getSites().add(site);
    final Group group = new Group();
    group.setActive(true);
    group.setId(0L);
    group.setVersion(0);
    group.setName("Folly words widow one downs few age every seven.");
    group.setDescription("Folly words widow one downs few age every seven.");
    group.setPermission(new Permission());
    group.getPermission().setId(0L);
    group.getPermission().setVersion(0);
    group.getPermission().setOwner(DELETE_ACCESS);
    group.getPermission().setGroup(DELETE_ACCESS);
    group.getPermission().setOthers(DELETE_ACCESS);
    user.getGroups().add(group);
    userDataProvider.setUser("root");
    userDataProvider.setPassword("root");
    userDataProvider.setSite("domain");
    userDataProvider.getType().setActive(true);
    user = userDataProvider.persist(user);
  }

  @After
  public void tearDown() throws Exception {}

  @Override
  public IGenericTypeDataProvider<User> getGenericTypeProvider() {
    return userDataProvider;
  }

  @Override
  public User getType() {
    return user;
  }

  @Override
  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testSizeAsRoot() {
    getGenericTypeProvider().setUser(ROOT);
    getGenericTypeProvider().setPassword(ROOT);
    assertEquals("Size", 7L, getGenericTypeProvider().size());
  }

  @Override
  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testSizeAsAdministrator() {
    getGenericTypeProvider().setUser(ADMINISTRATOR);
    getGenericTypeProvider().setPassword(ADMINISTRATOR);
    assertEquals("Size", 7L, getGenericTypeProvider().size());
  }

  @Override
  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testSizeAsManager() {
    getGenericTypeProvider().setUser(MANAGER);
    getGenericTypeProvider().setPassword(MANAGER);
    assertEquals("Size", 7L, getGenericTypeProvider().size());
  }

  @Override
  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testSizeAsEmployee() {
    getGenericTypeProvider().setUser(EMPLOYEE);
    getGenericTypeProvider().setPassword(EMPLOYEE);
    assertEquals("Size", 7L, getGenericTypeProvider().size());
  }

  @Override
  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testSizeAsGuest() {
    getGenericTypeProvider().setUser(GUEST);
    getGenericTypeProvider().setPassword(GUEST);
    assertEquals("Size", 7L, getGenericTypeProvider().size());
  }
}
