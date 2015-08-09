package com.netbrasoft.gnuob.api.security;

import java.util.List;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Repository;

import com.netbrasoft.gnuob.api.CountGroup;
import com.netbrasoft.gnuob.api.CountGroupResponse;
import com.netbrasoft.gnuob.api.FindGroup;
import com.netbrasoft.gnuob.api.FindGroupById;
import com.netbrasoft.gnuob.api.FindGroupByIdResponse;
import com.netbrasoft.gnuob.api.FindGroupResponse;
import com.netbrasoft.gnuob.api.Group;
import com.netbrasoft.gnuob.api.GroupWebServiceImpl;
import com.netbrasoft.gnuob.api.GroupWebServiceImplService;
import com.netbrasoft.gnuob.api.MergeGroup;
import com.netbrasoft.gnuob.api.MergeGroupResponse;
import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.OrderBy;
import com.netbrasoft.gnuob.api.Paging;
import com.netbrasoft.gnuob.api.PersistGroup;
import com.netbrasoft.gnuob.api.PersistGroupResponse;
import com.netbrasoft.gnuob.api.RefreshGroup;
import com.netbrasoft.gnuob.api.RefreshGroupResponse;
import com.netbrasoft.gnuob.api.RemoveGroup;
import com.netbrasoft.gnuob.api.generic.GenericTypeWebServiceRepository;

@Monitored
@Repository("GroupWebServiceRepository")
public class GroupWebServiceRepository<G extends Group> implements GenericTypeWebServiceRepository<G> {

   private GroupWebServiceImpl groupWebServiceImpl;

   public GroupWebServiceRepository() {
   }

   @Override
   public long count(MetaData paramMetaData, G paramGroup) {
      CountGroup paramCountGroup = new CountGroup();
      paramCountGroup.setGroup(paramGroup);
      CountGroupResponse countGroupResponse = getGroupWebServiceImpl().countGroup(paramCountGroup, paramMetaData);
      return countGroupResponse.getReturn();
   }

   @SuppressWarnings("unchecked")
   @Override
   public G find(MetaData paramMetaData, G paramGroup) {
      FindGroupById paramFindGroupById = new FindGroupById();
      paramFindGroupById.setGroup(paramGroup);
      FindGroupByIdResponse findGroupByIdResponse = getGroupWebServiceImpl().findGroupById(paramFindGroupById, paramMetaData);
      return (G) findGroupByIdResponse.getReturn();

   }

   @SuppressWarnings("unchecked")
   @Override
   public List<G> find(MetaData paramMetaData, G paramGroup, Paging paramPaging, OrderBy paramOrderBy) {
      FindGroup paramFindGroup = new FindGroup();
      paramFindGroup.setGroup(paramGroup);
      paramFindGroup.setPaging(paramPaging);
      paramFindGroup.setOrderBy(paramOrderBy);
      FindGroupResponse findGroupResponse = getGroupWebServiceImpl().findGroup(paramFindGroup, paramMetaData);
      return (List<G>) findGroupResponse.getReturn();
   }

   private GroupWebServiceImpl getGroupWebServiceImpl() {
      if (groupWebServiceImpl == null) {
         GroupWebServiceImplService groupWebServiceImplService = new GroupWebServiceImplService(GroupWebServiceImplService.WSDL_LOCATION);
         groupWebServiceImpl = groupWebServiceImplService.getGroupWebServiceImplPort();
      }

      return groupWebServiceImpl;
   }

   @SuppressWarnings("unchecked")
   @Override
   public G merge(MetaData paramMetaData, G paramGroup) {
      MergeGroup paramMergeGroup = new MergeGroup();
      paramMergeGroup.setGroup(paramGroup);
      MergeGroupResponse mergeGroupResponse = getGroupWebServiceImpl().mergeGroup(paramMergeGroup, paramMetaData);
      return (G) mergeGroupResponse.getReturn();
   }

   @SuppressWarnings("unchecked")
   @Override
   public G persist(MetaData paramMetaData, G paramGroup) {
      PersistGroup paramPersistGroup = new PersistGroup();
      paramPersistGroup.setGroup(paramGroup);
      PersistGroupResponse persistGroupResponse = getGroupWebServiceImpl().persistGroup(paramPersistGroup, paramMetaData);
      return (G) persistGroupResponse.getReturn();
   }

   @SuppressWarnings("unchecked")
   @Override
   public G refresh(MetaData paramMetaData, G paramGroup) {
      RefreshGroup paramRefresGroup = new RefreshGroup();
      paramRefresGroup.setGroup(paramGroup);
      RefreshGroupResponse refresGroupResponse = getGroupWebServiceImpl().refreshGroup(paramRefresGroup, paramMetaData);
      return (G) refresGroupResponse.getReturn();
   }

   @Override
   public void remove(MetaData paramMetaData, G paramGroup) {
      RemoveGroup paramRemoveGroup = new RemoveGroup();
      paramRemoveGroup.setGroup(paramGroup);
      getGroupWebServiceImpl().removeGroup(paramRemoveGroup, paramMetaData);
   }
}
