package com.netbrasoft.gnuob.api.offer;

import javax.annotation.Resource;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Controller;

import com.netbrasoft.gnuob.api.Offer;
import com.netbrasoft.gnuob.api.generic.AbstractGenericTypeDataProvider;
import com.netbrasoft.gnuob.api.generic.GenericTypeWebServiceRepository;

@Monitored
@Controller("OfferDataProvider")
public class OfferDataProvider<C extends Offer> extends AbstractGenericTypeDataProvider<C> {

   private static final long serialVersionUID = -1570846724067511139L;

   @Resource(name = "OfferWebServiceRepository")
   private GenericTypeWebServiceRepository<C> offerWebServiceRepository;

   @SuppressWarnings("unchecked")
   public OfferDataProvider() {
      super((C) new Offer());
   }

   @Override
   public GenericTypeWebServiceRepository<C> getGenericTypeWebServiceRepository() {
      return offerWebServiceRepository;
   }
}
