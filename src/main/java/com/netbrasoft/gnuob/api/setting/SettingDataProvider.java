package com.netbrasoft.gnuob.api.setting;

import javax.annotation.Resource;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Controller;

import com.netbrasoft.gnuob.api.Setting;
import com.netbrasoft.gnuob.api.generic.AbstractGenericTypeDataProvider;
import com.netbrasoft.gnuob.api.generic.GenericTypeWebServiceRepository;

@Monitored
@Controller("SettingDataProvider")
public class SettingDataProvider<S extends Setting> extends AbstractGenericTypeDataProvider<S> {

  private static final long serialVersionUID = -919053464359522143L;

  @Resource(name = "SettingWebServiceRepository")
  private transient GenericTypeWebServiceRepository<S> settingWebServiceRepository;

  @SuppressWarnings("unchecked")
  public SettingDataProvider() {
    super((S) new Setting());
  }

  @Override
  public GenericTypeWebServiceRepository<S> getGenericTypeWebServiceRepository() {
    return settingWebServiceRepository;
  }
}
