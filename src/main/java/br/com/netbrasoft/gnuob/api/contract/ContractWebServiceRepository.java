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

import static br.com.netbrasoft.gnuob.api.contract.ContractWebServiceWrapperHelper.wrapToCountContract;
import static br.com.netbrasoft.gnuob.api.contract.ContractWebServiceWrapperHelper.wrapToFindContract;
import static br.com.netbrasoft.gnuob.api.contract.ContractWebServiceWrapperHelper.wrapToFindContractById;
import static br.com.netbrasoft.gnuob.api.contract.ContractWebServiceWrapperHelper.wrapToMergeContract;
import static br.com.netbrasoft.gnuob.api.contract.ContractWebServiceWrapperHelper.wrapToPersistContract;
import static br.com.netbrasoft.gnuob.api.contract.ContractWebServiceWrapperHelper.wrapToRefreshContract;
import static br.com.netbrasoft.gnuob.api.contract.ContractWebServiceWrapperHelper.wrapToRemoveContract;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.CONTRACT_WEB_SERVICE_REPOSITORY_NAME;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.UNCHECKED_VALUE;

import java.util.List;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Repository;

import br.com.netbrasoft.gnuob.api.Contract;
import br.com.netbrasoft.gnuob.api.ContractWebServiceImpl;
import br.com.netbrasoft.gnuob.api.ContractWebServiceImplService;
import br.com.netbrasoft.gnuob.api.MetaData;
import br.com.netbrasoft.gnuob.api.OrderBy;
import br.com.netbrasoft.gnuob.api.Paging;

import br.com.netbrasoft.gnuob.api.generic.IGenericTypeWebServiceRepository;

@Monitored
@Repository(CONTRACT_WEB_SERVICE_REPOSITORY_NAME)
public class ContractWebServiceRepository<C extends Contract> implements IGenericTypeWebServiceRepository<C> {

  private transient ContractWebServiceImpl contractWebServiceImpl;

  private ContractWebServiceImpl getContractWebServiceImpl() {
    if (contractWebServiceImpl == null) {
      contractWebServiceImpl = new ContractWebServiceImplService().getContractWebServiceImplPort();
    }
    return contractWebServiceImpl;
  }

  @Override
  public long count(final MetaData credentials, final C contractExample) {
    return getContractWebServiceImpl().countContract(wrapToCountContract(contractExample), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public List<C> find(final MetaData credentials, final C contractExample, final Paging paging,
      final OrderBy orderingProperty) {
    return (List<C>) getContractWebServiceImpl()
        .findContract(wrapToFindContract(contractExample, paging, orderingProperty), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public C find(final MetaData credentials, final C contractExample) {
    return (C) getContractWebServiceImpl().findContractById(wrapToFindContractById(contractExample), credentials)
        .getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public C persist(final MetaData credentials, final C contract) {
    return (C) getContractWebServiceImpl().persistContract(wrapToPersistContract(contract), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public C merge(final MetaData credentials, final C contract) {
    return (C) getContractWebServiceImpl().mergeContract(wrapToMergeContract(contract), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public C refresh(final MetaData credentials, final C contract) {
    return (C) getContractWebServiceImpl().refreshContract(wrapToRefreshContract(contract), credentials).getReturn();
  }

  @Override
  public void remove(final MetaData credentials, final C contract) {
    getContractWebServiceImpl().removeContract(wrapToRemoveContract(contract), credentials);
  }
}
