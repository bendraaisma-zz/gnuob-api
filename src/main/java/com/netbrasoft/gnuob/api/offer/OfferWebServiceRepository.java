package com.netbrasoft.gnuob.api.offer;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.netbrasoft.gnuob.api.CountOffer;
import com.netbrasoft.gnuob.api.CountOfferResponse;
import com.netbrasoft.gnuob.api.FindOffer;
import com.netbrasoft.gnuob.api.FindOfferById;
import com.netbrasoft.gnuob.api.FindOfferByIdResponse;
import com.netbrasoft.gnuob.api.FindOfferResponse;
import com.netbrasoft.gnuob.api.GNUOpenBusinessServiceException_Exception;
import com.netbrasoft.gnuob.api.MergeOffer;
import com.netbrasoft.gnuob.api.MergeOfferResponse;
import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.Offer;
import com.netbrasoft.gnuob.api.OfferWebServiceImpl;
import com.netbrasoft.gnuob.api.OfferWebServiceImplService;
import com.netbrasoft.gnuob.api.OrderBy;
import com.netbrasoft.gnuob.api.Paging;
import com.netbrasoft.gnuob.api.PersistOffer;
import com.netbrasoft.gnuob.api.PersistOfferResponse;
import com.netbrasoft.gnuob.api.RefreshOffer;
import com.netbrasoft.gnuob.api.RefreshOfferResponse;
import com.netbrasoft.gnuob.api.RemoveOffer;

@Repository("OfferWebServiceRepository")
public class OfferWebServiceRepository {

	private static final String GNUOB_OFFER_WEB_SERVICE = System.getProperty("gnuob.offer-service.url", "http://localhost:8080/gnuob-soap/OfferWebServiceImpl?wsdl");
	private OfferWebServiceImpl offerWebServiceImpl;

	public OfferWebServiceRepository() {
		try {
			OfferWebServiceImplService offerWebServiceImplService = new OfferWebServiceImplService(new URL(GNUOB_OFFER_WEB_SERVICE));
			offerWebServiceImpl = offerWebServiceImplService.getOfferWebServiceImplPort();
		} catch (MalformedURLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public long count(MetaData paramMetaData, Offer paramOffer) throws GNUOpenBusinessServiceException_Exception {
		CountOffer paramCountOffer = new CountOffer();
		paramCountOffer.setOffer(paramOffer);
		CountOfferResponse countOfferResponse = offerWebServiceImpl.countOffer(paramCountOffer, paramMetaData);
		return countOfferResponse.getReturn();
	}

	public Offer find(MetaData paramMetaData, Offer paramOffer) throws GNUOpenBusinessServiceException_Exception {
		FindOfferById paramFindOfferById = new FindOfferById();
		paramFindOfferById.setOffer(paramOffer);
		FindOfferByIdResponse findOfferByIdResponse = offerWebServiceImpl.findOfferById(paramFindOfferById, paramMetaData);
		return findOfferByIdResponse.getReturn();

	}

	public List<Offer> find(MetaData paramMetaData, Offer paramOffer, Paging paramPaging, OrderBy paramOrderBy) throws GNUOpenBusinessServiceException_Exception {
		FindOffer paramFindOffer = new FindOffer();
		paramFindOffer.setOffer(paramOffer);
		paramFindOffer.setPaging(paramPaging);
		paramFindOffer.setOrderBy(paramOrderBy);
		FindOfferResponse findOfferResponse = offerWebServiceImpl.findOffer(paramFindOffer, paramMetaData);
		return findOfferResponse.getReturn();
	}

	public Offer merge(MetaData paramMetaData, Offer paramOffer) throws GNUOpenBusinessServiceException_Exception {
		MergeOffer paramMergeOffer = new MergeOffer();
		paramMergeOffer.setOffer(paramOffer);
		MergeOfferResponse mergeOfferResponse = offerWebServiceImpl.mergeOffer(paramMergeOffer, paramMetaData);
		return mergeOfferResponse.getReturn();
	}

	public Offer persist(MetaData paramMetaData, Offer paramOffer) throws GNUOpenBusinessServiceException_Exception {
		PersistOffer paramPersistOffer = new PersistOffer();
		paramPersistOffer.setOffer(paramOffer);
		PersistOfferResponse persistOfferResponse = offerWebServiceImpl.persistOffer(paramPersistOffer, paramMetaData);
		return persistOfferResponse.getReturn();
	}

	public Offer refresh(MetaData paramMetaData, Offer paramOffer) throws GNUOpenBusinessServiceException_Exception {
		RefreshOffer paramRefresOffer = new RefreshOffer();
		paramRefresOffer.setOffer(paramOffer);
		RefreshOfferResponse refresOfferResponse = offerWebServiceImpl.refreshOffer(paramRefresOffer, paramMetaData);
		return refresOfferResponse.getReturn();
	}

	public void remove(MetaData paramMetaData, Offer paramOffer) throws GNUOpenBusinessServiceException_Exception {
		RemoveOffer paramRemoveOffer = new RemoveOffer();
		paramRemoveOffer.setOffer(paramOffer);
		offerWebServiceImpl.removeOffer(paramRemoveOffer, paramMetaData);
	}
}
