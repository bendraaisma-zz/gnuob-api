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

package com.netbrasoft.gnuob.api.setting;

import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.SETTING_WEB_SERVICE_REPOSITORY_NAME;
import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.UNCHECKED_VALUE;
import static com.netbrasoft.gnuob.api.setting.SettingWebServiceWrapperHelper.wrapToCountSetting;
import static com.netbrasoft.gnuob.api.setting.SettingWebServiceWrapperHelper.wrapToFindSetting;
import static com.netbrasoft.gnuob.api.setting.SettingWebServiceWrapperHelper.wrapToFindSettingsById;
import static com.netbrasoft.gnuob.api.setting.SettingWebServiceWrapperHelper.wrapToMergeSetting;
import static com.netbrasoft.gnuob.api.setting.SettingWebServiceWrapperHelper.wrapToPersistSetting;
import static com.netbrasoft.gnuob.api.setting.SettingWebServiceWrapperHelper.wrapToRefreshSetting;
import static com.netbrasoft.gnuob.api.setting.SettingWebServiceWrapperHelper.wrapToRemoveSetting;

import java.util.List;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Repository;

import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.OrderBy;
import com.netbrasoft.gnuob.api.Paging;
import com.netbrasoft.gnuob.api.Setting;
import com.netbrasoft.gnuob.api.SettingWebServiceImpl;
import com.netbrasoft.gnuob.api.SettingWebServiceImplService;
import com.netbrasoft.gnuob.api.generic.IGenericTypeWebServiceRepository;

@Monitored
@Repository(SETTING_WEB_SERVICE_REPOSITORY_NAME)
public class SettingWebServiceRepository<S extends Setting> implements IGenericTypeWebServiceRepository<S> {

  private transient SettingWebServiceImpl settingWebServiceImpl;

  private SettingWebServiceImpl getSettingWebServiceImpl() {
    if (settingWebServiceImpl == null) {
      settingWebServiceImpl = new SettingWebServiceImplService().getSettingWebServiceImplPort();
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
