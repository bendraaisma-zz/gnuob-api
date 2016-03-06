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

import static com.netbrasoft.gnuob.api.customer.PostalCodeWebserviceWrapperHelper.wrapFindPostalCode;
import static com.netbrasoft.gnuob.api.customer.PostalCodeWebserviceWrapperHelper.wrapToCountPostalCode;
import static com.netbrasoft.gnuob.api.customer.PostalCodeWebserviceWrapperHelper.wrapToFindPostalCodeById;
import static com.netbrasoft.gnuob.api.customer.PostalCodeWebserviceWrapperHelper.wrapToMergePostalCode;
import static com.netbrasoft.gnuob.api.customer.PostalCodeWebserviceWrapperHelper.wrapToPersistPostalCode;
import static com.netbrasoft.gnuob.api.customer.PostalCodeWebserviceWrapperHelper.wrapToRefreshPostalCode;
import static com.netbrasoft.gnuob.api.customer.PostalCodeWebserviceWrapperHelper.wrapToRemovePostalCode;
import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.POSTAL_CODE_WEB_SERVICE_REPOSITORY_NAME;
import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.UNCHECKED_VALUE;

import java.util.List;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Repository;

import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.OrderBy;
import com.netbrasoft.gnuob.api.Paging;
import com.netbrasoft.gnuob.api.PostalCode;
import com.netbrasoft.gnuob.api.PostalCodeWebServiceImpl;
import com.netbrasoft.gnuob.api.PostalCodeWebServiceImplService;
import com.netbrasoft.gnuob.api.generic.IGenericTypeWebServiceRepository;

@Monitored
@Repository(POSTAL_CODE_WEB_SERVICE_REPOSITORY_NAME)
public class PostalCodeWebServiceRepository<P extends PostalCode> implements IGenericTypeWebServiceRepository<P> {

  private transient PostalCodeWebServiceImpl postalCodeWebServiceImpl;

  private PostalCodeWebServiceImpl getPostalCodeWebServiceImpl() {
    if (postalCodeWebServiceImpl == null) {
      postalCodeWebServiceImpl = new PostalCodeWebServiceImplService().getPostalCodeWebServiceImplPort();
    }
    return postalCodeWebServiceImpl;
  }

  @Override
  public long count(final MetaData credentials, final P postalCodeExample) {
    return getPostalCodeWebServiceImpl().countPostalCode(wrapToCountPostalCode(postalCodeExample), credentials)
        .getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public List<P> find(final MetaData credentials, final P postalCodeExample, final Paging paging,
      final OrderBy orderingProperty) {
    return (List<P>) getPostalCodeWebServiceImpl()
        .findPostalCode(wrapFindPostalCode(postalCodeExample, paging, orderingProperty), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public P find(final MetaData credentials, final P postalCodeExample) {
    return (P) getPostalCodeWebServiceImpl()
        .findPostalCodeById(wrapToFindPostalCodeById(postalCodeExample), credentials).getReturn();

  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public P persist(final MetaData credentials, final P postalCode) {
    return (P) getPostalCodeWebServiceImpl().persistPostalCode(wrapToPersistPostalCode(postalCode), credentials)
        .getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public P merge(final MetaData credentials, final P postalCode) {
    return (P) getPostalCodeWebServiceImpl().mergePostalCode(wrapToMergePostalCode(postalCode), credentials)
        .getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public P refresh(final MetaData credentials, final P postalCode) {
    return (P) getPostalCodeWebServiceImpl().refreshPostalCode(wrapToRefreshPostalCode(postalCode), credentials)
        .getReturn();
  }

  @Override
  public void remove(final MetaData credentials, final P postalCode) {
    getPostalCodeWebServiceImpl().removePostalCode(wrapToRemovePostalCode(postalCode), credentials);
  }
}
