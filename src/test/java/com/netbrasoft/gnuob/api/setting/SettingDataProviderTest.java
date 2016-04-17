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

import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.SETTING_DATA_PROVIDER_NAME;
import static com.netbrasoft.gnuob.generic.utils.EntityInstanceHelper.getSettingInstance;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.spring.integration.test.annotation.SpringWebConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.netbrasoft.gnuob.api.Setting;
import com.netbrasoft.gnuob.api.generic.AbstractGenericTypeDataProvider;
import com.netbrasoft.gnuob.api.generic.IGenericTypeDataProvider;
import com.netbrasoft.gnuob.generic.AbstractGenericTypeDataProviderTest;

@RunWith(Arquillian.class)
@SpringWebConfiguration()
public class SettingDataProviderTest extends AbstractGenericTypeDataProviderTest<Setting> {

  @Autowired
  @Qualifier(SETTING_DATA_PROVIDER_NAME)
  private AbstractGenericTypeDataProvider<Setting> settingDataProvider;

  private Setting setting;

  @Before
  public void setUp() throws Exception {
    settingDataProvider.setUser(ROOT);
    settingDataProvider.setPassword(ROOT);
    settingDataProvider.setSite("domain");
    settingDataProvider.getType().setActive(true);
    setting = settingDataProvider.persist(getSettingInstance());
  }

  @After
  public void tearDown() throws Exception {}

  @Override
  public IGenericTypeDataProvider<Setting> getGenericTypeProvider() {
    return settingDataProvider;
  }

  @Override
  public Setting getType() {
    return setting;
  }
}
