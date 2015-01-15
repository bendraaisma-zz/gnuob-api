package com.netbrasoft.gnuob.api.generic;

import java.util.List;

import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.OrderBy;
import com.netbrasoft.gnuob.api.Paging;

public interface GenericTypeWebServiceRepository<T> {

   long count(MetaData paramMetaData, T paramType);

   T find(MetaData paramMetaData, T paramType);

   List<T> find(MetaData paramMetaData, T paramType, Paging paramPaging, OrderBy paramOrderBy);

   T merge(MetaData paramMetaData, T paramType);

   T persist(MetaData paramMetaData, T paramType);

   T refresh(MetaData paramMetaData, T paramType);

   void remove(MetaData paramMetaData, T paramType);
}
