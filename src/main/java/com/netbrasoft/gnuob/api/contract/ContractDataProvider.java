package com.netbrasoft.gnuob.api.contract;

import javax.annotation.Resource;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Controller;

import com.netbrasoft.gnuob.api.Contract;
import com.netbrasoft.gnuob.api.generic.AbstractGenericTypeDataProvider;
import com.netbrasoft.gnuob.api.generic.GenericTypeWebServiceRepository;

@Monitored
@Controller(ContractDataProvider.CONTRACT_DATA_PROVIDER_NAME)
public class ContractDataProvider<C extends Contract> extends AbstractGenericTypeDataProvider<C> {

  public static final String CONTRACT_DATA_PROVIDER_NAME = "ContractDataProvider";

  private static final long serialVersionUID = -7147810111954265342L;

  @Resource(name = ContractWebServiceRepository.CONTRACT_WEB_SERVICE_REPOSITORY_NAME)
  private transient GenericTypeWebServiceRepository<C> contractWebServiceRepository;

  @SuppressWarnings("unchecked")
  public ContractDataProvider() {
    super((C) new Contract());
  }

  @Override
  public GenericTypeWebServiceRepository<C> getGenericTypeWebServiceRepository() {
    return contractWebServiceRepository;
  }
}
