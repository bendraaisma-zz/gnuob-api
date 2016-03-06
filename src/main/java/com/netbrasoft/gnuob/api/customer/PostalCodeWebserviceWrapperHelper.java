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

package com.netbrasoft.gnuob.api.customer;

import com.netbrasoft.gnuob.api.CountPostalCode;
import com.netbrasoft.gnuob.api.FindPostalCode;
import com.netbrasoft.gnuob.api.FindPostalCodeById;
import com.netbrasoft.gnuob.api.MergePostalCode;
import com.netbrasoft.gnuob.api.OrderBy;
import com.netbrasoft.gnuob.api.Paging;
import com.netbrasoft.gnuob.api.PersistPostalCode;
import com.netbrasoft.gnuob.api.PostalCode;
import com.netbrasoft.gnuob.api.RefreshPostalCode;
import com.netbrasoft.gnuob.api.RemovePostalCode;

final class PostalCodeWebserviceWrapperHelper {

  private PostalCodeWebserviceWrapperHelper() {}

  static CountPostalCode wrapToCountPostalCode(final PostalCode postalCode) {
    final CountPostalCode paramCountPostalCode = new CountPostalCode();
    paramCountPostalCode.setPostalCode(postalCode);
    return paramCountPostalCode;
  }

  static FindPostalCode wrapFindPostalCode(final PostalCode postalCode, final Paging paging,
      final OrderBy orderingProperty) {
    final FindPostalCode paramFindPostalCode = new FindPostalCode();
    paramFindPostalCode.setPostalCode(postalCode);
    paramFindPostalCode.setPaging(paging);
    paramFindPostalCode.setOrderBy(orderingProperty);
    return paramFindPostalCode;
  }

  static FindPostalCodeById wrapToFindPostalCodeById(final PostalCode postalCode) {
    final FindPostalCodeById paramFindPostalCodeById = new FindPostalCodeById();
    paramFindPostalCodeById.setPostalCode(postalCode);
    return paramFindPostalCodeById;
  }

  static PersistPostalCode wrapToPersistPostalCode(final PostalCode postalCode) {
    final PersistPostalCode paramPersistPostalCode = new PersistPostalCode();
    paramPersistPostalCode.setPostalCode(postalCode);
    return paramPersistPostalCode;
  }

  static MergePostalCode wrapToMergePostalCode(final PostalCode postalCode) {
    final MergePostalCode paramMergePostalCode = new MergePostalCode();
    paramMergePostalCode.setPostalCode(postalCode);
    return paramMergePostalCode;
  }

  static RefreshPostalCode wrapToRefreshPostalCode(final PostalCode postalCode) {
    final RefreshPostalCode paramRefresPostalCode = new RefreshPostalCode();
    paramRefresPostalCode.setPostalCode(postalCode);
    return paramRefresPostalCode;
  }

  static RemovePostalCode wrapToRemovePostalCode(final PostalCode postalCode) {
    final RemovePostalCode paramRemovePostalCode = new RemovePostalCode();
    paramRemovePostalCode.setPostalCode(postalCode);
    return paramRemovePostalCode;
  }
}
