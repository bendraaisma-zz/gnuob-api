package br.com.netbrasoft.gnuob.api.generic;

import java.util.List;

import br.com.netbrasoft.gnuob.api.MetaData;
import br.com.netbrasoft.gnuob.api.OrderBy;
import br.com.netbrasoft.gnuob.api.Paging;

public abstract interface IGenericTypeWebServiceRepository<T> {

  public abstract long count(MetaData credentials, T exampleType);

  public abstract List<T> find(MetaData credentials, T exampleType, Paging paging, OrderBy orderingProperty);

  public abstract T find(MetaData credentials, T exampleType);

  public abstract T persist(MetaData credentials, T type);

  public abstract T merge(MetaData credentials, T type);

  public abstract T refresh(MetaData credentials, T type);

  public abstract void remove(MetaData credentials, T type);
}
