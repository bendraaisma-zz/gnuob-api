package com.netbrasoft.gnuob.api.setting;

import java.util.List;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Repository;

import com.netbrasoft.gnuob.api.CountSetting;
import com.netbrasoft.gnuob.api.CountSettingResponse;
import com.netbrasoft.gnuob.api.FindSetting;
import com.netbrasoft.gnuob.api.FindSettingById;
import com.netbrasoft.gnuob.api.FindSettingByIdResponse;
import com.netbrasoft.gnuob.api.FindSettingResponse;
import com.netbrasoft.gnuob.api.MergeSetting;
import com.netbrasoft.gnuob.api.MergeSettingResponse;
import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.OrderBy;
import com.netbrasoft.gnuob.api.Paging;
import com.netbrasoft.gnuob.api.PersistSetting;
import com.netbrasoft.gnuob.api.PersistSettingResponse;
import com.netbrasoft.gnuob.api.RefreshSetting;
import com.netbrasoft.gnuob.api.RefreshSettingResponse;
import com.netbrasoft.gnuob.api.RemoveSetting;
import com.netbrasoft.gnuob.api.Setting;
import com.netbrasoft.gnuob.api.SettingWebServiceImpl;
import com.netbrasoft.gnuob.api.SettingWebServiceImplService;
import com.netbrasoft.gnuob.api.generic.GenericTypeWebServiceRepository;

@Monitored
@Repository("SettingWebServiceRepository")
public class SettingWebServiceRepository<S extends Setting> implements GenericTypeWebServiceRepository<S> {

   private SettingWebServiceImpl settingWebServiceImpl;

   public SettingWebServiceRepository() {
   }

   @Override
   public long count(MetaData paramMetaData, S paramSetting) {
      CountSetting paramCountSetting = new CountSetting();
      paramCountSetting.setSetting(paramSetting);
      CountSettingResponse countSettingResponse = getSettingWebServiceImpl().countSetting(paramCountSetting,
            paramMetaData);
      return countSettingResponse.getReturn();
   }

   @SuppressWarnings("unchecked")
   @Override
   public S find(MetaData paramMetaData, S paramSetting) {
      FindSettingById paramFindSettingById = new FindSettingById();
      paramFindSettingById.setSetting(paramSetting);
      FindSettingByIdResponse findSettingByIdResponse = getSettingWebServiceImpl().findSettingById(
            paramFindSettingById, paramMetaData);
      return (S) findSettingByIdResponse.getReturn();

   }

   @SuppressWarnings("unchecked")
   @Override
   public List<S> find(MetaData paramMetaData, S paramSetting, Paging paramPaging, OrderBy paramOrderBy) {
      FindSetting paramFindSetting = new FindSetting();
      paramFindSetting.setSetting(paramSetting);
      paramFindSetting.setPaging(paramPaging);
      paramFindSetting.setOrderBy(paramOrderBy);
      FindSettingResponse findSettingResponse = getSettingWebServiceImpl().findSetting(paramFindSetting, paramMetaData);
      return (List<S>) findSettingResponse.getReturn();
   }

   private SettingWebServiceImpl getSettingWebServiceImpl() {
      if (settingWebServiceImpl == null) {
         SettingWebServiceImplService settingWebServiceImplService = new SettingWebServiceImplService(
               SettingWebServiceImplService.WSDL_LOCATION);
         settingWebServiceImpl = settingWebServiceImplService.getSettingWebServiceImplPort();
      }

      return settingWebServiceImpl;
   }

   @SuppressWarnings("unchecked")
   @Override
   public S merge(MetaData paramMetaData, S paramSetting) {
      MergeSetting paramMergeSetting = new MergeSetting();
      paramMergeSetting.setSetting(paramSetting);
      MergeSettingResponse mergeSettingResponse = getSettingWebServiceImpl().mergeSetting(paramMergeSetting,
            paramMetaData);
      return (S) mergeSettingResponse.getReturn();
   }

   @SuppressWarnings("unchecked")
   @Override
   public S persist(MetaData paramMetaData, S paramSetting) {
      PersistSetting paramPersistSetting = new PersistSetting();
      paramPersistSetting.setSetting(paramSetting);
      PersistSettingResponse persistSettingResponse = getSettingWebServiceImpl().persistSetting(paramPersistSetting,
            paramMetaData);
      return (S) persistSettingResponse.getReturn();
   }

   @SuppressWarnings("unchecked")
   @Override
   public S refresh(MetaData paramMetaData, S paramSetting) {
      RefreshSetting paramRefresSetting = new RefreshSetting();
      paramRefresSetting.setSetting(paramSetting);
      RefreshSettingResponse refresSettingResponse = getSettingWebServiceImpl().refreshSetting(paramRefresSetting,
            paramMetaData);
      return (S) refresSettingResponse.getReturn();
   }

   @Override
   public void remove(MetaData paramMetaData, S paramSetting) {
      RemoveSetting paramRemoveSetting = new RemoveSetting();
      paramRemoveSetting.setSetting(paramSetting);
      getSettingWebServiceImpl().removeSetting(paramRemoveSetting, paramMetaData);
   }
}
