package com.netbrasoft.gnuob.api.customer;

import java.util.List;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Repository;

import com.netbrasoft.gnuob.api.CountPostalCode;
import com.netbrasoft.gnuob.api.CountPostalCodeResponse;
import com.netbrasoft.gnuob.api.FindPostalCode;
import com.netbrasoft.gnuob.api.FindPostalCodeById;
import com.netbrasoft.gnuob.api.FindPostalCodeByIdResponse;
import com.netbrasoft.gnuob.api.FindPostalCodeResponse;
import com.netbrasoft.gnuob.api.MergePostalCode;
import com.netbrasoft.gnuob.api.MergePostalCodeResponse;
import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.OrderBy;
import com.netbrasoft.gnuob.api.Paging;
import com.netbrasoft.gnuob.api.PersistPostalCode;
import com.netbrasoft.gnuob.api.PersistPostalCodeResponse;
import com.netbrasoft.gnuob.api.PostalCode;
import com.netbrasoft.gnuob.api.PostalCodeWebServiceImpl;
import com.netbrasoft.gnuob.api.PostalCodeWebServiceImplService;
import com.netbrasoft.gnuob.api.RefreshPostalCode;
import com.netbrasoft.gnuob.api.RefreshPostalCodeResponse;
import com.netbrasoft.gnuob.api.RemovePostalCode;
import com.netbrasoft.gnuob.api.generic.GenericTypeWebServiceRepository;

@Monitored
@Repository(PostalCodeWebServiceRepository.POSTAL_CODE_WEB_SERVICE_REPOSITORY_NAME)
public class PostalCodeWebServiceRepository<T extends PostalCode> implements GenericTypeWebServiceRepository<T> {

  protected static final String POSTAL_CODE_WEB_SERVICE_REPOSITORY_NAME = "PostalCodeWebServiceRepository";

  private PostalCodeWebServiceImpl postalCodeWebServiceImpl;

  public PostalCodeWebServiceRepository() {
    // Empty constructor.
  }

  @Override
  public long count(final MetaData metaData, final T type) {
    final CountPostalCode paramCountPostalCode = new CountPostalCode();
    paramCountPostalCode.setPostalCode(type);
    final CountPostalCodeResponse countPostalCodeResponse = getPostalCodeWebServiceImpl().countPostalCode(paramCountPostalCode, metaData);
    return countPostalCodeResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public T find(final MetaData metaData, final T type) {
    final FindPostalCodeById paramFindPostalCodeById = new FindPostalCodeById();
    paramFindPostalCodeById.setPostalCode(type);
    final FindPostalCodeByIdResponse findPostalCodeByIdResponse = getPostalCodeWebServiceImpl().findPostalCodeById(paramFindPostalCodeById, metaData);
    return (T) findPostalCodeByIdResponse.getReturn();

  }

  @SuppressWarnings("unchecked")
  @Override
  public List<T> find(final MetaData metaData, final T type, final Paging paramPaging, final OrderBy paramOrderBy) {
    final FindPostalCode paramFindPostalCode = new FindPostalCode();
    paramFindPostalCode.setPostalCode(type);
    paramFindPostalCode.setPaging(paramPaging);
    paramFindPostalCode.setOrderBy(paramOrderBy);
    final FindPostalCodeResponse findPostalCodeResponse = getPostalCodeWebServiceImpl().findPostalCode(paramFindPostalCode, metaData);
    return (List<T>) findPostalCodeResponse.getReturn();
  }

  private PostalCodeWebServiceImpl getPostalCodeWebServiceImpl() {
    if (postalCodeWebServiceImpl == null) {
      final PostalCodeWebServiceImplService postalCodeWebServiceImplService = new PostalCodeWebServiceImplService(PostalCodeWebServiceImplService.WSDL_LOCATION);
      postalCodeWebServiceImpl = postalCodeWebServiceImplService.getPostalCodeWebServiceImplPort();
    }

    return postalCodeWebServiceImpl;
  }

  @SuppressWarnings("unchecked")
  @Override
  public T merge(final MetaData metaData, final T type) {
    final MergePostalCode paramMergePostalCode = new MergePostalCode();
    paramMergePostalCode.setPostalCode(type);
    final MergePostalCodeResponse mergePostalCodeResponse = getPostalCodeWebServiceImpl().mergePostalCode(paramMergePostalCode, metaData);
    return (T) mergePostalCodeResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public T persist(final MetaData metaData, final T type) {
    final PersistPostalCode paramPersistPostalCode = new PersistPostalCode();
    paramPersistPostalCode.setPostalCode(type);
    final PersistPostalCodeResponse persistPostalCodeResponse = getPostalCodeWebServiceImpl().persistPostalCode(paramPersistPostalCode, metaData);
    return (T) persistPostalCodeResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public T refresh(final MetaData metaData, final T type) {
    final RefreshPostalCode paramRefresPostalCode = new RefreshPostalCode();
    paramRefresPostalCode.setPostalCode(type);
    final RefreshPostalCodeResponse refresPostalCodeResponse = getPostalCodeWebServiceImpl().refreshPostalCode(paramRefresPostalCode, metaData);
    return (T) refresPostalCodeResponse.getReturn();
  }

  @Override
  public void remove(final MetaData metaData, final T type) {
    final RemovePostalCode paramRemovePostalCode = new RemovePostalCode();
    paramRemovePostalCode.setPostalCode(type);
    getPostalCodeWebServiceImpl().removePostalCode(paramRemovePostalCode, metaData);
  }
}
