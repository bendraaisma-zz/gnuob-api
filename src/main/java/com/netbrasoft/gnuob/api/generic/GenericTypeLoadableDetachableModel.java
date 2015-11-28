package com.netbrasoft.gnuob.api.generic;

import org.apache.wicket.model.LoadableDetachableModel;

import com.netbrasoft.gnuob.api.AbstractType;

public class GenericTypeLoadableDetachableModel<T extends AbstractType> extends LoadableDetachableModel<T> {

  private static final long serialVersionUID = 2803887803933459687L;

  private final T type;

  public GenericTypeLoadableDetachableModel(final T type) {
    this.type = type;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
      return true;
    } else if (obj == null) {
      return false;
    } else if (obj instanceof GenericTypeLoadableDetachableModel) {
      final GenericTypeLoadableDetachableModel<?> other = (GenericTypeLoadableDetachableModel<?>) obj;
      return other.type.getId() == type.getId();
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Long.valueOf(type.getId()).hashCode();
  }

  @Override
  protected T load() {
    return type;
  }
}
