
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

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.wicket.model.LoadableDetachableModel;

import br.com.netbrasoft.gnuob.api.AbstractType;

public class GenericTypeLoadableDetachableModel<T extends AbstractType> extends LoadableDetachableModel<T> {

  private static final long serialVersionUID = 2803887803933459687L;

  private final T modelType;

  public GenericTypeLoadableDetachableModel(final T modelType) {
    this.modelType = modelType;
  }

  @Override
  protected T load() {
    return modelType;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    if (obj.getClass() != getClass()) {
      return false;
    }
    final GenericTypeLoadableDetachableModel<?> model = (GenericTypeLoadableDetachableModel<?>) obj;
    return new EqualsBuilder().appendSuper(super.equals(obj)).append(modelType.getId(), model.modelType.getId())
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(modelType.getId()).toHashCode();
  }
}
