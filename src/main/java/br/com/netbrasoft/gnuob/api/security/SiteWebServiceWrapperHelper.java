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

package br.com.netbrasoft.gnuob.api.security;

import br.com.netbrasoft.gnuob.api.CountSite;
import br.com.netbrasoft.gnuob.api.FindSite;
import br.com.netbrasoft.gnuob.api.FindSiteById;
import br.com.netbrasoft.gnuob.api.MergeSite;
import br.com.netbrasoft.gnuob.api.OrderBy;
import br.com.netbrasoft.gnuob.api.Paging;
import br.com.netbrasoft.gnuob.api.PersistSite;
import br.com.netbrasoft.gnuob.api.RefreshSite;
import br.com.netbrasoft.gnuob.api.RemoveSite;
import br.com.netbrasoft.gnuob.api.Site;

final class SiteWebServiceWrapperHelper {

  private SiteWebServiceWrapperHelper() {}

  static CountSite wraptToCountSite(final Site siteExample) {
    final CountSite paramCountSite = new CountSite();
    paramCountSite.setSite(siteExample);
    return paramCountSite;
  }

  static FindSite wrapToFindSite(final Site siteExample, final Paging paging, final OrderBy orderingProperty) {
    final FindSite paramFindSite = new FindSite();
    paramFindSite.setSite(siteExample);
    paramFindSite.setPaging(paging);
    paramFindSite.setOrderBy(orderingProperty);
    return paramFindSite;
  }

  static FindSiteById wrapToFindSiteById(final Site site) {
    final FindSiteById paramFindSiteById = new FindSiteById();
    paramFindSiteById.setSite(site);
    return paramFindSiteById;
  }

  static PersistSite wrapToPersistSite(final Site site) {
    final PersistSite paramPersistSite = new PersistSite();
    paramPersistSite.setSite(site);
    return paramPersistSite;
  }

  static MergeSite wrapToMergeSite(final Site site) {
    final MergeSite paramMergeSite = new MergeSite();
    paramMergeSite.setSite(site);
    return paramMergeSite;
  }

  static RefreshSite wrapToRefreshSite(final Site site) {
    final RefreshSite paramRefresSite = new RefreshSite();
    paramRefresSite.setSite(site);
    return paramRefresSite;
  }

  static RemoveSite wrapToRemoveSite(final Site site) {
    final RemoveSite paramRemoveSite = new RemoveSite();
    paramRemoveSite.setSite(site);
    return paramRemoveSite;
  }
}
