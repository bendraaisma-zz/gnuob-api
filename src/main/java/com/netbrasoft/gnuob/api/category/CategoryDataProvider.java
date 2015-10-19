package com.netbrasoft.gnuob.api.category;

import javax.annotation.Resource;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Controller;

import com.netbrasoft.gnuob.api.Category;
import com.netbrasoft.gnuob.api.generic.AbstractGenericTypeDataProvider;
import com.netbrasoft.gnuob.api.generic.GenericTypeWebServiceRepository;

@Monitored
@Controller("CategoryDataProvider")
public class CategoryDataProvider<C extends Category> extends AbstractGenericTypeDataProvider<C> {

  private static final long serialVersionUID = -7147813111234260412L;

  @Resource(name = "CategoryWebServiceRepository")
  private transient GenericTypeWebServiceRepository<C> categoryWebServiceRepository;

  @SuppressWarnings("unchecked")
  public CategoryDataProvider() {
    super((C) new Category());
  }

  @Override
  public GenericTypeWebServiceRepository<C> getGenericTypeWebServiceRepository() {
    return categoryWebServiceRepository;
  }
}
