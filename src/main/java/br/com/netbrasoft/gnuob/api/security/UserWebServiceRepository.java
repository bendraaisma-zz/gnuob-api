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

package br.com.netbrasoft.gnuob.api.security;

import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.CAN_NOT_INITIALIZE_THE_DEFAULT_WSDL_FROM_0;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.GNUOB_SOAP_USER_WEBSERVICE_WSDL;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.HTTP_LOCALHOST_8080_GNUOB_SOAP_USER_WEB_SERVICE_IMPL_WSDL;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.UNCHECKED_VALUE;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.USER_WEB_SERVICE_REPOSITORY_NAME;
import static br.com.netbrasoft.gnuob.api.security.UserWebServiceWrapperHelper.wrapToCountUser;
import static br.com.netbrasoft.gnuob.api.security.UserWebServiceWrapperHelper.wrapToFindUser;
import static br.com.netbrasoft.gnuob.api.security.UserWebServiceWrapperHelper.wrapToFindUserById;
import static br.com.netbrasoft.gnuob.api.security.UserWebServiceWrapperHelper.wrapToMergeUser;
import static br.com.netbrasoft.gnuob.api.security.UserWebServiceWrapperHelper.wrapToPersistUser;
import static br.com.netbrasoft.gnuob.api.security.UserWebServiceWrapperHelper.wrapToRefreshUser;
import static br.com.netbrasoft.gnuob.api.security.UserWebServiceWrapperHelper.wrapToRemoveUser;
import static java.lang.System.getProperty;
import static org.slf4j.LoggerFactory.getLogger;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.javasimon.aop.Monitored;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import br.com.netbrasoft.gnuob.api.MetaData;
import br.com.netbrasoft.gnuob.api.OrderBy;
import br.com.netbrasoft.gnuob.api.Paging;
import br.com.netbrasoft.gnuob.api.User;
import br.com.netbrasoft.gnuob.api.UserWebServiceImpl;
import br.com.netbrasoft.gnuob.api.UserWebServiceImplService;
import br.com.netbrasoft.gnuob.api.generic.IGenericTypeWebServiceRepository;

@Monitored
@Repository(USER_WEB_SERVICE_REPOSITORY_NAME)
public class UserWebServiceRepository<U extends User> implements IGenericTypeWebServiceRepository<U> {

  private static final Logger LOGGER = getLogger(UserWebServiceRepository.class);
  private static final URL WSDL_LOCATION;

  static {
    URL url = null;
    try {
      url = new URL(
          getProperty(GNUOB_SOAP_USER_WEBSERVICE_WSDL, HTTP_LOCALHOST_8080_GNUOB_SOAP_USER_WEB_SERVICE_IMPL_WSDL));
    } catch (final MalformedURLException e) {
      LOGGER.info(CAN_NOT_INITIALIZE_THE_DEFAULT_WSDL_FROM_0,
          getProperty(GNUOB_SOAP_USER_WEBSERVICE_WSDL, HTTP_LOCALHOST_8080_GNUOB_SOAP_USER_WEB_SERVICE_IMPL_WSDL));
    }
    WSDL_LOCATION = url;
  }

  private transient UserWebServiceImpl userWebServiceImpl;

  private UserWebServiceImpl getUserWebServiceImpl() {
    if (userWebServiceImpl == null) {
      userWebServiceImpl = new UserWebServiceImplService(WSDL_LOCATION).getUserWebServiceImplPort();
    }
    return userWebServiceImpl;
  }

  @Override
  public long count(final MetaData credentials, final U userExample) {
    return getUserWebServiceImpl().countUser(wrapToCountUser(userExample), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public List<U> find(final MetaData credentials, final U userExample, final Paging paging,
      final OrderBy orderingProperty) {
    return (List<U>) getUserWebServiceImpl()
        .findUser(wrapToFindUser(userExample, paging, orderingProperty), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public U find(final MetaData credentials, final U userExample) {
    return (U) getUserWebServiceImpl().findUserById(wrapToFindUserById(userExample), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public U persist(final MetaData credentials, final U user) {
    return (U) getUserWebServiceImpl().persistUser(wrapToPersistUser(user), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public U merge(final MetaData credentials, final U user) {
    return (U) getUserWebServiceImpl().mergeUser(wrapToMergeUser(user), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public U refresh(final MetaData credentials, final U user) {
    return (U) getUserWebServiceImpl().refreshUser(wrapToRefreshUser(user), credentials).getReturn();
  }

  @Override
  public void remove(final MetaData credentials, final U user) {
    getUserWebServiceImpl().removeUser(wrapToRemoveUser(user), credentials);
  }
}
