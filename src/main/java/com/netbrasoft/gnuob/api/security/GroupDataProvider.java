package com.netbrasoft.gnuob.api.security;

import javax.annotation.Resource;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Controller;

import com.netbrasoft.gnuob.api.Group;
import com.netbrasoft.gnuob.api.generic.AbstractGenericTypeDataProvider;
import com.netbrasoft.gnuob.api.generic.GenericTypeWebServiceRepository;

@Monitored
@Controller(GroupDataProvider.GROUP_DATA_PROVIDER_NAME)
public class GroupDataProvider<G extends Group> extends AbstractGenericTypeDataProvider<G> {

  public static final String GROUP_DATA_PROVIDER_NAME = "GroupDataProvider";

  private static final long serialVersionUID = -8167982674192813819L;

  @Resource(name = GroupWebServiceRepository.GROUP_WEB_SERVICE_REPOSITORY_NAME)
  private transient GenericTypeWebServiceRepository<G> groupWebServiceRepository;

  @SuppressWarnings("unchecked")
  public GroupDataProvider() {
    super((G) new Group());
  }

  @Override
  public GenericTypeWebServiceRepository<G> getGenericTypeWebServiceRepository() {
    return groupWebServiceRepository;
  }
}
