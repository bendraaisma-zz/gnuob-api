package com.netbrasoft.gnuob.api.security;

import javax.annotation.Resource;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Controller;

import com.netbrasoft.gnuob.api.Site;
import com.netbrasoft.gnuob.api.generic.AbstractGenericTypeDataProvider;
import com.netbrasoft.gnuob.api.generic.GenericTypeWebServiceRepository;

@Monitored
@Controller(SiteDataProvider.SITE_DATA_PROVIDER_NAME)
public class SiteDataProvider<S extends Site> extends AbstractGenericTypeDataProvider<S> {

  public static final String SITE_DATA_PROVIDER_NAME = "SiteDataProvider";

  private static final long serialVersionUID = -8167982674192813819L;

  @Resource(name = SiteWebServiceRepository.SITE_WEB_SERVICE_REPOSITORY_NAME)
  private transient GenericTypeWebServiceRepository<S> siteWebServiceRepository;

  @SuppressWarnings("unchecked")
  public SiteDataProvider() {
    super((S) new Site());
  }

  @Override
  public GenericTypeWebServiceRepository<S> getGenericTypeWebServiceRepository() {
    return siteWebServiceRepository;
  }
}
