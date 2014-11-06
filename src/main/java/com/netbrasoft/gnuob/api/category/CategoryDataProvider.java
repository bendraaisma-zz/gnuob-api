package com.netbrasoft.gnuob.api.category;

import java.util.Iterator;

import javax.xml.ws.soap.SOAPFaultException;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.netbrasoft.gnuob.api.Category;
import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.OrderBy;
import com.netbrasoft.gnuob.api.Paging;
import com.netbrasoft.gnuob.api.generic.GenericTypeDataProvider;

@Controller("CategoryDataProvider")
public class CategoryDataProvider<C extends Category> extends SortableDataProvider<C, String> implements GenericTypeDataProvider<C> {
   
   private static final long serialVersionUID = -7147810111954260412L;
   
   @Autowired(required = true)
   private CategoryWebServiceRepository categoryWebServiceRepository;
   
   private C category;
   private OrderBy orderBy;
   private MetaData metaData;
   
   @SuppressWarnings("unchecked")
   public CategoryDataProvider() {
      this((C) new Category());
   }
   
   public CategoryDataProvider(C category) {
      this(category, OrderBy.NONE);
      setSort("position", SortOrder.ASCENDING);
   }
   
   public CategoryDataProvider(C category, OrderBy orderBy) {
      this.category = category;
      this.orderBy = orderBy;
      metaData = new MetaData();
   }
   
   @Override
   public void detach() {
      
   }
   
   @SuppressWarnings("unchecked")
   @Override
   public C findById(C category) {
      try {
         return (C) categoryWebServiceRepository.find(metaData, category);
      } catch (SOAPFaultException e) {
         throw new RuntimeException(e.getMessage(), e);
      }
   }
   
   public C getCategory() {
      return category;
   }
   
   private OrderBy getOrderBy() {
      
      SortParam<String> sortOrder = getSort();
      
      switch (sortOrder.getProperty()) {
      
      case "name":
         orderBy = sortOrder.isAscending() ? OrderBy.TITLE_A_Z : OrderBy.TITLE_Z_A;
         break;
      case "description":
         orderBy = sortOrder.isAscending() ? OrderBy.TITLE_A_Z : OrderBy.TITLE_Z_A;
         break;
      default:
         orderBy = OrderBy.POSITION_A_Z;
         break;
      }
      
      return orderBy;
   }
   
   @SuppressWarnings("unchecked")
   @Override
   public Iterator<C> iterator(long first, long max) {
      try {
         Paging paramPaging = new Paging();
         paramPaging.setFirst((int) first);
         paramPaging.setMax((int) max);
         
         return (Iterator<C>) categoryWebServiceRepository.find(metaData, category, paramPaging, getOrderBy()).iterator();
      } catch (SOAPFaultException e) {
         throw new RuntimeException(e.getMessage(), e);
      }
   }
   
   @SuppressWarnings("unchecked")
   @Override
   public C merge(C category) {
      try {
         return (C) categoryWebServiceRepository.merge(metaData, category);
      } catch (SOAPFaultException e) {
         throw new RuntimeException(e.getMessage(), e);
      }
   }
   
   @Override
   public IModel<C> model(C category) {
      return new CategoryLoadableDetachableModel<C>(category);
   }
   
   @SuppressWarnings("unchecked")
   @Override
   public C persist(C category) {
      try {
         return (C) categoryWebServiceRepository.persist(metaData, category);
      } catch (SOAPFaultException e) {
         throw new RuntimeException(e.getMessage(), e);
      }
   }
   
   @SuppressWarnings("unchecked")
   @Override
   public C refresh(C category) {
      try {
         return (C) categoryWebServiceRepository.refresh(metaData, category);
      } catch (SOAPFaultException e) {
         throw new RuntimeException(e.getMessage(), e);
      }
   }
   
   @Override
   public void remove(C category) {
      try {
         categoryWebServiceRepository.remove(metaData, category);
      } catch (SOAPFaultException e) {
         throw new RuntimeException(e.getMessage(), e);
      }
      
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
   public void setType(C category) {
      this.category = category;
   }
   
   @Override
   public void setUser(String user) {
      this.metaData.setUser(user);
   }
   
   @Override
   public long size() {
      try {
         return categoryWebServiceRepository.count(metaData, category);
      } catch (SOAPFaultException e) {
         throw new RuntimeException(e.getMessage(), e);
      }
   }
}
