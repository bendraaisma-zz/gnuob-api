package com.netbrasoft.gnuob.api.generic;

import java.util.Iterator;

import javax.xml.ws.soap.SOAPFaultException;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;

import com.netbrasoft.gnuob.api.AbstractType;
import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.OrderBy;
import com.netbrasoft.gnuob.api.Paging;

public abstract class AbstractGenericTypeDataProvider<T extends AbstractType> extends SortableDataProvider<T, String> implements GenericTypeDataProvider<T> {

  private static final long serialVersionUID = -7323826275199384990L;

  private static final String LATEST_COLLECTION_PROPERTY = "latestCollection";

  private static final String POSITION_PROPERTY = "position";

  private static final String BESTSELLER_PROPERTY = "bestseller";

  private static final String DISCOUNT_PROPERTY = "discount";

  private static final String RATING_PROPERTY = "rating";

  private static final String RECOMMENDED_PROPERTY = "recommended";

  private static final String AMOUNT_PROPERTY = "amount";

  private static final String NAME_PROPERTY = "name";

  private static final String NONE_PROPERTY = "none";

  private static final String FIRST_NAME_PROPERTY = "firstName";

  private static final String LAST_NAME_PROPERTY = "lastName";

  private static final String CONTRACT_ID_PROPERTY = "contractId";

  private static final String ORDER_ID_PROPERTY = "orderId";

  private static final String OFFER_ID_PROPERTY = "offerId";

  private static final String NUMBER_PROPERTY = "number";

  private static final String CREATION_PROPERTY = "creation";

  private static final String MODIFICATION_PROPERTY = "modification";

  private static final String DESCRIPTION_PROPERTY = "description";

  private static final String PROPERTY_PROPERTY = "property";

  private static final String VALUE_PROPERTY = "value";

  private static final String PLACE_NAME_PROPERTY = "placeName";

  private static final String COUNTRY_CODE_PROPERTY = "countryCode";

  private static final String POSTAL_CODE_PROPERTY = "postalCode";

  private static final String STATE_NAME_PROPERTY = "adminName1";

  private T type;

  private OrderBy orderBy;

  protected MetaData metaData;

  public AbstractGenericTypeDataProvider(final OrderBy orderBy, final T type) {
    this.type = type;
    this.orderBy = orderBy;
    metaData = new MetaData();
  }

  public AbstractGenericTypeDataProvider(final T type) {
    this(OrderBy.NONE, type);
    setSort(NONE_PROPERTY, SortOrder.ASCENDING);
  }

  @Override
  public void detach() {
    return;
  }

  @Override
  public T findById(final T type) {
    try {
      return getGenericTypeWebServiceRepository().find(metaData, type);
    } catch (final SOAPFaultException e) {
      throw new GNUOpenBusinessApplicationException(e.getMessage(), e);
    }
  }

  public abstract GenericTypeWebServiceRepository<T> getGenericTypeWebServiceRepository();

