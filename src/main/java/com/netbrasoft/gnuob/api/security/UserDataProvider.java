package com.netbrasoft.gnuob.api.security;

import javax.annotation.Resource;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Controller;

import com.netbrasoft.gnuob.api.User;
import com.netbrasoft.gnuob.api.generic.AbstractGenericTypeDataProvider;
import com.netbrasoft.gnuob.api.generic.GenericTypeWebServiceRepository;

@Monitored
@Controller("UserDataProvider")
public class UserDataProvider<U extends User> extends AbstractGenericTypeDataProvider<U> {

   private static final long serialVersionUID = -8167982674192813819L;

   @Resource(name = "UserWebServiceRepository")
   private GenericTypeWebServiceRepository<U> userWebServiceRepository;

   @SuppressWarnings("unchecked")
   public UserDataProvider() {
      super((U) new User());
   }

   @Override
   public GenericTypeWebServiceRepository<U> getGenericTypeWebServiceRepository() {
      return userWebServiceRepository;
   }
}
