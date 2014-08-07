package com.netbrasoft.gnuob.generic.contract;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.netbrasoft.gnuob.api.Contract;
import com.netbrasoft.gnuob.api.ContractWebServiceImpl;
import com.netbrasoft.gnuob.api.ContractWebServiceImplService;
import com.netbrasoft.gnuob.api.CountContract;
import com.netbrasoft.gnuob.api.CountContractResponse;
import com.netbrasoft.gnuob.api.FindContract;
import com.netbrasoft.gnuob.api.FindContractById;
import com.netbrasoft.gnuob.api.FindContractByIdResponse;
import com.netbrasoft.gnuob.api.FindContractResponse;
import com.netbrasoft.gnuob.api.GNUOpenBusinessServiceException_Exception;
import com.netbrasoft.gnuob.api.MergeContract;
import com.netbrasoft.gnuob.api.MergeContractResponse;
import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.OrderBy;
import com.netbrasoft.gnuob.api.Paging;
import com.netbrasoft.gnuob.api.PersistContract;
import com.netbrasoft.gnuob.api.PersistContractResponse;
import com.netbrasoft.gnuob.api.RefreshContract;
import com.netbrasoft.gnuob.api.RefreshContractResponse;
import com.netbrasoft.gnuob.api.RemoveContract;

@Repository("ContractWebServiceRepository")
public class ContractWebServiceRepository {

	private static final String GNUOB_CONTRACT_WEB_SERVICE = System.getProperty("gnuob.contract-service.url", "http://localhost:8080/gnuob-soap/ContractWebServiceImpl?wsdl");
	private ContractWebServiceImpl contractWebServiceImpl;

	public ContractWebServiceRepository() {
		try {
			ContractWebServiceImplService contractWebServiceImplService = new ContractWebServiceImplService(new URL(GNUOB_CONTRACT_WEB_SERVICE));
			contractWebServiceImpl = contractWebServiceImplService.getContractWebServiceImplPort();
		} catch (MalformedURLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public long count(MetaData paramMetaData, Contract paramContract) throws GNUOpenBusinessServiceException_Exception {
		CountContract paramCountContract = new CountContract();
		paramCountContract.setContract(paramContract);
		CountContractResponse countContractResponse = contractWebServiceImpl.countContract(paramCountContract, paramMetaData);
		return countContractResponse.getReturn();
	}

	public Contract find(MetaData paramMetaData, Contract paramContract) throws GNUOpenBusinessServiceException_Exception {
		FindContractById paramFindContractById = new FindContractById();
		paramFindContractById.setContract(paramContract);
		FindContractByIdResponse findContractByIdResponse = contractWebServiceImpl.findContractById(paramFindContractById, paramMetaData);
		return findContractByIdResponse.getReturn();

	}

	public List<Contract> find(MetaData paramMetaData, Contract paramContract, Paging paramPaging, OrderBy paramOrderBy) throws GNUOpenBusinessServiceException_Exception {
		FindContract paramFindContract = new FindContract();
		paramFindContract.setContract(paramContract);
		paramFindContract.setPaging(paramPaging);
		paramFindContract.setOrderBy(paramOrderBy);
		FindContractResponse findContractResponse = contractWebServiceImpl.findContract(paramFindContract, paramMetaData);
		return findContractResponse.getReturn();
	}

	public Contract merge(MetaData paramMetaData, Contract paramContract) throws GNUOpenBusinessServiceException_Exception {
		MergeContract paramMergeContract = new MergeContract();
		paramMergeContract.setContract(paramContract);
		MergeContractResponse mergeContractResponse = contractWebServiceImpl.mergeContract(paramMergeContract, paramMetaData);
		return mergeContractResponse.getReturn();
	}

	public Contract persist(MetaData paramMetaData, Contract paramContract) throws GNUOpenBusinessServiceException_Exception {
		PersistContract paramPersistContract = new PersistContract();
		paramPersistContract.setContract(paramContract);
		PersistContractResponse persistContractResponse = contractWebServiceImpl.persistContract(paramPersistContract, paramMetaData);
		return persistContractResponse.getReturn();
	}

	public Contract refresh(MetaData paramMetaData, Contract paramContract) throws GNUOpenBusinessServiceException_Exception {
		RefreshContract paramRefresContract = new RefreshContract();
		paramRefresContract.setContract(paramContract);
		RefreshContractResponse refresContractResponse = contractWebServiceImpl.refreshContract(paramRefresContract, paramMetaData);
		return refresContractResponse.getReturn();
	}

	public void remove(MetaData paramMetaData, Contract paramContract) throws GNUOpenBusinessServiceException_Exception {
		RemoveContract paramRemoveContract = new RemoveContract();
		paramRemoveContract.setContract(paramContract);
		contractWebServiceImpl.removeContract(paramRemoveContract, paramMetaData);
	}
}
