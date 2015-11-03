package com.netbrasoft.gnuob.api.offer;

import java.util.List;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Repository;

import com.netbrasoft.gnuob.api.CountOffer;
import com.netbrasoft.gnuob.api.CountOfferResponse;
import com.netbrasoft.gnuob.api.FindOffer;
import com.netbrasoft.gnuob.api.FindOfferById;
import com.netbrasoft.gnuob.api.FindOfferByIdResponse;
import com.netbrasoft.gnuob.api.FindOfferResponse;
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
import com.netbrasoft.gnuob.api.generic.GenericTypeWebServiceRepository;

@Monitored
@Repository(OfferWebServiceRepository.OFFER_WEB_SERVICE_REPOSITORY_NAME)
public class OfferWebServiceRepository<O extends Offer> implements GenericTypeWebServiceRepository<O> {

  protected static final String OFFER_WEB_SERVICE_REPOSITORY_NAME = "OfferWebServiceRepository";

  private OfferWebServiceImpl offerWebServiceImpl;

  public OfferWebServiceRepository() {
    // Empty constructor.
  }

  @Override
  public long count(final MetaData paramMetaData, final O paramOffer) {
    final CountOffer paramCountOffer = new CountOffer();
    paramCountOffer.setOffer(paramOffer);
    final CountOfferResponse countOfferResponse = getOfferWebServiceImpl().countOffer(paramCountOffer, paramMetaData);
    return countOfferResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public O find(final MetaData paramMetaData, final O paramOffer) {
    final FindOfferById paramFindOfferById = new FindOfferById();
    paramFindOfferById.setOffer(paramOffer);
    final FindOfferByIdResponse findOfferByIdResponse = getOfferWebServiceImpl().findOfferById(paramFindOfferById, paramMetaData);
    return (O) findOfferByIdResponse.getReturn();

  }

  @SuppressWarnings("unchecked")
  @Override
  public List<O> find(final MetaData paramMetaData, final O paramOffer, final Paging paramPaging, final OrderBy paramOrderBy) {
    final FindOffer paramFindOffer = new FindOffer();
    paramFindOffer.setOffer(paramOffer);
    paramFindOffer.setPaging(paramPaging);
    paramFindOffer.setOrderBy(paramOrderBy);
    final FindOfferResponse findOfferResponse = getOfferWebServiceImpl().findOffer(paramFindOffer, paramMetaData);
    return (List<O>) findOfferResponse.getReturn();
  }

  private OfferWebServiceImpl getOfferWebServiceImpl() {
    if (offerWebServiceImpl == null) {
      final OfferWebServiceImplService offerWebServiceImplService = new OfferWebServiceImplService(OfferWebServiceImplService.WSDL_LOCATION);
      offerWebServiceImpl = offerWebServiceImplService.getOfferWebServiceImplPort();
    }
    return offerWebServiceImpl;
  }

  @SuppressWarnings("unchecked")
  @Override
  public O merge(final MetaData paramMetaData, final O paramOffer) {
    final MergeOffer paramMergeOffer = new MergeOffer();
    paramMergeOffer.setOffer(paramOffer);
    final MergeOfferResponse mergeOfferResponse = getOfferWebServiceImpl().mergeOffer(paramMergeOffer, paramMetaData);
    return (O) mergeOfferResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public O persist(final MetaData paramMetaData, final O paramOffer) {
    final PersistOffer paramPersistOffer = new PersistOffer();
    paramPersistOffer.setOffer(paramOffer);
    final PersistOfferResponse persistOfferResponse = getOfferWebServiceImpl().persistOffer(paramPersistOffer, paramMetaData);
    return (O) persistOfferResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public O refresh(final MetaData paramMetaData, final O paramOffer) {
    final RefreshOffer paramRefresOffer = new RefreshOffer();
    paramRefresOffer.setOffer(paramOffer);
    final RefreshOfferResponse refresOfferResponse = getOfferWebServiceImpl().refreshOffer(paramRefresOffer, paramMetaData);
    return (O) refresOfferResponse.getReturn();
  }

  @Override
  public void remove(final MetaData paramMetaData, final O paramOffer) {
    final RemoveOffer paramRemoveOffer = new RemoveOffer();
    paramRemoveOffer.setOffer(paramOffer);
    getOfferWebServiceImpl().removeOffer(paramRemoveOffer, paramMetaData);
  }
}
