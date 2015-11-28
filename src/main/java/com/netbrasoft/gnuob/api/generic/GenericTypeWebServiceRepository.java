package com.netbrasoft.gnuob.api.generic;

import java.util.List;

import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.OrderBy;
import com.netbrasoft.gnuob.api.Paging;

public interface GenericTypeWebServiceRepository<T> {

  long count(MetaData MetaData, T type);

  T find(MetaData MetaData, T type);

  List<T> find(MetaData MetaData, T type, Paging paramPaging, OrderBy paramOrderBy);

  T merge(MetaData MetaData, T type);

  T persist(MetaData MetaData, T type);

  T refresh(MetaData MetaData, T type);

  void remove(MetaData MetaData, T type);
}
