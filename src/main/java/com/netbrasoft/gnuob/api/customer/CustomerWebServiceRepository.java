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
@Repository(CustomerWebServiceRepository.CUSTOMER_WEB_SERVICE_REPOSITORY_NAME)
public class CustomerWebServiceRepository<C extends Customer> implements GenericTypeWebServiceRepository<C> {

  protected static final String CUSTOMER_WEB_SERVICE_REPOSITORY_NAME = "CustomerWebServiceRepository";

  private CustomerWebServiceImpl customerWebServiceImpl;

  public CustomerWebServiceRepository() {
    // Empty constructor.
  }

  @Override
  public long count(final MetaData paramMetaData, final C paramCustomer) {
    final CountCustomer paramCountCustomer = new CountCustomer();
    paramCountCustomer.setCustomer(paramCustomer);
    final CountCustomerResponse countCustomerResponse = getCustomerWebServiceImpl().countCustomer(paramCountCustomer, paramMetaData);
    return countCustomerResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public C find(final MetaData paramMetaData, final C paramCustomer) {
    final FindCustomerById paramFindCustomerById = new FindCustomerById();
    paramFindCustomerById.setCustomer(paramCustomer);
    final FindCustomerByIdResponse findCustomerByIdResponse = getCustomerWebServiceImpl().findCustomerById(paramFindCustomerById, paramMetaData);
    return (C) findCustomerByIdResponse.getReturn();

  }

  @SuppressWarnings("unchecked")
  @Override
  public List<C> find(final MetaData paramMetaData, final C paramCustomer, final Paging paramPaging, final OrderBy paramOrderBy) {
    final FindCustomer paramFindCustomer = new FindCustomer();
    paramFindCustomer.setCustomer(paramCustomer);
    paramFindCustomer.setPaging(paramPaging);
    paramFindCustomer.setOrderBy(paramOrderBy);
    final FindCustomerResponse findCustomerResponse = getCustomerWebServiceImpl().findCustomer(paramFindCustomer, paramMetaData);
    return (List<C>) findCustomerResponse.getReturn();
  }

  private CustomerWebServiceImpl getCustomerWebServiceImpl() {
    if (customerWebServiceImpl == null) {
      final CustomerWebServiceImplService customerWebServiceImplService = new CustomerWebServiceImplService(CustomerWebServiceImplService.WSDL_LOCATION);
      customerWebServiceImpl = customerWebServiceImplService.getCustomerWebServiceImplPort();
    }

    return customerWebServiceImpl;
  }

  @SuppressWarnings("unchecked")
  @Override
  public C merge(final MetaData paramMetaData, final C paramCustomer) {
    final MergeCustomer paramMergeCustomer = new MergeCustomer();
    paramMergeCustomer.setCustomer(paramCustomer);
    final MergeCustomerResponse mergeCustomerResponse = getCustomerWebServiceImpl().mergeCustomer(paramMergeCustomer, paramMetaData);
    return (C) mergeCustomerResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public C persist(final MetaData paramMetaData, final C paramCustomer) {
    final PersistCustomer paramPersistCustomer = new PersistCustomer();
    paramPersistCustomer.setCustomer(paramCustomer);
    final PersistCustomerResponse persistCustomerResponse = getCustomerWebServiceImpl().persistCustomer(paramPersistCustomer, paramMetaData);
    return (C) persistCustomerResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public C refresh(final MetaData paramMetaData, final C paramCustomer) {
    final RefreshCustomer paramRefresCustomer = new RefreshCustomer();
    paramRefresCustomer.setCustomer(paramCustomer);
    final RefreshCustomerResponse refresCustomerResponse = getCustomerWebServiceImpl().refreshCustomer(paramRefresCustomer, paramMetaData);
    return (C) refresCustomerResponse.getReturn();
  }

  @Override
  public void remove(final MetaData paramMetaData, final C paramCustomer) {
    final RemoveCustomer paramRemoveCustomer = new RemoveCustomer();
    paramRemoveCustomer.setCustomer(paramCustomer);
    getCustomerWebServiceImpl().removeCustomer(paramRemoveCustomer, paramMetaData);
  }
}
