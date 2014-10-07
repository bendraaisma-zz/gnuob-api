package com.netbrasoft.gnuob.api.security;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.netbrasoft.gnuob.api.CountGroup;
import com.netbrasoft.gnuob.api.CountGroupResponse;
import com.netbrasoft.gnuob.api.FindGroup;
import com.netbrasoft.gnuob.api.FindGroupById;
import com.netbrasoft.gnuob.api.FindGroupByIdResponse;
import com.netbrasoft.gnuob.api.FindGroupResponse;
import com.netbrasoft.gnuob.api.GNUOpenBusinessServiceException_Exception;
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

@Repository("GroupWebServiceRepository")
public class GroupWebServiceRepository {

    private GroupWebServiceImpl groupWebServiceImpl;

    public GroupWebServiceRepository() {
    }

    public long count(MetaData paramMetaData, Group paramGroup) throws GNUOpenBusinessServiceException_Exception {
        CountGroup paramCountGroup = new CountGroup();
        paramCountGroup.setGroup(paramGroup);
        CountGroupResponse countGroupResponse = getGroupWebServiceImpl().countGroup(paramCountGroup, paramMetaData);
        return countGroupResponse.getReturn();
    }

    public Group find(MetaData paramMetaData, Group paramGroup) throws GNUOpenBusinessServiceException_Exception {
        FindGroupById paramFindGroupById = new FindGroupById();
        paramFindGroupById.setGroup(paramGroup);
        FindGroupByIdResponse findGroupByIdResponse = getGroupWebServiceImpl().findGroupById(paramFindGroupById, paramMetaData);
        return findGroupByIdResponse.getReturn();

    }

    public List<Group> find(MetaData paramMetaData, Group paramGroup, Paging paramPaging, OrderBy paramOrderBy) throws GNUOpenBusinessServiceException_Exception {
        FindGroup paramFindGroup = new FindGroup();
        paramFindGroup.setGroup(paramGroup);
        paramFindGroup.setPaging(paramPaging);
        paramFindGroup.setOrderBy(paramOrderBy);
        FindGroupResponse findGroupResponse = getGroupWebServiceImpl().findGroup(paramFindGroup, paramMetaData);
        return findGroupResponse.getReturn();
    }

    private GroupWebServiceImpl getGroupWebServiceImpl() {
        if (groupWebServiceImpl == null) {
            GroupWebServiceImplService groupWebServiceImplService = new GroupWebServiceImplService(GroupWebServiceImplService.WSDL_LOCATION);
            groupWebServiceImpl = groupWebServiceImplService.getGroupWebServiceImplPort();
        }

        return groupWebServiceImpl;
    }

    public Group merge(MetaData paramMetaData, Group paramGroup) throws GNUOpenBusinessServiceException_Exception {
        MergeGroup paramMergeGroup = new MergeGroup();
        paramMergeGroup.setGroup(paramGroup);
        MergeGroupResponse mergeGroupResponse = getGroupWebServiceImpl().mergeGroup(paramMergeGroup, paramMetaData);
        return mergeGroupResponse.getReturn();
    }

    public Group persist(MetaData paramMetaData, Group paramGroup) throws GNUOpenBusinessServiceException_Exception {
        PersistGroup paramPersistGroup = new PersistGroup();
        paramPersistGroup.setGroup(paramGroup);
        PersistGroupResponse persistGroupResponse = getGroupWebServiceImpl().persistGroup(paramPersistGroup, paramMetaData);
        return persistGroupResponse.getReturn();
    }

    public Group refresh(MetaData paramMetaData, Group paramGroup) throws GNUOpenBusinessServiceException_Exception {
        RefreshGroup paramRefresGroup = new RefreshGroup();
        paramRefresGroup.setGroup(paramGroup);
        RefreshGroupResponse refresGroupResponse = getGroupWebServiceImpl().refreshGroup(paramRefresGroup, paramMetaData);
        return refresGroupResponse.getReturn();
    }

    public void remove(MetaData paramMetaData, Group paramGroup) throws GNUOpenBusinessServiceException_Exception {
        RemoveGroup paramRemoveGroup = new RemoveGroup();
        paramRemoveGroup.setGroup(paramGroup);
        getGroupWebServiceImpl().removeGroup(paramRemoveGroup, paramMetaData);
    }
}
