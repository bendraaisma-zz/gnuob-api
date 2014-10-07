package com.netbrasoft.gnuob.api.contract;

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

    private ContractWebServiceImpl contractWebServiceImpl;

    public ContractWebServiceRepository() {
    }

    public long count(MetaData paramMetaData, Contract paramContract) throws GNUOpenBusinessServiceException_Exception {
        CountContract paramCountContract = new CountContract();
        paramCountContract.setContract(paramContract);
        CountContractResponse countContractResponse = getContractWebServiceImpl().countContract(paramCountContract, paramMetaData);
        return countContractResponse.getReturn();
    }

    public Contract find(MetaData paramMetaData, Contract paramContract) throws GNUOpenBusinessServiceException_Exception {
        FindContractById paramFindContractById = new FindContractById();
        paramFindContractById.setContract(paramContract);
        FindContractByIdResponse findContractByIdResponse = getContractWebServiceImpl().findContractById(paramFindContractById, paramMetaData);
        return findContractByIdResponse.getReturn();

    }

    public List<Contract> find(MetaData paramMetaData, Contract paramContract, Paging paramPaging, OrderBy paramOrderBy) throws GNUOpenBusinessServiceException_Exception {
        FindContract paramFindContract = new FindContract();
        paramFindContract.setContract(paramContract);
        paramFindContract.setPaging(paramPaging);
        paramFindContract.setOrderBy(paramOrderBy);
        FindContractResponse findContractResponse = getContractWebServiceImpl().findContract(paramFindContract, paramMetaData);
        return findContractResponse.getReturn();
    }

    private ContractWebServiceImpl getContractWebServiceImpl() {
        if (contractWebServiceImpl == null) {
            ContractWebServiceImplService contractWebServiceImplService = new ContractWebServiceImplService(ContractWebServiceImplService.WSDL_LOCATION);
            contractWebServiceImpl = contractWebServiceImplService.getContractWebServiceImplPort();
        }

        return contractWebServiceImpl;
    }

    public Contract merge(MetaData paramMetaData, Contract paramContract) throws GNUOpenBusinessServiceException_Exception {
        MergeContract paramMergeContract = new MergeContract();
        paramMergeContract.setContract(paramContract);
        MergeContractResponse mergeContractResponse = getContractWebServiceImpl().mergeContract(paramMergeContract, paramMetaData);
        return mergeContractResponse.getReturn();
    }

    public Contract persist(MetaData paramMetaData, Contract paramContract) throws GNUOpenBusinessServiceException_Exception {
        PersistContract paramPersistContract = new PersistContract();
        paramPersistContract.setContract(paramContract);
        PersistContractResponse persistContractResponse = getContractWebServiceImpl().persistContract(paramPersistContract, paramMetaData);
        return persistContractResponse.getReturn();
    }

    public Contract refresh(MetaData paramMetaData, Contract paramContract) throws GNUOpenBusinessServiceException_Exception {
        RefreshContract paramRefresContract = new RefreshContract();
        paramRefresContract.setContract(paramContract);
        RefreshContractResponse refresContractResponse = getContractWebServiceImpl().refreshContract(paramRefresContract, paramMetaData);
        return refresContractResponse.getReturn();
    }

    public void remove(MetaData paramMetaData, Contract paramContract) throws GNUOpenBusinessServiceException_Exception {
        RemoveContract paramRemoveContract = new RemoveContract();
        paramRemoveContract.setContract(paramContract);
        getContractWebServiceImpl().removeContract(paramRemoveContract, paramMetaData);
    }
}
