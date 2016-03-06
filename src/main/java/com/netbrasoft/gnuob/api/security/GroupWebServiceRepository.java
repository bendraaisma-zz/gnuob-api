package com.netbrasoft.gnuob.api.security;

import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.GROUP_WEB_SERVICE_REPOSITORY_NAME;
import static com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.UNCHECKED_VALUE;
import static com.netbrasoft.gnuob.api.security.GroupWebServiceWrapperHelper.wrapToCountGroup;
import static com.netbrasoft.gnuob.api.security.GroupWebServiceWrapperHelper.wrapToFindGroup;
import static com.netbrasoft.gnuob.api.security.GroupWebServiceWrapperHelper.wrapToFindGroupById;
import static com.netbrasoft.gnuob.api.security.GroupWebServiceWrapperHelper.wrapToMergeGroup;
import static com.netbrasoft.gnuob.api.security.GroupWebServiceWrapperHelper.wrapToPersistGroup;
import static com.netbrasoft.gnuob.api.security.GroupWebServiceWrapperHelper.wrapToRefreshGroup;
import static com.netbrasoft.gnuob.api.security.GroupWebServiceWrapperHelper.wrapToRemoveGroup;

import java.util.List;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Repository;

import com.netbrasoft.gnuob.api.Group;
import com.netbrasoft.gnuob.api.GroupWebServiceImpl;
import com.netbrasoft.gnuob.api.GroupWebServiceImplService;
import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.OrderBy;
import com.netbrasoft.gnuob.api.Paging;
import com.netbrasoft.gnuob.api.generic.IGenericTypeWebServiceRepository;

@Monitored
@Repository(GROUP_WEB_SERVICE_REPOSITORY_NAME)
public class GroupWebServiceRepository<G extends Group> implements IGenericTypeWebServiceRepository<G> {

  private transient GroupWebServiceImpl groupWebServiceImpl;

  private GroupWebServiceImpl getGroupWebServiceImpl() {
    if (groupWebServiceImpl == null) {
      groupWebServiceImpl = new GroupWebServiceImplService().getGroupWebServiceImplPort();
    }
    return groupWebServiceImpl;
  }

  @Override
  public long count(final MetaData credentials, final G groupExample) {
    return getGroupWebServiceImpl().countGroup(wrapToCountGroup(groupExample), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public List<G> find(final MetaData credentials, final G groupExample, final Paging paging,
      final OrderBy orderingProperty) {
    return (List<G>) getGroupWebServiceImpl()
        .findGroup(wrapToFindGroup(groupExample, paging, orderingProperty), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public G find(final MetaData credentials, final G groupExample) {
    return (G) getGroupWebServiceImpl().findGroupById(wrapToFindGroupById(groupExample), credentials).getReturn();

  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public G persist(final MetaData credentials, final G group) {
    return (G) getGroupWebServiceImpl().persistGroup(wrapToPersistGroup(group), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public G merge(final MetaData credentials, final G group) {
    return (G) getGroupWebServiceImpl().mergeGroup(wrapToMergeGroup(group), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public G refresh(final MetaData credentials, final G group) {
    return (G) getGroupWebServiceImpl().refreshGroup(wrapToRefreshGroup(group), credentials).getReturn();
  }

  @Override
  public void remove(final MetaData credentials, final G group) {
    getGroupWebServiceImpl().removeGroup(wrapToRemoveGroup(group), credentials);
  }
}
