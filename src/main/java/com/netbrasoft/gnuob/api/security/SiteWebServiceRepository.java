package com.netbrasoft.gnuob.api.security;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.netbrasoft.gnuob.api.CountSite;
import com.netbrasoft.gnuob.api.CountSiteResponse;
import com.netbrasoft.gnuob.api.FindSite;
import com.netbrasoft.gnuob.api.FindSiteById;
import com.netbrasoft.gnuob.api.FindSiteByIdResponse;
import com.netbrasoft.gnuob.api.FindSiteResponse;
import com.netbrasoft.gnuob.api.GNUOpenBusinessServiceException_Exception;
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

@Repository("SiteWebServiceRepository")
public class SiteWebServiceRepository {

	private SiteWebServiceImpl siteWebServiceImpl;

	public SiteWebServiceRepository() {
	}

	public long count(MetaData paramMetaData, Site paramSite) throws GNUOpenBusinessServiceException_Exception {
		CountSite paramCountSite = new CountSite();
		paramCountSite.setSite(paramSite);
		CountSiteResponse countSiteResponse = getSiteWebServiceImpl().countSite(paramCountSite, paramMetaData);
		return countSiteResponse.getReturn();
	}

	public Site find(MetaData paramMetaData, Site paramSite) throws GNUOpenBusinessServiceException_Exception {
		FindSiteById paramFindSiteById = new FindSiteById();
		paramFindSiteById.setSite(paramSite);
		FindSiteByIdResponse findSiteByIdResponse = getSiteWebServiceImpl().findSiteById(paramFindSiteById, paramMetaData);
		return findSiteByIdResponse.getReturn();

	}

	public List<Site> find(MetaData paramMetaData, Site paramSite, Paging paramPaging, OrderBy paramOrderBy) throws GNUOpenBusinessServiceException_Exception {
		FindSite paramFindSite = new FindSite();
		paramFindSite.setSite(paramSite);
		paramFindSite.setPaging(paramPaging);
		paramFindSite.setOrderBy(paramOrderBy);
		FindSiteResponse findSiteResponse = getSiteWebServiceImpl().findSite(paramFindSite, paramMetaData);
		return findSiteResponse.getReturn();
	}

	private SiteWebServiceImpl getSiteWebServiceImpl() {
		if (siteWebServiceImpl == null) {
			SiteWebServiceImplService siteWebServiceImplService = new SiteWebServiceImplService(SiteWebServiceImplService.WSDL_LOCATION);
			siteWebServiceImpl = siteWebServiceImplService.getSiteWebServiceImplPort();
		}

		return siteWebServiceImpl;
	}

	public Site merge(MetaData paramMetaData, Site paramSite) throws GNUOpenBusinessServiceException_Exception {
		MergeSite paramMergeSite = new MergeSite();
		paramMergeSite.setSite(paramSite);
		MergeSiteResponse mergeSiteResponse = getSiteWebServiceImpl().mergeSite(paramMergeSite, paramMetaData);
		return mergeSiteResponse.getReturn();
	}

	public Site persist(MetaData paramMetaData, Site paramSite) throws GNUOpenBusinessServiceException_Exception {
		PersistSite paramPersistSite = new PersistSite();
		paramPersistSite.setSite(paramSite);
		PersistSiteResponse persistSiteResponse = getSiteWebServiceImpl().persistSite(paramPersistSite, paramMetaData);
		return persistSiteResponse.getReturn();
	}

	public Site refresh(MetaData paramMetaData, Site paramSite) throws GNUOpenBusinessServiceException_Exception {
		RefreshSite paramRefresSite = new RefreshSite();
		paramRefresSite.setSite(paramSite);
		RefreshSiteResponse refresSiteResponse = getSiteWebServiceImpl().refreshSite(paramRefresSite, paramMetaData);
		return refresSiteResponse.getReturn();
	}

	public void remove(MetaData paramMetaData, Site paramSite) throws GNUOpenBusinessServiceException_Exception {
		RemoveSite paramRemoveSite = new RemoveSite();
		paramRemoveSite.setSite(paramSite);
		getSiteWebServiceImpl().removeSite(paramRemoveSite, paramMetaData);
	}
}
