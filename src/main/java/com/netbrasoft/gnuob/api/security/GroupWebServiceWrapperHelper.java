package com.netbrasoft.gnuob.api.security;

import com.netbrasoft.gnuob.api.CountGroup;
import com.netbrasoft.gnuob.api.FindGroup;
import com.netbrasoft.gnuob.api.FindGroupById;
import com.netbrasoft.gnuob.api.Group;
import com.netbrasoft.gnuob.api.MergeGroup;
import com.netbrasoft.gnuob.api.OrderBy;
import com.netbrasoft.gnuob.api.Paging;
import com.netbrasoft.gnuob.api.PersistGroup;
import com.netbrasoft.gnuob.api.RefreshGroup;
import com.netbrasoft.gnuob.api.RemoveGroup;

final class GroupWebServiceWrapperHelper {

  private GroupWebServiceWrapperHelper() {}

  static CountGroup wrapToCountGroup(final Group group) {
    final CountGroup paramCountGroup = new CountGroup();
    paramCountGroup.setGroup(group);
    return paramCountGroup;
  }

  static FindGroup wrapToFindGroup(final Group group, final Paging paging, final OrderBy orderingProperty) {
    final FindGroup paramFindGroup = new FindGroup();
    paramFindGroup.setGroup(group);
    paramFindGroup.setPaging(paging);
    paramFindGroup.setOrderBy(orderingProperty);
    return paramFindGroup;
  }

  static FindGroupById wrapToFindGroupById(final Group group) {
    final FindGroupById paramFindGroupById = new FindGroupById();
    paramFindGroupById.setGroup(group);
    return paramFindGroupById;
  }

  static PersistGroup wrapToPersistGroup(final Group group) {
    final PersistGroup paramPersistGroup = new PersistGroup();
    paramPersistGroup.setGroup(group);
    return paramPersistGroup;
  }

  static MergeGroup wrapToMergeGroup(final Group group) {
    final MergeGroup paramMergeGroup = new MergeGroup();
    paramMergeGroup.setGroup(group);
    return paramMergeGroup;
  }

  static RefreshGroup wrapToRefreshGroup(final Group group) {
    final RefreshGroup paramRefresGroup = new RefreshGroup();
    paramRefresGroup.setGroup(group);
    return paramRefresGroup;
  }

  static RemoveGroup wrapToRemoveGroup(final Group group) {
    final RemoveGroup paramRemoveGroup = new RemoveGroup();
    paramRemoveGroup.setGroup(group);
    return paramRemoveGroup;
  }
}
