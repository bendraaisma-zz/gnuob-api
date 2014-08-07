package com.netbrasoft.gnuob.generic.security;

import java.net.MalformedURLException;
import java.net.URL;
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

	private static final String GNUOB_SITE_WEB_SERVICE = System.getProperty("gnuob.site-service.url", "http://localhost:8080/gnuob-soap/SiteWebServiceImpl?wsdl");
	private SiteWebServiceImpl siteWebServiceImpl;

	public SiteWebServiceRepository() {
		try {
			SiteWebServiceImplService siteWebServiceImplService = new SiteWebServiceImplService(new URL(GNUOB_SITE_WEB_SERVICE));
			siteWebServiceImpl = siteWebServiceImplService.getSiteWebServiceImplPort();
		} catch (MalformedURLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public long count(MetaData paramMetaData, Site paramSite) throws GNUOpenBusinessServiceException_Exception {
		CountSite paramCountSite = new CountSite();
		paramCountSite.setSite(paramSite);
		CountSiteResponse countSiteResponse = siteWebServiceImpl.countSite(paramCountSite, paramMetaData);
		return countSiteResponse.getReturn();
	}

	public Site find(MetaData paramMetaData, Site paramSite) throws GNUOpenBusinessServiceException_Exception {
		FindSiteById paramFindSiteById = new FindSiteById();
		paramFindSiteById.setSite(paramSite);
		FindSiteByIdResponse findSiteByIdResponse = siteWebServiceImpl.findSiteById(paramFindSiteById, paramMetaData);
		return findSiteByIdResponse.getReturn();

	}

	public List<Site> find(MetaData paramMetaData, Site paramSite, Paging paramPaging, OrderBy paramOrderBy) throws GNUOpenBusinessServiceException_Exception {
		FindSite paramFindSite = new FindSite();
		paramFindSite.setSite(paramSite);
		paramFindSite.setPaging(paramPaging);
		paramFindSite.setOrderBy(paramOrderBy);
		FindSiteResponse findSiteResponse = siteWebServiceImpl.findSite(paramFindSite, paramMetaData);
		return findSiteResponse.getReturn();
	}

	public Site merge(MetaData paramMetaData, Site paramSite) throws GNUOpenBusinessServiceException_Exception {
		MergeSite paramMergeSite = new MergeSite();
		paramMergeSite.setSite(paramSite);
		MergeSiteResponse mergeSiteResponse = siteWebServiceImpl.mergeSite(paramMergeSite, paramMetaData);
		return mergeSiteResponse.getReturn();
	}

	public Site persist(MetaData paramMetaData, Site paramSite) throws GNUOpenBusinessServiceException_Exception {
		PersistSite paramPersistSite = new PersistSite();
		paramPersistSite.setSite(paramSite);
		PersistSiteResponse persistSiteResponse = siteWebServiceImpl.persistSite(paramPersistSite, paramMetaData);
		return persistSiteResponse.getReturn();
	}

	public Site refresh(MetaData paramMetaData, Site paramSite) throws GNUOpenBusinessServiceException_Exception {
		RefreshSite paramRefresSite = new RefreshSite();
		paramRefresSite.setSite(paramSite);
		RefreshSiteResponse refresSiteResponse = siteWebServiceImpl.refreshSite(paramRefresSite, paramMetaData);
		return refresSiteResponse.getReturn();
	}

	public void remove(MetaData paramMetaData, Site paramSite) throws GNUOpenBusinessServiceException_Exception {
		RemoveSite paramRemoveSite = new RemoveSite();
		paramRemoveSite.setSite(paramSite);
		siteWebServiceImpl.removeSite(paramRemoveSite, paramMetaData);
	}
}
