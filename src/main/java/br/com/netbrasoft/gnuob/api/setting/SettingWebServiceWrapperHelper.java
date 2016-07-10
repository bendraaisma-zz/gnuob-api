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

import br.com.netbrasoft.gnuob.api.CountSetting;
import br.com.netbrasoft.gnuob.api.FindSetting;
import br.com.netbrasoft.gnuob.api.FindSettingById;
import br.com.netbrasoft.gnuob.api.MergeSetting;
import br.com.netbrasoft.gnuob.api.OrderBy;
import br.com.netbrasoft.gnuob.api.Paging;
import br.com.netbrasoft.gnuob.api.PersistSetting;
import br.com.netbrasoft.gnuob.api.RefreshSetting;
import br.com.netbrasoft.gnuob.api.RemoveSetting;
import br.com.netbrasoft.gnuob.api.Setting;

final class SettingWebServiceWrapperHelper {

  private SettingWebServiceWrapperHelper() {}

  static CountSetting wrapToCountSetting(final Setting setting) {
    final CountSetting paramCountSetting = new CountSetting();
    paramCountSetting.setSetting(setting);
    return paramCountSetting;
  }

  static FindSetting wrapToFindSetting(final Setting setting, final Paging paging, final OrderBy orderingProperty) {
    final FindSetting paramFindSetting = new FindSetting();
    paramFindSetting.setSetting(setting);
    paramFindSetting.setPaging(paging);
    paramFindSetting.setOrderBy(orderingProperty);
    return paramFindSetting;
  }

  static FindSettingById wrapToFindSettingsById(final Setting settingExample) {
    final FindSettingById paramFindSettingById = new FindSettingById();
    paramFindSettingById.setSetting(settingExample);
    return paramFindSettingById;
  }

  static MergeSetting wrapToMergeSetting(final Setting setting) {
    final MergeSetting paramMergeSetting = new MergeSetting();
    paramMergeSetting.setSetting(setting);
    return paramMergeSetting;
  }

  static PersistSetting wrapToPersistSetting(final Setting setting) {
    final PersistSetting paramPersistSetting = new PersistSetting();
    paramPersistSetting.setSetting(setting);
    return paramPersistSetting;
  }

  static RefreshSetting wrapToRefreshSetting(final Setting setting) {
    final RefreshSetting paramRefresSetting = new RefreshSetting();
    paramRefresSetting.setSetting(setting);
    return paramRefresSetting;
  }

  static RemoveSetting wrapToRemoveSetting(final Setting setting) {
    final RemoveSetting paramRemoveSetting = new RemoveSetting();
    paramRemoveSetting.setSetting(setting);
    return paramRemoveSetting;
  }
}
