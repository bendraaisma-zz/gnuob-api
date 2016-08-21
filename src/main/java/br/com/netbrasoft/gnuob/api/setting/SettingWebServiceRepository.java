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

package br.com.netbrasoft.gnuob.api.setting;

import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.CAN_NOT_INITIALIZE_THE_DEFAULT_WSDL_FROM_0;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.GNUOB_SOAP_SETTING_WEBSERVICE_WSDL;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.HTTP_LOCALHOST_8080_GNUOB_SOAP_SETTING_WEB_SERVICE_IMPL_WSDL;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.SETTING_WEB_SERVICE_REPOSITORY_NAME;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.UNCHECKED_VALUE;
import static br.com.netbrasoft.gnuob.api.setting.SettingWebServiceWrapperHelper.wrapToCountSetting;
import static br.com.netbrasoft.gnuob.api.setting.SettingWebServiceWrapperHelper.wrapToFindSetting;
import static br.com.netbrasoft.gnuob.api.setting.SettingWebServiceWrapperHelper.wrapToFindSettingsById;
import static br.com.netbrasoft.gnuob.api.setting.SettingWebServiceWrapperHelper.wrapToMergeSetting;
import static br.com.netbrasoft.gnuob.api.setting.SettingWebServiceWrapperHelper.wrapToPersistSetting;
import static br.com.netbrasoft.gnuob.api.setting.SettingWebServiceWrapperHelper.wrapToRefreshSetting;
import static br.com.netbrasoft.gnuob.api.setting.SettingWebServiceWrapperHelper.wrapToRemoveSetting;
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
import br.com.netbrasoft.gnuob.api.Setting;
import br.com.netbrasoft.gnuob.api.SettingWebServiceImpl;
import br.com.netbrasoft.gnuob.api.SettingWebServiceImplService;
import br.com.netbrasoft.gnuob.api.generic.IGenericTypeWebServiceRepository;
import br.com.netbrasoft.gnuob.api.security.UserWebServiceRepository;

@Monitored
@Repository(SETTING_WEB_SERVICE_REPOSITORY_NAME)
public class SettingWebServiceRepository<S extends Setting> implements IGenericTypeWebServiceRepository<S> {

  private static final Logger LOGGER = getLogger(UserWebServiceRepository.class);
  private static final URL WSDL_LOCATION;

  static {
    URL url = null;
    try {
      url = new URL(getProperty(GNUOB_SOAP_SETTING_WEBSERVICE_WSDL,
          HTTP_LOCALHOST_8080_GNUOB_SOAP_SETTING_WEB_SERVICE_IMPL_WSDL));
    } catch (final MalformedURLException e) {
      LOGGER.info(CAN_NOT_INITIALIZE_THE_DEFAULT_WSDL_FROM_0, getProperty(GNUOB_SOAP_SETTING_WEBSERVICE_WSDL,
          HTTP_LOCALHOST_8080_GNUOB_SOAP_SETTING_WEB_SERVICE_IMPL_WSDL));
    }
    WSDL_LOCATION = url;
  }

  private transient SettingWebServiceImpl settingWebServiceImpl;

  private SettingWebServiceImpl getSettingWebServiceImpl() {
    if (settingWebServiceImpl == null) {
      settingWebServiceImpl = new SettingWebServiceImplService(WSDL_LOCATION).getSettingWebServiceImplPort();
    }
    return settingWebServiceImpl;
  }

  @Override
  public long count(final MetaData credentials, final S settingExample) {
    return getSettingWebServiceImpl().countSetting(wrapToCountSetting(settingExample), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public List<S> find(final MetaData credentials, final S settingExample, final Paging paging,
      final OrderBy orderingProperty) {
    return (List<S>) getSettingWebServiceImpl()
        .findSetting(wrapToFindSetting(settingExample, paging, orderingProperty), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public S find(final MetaData credentials, final S settingExample) {
    return (S) getSettingWebServiceImpl().findSettingById(wrapToFindSettingsById(settingExample), credentials)
        .getReturn();

  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public S persist(final MetaData credentials, final S setting) {
    return (S) getSettingWebServiceImpl().persistSetting(wrapToPersistSetting(setting), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public S merge(final MetaData credentials, final S setting) {
    return (S) getSettingWebServiceImpl().mergeSetting(wrapToMergeSetting(setting), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public S refresh(final MetaData credentials, final S setting) {
    return (S) getSettingWebServiceImpl().refreshSetting(wrapToRefreshSetting(setting), credentials).getReturn();
  }

  @Override
  public void remove(final MetaData credentials, final S setting) {
    getSettingWebServiceImpl().removeSetting(wrapToRemoveSetting(setting), credentials);
  }
}
