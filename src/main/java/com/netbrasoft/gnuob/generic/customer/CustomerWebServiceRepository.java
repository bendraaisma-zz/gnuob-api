package com.netbrasoft.gnuob.generic.customer;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

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
import com.netbrasoft.gnuob.api.GNUOpenBusinessServiceException_Exception;
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

@Repository("CustomerWebServiceRepository")
public class CustomerWebServiceRepository {

	private static final String GNUOB_CUSTOMER_WEB_SERVICE = System.getProperty("gnuob.customer-service.url", "http://localhost:8080/gnuob-soap/CustomerWebServiceImpl?wsdl");
	private CustomerWebServiceImpl customerWebServiceImpl;

	public CustomerWebServiceRepository() {
		try {
			CustomerWebServiceImplService customerWebServiceImplService = new CustomerWebServiceImplService(new URL(GNUOB_CUSTOMER_WEB_SERVICE));
			customerWebServiceImpl = customerWebServiceImplService.getCustomerWebServiceImplPort();
		} catch (MalformedURLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public long count(MetaData paramMetaData, Customer paramCustomer) throws GNUOpenBusinessServiceException_Exception {
		CountCustomer paramCountCustomer = new CountCustomer();
		paramCountCustomer.setCustomer(paramCustomer);
		CountCustomerResponse countCustomerResponse = customerWebServiceImpl.countCustomer(paramCountCustomer, paramMetaData);
		return countCustomerResponse.getReturn();
	}

	public Customer find(MetaData paramMetaData, Customer paramCustomer) throws GNUOpenBusinessServiceException_Exception {
		FindCustomerById paramFindCustomerById = new FindCustomerById();
		paramFindCustomerById.setCustomer(paramCustomer);
		FindCustomerByIdResponse findCustomerByIdResponse = customerWebServiceImpl.findCustomerById(paramFindCustomerById, paramMetaData);
		return findCustomerByIdResponse.getReturn();

	}

	public List<Customer> find(MetaData paramMetaData, Customer paramCustomer, Paging paramPaging, OrderBy paramOrderBy) throws GNUOpenBusinessServiceException_Exception {
		FindCustomer paramFindCustomer = new FindCustomer();
		paramFindCustomer.setCustomer(paramCustomer);
		paramFindCustomer.setPaging(paramPaging);
		paramFindCustomer.setOrderBy(paramOrderBy);
		FindCustomerResponse findCustomerResponse = customerWebServiceImpl.findCustomer(paramFindCustomer, paramMetaData);
		return findCustomerResponse.getReturn();
	}

	public Customer merge(MetaData paramMetaData, Customer paramCustomer) throws GNUOpenBusinessServiceException_Exception {
		MergeCustomer paramMergeCustomer = new MergeCustomer();
		paramMergeCustomer.setCustomer(paramCustomer);
		MergeCustomerResponse mergeCustomerResponse = customerWebServiceImpl.mergeCustomer(paramMergeCustomer, paramMetaData);
		return mergeCustomerResponse.getReturn();
	}

	public Customer persist(MetaData paramMetaData, Customer paramCustomer) throws GNUOpenBusinessServiceException_Exception {
		PersistCustomer paramPersistCustomer = new PersistCustomer();
		paramPersistCustomer.setCustomer(paramCustomer);
		PersistCustomerResponse persistCustomerResponse = customerWebServiceImpl.persistCustomer(paramPersistCustomer, paramMetaData);
		return persistCustomerResponse.getReturn();
	}

	public Customer refresh(MetaData paramMetaData, Customer paramCustomer) throws GNUOpenBusinessServiceException_Exception {
		RefreshCustomer paramRefresCustomer = new RefreshCustomer();
		paramRefresCustomer.setCustomer(paramCustomer);
		RefreshCustomerResponse refresCustomerResponse = customerWebServiceImpl.refreshCustomer(paramRefresCustomer, paramMetaData);
		return refresCustomerResponse.getReturn();
	}

	public void remove(MetaData paramMetaData, Customer paramCustomer) throws GNUOpenBusinessServiceException_Exception {
		RemoveCustomer paramRemoveCustomer = new RemoveCustomer();
		paramRemoveCustomer.setCustomer(paramCustomer);
		customerWebServiceImpl.removeCustomer(paramRemoveCustomer, paramMetaData);
	}
}
