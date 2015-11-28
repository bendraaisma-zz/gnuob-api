package com.netbrasoft.gnuob.api.customer;

import javax.annotation.Resource;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Controller;

import com.netbrasoft.gnuob.api.PostalCode;
import com.netbrasoft.gnuob.api.generic.AbstractGenericTypeDataProvider;
import com.netbrasoft.gnuob.api.generic.GenericTypeWebServiceRepository;

@Monitored
@Controller(PostalCodeDataProvider.POSTAL_CODE_DATA_PROVIDER_NAME)
public class PostalCodeDataProvider<T extends PostalCode> extends AbstractGenericTypeDataProvider<T> {

  public static final String POSTAL_CODE_DATA_PROVIDER_NAME = "PostalCodeDataProvider";

  private static final long serialVersionUID = -7147810111954264232L;

  @Resource(name = PostalCodeWebServiceRepository.POSTAL_CODE_WEB_SERVICE_REPOSITORY_NAME)
  private transient GenericTypeWebServiceRepository<T> postalCodeWebServiceRepository;

  @SuppressWarnings("unchecked")
  public PostalCodeDataProvider() {
    super((T) new PostalCode());
  }

  @Override
  public GenericTypeWebServiceRepository<T> getGenericTypeWebServiceRepository() {
    return postalCodeWebServiceRepository;
  }
}
