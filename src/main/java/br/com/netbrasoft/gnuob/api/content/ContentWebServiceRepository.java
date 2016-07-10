/*
 * Copyright 2016 Netbrasoft
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package br.com.netbrasoft.gnuob.api.content;

import static br.com.netbrasoft.gnuob.api.content.ContentWebServiceWrapperHelper.wrapToCountContent;
import static br.com.netbrasoft.gnuob.api.content.ContentWebServiceWrapperHelper.wrapToFindContent;
import static br.com.netbrasoft.gnuob.api.content.ContentWebServiceWrapperHelper.wrapToFindContentById;
import static br.com.netbrasoft.gnuob.api.content.ContentWebServiceWrapperHelper.wrapToMergeContent;
import static br.com.netbrasoft.gnuob.api.content.ContentWebServiceWrapperHelper.wrapToPersistContent;
import static br.com.netbrasoft.gnuob.api.content.ContentWebServiceWrapperHelper.wrapToRefreshContent;
import static br.com.netbrasoft.gnuob.api.content.ContentWebServiceWrapperHelper.wrapToRemoveContent;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.CONTENT_WEB_SERVICE_REPOSITORY_NAME;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.UNCHECKED_VALUE;

import java.util.List;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Repository;

import br.com.netbrasoft.gnuob.api.Content;
import br.com.netbrasoft.gnuob.api.ContentWebServiceImpl;
import br.com.netbrasoft.gnuob.api.ContentWebServiceImplService;
import br.com.netbrasoft.gnuob.api.MetaData;
import br.com.netbrasoft.gnuob.api.OrderBy;
import br.com.netbrasoft.gnuob.api.Paging;

import br.com.netbrasoft.gnuob.api.generic.IGenericTypeWebServiceRepository;

@Monitored
@Repository(CONTENT_WEB_SERVICE_REPOSITORY_NAME)
public class ContentWebServiceRepository<C extends Content> implements IGenericTypeWebServiceRepository<C> {

  private transient ContentWebServiceImpl contentWebServiceImpl;

  private ContentWebServiceImpl getContentWebServiceImpl() {
    if (contentWebServiceImpl == null) {
      contentWebServiceImpl = new ContentWebServiceImplService().getContentWebServiceImplPort();
    }
    return contentWebServiceImpl;
  }

  @Override
  public long count(final MetaData credentials, final C contentExample) {
    return getContentWebServiceImpl().countContent(wrapToCountContent(contentExample), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public List<C> find(final MetaData credentials, final C contentExample, final Paging paging,
      final OrderBy orderingProperty) {
    return (List<C>) getContentWebServiceImpl()
        .findContent(wrapToFindContent(contentExample, paging, orderingProperty), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public C find(final MetaData credentials, final C contentExample) {
    return (C) getContentWebServiceImpl().findContentById(wrapToFindContentById(contentExample), credentials)
        .getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public C persist(final MetaData credentials, final C content) {
    return (C) getContentWebServiceImpl().persistContent(wrapToPersistContent(content), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public C merge(final MetaData credentials, final C content) {
    return (C) getContentWebServiceImpl().mergeContent(wrapToMergeContent(content), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public C refresh(final MetaData credentials, final C content) {
    return (C) getContentWebServiceImpl().refreshContent(wrapToRefreshContent(content), credentials).getReturn();
  }

  @Override
  public void remove(final MetaData credentials, final C content) {
    getContentWebServiceImpl().removeContent(wrapToRemoveContent(content), credentials);
  }
}
