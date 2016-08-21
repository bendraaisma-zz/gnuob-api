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

import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.UNCHECKED_VALUE;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.USER_DATA_PROVIDER_NAME;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.USER_WEB_SERVICE_REPOSITORY_NAME;

import javax.annotation.Resource;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Controller;

import br.com.netbrasoft.gnuob.api.User;

import br.com.netbrasoft.gnuob.api.generic.AbstractGenericTypeDataProvider;
import br.com.netbrasoft.gnuob.api.generic.IGenericTypeWebServiceRepository;

@Monitored
@Controller(USER_DATA_PROVIDER_NAME)
public class UserDataProvider<U extends User> extends AbstractGenericTypeDataProvider<U> {

  private static final long serialVersionUID = -8167982674192813819L;

  @Resource(name = USER_WEB_SERVICE_REPOSITORY_NAME)
  private transient IGenericTypeWebServiceRepository<U> userWebServiceRepository;

  @SuppressWarnings(UNCHECKED_VALUE)
  public UserDataProvider() {
    super((U) new User());
  }

  @Override
  public IGenericTypeWebServiceRepository<U> getGenericTypeWebServiceRepository() {
    return userWebServiceRepository;
  }
}
