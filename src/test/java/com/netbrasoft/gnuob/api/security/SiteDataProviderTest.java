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

import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.SITE_DATA_PROVIDER_NAME;
import static com.netbrasoft.gnuob.generic.utils.DummyInstanceHelper.getSiteInstance;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.spring.integration.test.annotation.SpringWebConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.netbrasoft.gnuob.api.Site;
import com.netbrasoft.gnuob.api.generic.IGenericTypeDataProvider;
import com.netbrasoft.gnuob.generic.AbstractGenericTypeDataProviderTest;

@RunWith(Arquillian.class)
@SpringWebConfiguration()
public class SiteDataProviderTest extends AbstractGenericTypeDataProviderTest<Site> {

  @Autowired
  @Qualifier(SITE_DATA_PROVIDER_NAME)
  private IGenericTypeDataProvider<Site> siteDataProvider;
  private Site site;

  @Before
  public void setUp() throws Exception {
    siteDataProvider.setUser(ROOT);
    siteDataProvider.setPassword(ROOT);
    siteDataProvider.setSite("domain");
    siteDataProvider.getType().setActive(true);
    site = siteDataProvider.persist(getSiteInstance());
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
}
