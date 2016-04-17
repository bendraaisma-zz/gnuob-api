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

package com.netbrasoft.gnuob.api.customer;

import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.POSTAL_CODE_DATA_PROVIDER_NAME;
import static com.netbrasoft.gnuob.generic.utils.EntityInstanceHelper.getPostalCodeInstance;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.spring.integration.test.annotation.SpringWebConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.netbrasoft.gnuob.api.PostalCode;
import com.netbrasoft.gnuob.api.generic.AbstractGenericTypeDataProvider;
import com.netbrasoft.gnuob.api.generic.IGenericTypeDataProvider;
import com.netbrasoft.gnuob.generic.AbstractGenericTypeDataProviderTest;

@RunWith(Arquillian.class)
@SpringWebConfiguration()
public class PostalCodeDataProviderTest extends AbstractGenericTypeDataProviderTest<PostalCode> {

  @Autowired
  @Qualifier(POSTAL_CODE_DATA_PROVIDER_NAME)
  private AbstractGenericTypeDataProvider<PostalCode> postalCodeDataProvider;
  private PostalCode postalCode;

  @Before
  public void setUp() throws Exception {
    postalCodeDataProvider.setUser(ROOT);
    postalCodeDataProvider.setPassword(ROOT);
    postalCodeDataProvider.setSite("domain");
    postalCode = postalCodeDataProvider.persist(getPostalCodeInstance());
  }

  @After
  public void tearDown() throws Exception {}

  @Override
  public IGenericTypeDataProvider<PostalCode> getGenericTypeProvider() {
    return postalCodeDataProvider;
  }

  @Override
  public PostalCode getType() {
    return postalCode;
  }
}
