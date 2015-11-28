package com.netbrasoft.gnuob.api.security;

import javax.annotation.Resource;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Controller;

import com.netbrasoft.gnuob.api.User;
import com.netbrasoft.gnuob.api.generic.AbstractGenericTypeDataProvider;
import com.netbrasoft.gnuob.api.generic.GenericTypeWebServiceRepository;

@Monitored
@Controller(UserDataProvider.USER_DATA_PROVIDER_NAME)
public class UserDataProvider<U extends User> extends AbstractGenericTypeDataProvider<U> {

  public static final String USER_DATA_PROVIDER_NAME = "UserDataProvider";

  private static final long serialVersionUID = -8167982674192813819L;

  @Resource(name = UserWebServiceRepository.USER_WEB_SERVICE_REPOSITORY_NAME)
  private transient GenericTypeWebServiceRepository<U> userWebServiceRepository;

  @SuppressWarnings("unchecked")
  public UserDataProvider() {
    super((U) new User());
  }

  @Override
  public GenericTypeWebServiceRepository<U> getGenericTypeWebServiceRepository() {
    return userWebServiceRepository;
  }
}
