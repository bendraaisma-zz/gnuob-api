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

package br.com.netbrasoft.gnuob.api.offer;

import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.CAN_NOT_INITIALIZE_THE_DEFAULT_WSDL_FROM_0;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.GNUOB_SOAP_OFFER_WEBSERVICE_WSDL;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.HTTP_LOCALHOST_8080_GNUOB_SOAP_OFFER_WEB_SERVICE_IMPL_WSDL;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.OFFER_WEB_SERVICE_REPOSITORY_NAME;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.UNCHECKED_VALUE;
import static br.com.netbrasoft.gnuob.api.offer.OfferWebServiceWrapperHelper.wrapToCountOffer;
import static br.com.netbrasoft.gnuob.api.offer.OfferWebServiceWrapperHelper.wrapToFindOffer;
import static br.com.netbrasoft.gnuob.api.offer.OfferWebServiceWrapperHelper.wrapToFindOfferById;
import static br.com.netbrasoft.gnuob.api.offer.OfferWebServiceWrapperHelper.wrapToMergeOffer;
import static br.com.netbrasoft.gnuob.api.offer.OfferWebServiceWrapperHelper.wrapToPersistOffer;
import static br.com.netbrasoft.gnuob.api.offer.OfferWebServiceWrapperHelper.wrapToRefreshOffer;
import static br.com.netbrasoft.gnuob.api.offer.OfferWebServiceWrapperHelper.wrapToRemoveOffer;
import static java.lang.System.getProperty;
import static org.slf4j.LoggerFactory.getLogger;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.javasimon.aop.Monitored;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import br.com.netbrasoft.gnuob.api.MetaData;
import br.com.netbrasoft.gnuob.api.Offer;
import br.com.netbrasoft.gnuob.api.OfferWebServiceImpl;
import br.com.netbrasoft.gnuob.api.OfferWebServiceImplService;
import br.com.netbrasoft.gnuob.api.OrderBy;
import br.com.netbrasoft.gnuob.api.Paging;
import br.com.netbrasoft.gnuob.api.generic.IGenericTypeWebServiceRepository;

@Monitored
@Repository(OFFER_WEB_SERVICE_REPOSITORY_NAME)
public class OfferWebServiceRepository<O extends Offer> implements IGenericTypeWebServiceRepository<O> {

  private static final Logger LOGGER = getLogger(OfferWebServiceRepository.class);
  private static final URL WSDL_LOCATION;

  static {
    URL url = null;
    try {
      url = new URL(
          getProperty(GNUOB_SOAP_OFFER_WEBSERVICE_WSDL, HTTP_LOCALHOST_8080_GNUOB_SOAP_OFFER_WEB_SERVICE_IMPL_WSDL));
    } catch (final MalformedURLException e) {
      LOGGER.info(CAN_NOT_INITIALIZE_THE_DEFAULT_WSDL_FROM_0,
          getProperty(GNUOB_SOAP_OFFER_WEBSERVICE_WSDL, HTTP_LOCALHOST_8080_GNUOB_SOAP_OFFER_WEB_SERVICE_IMPL_WSDL));
    }
    WSDL_LOCATION = url;
  }

  private transient OfferWebServiceImpl offerWebServiceImpl;

  private OfferWebServiceImpl getOfferWebServiceImpl() {
    if (offerWebServiceImpl == null) {
      offerWebServiceImpl = new OfferWebServiceImplService(WSDL_LOCATION).getOfferWebServiceImplPort();
    }
    return offerWebServiceImpl;
  }

  @Override
  public long count(final MetaData credentials, final O offerExample) {
    return getOfferWebServiceImpl().countOffer(wrapToCountOffer(offerExample), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public List<O> find(final MetaData credentials, final O offerExample, final Paging paging,
      final OrderBy orderingProperty) {
    return (List<O>) getOfferWebServiceImpl()
        .findOffer(wrapToFindOffer(offerExample, paging, orderingProperty), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public O find(final MetaData credentials, final O offerExample) {
    return (O) getOfferWebServiceImpl().findOfferById(wrapToFindOfferById(offerExample), credentials).getReturn();

  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public O persist(final MetaData credentials, final O offer) {
    return (O) getOfferWebServiceImpl().persistOffer(wrapToPersistOffer(offer), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public O merge(final MetaData credentials, final O offer) {
    return (O) getOfferWebServiceImpl().mergeOffer(wrapToMergeOffer(offer), credentials).getReturn();
  }

  @SuppressWarnings(UNCHECKED_VALUE)
  @Override
  public O refresh(final MetaData credentials, final O offer) {
    return (O) getOfferWebServiceImpl().refreshOffer(wrapToRefreshOffer(offer), credentials).getReturn();
  }

  @Override
  public void remove(final MetaData credentials, final O offer) {
    getOfferWebServiceImpl().removeOffer(wrapToRemoveOffer(offer), credentials);
  }
}
