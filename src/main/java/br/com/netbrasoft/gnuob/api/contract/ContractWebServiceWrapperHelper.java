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

package br.com.netbrasoft.gnuob.api.contract;

import br.com.netbrasoft.gnuob.api.Contract;
import br.com.netbrasoft.gnuob.api.CountContract;
import br.com.netbrasoft.gnuob.api.FindContract;
import br.com.netbrasoft.gnuob.api.FindContractById;
import br.com.netbrasoft.gnuob.api.MergeContract;
import br.com.netbrasoft.gnuob.api.OrderBy;
import br.com.netbrasoft.gnuob.api.Paging;
import br.com.netbrasoft.gnuob.api.PersistContract;
import br.com.netbrasoft.gnuob.api.RefreshContract;
import br.com.netbrasoft.gnuob.api.RemoveContract;

final class ContractWebServiceWrapperHelper {

  private ContractWebServiceWrapperHelper() {}

  static CountContract wrapToCountContract(final Contract contract) {
    final CountContract paramCountContract = new CountContract();
    paramCountContract.setContract(contract);
    return paramCountContract;
  }

  static FindContract wrapToFindContract(final Contract contract, final Paging paging, final OrderBy orderingProperty) {
    final FindContract paramFindContract = new FindContract();
    paramFindContract.setContract(contract);
    paramFindContract.setPaging(paging);
    paramFindContract.setOrderBy(orderingProperty);
    return paramFindContract;
  }

  static FindContractById wrapToFindContractById(final Contract contract) {
    final FindContractById paramFindContractById = new FindContractById();
    paramFindContractById.setContract(contract);
    return paramFindContractById;
  }

  static PersistContract wrapToPersistContract(final Contract contract) {
    final PersistContract paramPersistContract = new PersistContract();
    paramPersistContract.setContract(contract);
    return paramPersistContract;
  }

  static MergeContract wrapToMergeContract(final Contract contract) {
    final MergeContract paramMergeContract = new MergeContract();
    paramMergeContract.setContract(contract);
    return paramMergeContract;
  }

  static RefreshContract wrapToRefreshContract(final Contract contract) {
    final RefreshContract paramRefresContract = new RefreshContract();
    paramRefresContract.setContract(contract);
    return paramRefresContract;
  }

  static RemoveContract wrapToRemoveContract(final Contract contract) {
    final RemoveContract paramRemoveContract = new RemoveContract();
    paramRemoveContract.setContract(contract);
    return paramRemoveContract;
  }
}