  private OrderBy getOrderBy() {
    final SortParam<String> sortOrder = getSort();
    switch (sortOrder.getProperty()) {
      case NAME_PROPERTY:
        orderBy = sortOrder.isAscending() ? OrderBy.NAME_A_Z : OrderBy.NAME_Z_A;
        break;
      case PLACE_NAME_PROPERTY:
        orderBy = sortOrder.isAscending() ? OrderBy.PLACE_NAME_A_Z : OrderBy.PLACE_NAME_Z_A;
        break;
      case COUNTRY_CODE_PROPERTY:
        orderBy = sortOrder.isAscending() ? OrderBy.COUNTRY_CODE_A_Z : OrderBy.COUNTRY_CODE_Z_A;
        break;
      case POSTAL_CODE_PROPERTY:
        orderBy = sortOrder.isAscending() ? OrderBy.POSTAL_CODE_A_Z : OrderBy.POSTAL_CODE_Z_A;
        break;
      case STATE_NAME_PROPERTY:
        orderBy = sortOrder.isAscending() ? OrderBy.STATE_NAME_A_Z : OrderBy.STATE_NAME_Z_A;
        break;
      case DESCRIPTION_PROPERTY:
        orderBy = sortOrder.isAscending() ? OrderBy.DESCRIPTION_A_Z : OrderBy.DESCRIPTION_Z_A;
        break;
      case PROPERTY_PROPERTY:
        orderBy = sortOrder.isAscending() ? OrderBy.PROPERTY_A_Z : OrderBy.PROPERTY_Z_A;
        break;
      case VALUE_PROPERTY:
        orderBy = sortOrder.isAscending() ? OrderBy.VALUE_A_Z : OrderBy.VALUE_Z_A;
        break;
      case AMOUNT_PROPERTY:
        orderBy = sortOrder.isAscending() ? OrderBy.HIGHEST_PRICE : OrderBy.LOWEST_PRICE;
        break;
      case RECOMMENDED_PROPERTY:
        orderBy = OrderBy.RECOMMENDED;
        break;
      case RATING_PROPERTY:
        orderBy = sortOrder.isAscending() ? OrderBy.HIGHEST_RATING : OrderBy.LOWEST_RATING;
        break;
      case DISCOUNT_PROPERTY:
        orderBy = sortOrder.isAscending() ? OrderBy.HIGHEST_DISCOUNT : OrderBy.LOWEST_DISCOUNT;
        break;
      case BESTSELLER_PROPERTY:
        orderBy = OrderBy.BESTSELLERS;
        break;
      case POSITION_PROPERTY:
        orderBy = sortOrder.isAscending() ? OrderBy.POSITION_A_Z : OrderBy.POSITION_Z_A;
        break;
      case LATEST_COLLECTION_PROPERTY:
        orderBy = OrderBy.LATEST_COLLECTION;
        break;
      case FIRST_NAME_PROPERTY:
        orderBy = sortOrder.isAscending() ? OrderBy.FIRST_NAME_A_Z : OrderBy.FIRST_NAME_Z_A;
        break;
      case LAST_NAME_PROPERTY:
        orderBy = sortOrder.isAscending() ? OrderBy.LAST_NAME_A_Z : OrderBy.LAST_NAME_Z_A;
        break;
      case CONTRACT_ID_PROPERTY:
        orderBy = sortOrder.isAscending() ? OrderBy.CONTRACT_ID_A_Z : OrderBy.CONTRACT_ID_Z_A;
        break;
      case ORDER_ID_PROPERTY:
        orderBy = sortOrder.isAscending() ? OrderBy.ORDER_ID_A_Z : OrderBy.ORDER_ID_Z_A;
        break;
      case OFFER_ID_PROPERTY:
        orderBy = sortOrder.isAscending() ? OrderBy.OFFER_ID_A_Z : OrderBy.OFFER_ID_Z_A;
        break;
      case NUMBER_PROPERTY:
        orderBy = sortOrder.isAscending() ? OrderBy.NUMBER_A_Z : OrderBy.NUMBER_Z_A;
        break;
      case CREATION_PROPERTY:
        orderBy = sortOrder.isAscending() ? OrderBy.CREATION_A_Z : OrderBy.CREATION_Z_A;
        break;
      case MODIFICATION_PROPERTY:
        orderBy = sortOrder.isAscending() ? OrderBy.MODIFICATION_A_Z : OrderBy.MODIFICATION_Z_A;
        break;
      default:
        break;
    }

    return orderBy;
  }

  @Override
  public T getType() {
    return this.type;
  }

  @Override
  public Iterator<T> iterator(final long first, final long max) {
    try {
      final Paging paramPaging = new Paging();
      paramPaging.setFirst((int) first);
      paramPaging.setMax((int) max);
      return getGenericTypeWebServiceRepository().find(metaData, type, paramPaging, getOrderBy()).iterator();
    } catch (final SOAPFaultException e) {
      throw new GNUOpenBusinessApplicationException(e.getMessage(), e);
    }
  }

  @Override
  public T merge(final T type) {
    try {
      return getGenericTypeWebServiceRepository().merge(metaData, type);
    } catch (final SOAPFaultException e) {
      throw new GNUOpenBusinessApplicationException(e.getMessage(), e);
    }
  }

  @Override
  public IModel<T> model(final T type) {
    return new GenericTypeLoadableDetachableModel<T>(type);
  }

  @Override
  public T persist(final T type) {
    try {
      return getGenericTypeWebServiceRepository().persist(metaData, type);
    } catch (final SOAPFaultException e) {
      throw new GNUOpenBusinessApplicationException(e.getMessage(), e);
    }
  }

  @Override
  public T refresh(final T type) {
    try {
      return getGenericTypeWebServiceRepository().refresh(metaData, type);
    } catch (final SOAPFaultException e) {
      throw new GNUOpenBusinessApplicationException(e.getMessage(), e);
    }
  }

  @Override
  public void remove(final T type) {
    try {
      getGenericTypeWebServiceRepository().remove(metaData, type);
    } catch (final SOAPFaultException e) {
      throw new GNUOpenBusinessApplicationException(e.getMessage(), e);
    }
  }

  @Override
  public void setOrderBy(final OrderBy orderBy) {
    this.orderBy = orderBy;
  }

  @Override
  public void setPassword(final String password) {
    this.metaData.setPassword(password);
  }

  @Override
  public void setSite(final String site) {
    this.metaData.setSite(site);
  }

  @Override
  public void setType(final T type) {
    this.type = type;
  }

  @Override
  public void setUser(final String user) {
    this.metaData.setUser(user);
  }

  @Override
  public long size() {
    try {
      return getGenericTypeWebServiceRepository().count(metaData, type);
    } catch (final SOAPFaultException e) {
      throw new GNUOpenBusinessApplicationException(e.getMessage(), e);
    }
  }
}
