package br.com.netbrasoft.gnuob.api.security;

import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.CAN_NOT_INITIALIZE_THE_DEFAULT_WSDL_FROM_0;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.GNUOB_SOAP_GROUP_WEBSERVICE_WSDL;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.GROUP_WEB_SERVICE_REPOSITORY_NAME;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.HTTP_LOCALHOST_8080_GNUOB_SOAP_GROUP_WEB_SERVICE_IMPL_WSDL;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.UNCHECKED_VALUE;
import static br.com.netbrasoft.gnuob.api.security.GroupWebServiceWrapperHelper.wrapToCountGroup;
import static br.com.netbrasoft.gnuob.api.security.GroupWebServiceWrapperHelper.wrapToFindGroup;
import static br.com.netbrasoft.gnuob.api.security.GroupWebServiceWrapperHelper.wrapToFindGroupById;
import static br.com.netbrasoft.gnuob.api.security.GroupWebServiceWrapperHelper.wrapToMergeGroup;
import static br.com.netbrasoft.gnuob.api.security.GroupWebServiceWrapperHelper.wrapToPersistGroup;
import static br.com.netbrasoft.gnuob.api.security.GroupWebServiceWrapperHelper.wrapToRefreshGroup;
import static br.com.netbrasoft.gnuob.api.security.GroupWebServiceWrapperHelper.wrapToRemoveGroup;
import static java.lang.System.getProperty;
import static org.slf4j.LoggerFactory.getLogger;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.javasimon.aop.Monitored;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import br.com.netbrasoft.gnuob.api.Group;
import br.com.netbrasoft.gnuob.api.GroupWebServiceImpl;
import br.com.netbrasoft.gnuob.api.GroupWebServiceImplService;
import br.com.netbrasoft.gnuob.api.MetaData;
import br.com.netbrasoft.gnuob.api.OrderBy;
import br.com.netbrasoft.gnuob.api.Paging;
import br.com.netbrasoft.gnuob.api.generic.IGenericTypeWebServiceRepository;

@Monitored
@Repository(GROUP_WEB_SERVICE_REPOSITORY_NAME)
public class GroupWebServiceRepository<G extends Group> implements IGenericTypeWebServiceRepository<G> {

  private static final Logger LOGGER = getLogger(GroupWebServiceRepository.class);
  private static final URL WSDL_LOCATION;

  static {
    URL url = null;
    try {
      url = new URL(
          getProperty(GNUOB_SOAP_GROUP_WEBSERVICE_WSDL, HTTP_LOCALHOST_8080_GNUOB_SOAP_GROUP_WEB_SERVICE_IMPL_WSDL));
    } catch (final MalformedURLException e) {
      LOGGER.info(CAN_NOT_INITIALIZE_THE_DEFAULT_WSDL_FROM_0,
          getProperty(GNUOB_SOAP_GROUP_WEBSERVICE_WSDL, HTTP_LOCALHOST_8080_GNUOB_SOAP_GROUP_WEB_SERVICE_IMPL_WSDL));
    }
    WSDL_LOCATION = url;
  }

  private transient GroupWebServiceImpl groupWebServiceImpl;

  private GroupWebServiceImpl getGroupWebServiceImpl() {
    if (groupWebServiceImpl == null) {
      groupWebServiceImpl = new GroupWebServiceImplService(WSDL_LOCATION).getGroupWebServiceImplPort();
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
