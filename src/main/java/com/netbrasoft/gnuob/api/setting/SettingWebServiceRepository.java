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
@Repository(SettingWebServiceRepository.SETTING_WEB_SERVICE_REPOSITORY_NAME)
public class SettingWebServiceRepository<S extends Setting> implements GenericTypeWebServiceRepository<S> {

  protected static final String SETTING_WEB_SERVICE_REPOSITORY_NAME = "SettingWebServiceRepository";

  private SettingWebServiceImpl settingWebServiceImpl;

  public SettingWebServiceRepository() {
    // Empty constructor.
  }

  @Override
  public long count(final MetaData paramMetaData, final S paramSetting) {
    final CountSetting paramCountSetting = new CountSetting();
    paramCountSetting.setSetting(paramSetting);
    final CountSettingResponse countSettingResponse = getSettingWebServiceImpl().countSetting(paramCountSetting, paramMetaData);
    return countSettingResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public S find(final MetaData paramMetaData, final S paramSetting) {
    final FindSettingById paramFindSettingById = new FindSettingById();
    paramFindSettingById.setSetting(paramSetting);
    final FindSettingByIdResponse findSettingByIdResponse = getSettingWebServiceImpl().findSettingById(paramFindSettingById, paramMetaData);
    return (S) findSettingByIdResponse.getReturn();

  }

  @SuppressWarnings("unchecked")
  @Override
  public List<S> find(final MetaData paramMetaData, final S paramSetting, final Paging paramPaging, final OrderBy paramOrderBy) {
    final FindSetting paramFindSetting = new FindSetting();
    paramFindSetting.setSetting(paramSetting);
    paramFindSetting.setPaging(paramPaging);
    paramFindSetting.setOrderBy(paramOrderBy);
    final FindSettingResponse findSettingResponse = getSettingWebServiceImpl().findSetting(paramFindSetting, paramMetaData);
    return (List<S>) findSettingResponse.getReturn();
  }

  private SettingWebServiceImpl getSettingWebServiceImpl() {
    if (settingWebServiceImpl == null) {
      final SettingWebServiceImplService settingWebServiceImplService = new SettingWebServiceImplService(SettingWebServiceImplService.WSDL_LOCATION);
      settingWebServiceImpl = settingWebServiceImplService.getSettingWebServiceImplPort();
    }

    return settingWebServiceImpl;
  }

  @SuppressWarnings("unchecked")
  @Override
  public S merge(final MetaData paramMetaData, final S paramSetting) {
    final MergeSetting paramMergeSetting = new MergeSetting();
    paramMergeSetting.setSetting(paramSetting);
    final MergeSettingResponse mergeSettingResponse = getSettingWebServiceImpl().mergeSetting(paramMergeSetting, paramMetaData);
    return (S) mergeSettingResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public S persist(final MetaData paramMetaData, final S paramSetting) {
    final PersistSetting paramPersistSetting = new PersistSetting();
    paramPersistSetting.setSetting(paramSetting);
    final PersistSettingResponse persistSettingResponse = getSettingWebServiceImpl().persistSetting(paramPersistSetting, paramMetaData);
    return (S) persistSettingResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public S refresh(final MetaData paramMetaData, final S paramSetting) {
    final RefreshSetting paramRefresSetting = new RefreshSetting();
    paramRefresSetting.setSetting(paramSetting);
    final RefreshSettingResponse refresSettingResponse = getSettingWebServiceImpl().refreshSetting(paramRefresSetting, paramMetaData);
    return (S) refresSettingResponse.getReturn();
  }

  @Override
  public void remove(final MetaData paramMetaData, final S paramSetting) {
    final RemoveSetting paramRemoveSetting = new RemoveSetting();
    paramRemoveSetting.setSetting(paramSetting);
    getSettingWebServiceImpl().removeSetting(paramRemoveSetting, paramMetaData);
  }
}
