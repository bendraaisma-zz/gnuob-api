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

package com.netbrasoft.gnuob.api.content;

import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.CONTENT_DATA_PROVIDER_NAME;
import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.DOMAIN;
import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiTestConstants.ROOT;
import static com.netbrasoft.gnuob.api.generic.utils.DummyInstanceHelper.getContentInstance;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.spring.integration.test.annotation.SpringWebConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.netbrasoft.gnuob.api.Content;
import com.netbrasoft.gnuob.api.generic.AbstractGenericTypeDataProviderTest;
import com.netbrasoft.gnuob.api.generic.IGenericTypeDataProvider;

@RunWith(Arquillian.class)
@SpringWebConfiguration()
public class ContentDataProviderTest extends AbstractGenericTypeDataProviderTest<Content> {

  @Autowired
  @Qualifier(CONTENT_DATA_PROVIDER_NAME)
  private IGenericTypeDataProvider<Content> contentDataProvider;
  private Content content;

  @Before
  public void setUp() throws Exception {
    contentDataProvider.setUser(ROOT);
    contentDataProvider.setPassword(ROOT);
    contentDataProvider.setSite(DOMAIN);
    content = contentDataProvider.persist(getContentInstance());
  }

  @After
  public void tearDown() throws Exception {}

  @Override
  public IGenericTypeDataProvider<Content> getGenericTypeProvider() {
    return contentDataProvider;
  }

  @Override
  public Content getType() {
    return content;
  }
}
