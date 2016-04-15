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
import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.SITE_DATA_PROVIDER_NAME;
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

import com.netbrasoft.gnuob.api.Permission;
import com.netbrasoft.gnuob.api.Site;
import com.netbrasoft.gnuob.api.generic.AbstractGenericTypeDataProvider;
import com.netbrasoft.gnuob.api.generic.IGenericTypeDataProvider;
import com.netbrasoft.gnuob.generic.AbstractGenericTypeDataProviderTest;

@RunWith(Arquillian.class)
@SpringWebConfiguration()
public class SiteDataProviderTest extends AbstractGenericTypeDataProviderTest<Site> {

  @Autowired
  @Qualifier(SITE_DATA_PROVIDER_NAME)
  private AbstractGenericTypeDataProvider<Site> siteDataProvider;
  private Site site;

  @Before
  public void setUp() throws Exception {
    site = new Site();
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
    siteDataProvider.setUser("root");
    siteDataProvider.setPassword("root");
    siteDataProvider.setSite("domain");
    siteDataProvider.getType().setActive(true);
    site = siteDataProvider.persist(site);
  }

  @After
  public void tearDown() throws Exception {}

  @Override
  public IGenericTypeDataProvider<Site> getGenericTypeProvider() {
    return siteDataProvider;
  }

  @Override
  public Site getType() {
    return site;
  }

  @Override
  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testSizeAsRoot() {
    getGenericTypeProvider().setUser(ROOT);
    getGenericTypeProvider().setPassword(ROOT);
    assertEquals("Size", 2L, getGenericTypeProvider().size());
  }

  @Override
  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testSizeAsAdministrator() {
    getGenericTypeProvider().setUser(ADMINISTRATOR);
    getGenericTypeProvider().setPassword(ADMINISTRATOR);
    assertEquals("Size", 2L, getGenericTypeProvider().size());
  }

  @Override
  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testSizeAsManager() {
    getGenericTypeProvider().setUser(MANAGER);
    getGenericTypeProvider().setPassword(MANAGER);
    assertEquals("Size", 2L, getGenericTypeProvider().size());
  }

  @Override
  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testSizeAsEmployee() {
    getGenericTypeProvider().setUser(EMPLOYEE);
    getGenericTypeProvider().setPassword(EMPLOYEE);
    assertEquals("Size", 2L, getGenericTypeProvider().size());
  }

  @Override
  @Test
  @ApplyScriptBefore({SCRIPTS_TO_EXECUTE_BEFORE_TEST_SQL})
  @UsingDataSet(DATASETS_SETTINGS_XML)
  public void testSizeAsGuest() {
    getGenericTypeProvider().setUser(GUEST);
    getGenericTypeProvider().setPassword(GUEST);
    assertEquals("Size", 2L, getGenericTypeProvider().size());
  }
}
