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

package br.com.netbrasoft.gnuob.api.generic;

import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.AMOUNT_PROPERTY;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.BESTSELLER_PROPERTY;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.CONTRACT_ID_PROPERTY;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.COUNTRY_CODE_PROPERTY;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.CREATION_PROPERTY;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.DESCRIPTION_PROPERTY;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.DISCOUNT_PROPERTY;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.FIRST_NAME_PROPERTY;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.LAST_NAME_PROPERTY;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.LATEST_COLLECTION_PROPERTY;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.MODIFICATION_PROPERTY;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.NAME_PROPERTY;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.NUMBER_PROPERTY;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.OFFER_ID_PROPERTY;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.ORDER_ID_PROPERTY;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.PLACE_NAME_PROPERTY;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.POSITION_PROPERTY;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.POSTAL_CODE_PROPERTY;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.PROPERTY_PROPERTY;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.RATING_PROPERTY;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.RECOMMENDED_PROPERTY;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.STATE_NAME_PROPERTY;
import static br.com.netbrasoft.gnuob.api.generic.NetbrasoftApiConstants.VALUE_PROPERTY;
import static br.com.netbrasoft.gnuob.api.OrderBy.BESTSELLERS;
import static br.com.netbrasoft.gnuob.api.OrderBy.CONTRACT_ID_A_Z;
import static br.com.netbrasoft.gnuob.api.OrderBy.CONTRACT_ID_Z_A;
import static br.com.netbrasoft.gnuob.api.OrderBy.COUNTRY_CODE_A_Z;
import static br.com.netbrasoft.gnuob.api.OrderBy.COUNTRY_CODE_Z_A;
import static br.com.netbrasoft.gnuob.api.OrderBy.CREATION_A_Z;
import static br.com.netbrasoft.gnuob.api.OrderBy.CREATION_Z_A;
import static br.com.netbrasoft.gnuob.api.OrderBy.DESCRIPTION_A_Z;
import static br.com.netbrasoft.gnuob.api.OrderBy.DESCRIPTION_Z_A;
import static br.com.netbrasoft.gnuob.api.OrderBy.FIRST_NAME_A_Z;
import static br.com.netbrasoft.gnuob.api.OrderBy.FIRST_NAME_Z_A;
import static br.com.netbrasoft.gnuob.api.OrderBy.HIGHEST_DISCOUNT;
import static br.com.netbrasoft.gnuob.api.OrderBy.HIGHEST_PRICE;
import static br.com.netbrasoft.gnuob.api.OrderBy.HIGHEST_RATING;
import static br.com.netbrasoft.gnuob.api.OrderBy.LAST_NAME_A_Z;
import static br.com.netbrasoft.gnuob.api.OrderBy.LAST_NAME_Z_A;
import static br.com.netbrasoft.gnuob.api.OrderBy.LATEST_COLLECTION;
import static br.com.netbrasoft.gnuob.api.OrderBy.LOWEST_DISCOUNT;
import static br.com.netbrasoft.gnuob.api.OrderBy.LOWEST_PRICE;
import static br.com.netbrasoft.gnuob.api.OrderBy.LOWEST_RATING;
import static br.com.netbrasoft.gnuob.api.OrderBy.MODIFICATION_A_Z;
import static br.com.netbrasoft.gnuob.api.OrderBy.MODIFICATION_Z_A;
import static br.com.netbrasoft.gnuob.api.OrderBy.NAME_A_Z;
import static br.com.netbrasoft.gnuob.api.OrderBy.NAME_Z_A;
import static br.com.netbrasoft.gnuob.api.OrderBy.NUMBER_A_Z;
import static br.com.netbrasoft.gnuob.api.OrderBy.NUMBER_Z_A;
import static br.com.netbrasoft.gnuob.api.OrderBy.OFFER_ID_A_Z;
import static br.com.netbrasoft.gnuob.api.OrderBy.OFFER_ID_Z_A;
import static br.com.netbrasoft.gnuob.api.OrderBy.ORDER_ID_A_Z;
import static br.com.netbrasoft.gnuob.api.OrderBy.ORDER_ID_Z_A;
import static br.com.netbrasoft.gnuob.api.OrderBy.PLACE_NAME_A_Z;
import static br.com.netbrasoft.gnuob.api.OrderBy.PLACE_NAME_Z_A;
import static br.com.netbrasoft.gnuob.api.OrderBy.POSITION_A_Z;
import static br.com.netbrasoft.gnuob.api.OrderBy.POSITION_Z_A;
import static br.com.netbrasoft.gnuob.api.OrderBy.POSTAL_CODE_A_Z;
import static br.com.netbrasoft.gnuob.api.OrderBy.POSTAL_CODE_Z_A;
import static br.com.netbrasoft.gnuob.api.OrderBy.PROPERTY_A_Z;
import static br.com.netbrasoft.gnuob.api.OrderBy.PROPERTY_Z_A;
import static br.com.netbrasoft.gnuob.api.OrderBy.RECOMMENDED;
import static br.com.netbrasoft.gnuob.api.OrderBy.STATE_NAME_A_Z;
import static br.com.netbrasoft.gnuob.api.OrderBy.STATE_NAME_Z_A;
import static br.com.netbrasoft.gnuob.api.OrderBy.VALUE_A_Z;
import static br.com.netbrasoft.gnuob.api.OrderBy.VALUE_Z_A;

