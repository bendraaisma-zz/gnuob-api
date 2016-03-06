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

package com.netbrasoft.gnuob.api.category;

import com.netbrasoft.gnuob.api.Category;
import com.netbrasoft.gnuob.api.CountCategory;
import com.netbrasoft.gnuob.api.FindCategory;
import com.netbrasoft.gnuob.api.FindCategoryById;
import com.netbrasoft.gnuob.api.MergeCategory;
import com.netbrasoft.gnuob.api.OrderBy;
import com.netbrasoft.gnuob.api.Paging;
import com.netbrasoft.gnuob.api.PersistCategory;
import com.netbrasoft.gnuob.api.RefreshCategory;
import com.netbrasoft.gnuob.api.RemoveCategory;

final class CategoryWebServiceWrapperHelper {

  private CategoryWebServiceWrapperHelper() {}

  static CountCategory wrapToCountCategory(final Category categoryExample) {
    final CountCategory paramCountCategory = new CountCategory();
    paramCountCategory.setCategory(categoryExample);
    return paramCountCategory;
  }

  static FindCategory wrapToFindCategory(final Category category, final Paging paging, final OrderBy orderingProperty) {
    final FindCategory paramFindCategory = new FindCategory();
    paramFindCategory.setCategory(category);
    paramFindCategory.setPaging(paging);
    paramFindCategory.setOrderBy(orderingProperty);
    return paramFindCategory;
  }

  static FindCategoryById wrapToFindCategoryById(final Category category) {
    final FindCategoryById paramFindCategoryById = new FindCategoryById();
    paramFindCategoryById.setCategory(category);
    return paramFindCategoryById;
  }

  static PersistCategory wrapToPersistCategory(final Category category) {
    final PersistCategory paramPersistCategory = new PersistCategory();
    paramPersistCategory.setCategory(category);
    return paramPersistCategory;
  }

  static MergeCategory wrapToMergeCategory(final Category category) {
    final MergeCategory paramMergeCategory = new MergeCategory();
    paramMergeCategory.setCategory(category);
    return paramMergeCategory;
  }

  static RefreshCategory wrapToRefreshCategory(final Category category) {
    final RefreshCategory paramRefresCategory = new RefreshCategory();
    paramRefresCategory.setCategory(category);
    return paramRefresCategory;
  }

  static RemoveCategory wrapToRemoveCategory(final Category category) {
    final RemoveCategory paramRemoveCategory = new RemoveCategory();
    paramRemoveCategory.setCategory(category);
    return paramRemoveCategory;
  }
}
