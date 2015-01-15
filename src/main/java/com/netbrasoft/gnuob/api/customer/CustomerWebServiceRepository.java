package com.netbrasoft.gnuob.api.customer;

import java.util.List;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Repository;

import com.netbrasoft.gnuob.api.CountCustomer;
import com.netbrasoft.gnuob.api.CountCustomerResponse;
import com.netbrasoft.gnuob.api.Customer;
import com.netbrasoft.gnuob.api.CustomerWebServiceImpl;
import com.netbrasoft.gnuob.api.CustomerWebServiceImplService;
import com.netbrasoft.gnuob.api.FindCustomer;
import com.netbrasoft.gnuob.api.FindCustomerById;
import com.netbrasoft.gnuob.api.FindCustomerByIdResponse;
import com.netbrasoft.gnuob.api.FindCustomerResponse;
import com.netbrasoft.gnuob.api.MergeCustomer;
import com.netbrasoft.gnuob.api.MergeCustomerResponse;
import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.OrderBy;
import com.netbrasoft.gnuob.api.Paging;
import com.netbrasoft.gnuob.api.PersistCustomer;
import com.netbrasoft.gnuob.api.PersistCustomerResponse;
import com.netbrasoft.gnuob.api.RefreshCustomer;
import com.netbrasoft.gnuob.api.RefreshCustomerResponse;
import com.netbrasoft.gnuob.api.RemoveCustomer;
import com.netbrasoft.gnuob.api.generic.GenericTypeWebServiceRepository;

@Monitored
@Repository("CustomerWebServiceRepository")
public class CustomerWebServiceRepository<C extends Customer> implements GenericTypeWebServiceRepository<C> {

   private CustomerWebServiceImpl customerWebServiceImpl;

   public CustomerWebServiceRepository() {
   }

   @Override
   public long count(MetaData paramMetaData, C paramCustomer) {
      CountCustomer paramCountCustomer = new CountCustomer();
      paramCountCustomer.setCustomer(paramCustomer);
      CountCustomerResponse countCustomerResponse = getCustomerWebServiceImpl().countCustomer(paramCountCustomer, paramMetaData);
      return countCustomerResponse.getReturn();
   }

   @SuppressWarnings("unchecked")
   @Override
   public C find(MetaData paramMetaData, C paramCustomer) {
      FindCustomerById paramFindCustomerById = new FindCustomerById();
      paramFindCustomerById.setCustomer(paramCustomer);
      FindCustomerByIdResponse findCustomerByIdResponse = getCustomerWebServiceImpl().findCustomerById(paramFindCustomerById, paramMetaData);
      return (C) findCustomerByIdResponse.getReturn();

   }

   @SuppressWarnings("unchecked")
   @Override
   public List<C> find(MetaData paramMetaData, C paramCustomer, Paging paramPaging, OrderBy paramOrderBy) {
      FindCustomer paramFindCustomer = new FindCustomer();
      paramFindCustomer.setCustomer(paramCustomer);
      paramFindCustomer.setPaging(paramPaging);
      paramFindCustomer.setOrderBy(paramOrderBy);
      FindCustomerResponse findCustomerResponse = getCustomerWebServiceImpl().findCustomer(paramFindCustomer, paramMetaData);
      return (List<C>) findCustomerResponse.getReturn();
   }

   private CustomerWebServiceImpl getCustomerWebServiceImpl() {
      if (customerWebServiceImpl == null) {
         CustomerWebServiceImplService customerWebServiceImplService = new CustomerWebServiceImplService(CustomerWebServiceImplService.WSDL_LOCATION);
         customerWebServiceImpl = customerWebServiceImplService.getCustomerWebServiceImplPort();
      }

      return customerWebServiceImpl;
   }

   @SuppressWarnings("unchecked")
   @Override
   public C merge(MetaData paramMetaData, C paramCustomer) {
      MergeCustomer paramMergeCustomer = new MergeCustomer();
      paramMergeCustomer.setCustomer(paramCustomer);
      MergeCustomerResponse mergeCustomerResponse = getCustomerWebServiceImpl().mergeCustomer(paramMergeCustomer, paramMetaData);
      return (C) mergeCustomerResponse.getReturn();
   }

   @SuppressWarnings("unchecked")
   @Override
   public C persist(MetaData paramMetaData, C paramCustomer) {
      PersistCustomer paramPersistCustomer = new PersistCustomer();
      paramPersistCustomer.setCustomer(paramCustomer);
      PersistCustomerResponse persistCustomerResponse = getCustomerWebServiceImpl().persistCustomer(paramPersistCustomer, paramMetaData);
      return (C) persistCustomerResponse.getReturn();
   }

   @SuppressWarnings("unchecked")
   @Override
   public C refresh(MetaData paramMetaData, C paramCustomer) {
      RefreshCustomer paramRefresCustomer = new RefreshCustomer();
      paramRefresCustomer.setCustomer(paramCustomer);
      RefreshCustomerResponse refresCustomerResponse = getCustomerWebServiceImpl().refreshCustomer(paramRefresCustomer, paramMetaData);
      return (C) refresCustomerResponse.getReturn();
   }

   @Override
   public void remove(MetaData paramMetaData, C paramCustomer) {
      RemoveCustomer paramRemoveCustomer = new RemoveCustomer();
      paramRemoveCustomer.setCustomer(paramCustomer);
      getCustomerWebServiceImpl().removeCustomer(paramRemoveCustomer, paramMetaData);
   }
}
