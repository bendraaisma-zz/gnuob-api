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
@Repository("OfferWebServiceRepository")
public class OfferWebServiceRepository<O extends Offer> implements GenericTypeWebServiceRepository<O> {

   private OfferWebServiceImpl offerWebServiceImpl;

   public OfferWebServiceRepository() {
   }

   @Override
   public long count(MetaData paramMetaData, O paramOffer) {
      CountOffer paramCountOffer = new CountOffer();
      paramCountOffer.setOffer(paramOffer);
      CountOfferResponse countOfferResponse = getOfferWebServiceImpl().countOffer(paramCountOffer, paramMetaData);
      return countOfferResponse.getReturn();
   }

   @SuppressWarnings("unchecked")
   @Override
   public O find(MetaData paramMetaData, O paramOffer) {
      FindOfferById paramFindOfferById = new FindOfferById();
      paramFindOfferById.setOffer(paramOffer);
      FindOfferByIdResponse findOfferByIdResponse = getOfferWebServiceImpl().findOfferById(paramFindOfferById,
            paramMetaData);
      return (O) findOfferByIdResponse.getReturn();

   }

   @SuppressWarnings("unchecked")
   @Override
   public List<O> find(MetaData paramMetaData, O paramOffer, Paging paramPaging, OrderBy paramOrderBy) {
      FindOffer paramFindOffer = new FindOffer();
      paramFindOffer.setOffer(paramOffer);
      paramFindOffer.setPaging(paramPaging);
      paramFindOffer.setOrderBy(paramOrderBy);
      FindOfferResponse findOfferResponse = getOfferWebServiceImpl().findOffer(paramFindOffer, paramMetaData);
      return (List<O>) findOfferResponse.getReturn();
   }

   private OfferWebServiceImpl getOfferWebServiceImpl() {
      if (offerWebServiceImpl == null) {
         OfferWebServiceImplService offerWebServiceImplService = new OfferWebServiceImplService(
               OfferWebServiceImplService.WSDL_LOCATION);
         offerWebServiceImpl = offerWebServiceImplService.getOfferWebServiceImplPort();
      }
      return offerWebServiceImpl;
   }

   @SuppressWarnings("unchecked")
   @Override
   public O merge(MetaData paramMetaData, O paramOffer) {
      MergeOffer paramMergeOffer = new MergeOffer();
      paramMergeOffer.setOffer(paramOffer);
      MergeOfferResponse mergeOfferResponse = getOfferWebServiceImpl().mergeOffer(paramMergeOffer, paramMetaData);
      return (O) mergeOfferResponse.getReturn();
   }

   @SuppressWarnings("unchecked")
   @Override
   public O persist(MetaData paramMetaData, O paramOffer) {
      PersistOffer paramPersistOffer = new PersistOffer();
      paramPersistOffer.setOffer(paramOffer);
      PersistOfferResponse persistOfferResponse = getOfferWebServiceImpl().persistOffer(paramPersistOffer,
            paramMetaData);
      return (O) persistOfferResponse.getReturn();
   }

   @SuppressWarnings("unchecked")
   @Override
   public O refresh(MetaData paramMetaData, O paramOffer) {
      RefreshOffer paramRefresOffer = new RefreshOffer();
      paramRefresOffer.setOffer(paramOffer);
      RefreshOfferResponse refresOfferResponse = getOfferWebServiceImpl().refreshOffer(paramRefresOffer, paramMetaData);
      return (O) refresOfferResponse.getReturn();
   }

   @Override
   public void remove(MetaData paramMetaData, O paramOffer) {
      RemoveOffer paramRemoveOffer = new RemoveOffer();
      paramRemoveOffer.setOffer(paramOffer);
      getOfferWebServiceImpl().removeOffer(paramRemoveOffer, paramMetaData);
   }
}
