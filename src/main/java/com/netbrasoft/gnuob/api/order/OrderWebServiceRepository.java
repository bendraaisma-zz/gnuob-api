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

import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.ORDER_WEB_SERVICE_REPOSITORY_NAME;
import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.UNCHECKED_VALUE;
import static com.netbrasoft.gnuob.api.order.OrderWebserviceWrapperHelper.wrapToCountOrder;
import static com.netbrasoft.gnuob.api.order.OrderWebserviceWrapperHelper.wrapToFindOrder;
import static com.netbrasoft.gnuob.api.order.OrderWebserviceWrapperHelper.wrapToFindOrderById;
import static com.netbrasoft.gnuob.api.order.OrderWebserviceWrapperHelper.wrapToMergeOrder;
import static com.netbrasoft.gnuob.api.order.OrderWebserviceWrapperHelper.wrapToPersistOrder;
import static com.netbrasoft.gnuob.api.order.OrderWebserviceWrapperHelper.wrapToRefreshOrder;
import static com.netbrasoft.gnuob.api.order.OrderWebserviceWrapperHelper.wrapToRemoveOrder;

import java.util.List;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Repository;

import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.Order;
import com.netbrasoft.gnuob.api.OrderBy;
import com.netbrasoft.gnuob.api.OrderWebServiceImpl;
import com.netbrasoft.gnuob.api.OrderWebServiceImplService;
import com.netbrasoft.gnuob.api.Paging;
import com.netbrasoft.gnuob.api.generic.IGenericTypeWebServiceRepository;

@Monitored
@Repository(ORDER_WEB_SERVICE_REPOSITORY_NAME)
public class OrderWebServiceRepository<O extends Order> implements IGenericTypeWebServiceRepository<O> {

  private transient OrderWebServiceImpl orderWebServiceImpl;

  private OrderWebServiceImpl getOrderWebServiceImpl() {
    if (orderWebServiceImpl == null) {
      orderWebServiceImpl = new OrderWebServiceImplService().getOrderWebServiceImplPort();
    }
    return orderWebServiceImpl;
  }

  @Override
  public long count(final MetaData credentials, final O orderTypeExample) {
    return getOrderWebServiceImpl().countOrder(wrapToCountOrder(orderTypeExample), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public List<O> find(final MetaData credentials, final O orderTypeExample, final Paging paging,
      final OrderBy orderingProperty) {
    return (List<O>) getOrderWebServiceImpl()
        .findOrder(wrapToFindOrder(orderTypeExample, paging, orderingProperty), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public O find(final MetaData credentials, final O orderTypeExample) {
    return (O) getOrderWebServiceImpl().findOrderById(wrapToFindOrderById(orderTypeExample), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public O merge(final MetaData credentials, final O orderType) {
    return (O) getOrderWebServiceImpl().mergeOrder(wrapToMergeOrder(orderType), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public O persist(final MetaData credentials, final O orderType) {
    return (O) getOrderWebServiceImpl().persistOrder(wrapToPersistOrder(orderType), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public O refresh(final MetaData credentials, final O orderType) {
    return (O) getOrderWebServiceImpl().refreshOrder(wrapToRefreshOrder(orderType), credentials).getReturn();
  }

  @Override
  public void remove(final MetaData credentials, final O orderType) {
    getOrderWebServiceImpl().removeOrder(wrapToRemoveOrder(orderType), credentials);
  }
}
