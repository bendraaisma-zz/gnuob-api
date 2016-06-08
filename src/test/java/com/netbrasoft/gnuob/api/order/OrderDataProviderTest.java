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

package com.netbrasoft.gnuob.api.order;

import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.ORDER_DATA_PROVIDER_NAME;
import static com.netbrasoft.gnuob.generic.utils.DummyInstanceHelper.getOrderInstance;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.spring.integration.test.annotation.SpringWebConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.netbrasoft.gnuob.api.Order;
import com.netbrasoft.gnuob.api.generic.IGenericTypeDataProvider;
import com.netbrasoft.gnuob.generic.AbstractGenericTypeDataProviderTest;

@RunWith(Arquillian.class)
@SpringWebConfiguration()
public class OrderDataProviderTest extends AbstractGenericTypeDataProviderTest<Order> {

  @Autowired
  @Qualifier(ORDER_DATA_PROVIDER_NAME)
  private IGenericTypeDataProvider<Order> orderDataProvider;
  private Order order;

  @Before
  public void setUp() throws Exception {
    orderDataProvider.setUser(ROOT);
    orderDataProvider.setPassword(ROOT);
    orderDataProvider.setSite("domain");
    orderDataProvider.getType().setActive(true);
    order = orderDataProvider.persist(getOrderInstance());
  }

  @After
  public void tearDown() throws Exception {}

  @Override
  public IGenericTypeDataProvider<Order> getGenericTypeProvider() {
    return orderDataProvider;
  }

  @Override
  public Order getType() {
    return order;
  }
}
