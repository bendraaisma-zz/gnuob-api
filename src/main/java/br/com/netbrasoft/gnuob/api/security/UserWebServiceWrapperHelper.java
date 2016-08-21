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

package br.com.netbrasoft.gnuob.api.security;

import br.com.netbrasoft.gnuob.api.CountUser;
import br.com.netbrasoft.gnuob.api.FindUser;
import br.com.netbrasoft.gnuob.api.FindUserById;
import br.com.netbrasoft.gnuob.api.MergeUser;
import br.com.netbrasoft.gnuob.api.OrderBy;
import br.com.netbrasoft.gnuob.api.Paging;
import br.com.netbrasoft.gnuob.api.PersistUser;
import br.com.netbrasoft.gnuob.api.RefreshUser;
import br.com.netbrasoft.gnuob.api.RemoveUser;
import br.com.netbrasoft.gnuob.api.User;

final class UserWebServiceWrapperHelper {

  private UserWebServiceWrapperHelper() {}

  static CountUser wrapToCountUser(final User user) {
    final CountUser paramCountUser = new CountUser();
    paramCountUser.setUser(user);
    return paramCountUser;
  }

  static FindUser wrapToFindUser(final User user, final Paging paging, final OrderBy orderingProperty) {
    final FindUser paramFindUser = new FindUser();
    paramFindUser.setUser(user);
    paramFindUser.setPaging(paging);
    paramFindUser.setOrderBy(orderingProperty);
    return paramFindUser;
  }

  static FindUserById wrapToFindUserById(final User user) {
    final FindUserById paramFindUserById = new FindUserById();
    paramFindUserById.setUser(user);
    return paramFindUserById;
  }

  static PersistUser wrapToPersistUser(final User user) {
    final PersistUser paramPersistUser = new PersistUser();
    paramPersistUser.setUser(user);
    return paramPersistUser;
  }

  static MergeUser wrapToMergeUser(final User user) {
    final MergeUser paramMergeUser = new MergeUser();
    paramMergeUser.setUser(user);
    return paramMergeUser;
  }

  static RefreshUser wrapToRefreshUser(final User user) {
    final RefreshUser paramRefresUser = new RefreshUser();
    paramRefresUser.setUser(user);
    return paramRefresUser;
  }

  static RemoveUser wrapToRemoveUser(final User user) {
    final RemoveUser paramRemoveUser = new RemoveUser();
    paramRemoveUser.setUser(user);
    return paramRemoveUser;
  }
}