import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;

import br.com.netbrasoft.gnuob.api.OrderBy;

public final class OrderByFactory {

  private OrderByFactory() {}

  public static OrderBy getOrderBy(final SortParam<String> selectedSortOrder, final OrderBy defaultOrderBy) {
    switch (selectedSortOrder.getProperty()) {
      case NAME_PROPERTY:
        return selectedSortOrder.isAscending() ? NAME_A_Z : NAME_Z_A;
      case PLACE_NAME_PROPERTY:
        return selectedSortOrder.isAscending() ? PLACE_NAME_A_Z : PLACE_NAME_Z_A;
      case COUNTRY_CODE_PROPERTY:
        return selectedSortOrder.isAscending() ? COUNTRY_CODE_A_Z : COUNTRY_CODE_Z_A;
      case POSTAL_CODE_PROPERTY:
        return selectedSortOrder.isAscending() ? POSTAL_CODE_A_Z : POSTAL_CODE_Z_A;
      case STATE_NAME_PROPERTY:
        return selectedSortOrder.isAscending() ? STATE_NAME_A_Z : STATE_NAME_Z_A;
      case DESCRIPTION_PROPERTY:
        return selectedSortOrder.isAscending() ? DESCRIPTION_A_Z : DESCRIPTION_Z_A;
      case PROPERTY_PROPERTY:
        return selectedSortOrder.isAscending() ? PROPERTY_A_Z : PROPERTY_Z_A;
      case VALUE_PROPERTY:
        return selectedSortOrder.isAscending() ? VALUE_A_Z : VALUE_Z_A;
      case AMOUNT_PROPERTY:
        return selectedSortOrder.isAscending() ? HIGHEST_PRICE : LOWEST_PRICE;
      case RECOMMENDED_PROPERTY:
        return RECOMMENDED;
      case RATING_PROPERTY:
        return selectedSortOrder.isAscending() ? HIGHEST_RATING : LOWEST_RATING;
      case DISCOUNT_PROPERTY:
        return selectedSortOrder.isAscending() ? HIGHEST_DISCOUNT : LOWEST_DISCOUNT;
      case BESTSELLER_PROPERTY:
        return BESTSELLERS;
      case POSITION_PROPERTY:
        return selectedSortOrder.isAscending() ? POSITION_A_Z : POSITION_Z_A;
      case LATEST_COLLECTION_PROPERTY:
        return LATEST_COLLECTION;
      case FIRST_NAME_PROPERTY:
        return selectedSortOrder.isAscending() ? FIRST_NAME_A_Z : FIRST_NAME_Z_A;
      case LAST_NAME_PROPERTY:
        return selectedSortOrder.isAscending() ? LAST_NAME_A_Z : LAST_NAME_Z_A;
      case CONTRACT_ID_PROPERTY:
        return selectedSortOrder.isAscending() ? CONTRACT_ID_A_Z : CONTRACT_ID_Z_A;
      case ORDER_ID_PROPERTY:
        return selectedSortOrder.isAscending() ? ORDER_ID_A_Z : ORDER_ID_Z_A;
      case OFFER_ID_PROPERTY:
        return selectedSortOrder.isAscending() ? OFFER_ID_A_Z : OFFER_ID_Z_A;
      case NUMBER_PROPERTY:
        return selectedSortOrder.isAscending() ? NUMBER_A_Z : NUMBER_Z_A;
      case CREATION_PROPERTY:
        return selectedSortOrder.isAscending() ? CREATION_A_Z : CREATION_Z_A;
      case MODIFICATION_PROPERTY:
        return selectedSortOrder.isAscending() ? MODIFICATION_A_Z : MODIFICATION_Z_A;
      default:
        return defaultOrderBy;
    }
  }
}
