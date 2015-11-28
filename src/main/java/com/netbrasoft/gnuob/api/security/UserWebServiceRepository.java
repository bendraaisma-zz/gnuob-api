package com.netbrasoft.gnuob.api.security;

import java.util.List;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Repository;

import com.netbrasoft.gnuob.api.CountUser;
import com.netbrasoft.gnuob.api.CountUserResponse;
import com.netbrasoft.gnuob.api.FindUser;
import com.netbrasoft.gnuob.api.FindUserById;
import com.netbrasoft.gnuob.api.FindUserByIdResponse;
import com.netbrasoft.gnuob.api.FindUserResponse;
import com.netbrasoft.gnuob.api.MergeUser;
import com.netbrasoft.gnuob.api.MergeUserResponse;
import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.OrderBy;
import com.netbrasoft.gnuob.api.Paging;
import com.netbrasoft.gnuob.api.PersistUser;
import com.netbrasoft.gnuob.api.PersistUserResponse;
import com.netbrasoft.gnuob.api.RefreshUser;
import com.netbrasoft.gnuob.api.RefreshUserResponse;
import com.netbrasoft.gnuob.api.RemoveUser;
import com.netbrasoft.gnuob.api.User;
import com.netbrasoft.gnuob.api.UserWebServiceImpl;
import com.netbrasoft.gnuob.api.UserWebServiceImplService;
import com.netbrasoft.gnuob.api.generic.GenericTypeWebServiceRepository;

@Monitored
@Repository(UserWebServiceRepository.USER_WEB_SERVICE_REPOSITORY_NAME)
public class UserWebServiceRepository<U extends User> implements GenericTypeWebServiceRepository<U> {

  protected static final String USER_WEB_SERVICE_REPOSITORY_NAME = "UserWebServiceRepository";

  private UserWebServiceImpl userWebServiceImpl;

  public UserWebServiceRepository() {
    // Empty constructor.
  }

  @Override
  public long count(final MetaData paramMetaData, final U paramUser) {
    final CountUser paramCountUser = new CountUser();
    paramCountUser.setUser(paramUser);
    final CountUserResponse countUserResponse = getUserWebServiceImpl().countUser(paramCountUser, paramMetaData);
    return countUserResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public U find(final MetaData paramMetaData, final U paramUser) {
    final FindUserById paramFindUserById = new FindUserById();
    paramFindUserById.setUser(paramUser);
    final FindUserByIdResponse findUserByIdResponse = getUserWebServiceImpl().findUserById(paramFindUserById, paramMetaData);
    return (U) findUserByIdResponse.getReturn();

  }

  @SuppressWarnings("unchecked")
  @Override
  public List<U> find(final MetaData paramMetaData, final U paramUser, final Paging paramPaging, final OrderBy paramOrderBy) {
    final FindUser paramFindUser = new FindUser();
    paramFindUser.setUser(paramUser);
    paramFindUser.setPaging(paramPaging);
    paramFindUser.setOrderBy(paramOrderBy);
    final FindUserResponse findUserResponse = getUserWebServiceImpl().findUser(paramFindUser, paramMetaData);
    return (List<U>) findUserResponse.getReturn();
  }

  private UserWebServiceImpl getUserWebServiceImpl() {
    if (userWebServiceImpl == null) {
      final UserWebServiceImplService userWebServiceImplService = new UserWebServiceImplService(UserWebServiceImplService.WSDL_LOCATION);
      userWebServiceImpl = userWebServiceImplService.getUserWebServiceImplPort();
    }

    return userWebServiceImpl;
  }

  @SuppressWarnings("unchecked")
  @Override
  public U merge(final MetaData paramMetaData, final U paramUser) {
    final MergeUser paramMergeUser = new MergeUser();
    paramMergeUser.setUser(paramUser);
    final MergeUserResponse mergeUserResponse = getUserWebServiceImpl().mergeUser(paramMergeUser, paramMetaData);
    return (U) mergeUserResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public U persist(final MetaData paramMetaData, final U paramUser) {
    final PersistUser paramPersistUser = new PersistUser();
    paramPersistUser.setUser(paramUser);
    final PersistUserResponse persistUserResponse = getUserWebServiceImpl().persistUser(paramPersistUser, paramMetaData);
    return (U) persistUserResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public U refresh(final MetaData paramMetaData, final U paramUser) {
    final RefreshUser paramRefresUser = new RefreshUser();
    paramRefresUser.setUser(paramUser);
    final RefreshUserResponse refresUserResponse = getUserWebServiceImpl().refreshUser(paramRefresUser, paramMetaData);
    return (U) refresUserResponse.getReturn();
  }

  @Override
  public void remove(final MetaData paramMetaData, final U paramUser) {
    final RemoveUser paramRemoveUser = new RemoveUser();
    paramRemoveUser.setUser(paramUser);
    getUserWebServiceImpl().removeUser(paramRemoveUser, paramMetaData);
  }
}
