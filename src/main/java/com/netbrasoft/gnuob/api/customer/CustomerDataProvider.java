package com.netbrasoft.gnuob.api.customer;

import javax.annotation.Resource;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Controller;

import com.netbrasoft.gnuob.api.Customer;
import com.netbrasoft.gnuob.api.generic.AbstractGenericTypeDataProvider;
import com.netbrasoft.gnuob.api.generic.GenericTypeWebServiceRepository;

@Monitored
@Controller("CustomerDataProvider")
public class CustomerDataProvider<C extends Customer> extends AbstractGenericTypeDataProvider<C> {

   private static final long serialVersionUID = -7147810111954264232L;

   @Resource(name = "CustomerWebServiceRepository")
   private GenericTypeWebServiceRepository<C> customerWebServiceRepository;

   @SuppressWarnings("unchecked")
   public CustomerDataProvider() {
      super((C) new Customer());
   }

   @Override
   public GenericTypeWebServiceRepository<C> getGenericTypeWebServiceRepository() {
      return customerWebServiceRepository;
   }
}
