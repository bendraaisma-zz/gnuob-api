package com.netbrasoft.gnuob.api.security;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.netbrasoft.gnuob.api.CountUser;
import com.netbrasoft.gnuob.api.CountUserResponse;
import com.netbrasoft.gnuob.api.FindUser;
import com.netbrasoft.gnuob.api.FindUserById;
import com.netbrasoft.gnuob.api.FindUserByIdResponse;
import com.netbrasoft.gnuob.api.FindUserResponse;
import com.netbrasoft.gnuob.api.GNUOpenBusinessServiceException_Exception;
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

@Repository("UserWebServiceRepository")
public class UserWebServiceRepository {

	private static final String GNUOB_USER_WEB_SERVICE = System.getProperty("gnuob.user-service.url", "http://localhost:8080/gnuob-soap/UserWebServiceImpl?wsdl");
	private UserWebServiceImpl userWebServiceImpl;

	public UserWebServiceRepository() {
		try {
			UserWebServiceImplService userWebServiceImplService = new UserWebServiceImplService(new URL(GNUOB_USER_WEB_SERVICE));
			userWebServiceImpl = userWebServiceImplService.getUserWebServiceImplPort();
		} catch (MalformedURLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public long count(MetaData paramMetaData, User paramUser) throws GNUOpenBusinessServiceException_Exception {
		CountUser paramCountUser = new CountUser();
		paramCountUser.setUser(paramUser);
		CountUserResponse countUserResponse = userWebServiceImpl.countUser(paramCountUser, paramMetaData);
		return countUserResponse.getReturn();
	}

	public User find(MetaData paramMetaData, User paramUser) throws GNUOpenBusinessServiceException_Exception {
		FindUserById paramFindUserById = new FindUserById();
		paramFindUserById.setUser(paramUser);
		FindUserByIdResponse findUserByIdResponse = userWebServiceImpl.findUserById(paramFindUserById, paramMetaData);
		return findUserByIdResponse.getReturn();

	}

	public List<User> find(MetaData paramMetaData, User paramUser, Paging paramPaging, OrderBy paramOrderBy) throws GNUOpenBusinessServiceException_Exception {
		FindUser paramFindUser = new FindUser();
		paramFindUser.setUser(paramUser);
		paramFindUser.setPaging(paramPaging);
		paramFindUser.setOrderBy(paramOrderBy);
		FindUserResponse findUserResponse = userWebServiceImpl.findUser(paramFindUser, paramMetaData);
		return findUserResponse.getReturn();
	}

	public User merge(MetaData paramMetaData, User paramUser) throws GNUOpenBusinessServiceException_Exception {
		MergeUser paramMergeUser = new MergeUser();
		paramMergeUser.setUser(paramUser);
		MergeUserResponse mergeUserResponse = userWebServiceImpl.mergeUser(paramMergeUser, paramMetaData);
		return mergeUserResponse.getReturn();
	}

	public User persist(MetaData paramMetaData, User paramUser) throws GNUOpenBusinessServiceException_Exception {
		PersistUser paramPersistUser = new PersistUser();
		paramPersistUser.setUser(paramUser);
		PersistUserResponse persistUserResponse = userWebServiceImpl.persistUser(paramPersistUser, paramMetaData);
		return persistUserResponse.getReturn();
	}

	public User refresh(MetaData paramMetaData, User paramUser) throws GNUOpenBusinessServiceException_Exception {
		RefreshUser paramRefresUser = new RefreshUser();
		paramRefresUser.setUser(paramUser);
		RefreshUserResponse refresUserResponse = userWebServiceImpl.refreshUser(paramRefresUser, paramMetaData);
		return refresUserResponse.getReturn();
	}

	public void remove(MetaData paramMetaData, User paramUser) throws GNUOpenBusinessServiceException_Exception {
		RemoveUser paramRemoveUser = new RemoveUser();
		paramRemoveUser.setUser(paramUser);
		userWebServiceImpl.removeUser(paramRemoveUser, paramMetaData);
	}
}
