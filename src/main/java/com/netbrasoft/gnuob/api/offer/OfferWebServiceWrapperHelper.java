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

package com.netbrasoft.gnuob.api.offer;

import com.netbrasoft.gnuob.api.CountOffer;
import com.netbrasoft.gnuob.api.FindOffer;
import com.netbrasoft.gnuob.api.FindOfferById;
import com.netbrasoft.gnuob.api.MergeOffer;
import com.netbrasoft.gnuob.api.Offer;
import com.netbrasoft.gnuob.api.OrderBy;
import com.netbrasoft.gnuob.api.Paging;
import com.netbrasoft.gnuob.api.PersistOffer;
import com.netbrasoft.gnuob.api.RefreshOffer;
import com.netbrasoft.gnuob.api.RemoveOffer;

final class OfferWebServiceWrapperHelper {

  private OfferWebServiceWrapperHelper() {}

  static CountOffer wrapToCountOffer(final Offer offer) {
    final CountOffer paramCountOffer = new CountOffer();
    paramCountOffer.setOffer(offer);
    return paramCountOffer;
  }

  static FindOffer wrapToFindOffer(final Offer offer, final Paging paging, final OrderBy orderingProperty) {
    final FindOffer paramFindOffer = new FindOffer();
    paramFindOffer.setOffer(offer);
    paramFindOffer.setPaging(paging);
    paramFindOffer.setOrderBy(orderingProperty);
    return paramFindOffer;
  }

  static FindOfferById wrapToFindOfferById(final Offer offer) {
    final FindOfferById paramFindOfferById = new FindOfferById();
    paramFindOfferById.setOffer(offer);
    return paramFindOfferById;
  }

  static PersistOffer wrapToPersistOffer(final Offer offer) {
    final PersistOffer paramPersistOffer = new PersistOffer();
    paramPersistOffer.setOffer(offer);
    return paramPersistOffer;
  }

  static MergeOffer wrapToMergeOffer(final Offer offer) {
    final MergeOffer paramMergeOffer = new MergeOffer();
    paramMergeOffer.setOffer(offer);
    return paramMergeOffer;
  }

  static RefreshOffer wrapToRefreshOffer(final Offer offer) {
    final RefreshOffer paramRefresOffer = new RefreshOffer();
    paramRefresOffer.setOffer(offer);
    return paramRefresOffer;
  }

  static RemoveOffer wrapToRemoveOffer(final Offer offer) {
    final RemoveOffer paramRemoveOffer = new RemoveOffer();
    paramRemoveOffer.setOffer(offer);
    return paramRemoveOffer;
  }
}
