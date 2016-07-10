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

import br.com.netbrasoft.gnuob.api.Content;
import br.com.netbrasoft.gnuob.api.CountContent;
import br.com.netbrasoft.gnuob.api.FindContent;
import br.com.netbrasoft.gnuob.api.FindContentById;
import br.com.netbrasoft.gnuob.api.MergeContent;
import br.com.netbrasoft.gnuob.api.OrderBy;
import br.com.netbrasoft.gnuob.api.Paging;
import br.com.netbrasoft.gnuob.api.PersistContent;
import br.com.netbrasoft.gnuob.api.RefreshContent;
import br.com.netbrasoft.gnuob.api.RemoveContent;

final class ContentWebServiceWrapperHelper {

  private ContentWebServiceWrapperHelper() {}

  static CountContent wrapToCountContent(final Content content) {
    final CountContent paramCountContent = new CountContent();
    paramCountContent.setContent(content);
    return paramCountContent;
  }

  static FindContent wrapToFindContent(final Content content, final Paging paging, final OrderBy orderingProperty) {
    final FindContent paramFindContent = new FindContent();
    paramFindContent.setContent(content);
    paramFindContent.setPaging(paging);
    paramFindContent.setOrderBy(orderingProperty);
    return paramFindContent;
  }

  static FindContentById wrapToFindContentById(final Content content) {
    final FindContentById paramFindContentById = new FindContentById();
    paramFindContentById.setContent(content);
    return paramFindContentById;
  }

  static PersistContent wrapToPersistContent(final Content content) {
    final PersistContent paramPersistContent = new PersistContent();
    paramPersistContent.setContent(content);
    return paramPersistContent;
  }

  static MergeContent wrapToMergeContent(final Content content) {
    final MergeContent paramMergeContent = new MergeContent();
    paramMergeContent.setContent(content);
    return paramMergeContent;
  }

  static RefreshContent wrapToRefreshContent(final Content content) {
    final RefreshContent paramRefresContent = new RefreshContent();
    paramRefresContent.setContent(content);
    return paramRefresContent;
  }

  static RemoveContent wrapToRemoveContent(final Content content) {
    final RemoveContent paramRemoveContent = new RemoveContent();
    paramRemoveContent.setContent(content);
    return paramRemoveContent;
  }
}
