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

package br.com.netbrasoft.gnuob.api.order;

import br.com.netbrasoft.gnuob.api.CountOrder;
import br.com.netbrasoft.gnuob.api.DoCheckout;
import br.com.netbrasoft.gnuob.api.DoCheckoutDetails;
import br.com.netbrasoft.gnuob.api.DoCheckoutPayment;
import br.com.netbrasoft.gnuob.api.DoNotification;
import br.com.netbrasoft.gnuob.api.DoRefundTransaction;
import br.com.netbrasoft.gnuob.api.DoTransactionDetails;
import br.com.netbrasoft.gnuob.api.FindOrder;
import br.com.netbrasoft.gnuob.api.FindOrderById;
import br.com.netbrasoft.gnuob.api.MergeOrder;
import br.com.netbrasoft.gnuob.api.Order;
import br.com.netbrasoft.gnuob.api.OrderBy;
import br.com.netbrasoft.gnuob.api.Paging;
import br.com.netbrasoft.gnuob.api.PersistOrder;
import br.com.netbrasoft.gnuob.api.RefreshOrder;
import br.com.netbrasoft.gnuob.api.RemoveOrder;

final class OrderWebserviceWrapperHelper {

  private OrderWebserviceWrapperHelper() {}

  static CountOrder wrapToCountOrder(final Order orderType) {
    final CountOrder paramCountOrder = new CountOrder();
    paramCountOrder.setOrder(orderType);
    return paramCountOrder;
  }

  static DoCheckout wrapToDoCheckout(final Order orderType) {
    final DoCheckout paramDoCheckout = new DoCheckout();
    paramDoCheckout.setOrder(orderType);
    return paramDoCheckout;
  }

  static DoCheckoutDetails wrapToDoCheckoutDetails(final Order orderType) {
    final DoCheckoutDetails paramDoCheckoutDetails = new DoCheckoutDetails();
    paramDoCheckoutDetails.setOrder(orderType);
    return paramDoCheckoutDetails;
  }

  static DoCheckoutPayment wrapToDoCheckoutPayment(final Order orderType) {
    final DoCheckoutPayment paramDoCheckoutPayment = new DoCheckoutPayment();
    paramDoCheckoutPayment.setOrder(orderType);
    return paramDoCheckoutPayment;
  }

  static DoNotification wrapToDoNotification(final Order orderType) {
    final DoNotification paramDoNotification = new DoNotification();
    paramDoNotification.setOrder(orderType);
    return paramDoNotification;
  }

  static DoRefundTransaction wrapToDoRefundTransaction(final Order orderType) {
    final DoRefundTransaction paramRefundTransaction = new DoRefundTransaction();
    paramRefundTransaction.setOrder(orderType);
    return paramRefundTransaction;
  }

  static DoTransactionDetails wrapToDoTransactionDetails(final Order orderType) {
    final DoTransactionDetails paramDoTransactionDetails = new DoTransactionDetails();
    paramDoTransactionDetails.setOrder(orderType);
    return paramDoTransactionDetails;
  }

  static FindOrder wrapToFindOrder(final Order orderType, final Paging paging, final OrderBy orderingProperty) {
    final FindOrder paramFindOrder = new FindOrder();
    paramFindOrder.setOrder(orderType);
    paramFindOrder.setPaging(paging);
    paramFindOrder.setOrderBy(orderingProperty);
    return paramFindOrder;
  }

  static FindOrderById wrapToFindOrderById(final Order orderType) {
    final FindOrderById paramFindOrderById = new FindOrderById();
    paramFindOrderById.setOrder(orderType);
    return paramFindOrderById;
  }

  static MergeOrder wrapToMergeOrder(final Order orderType) {
    final MergeOrder paramMergeOrder = new MergeOrder();
    paramMergeOrder.setOrder(orderType);
    return paramMergeOrder;
  }

  static PersistOrder wrapToPersistOrder(final Order orderType) {
    final PersistOrder paramPersistOrder = new PersistOrder();
    paramPersistOrder.setOrder(orderType);
    return paramPersistOrder;
  }

  static RefreshOrder wrapToRefreshOrder(final Order orderType) {
    final RefreshOrder paramRefreshOrder = new RefreshOrder();
    paramRefreshOrder.setOrder(orderType);
    return paramRefreshOrder;
  }

  static RemoveOrder wrapToRemoveOrder(final Order orderType) {
    final RemoveOrder paramRemoveOrder = new RemoveOrder();
    paramRemoveOrder.setOrder(orderType);
    return paramRemoveOrder;
  }
}
