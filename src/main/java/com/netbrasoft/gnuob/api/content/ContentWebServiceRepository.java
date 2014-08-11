package com.netbrasoft.gnuob.api.content;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.netbrasoft.gnuob.api.Content;
import com.netbrasoft.gnuob.api.ContentWebServiceImpl;
import com.netbrasoft.gnuob.api.ContentWebServiceImplService;
import com.netbrasoft.gnuob.api.CountContent;
import com.netbrasoft.gnuob.api.CountContentResponse;
import com.netbrasoft.gnuob.api.FindContent;
import com.netbrasoft.gnuob.api.FindContentById;
import com.netbrasoft.gnuob.api.FindContentByIdResponse;
import com.netbrasoft.gnuob.api.FindContentResponse;
import com.netbrasoft.gnuob.api.GNUOpenBusinessServiceException_Exception;
import com.netbrasoft.gnuob.api.MergeContent;
import com.netbrasoft.gnuob.api.MergeContentResponse;
import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.OrderBy;
import com.netbrasoft.gnuob.api.Paging;
import com.netbrasoft.gnuob.api.PersistContent;
import com.netbrasoft.gnuob.api.PersistContentResponse;
import com.netbrasoft.gnuob.api.RefreshContent;
import com.netbrasoft.gnuob.api.RefreshContentResponse;
import com.netbrasoft.gnuob.api.RemoveContent;

@Repository("ContentWebServiceRepository")
public class ContentWebServiceRepository {

	private ContentWebServiceImpl contentWebServiceImpl;

	public ContentWebServiceRepository() {
	}

	public long count(MetaData paramMetaData, Content paramContent) throws GNUOpenBusinessServiceException_Exception {
		CountContent paramCountContent = new CountContent();
		paramCountContent.setContent(paramContent);
		CountContentResponse countContentResponse = getContentWebServiceImpl().countContent(paramCountContent, paramMetaData);
		return countContentResponse.getReturn();
	}

	public Content find(MetaData paramMetaData, Content paramContent) throws GNUOpenBusinessServiceException_Exception {
		FindContentById paramFindContentById = new FindContentById();
		paramFindContentById.setContent(paramContent);
		FindContentByIdResponse findContentByIdResponse = getContentWebServiceImpl().findContentById(paramFindContentById, paramMetaData);
		return findContentByIdResponse.getReturn();

	}

	public List<Content> find(MetaData paramMetaData, Content paramContent, Paging paramPaging, OrderBy paramOrderBy) throws GNUOpenBusinessServiceException_Exception {
		FindContent paramFindContent = new FindContent();
		paramFindContent.setContent(paramContent);
		paramFindContent.setPaging(paramPaging);
		paramFindContent.setOrderBy(paramOrderBy);
		FindContentResponse findContentResponse = getContentWebServiceImpl().findContent(paramFindContent, paramMetaData);
		return findContentResponse.getReturn();
	}

	private ContentWebServiceImpl getContentWebServiceImpl() {
		if (contentWebServiceImpl == null) {
			ContentWebServiceImplService contentWebServiceImplService = new ContentWebServiceImplService(ContentWebServiceImplService.WSDL_LOCATION);
			contentWebServiceImpl = contentWebServiceImplService.getContentWebServiceImplPort();
		}
		return contentWebServiceImpl;
	}

	public Content merge(MetaData paramMetaData, Content paramContent) throws GNUOpenBusinessServiceException_Exception {
		MergeContent paramMergeContent = new MergeContent();
		paramMergeContent.setContent(paramContent);
		MergeContentResponse mergeContentResponse = getContentWebServiceImpl().mergeContent(paramMergeContent, paramMetaData);
		return mergeContentResponse.getReturn();
	}

	public Content persist(MetaData paramMetaData, Content paramContent) throws GNUOpenBusinessServiceException_Exception {
		PersistContent paramPersistContent = new PersistContent();
		paramPersistContent.setContent(paramContent);
		PersistContentResponse persistContentResponse = getContentWebServiceImpl().persistContent(paramPersistContent, paramMetaData);
		return persistContentResponse.getReturn();
	}

	public Content refresh(MetaData paramMetaData, Content paramContent) throws GNUOpenBusinessServiceException_Exception {
		RefreshContent paramRefresContent = new RefreshContent();
		paramRefresContent.setContent(paramContent);
		RefreshContentResponse refresContentResponse = getContentWebServiceImpl().refreshContent(paramRefresContent, paramMetaData);
		return refresContentResponse.getReturn();
	}

	public void remove(MetaData paramMetaData, Content paramContent) throws GNUOpenBusinessServiceException_Exception {
		RemoveContent paramRemoveContent = new RemoveContent();
		paramRemoveContent.setContent(paramContent);
		getContentWebServiceImpl().removeContent(paramRemoveContent, paramMetaData);
	}
}
