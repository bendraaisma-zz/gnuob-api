package com.netbrasoft.gnuob.api.content;

import javax.annotation.Resource;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Controller;

import com.netbrasoft.gnuob.api.Content;
import com.netbrasoft.gnuob.api.generic.AbstractGenericTypeDataProvider;
import com.netbrasoft.gnuob.api.generic.GenericTypeWebServiceRepository;

@Monitored
@Controller(ContentDataProvider.CONTENT_DATA_PROVIDER_NAME)
public class ContentDataProvider<C extends Content> extends AbstractGenericTypeDataProvider<C> {

  public static final String CONTENT_DATA_PROVIDER_NAME = "ContentDataProvider";

  private static final long serialVersionUID = -7147810111952342412L;

  @Resource(name = ContentWebServiceRepository.CONTENT_WEB_SERVICE_REPOSITORY_NAME)
  private transient GenericTypeWebServiceRepository<C> contentWebServiceRepository;

  @SuppressWarnings("unchecked")
  public ContentDataProvider() {
    super((C) new Content());
  }

  @Override
  public GenericTypeWebServiceRepository<C> getGenericTypeWebServiceRepository() {
    return contentWebServiceRepository;
  }
}
