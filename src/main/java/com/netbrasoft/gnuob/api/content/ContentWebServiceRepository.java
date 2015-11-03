package com.netbrasoft.gnuob.api.content;

import java.util.List;

import org.javasimon.aop.Monitored;
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
import com.netbrasoft.gnuob.api.generic.GenericTypeWebServiceRepository;

@Monitored
@Repository(ContentWebServiceRepository.CONTENT_WEB_SERVICE_REPOSITORY_NAME)
public class ContentWebServiceRepository<C extends Content> implements GenericTypeWebServiceRepository<C> {

  public static final String CONTENT_WEB_SERVICE_REPOSITORY_NAME = "ContentWebServiceRepository";

  private ContentWebServiceImpl contentWebServiceImpl;

  public ContentWebServiceRepository() {
    // Empty constructor.
  }

  @Override
  public long count(final MetaData paramMetaData, final C paramContent) {
    final CountContent paramCountContent = new CountContent();
    paramCountContent.setContent(paramContent);
    final CountContentResponse countContentResponse = getContentWebServiceImpl().countContent(paramCountContent, paramMetaData);
    return countContentResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public C find(final MetaData paramMetaData, final C paramContent) {
    final FindContentById paramFindContentById = new FindContentById();
    paramFindContentById.setContent(paramContent);
    final FindContentByIdResponse findContentByIdResponse = getContentWebServiceImpl().findContentById(paramFindContentById, paramMetaData);
    return (C) findContentByIdResponse.getReturn();

  }

  @SuppressWarnings("unchecked")
  @Override
  public List<C> find(final MetaData paramMetaData, final C paramContent, final Paging paramPaging, final OrderBy paramOrderBy) {
    final FindContent paramFindContent = new FindContent();
    paramFindContent.setContent(paramContent);
    paramFindContent.setPaging(paramPaging);
    paramFindContent.setOrderBy(paramOrderBy);
    final FindContentResponse findContentResponse = getContentWebServiceImpl().findContent(paramFindContent, paramMetaData);
    return (List<C>) findContentResponse.getReturn();
  }

  private ContentWebServiceImpl getContentWebServiceImpl() {
    if (contentWebServiceImpl == null) {
      final ContentWebServiceImplService contentWebServiceImplService = new ContentWebServiceImplService(ContentWebServiceImplService.WSDL_LOCATION);
      contentWebServiceImpl = contentWebServiceImplService.getContentWebServiceImplPort();
    }
    return contentWebServiceImpl;
  }

  @SuppressWarnings("unchecked")
  @Override
  public C merge(final MetaData paramMetaData, final C paramContent) {
    final MergeContent paramMergeContent = new MergeContent();
    paramMergeContent.setContent(paramContent);
    final MergeContentResponse mergeContentResponse = getContentWebServiceImpl().mergeContent(paramMergeContent, paramMetaData);
    return (C) mergeContentResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public C persist(final MetaData paramMetaData, final C paramContent) {
    final PersistContent paramPersistContent = new PersistContent();
    paramPersistContent.setContent(paramContent);
    final PersistContentResponse persistContentResponse = getContentWebServiceImpl().persistContent(paramPersistContent, paramMetaData);
    return (C) persistContentResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public C refresh(final MetaData paramMetaData, final C paramContent) {
    final RefreshContent paramRefresContent = new RefreshContent();
    paramRefresContent.setContent(paramContent);
    final RefreshContentResponse refresContentResponse = getContentWebServiceImpl().refreshContent(paramRefresContent, paramMetaData);
    return (C) refresContentResponse.getReturn();
  }

  @Override
  public void remove(final MetaData paramMetaData, final C paramContent) {
    final RemoveContent paramRemoveContent = new RemoveContent();
    paramRemoveContent.setContent(paramContent);
    getContentWebServiceImpl().removeContent(paramRemoveContent, paramMetaData);
  }
}
