package com.netbrasoft.gnuob.api.generic;

import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.markup.repeater.data.IDataProvider;

import com.netbrasoft.gnuob.api.OrderBy;

public interface GenericTypeDataProvider<T> extends IDataProvider<T>, ISortableDataProvider<T, String> {

   T findById(T type);

   T getType();

   T merge(T type);

   T persist(T type);

   T refresh(T type);

   void remove(T type);

   void setOrderBy(OrderBy orderBy);

   void setPassword(String password);

   void setSite(String site);

   void setType(T type);

   void setUser(String user);
}
