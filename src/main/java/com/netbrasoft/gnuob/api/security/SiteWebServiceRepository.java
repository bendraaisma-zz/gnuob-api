package com.netbrasoft.gnuob.api.security;

import java.util.List;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Repository;

import com.netbrasoft.gnuob.api.CountSite;
import com.netbrasoft.gnuob.api.CountSiteResponse;
import com.netbrasoft.gnuob.api.FindSite;
import com.netbrasoft.gnuob.api.FindSiteById;
import com.netbrasoft.gnuob.api.FindSiteByIdResponse;
import com.netbrasoft.gnuob.api.FindSiteResponse;
import com.netbrasoft.gnuob.api.MergeSite;
import com.netbrasoft.gnuob.api.MergeSiteResponse;
import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.OrderBy;
import com.netbrasoft.gnuob.api.Paging;
import com.netbrasoft.gnuob.api.PersistSite;
import com.netbrasoft.gnuob.api.PersistSiteResponse;
import com.netbrasoft.gnuob.api.RefreshSite;
import com.netbrasoft.gnuob.api.RefreshSiteResponse;
import com.netbrasoft.gnuob.api.RemoveSite;
import com.netbrasoft.gnuob.api.Site;
import com.netbrasoft.gnuob.api.SiteWebServiceImpl;
import com.netbrasoft.gnuob.api.SiteWebServiceImplService;
import com.netbrasoft.gnuob.api.generic.GenericTypeWebServiceRepository;

@Monitored
@Repository(SiteWebServiceRepository.SITE_WEB_SERVICE_REPOSITORY_NAME)
public class SiteWebServiceRepository<S extends Site> implements GenericTypeWebServiceRepository<S> {

  protected static final String SITE_WEB_SERVICE_REPOSITORY_NAME = "SiteWebServiceRepository";

  private SiteWebServiceImpl siteWebServiceImpl;

  public SiteWebServiceRepository() {
    // Empty constructor.
  }

  @Override
  public long count(final MetaData paramMetaData, final S paramSite) {
    final CountSite paramCountSite = new CountSite();
    paramCountSite.setSite(paramSite);
    final CountSiteResponse countSiteResponse = getSiteWebServiceImpl().countSite(paramCountSite, paramMetaData);
    return countSiteResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public S find(final MetaData paramMetaData, final S paramSite) {
    final FindSiteById paramFindSiteById = new FindSiteById();
    paramFindSiteById.setSite(paramSite);
    final FindSiteByIdResponse findSiteByIdResponse = getSiteWebServiceImpl().findSiteById(paramFindSiteById, paramMetaData);
    return (S) findSiteByIdResponse.getReturn();

  }

  @SuppressWarnings("unchecked")
  @Override
  public List<S> find(final MetaData paramMetaData, final S paramSite, final Paging paramPaging, final OrderBy paramOrderBy) {
    final FindSite paramFindSite = new FindSite();
    paramFindSite.setSite(paramSite);
    paramFindSite.setPaging(paramPaging);
    paramFindSite.setOrderBy(paramOrderBy);
    final FindSiteResponse findSiteResponse = getSiteWebServiceImpl().findSite(paramFindSite, paramMetaData);
    return (List<S>) findSiteResponse.getReturn();
  }

  private SiteWebServiceImpl getSiteWebServiceImpl() {
    if (siteWebServiceImpl == null) {
      final SiteWebServiceImplService siteWebServiceImplService = new SiteWebServiceImplService(SiteWebServiceImplService.WSDL_LOCATION);
      siteWebServiceImpl = siteWebServiceImplService.getSiteWebServiceImplPort();
    }

    return siteWebServiceImpl;
  }

  @SuppressWarnings("unchecked")
  @Override
  public S merge(final MetaData paramMetaData, final S paramSite) {
    final MergeSite paramMergeSite = new MergeSite();
    paramMergeSite.setSite(paramSite);
    final MergeSiteResponse mergeSiteResponse = getSiteWebServiceImpl().mergeSite(paramMergeSite, paramMetaData);
    return (S) mergeSiteResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public S persist(final MetaData paramMetaData, final S paramSite) {
    final PersistSite paramPersistSite = new PersistSite();
    paramPersistSite.setSite(paramSite);
    final PersistSiteResponse persistSiteResponse = getSiteWebServiceImpl().persistSite(paramPersistSite, paramMetaData);
    return (S) persistSiteResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public S refresh(final MetaData paramMetaData, final S paramSite) {
    final RefreshSite paramRefresSite = new RefreshSite();
    paramRefresSite.setSite(paramSite);
    final RefreshSiteResponse refresSiteResponse = getSiteWebServiceImpl().refreshSite(paramRefresSite, paramMetaData);
    return (S) refresSiteResponse.getReturn();
  }

  @Override
  public void remove(final MetaData paramMetaData, final S paramSite) {
    final RemoveSite paramRemoveSite = new RemoveSite();
    paramRemoveSite.setSite(paramSite);
    getSiteWebServiceImpl().removeSite(paramRemoveSite, paramMetaData);
  }
}
