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

package com.netbrasoft.gnuob.api.generic;

import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.markup.repeater.data.IDataProvider;

import com.netbrasoft.gnuob.api.OrderBy;

public abstract interface IGenericTypeDataProvider<T> extends IDataProvider<T>, ISortableDataProvider<T, String> {

  public abstract T findById(T type);

  public abstract T persist(T type);

  public abstract T merge(T type);

  public abstract T refresh(T type);

  public abstract void remove(T type);

  public abstract void setOrderBy(OrderBy OrderBy);

  public abstract T getType();

  public abstract void setType(T type);

  public abstract void setUser(String user);

  public abstract void setPassword(String password);

  public abstract void setSite(String site);
}
