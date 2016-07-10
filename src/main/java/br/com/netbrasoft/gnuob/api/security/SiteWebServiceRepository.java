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

import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.SITE_WEB_SERVICE_REPOSITORY_NAME;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.UNCHECKED_VALUE;
import static br.com.netbrasoft.gnuob.api.security.SiteWebServiceWrapperHelper.wrapToFindSite;
import static br.com.netbrasoft.gnuob.api.security.SiteWebServiceWrapperHelper.wrapToFindSiteById;
import static br.com.netbrasoft.gnuob.api.security.SiteWebServiceWrapperHelper.wrapToMergeSite;
import static br.com.netbrasoft.gnuob.api.security.SiteWebServiceWrapperHelper.wrapToPersistSite;
import static br.com.netbrasoft.gnuob.api.security.SiteWebServiceWrapperHelper.wrapToRefreshSite;
import static br.com.netbrasoft.gnuob.api.security.SiteWebServiceWrapperHelper.wrapToRemoveSite;
import static br.com.netbrasoft.gnuob.api.security.SiteWebServiceWrapperHelper.wraptToCountSite;

import java.util.List;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Repository;

import br.com.netbrasoft.gnuob.api.MetaData;
import br.com.netbrasoft.gnuob.api.OrderBy;
import br.com.netbrasoft.gnuob.api.Paging;
import br.com.netbrasoft.gnuob.api.Site;
import br.com.netbrasoft.gnuob.api.SiteWebServiceImpl;
import br.com.netbrasoft.gnuob.api.SiteWebServiceImplService;

import br.com.netbrasoft.gnuob.api.generic.IGenericTypeWebServiceRepository;

@Monitored
@Repository(SITE_WEB_SERVICE_REPOSITORY_NAME)
public class SiteWebServiceRepository<S extends Site> implements IGenericTypeWebServiceRepository<S> {

  private transient SiteWebServiceImpl siteWebServiceImpl;

  private SiteWebServiceImpl getSiteWebServiceImpl() {
    if (siteWebServiceImpl == null) {
      siteWebServiceImpl = new SiteWebServiceImplService().getSiteWebServiceImplPort();
    }
    return siteWebServiceImpl;
  }

  @Override
  public long count(final MetaData credentials, final S siteExample) {
    return getSiteWebServiceImpl().countSite(wraptToCountSite(siteExample), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public List<S> find(final MetaData credentials, final S siteExample, final Paging paging,
      final OrderBy orderingProperty) {
    return (List<S>) getSiteWebServiceImpl()
        .findSite(wrapToFindSite(siteExample, paging, orderingProperty), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public S find(final MetaData credentials, final S site) {
    return (S) getSiteWebServiceImpl().findSiteById(wrapToFindSiteById(site), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public S persist(final MetaData credentials, final S site) {
    return (S) getSiteWebServiceImpl().persistSite(wrapToPersistSite(site), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public S merge(final MetaData credentials, final S site) {
    return (S) getSiteWebServiceImpl().mergeSite(wrapToMergeSite(site), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public S refresh(final MetaData credentials, final S site) {
    return (S) getSiteWebServiceImpl().refreshSite(wrapToRefreshSite(site), credentials).getReturn();
  }

  @Override
  public void remove(final MetaData credentials, final S site) {
    getSiteWebServiceImpl().removeSite(wrapToRemoveSite(site), credentials);
  }
}
