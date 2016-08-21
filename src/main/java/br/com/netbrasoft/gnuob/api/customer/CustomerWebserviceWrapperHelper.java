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

package br.com.netbrasoft.gnuob.api.customer;

import br.com.netbrasoft.gnuob.api.CountCustomer;
import br.com.netbrasoft.gnuob.api.Customer;
import br.com.netbrasoft.gnuob.api.FindCustomer;
import br.com.netbrasoft.gnuob.api.FindCustomerById;
import br.com.netbrasoft.gnuob.api.MergeCustomer;
import br.com.netbrasoft.gnuob.api.OrderBy;
import br.com.netbrasoft.gnuob.api.Paging;
import br.com.netbrasoft.gnuob.api.PersistCustomer;
import br.com.netbrasoft.gnuob.api.RefreshCustomer;
import br.com.netbrasoft.gnuob.api.RemoveCustomer;

final class CustomerWebserviceWrapperHelper {

  private CustomerWebserviceWrapperHelper() {}

  static CountCustomer wrapToCountCustomer(final Customer customer) {
    final CountCustomer paramCountCustomer = new CountCustomer();
    paramCountCustomer.setCustomer(customer);
    return paramCountCustomer;
  }

  static FindCustomer wrapToFindCustomer(final Customer customer, final Paging paging, final OrderBy orderingProperty) {
    final FindCustomer paramFindCustomer = new FindCustomer();
    paramFindCustomer.setCustomer(customer);
    paramFindCustomer.setPaging(paging);
    paramFindCustomer.setOrderBy(orderingProperty);
    return paramFindCustomer;
  }

  static FindCustomerById wrapToFindCustomerById(final Customer customer) {
    final FindCustomerById paramFindCustomerById = new FindCustomerById();
    paramFindCustomerById.setCustomer(customer);
    return paramFindCustomerById;
  }

  static PersistCustomer wrapToPersistCustomer(final Customer customer) {
    final PersistCustomer paramPersistCustomer = new PersistCustomer();
    paramPersistCustomer.setCustomer(customer);
    return paramPersistCustomer;
  }

  static MergeCustomer wrapToMergeCustomer(final Customer customer) {
    final MergeCustomer paramMergeCustomer = new MergeCustomer();
    paramMergeCustomer.setCustomer(customer);
    return paramMergeCustomer;
  }

  static RefreshCustomer wrapToRefreshCustomer(final Customer customer) {
    final RefreshCustomer paramRefresCustomer = new RefreshCustomer();
    paramRefresCustomer.setCustomer(customer);
    return paramRefresCustomer;
  }

  static RemoveCustomer wrapToRemoveCustomer(final Customer customer) {
    final RemoveCustomer paramRemoveCustomer = new RemoveCustomer();
    paramRemoveCustomer.setCustomer(customer);
    return paramRemoveCustomer;
  }
}
