package com.netbrasoft.gnuob.api.generic;

import java.util.Iterator;

import javax.xml.ws.soap.SOAPFaultException;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;

import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.OrderBy;
import com.netbrasoft.gnuob.api.Paging;
import com.netbrasoft.gnuob.api.Type;

public abstract class AbstractGenericTypeDataProvider<T extends Type> extends SortableDataProvider<T, String>implements GenericTypeDataProvider<T> {

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
   private T type;

   private OrderBy orderBy;
   protected MetaData metaData;

   public AbstractGenericTypeDataProvider(OrderBy orderBy, T type) {
      this.type = type;
      this.orderBy = orderBy;
      metaData = new MetaData();
   }

   public AbstractGenericTypeDataProvider(T type) {
      this(OrderBy.NONE, type);
      setSort(NONE_PROPERTY, SortOrder.ASCENDING);
   }

   @Override
   public void detach() {

   }

   @Override
   public T findById(T type) {
      try {
         return getGenericTypeWebServiceRepository().find(metaData, type);
      } catch (SOAPFaultException e) {
         throw new GNUOpenBusinessApplicationException(e.getMessage(), e);
      }
   }

   public abstract GenericTypeWebServiceRepository<T> getGenericTypeWebServiceRepository();

   private OrderBy getOrderBy() {

      SortParam<String> sortOrder = getSort();

      switch (sortOrder.getProperty()) {

      case NAME_PROPERTY:
         orderBy = sortOrder.isAscending() ? OrderBy.TITLE_A_Z : OrderBy.TITLE_Z_A;
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
         orderBy = OrderBy.POSITION_A_Z;
         break;
      case LATEST_COLLECTION_PROPERTY:
         orderBy = OrderBy.LATEST_COLLECTION;
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
   public Iterator<T> iterator(long first, long max) {
      try {
         Paging paramPaging = new Paging();
         paramPaging.setFirst((int) first);
         paramPaging.setMax((int) max);

         return getGenericTypeWebServiceRepository().find(metaData, type, paramPaging, getOrderBy()).iterator();
      } catch (SOAPFaultException e) {
         throw new GNUOpenBusinessApplicationException(e.getMessage(), e);
      }
   }

   @Override
   public T merge(T type) {
      try {
         return getGenericTypeWebServiceRepository().merge(metaData, type);
      } catch (SOAPFaultException e) {
         throw new GNUOpenBusinessApplicationException(e.getMessage(), e);
      }
   }

   @Override
   public IModel<T> model(T type) {
      return new GenericTypeLoadableDetachableModel<T>(type);
   }

   @Override
   public T persist(T type) {
      try {
         return getGenericTypeWebServiceRepository().persist(metaData, type);
      } catch (SOAPFaultException e) {
         throw new GNUOpenBusinessApplicationException(e.getMessage(), e);
      }
   }

   @Override
   public T refresh(T type) {
      try {
         return getGenericTypeWebServiceRepository().refresh(metaData, type);
      } catch (SOAPFaultException e) {
         throw new GNUOpenBusinessApplicationException(e.getMessage(), e);
      }
   }

   @Override
   public void remove(T type) {
      try {
         getGenericTypeWebServiceRepository().remove(metaData, type);
      } catch (SOAPFaultException e) {
         throw new GNUOpenBusinessApplicationException(e.getMessage(), e);
      }
   }

   @Override
   public void setOrderBy(OrderBy orderBy) {
      this.orderBy = orderBy;
   }

   @Override
   public void setPassword(String password) {
      this.metaData.setPassword(password);
   }

   @Override
   public void setSite(String site) {
      this.metaData.setSite(site);
   }

   @Override
   public void setType(T type) {
      this.type = type;
   }

   @Override
   public void setUser(String user) {
      this.metaData.setUser(user);
   }

   @Override
   public long size() {
      try {
         return getGenericTypeWebServiceRepository().count(metaData, type);
      } catch (SOAPFaultException e) {
         throw new GNUOpenBusinessApplicationException(e.getMessage(), e);
      }
   }
}
