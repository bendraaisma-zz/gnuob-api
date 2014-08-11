package com.netbrasoft.gnuob.api.setting;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.netbrasoft.gnuob.api.CountSetting;
import com.netbrasoft.gnuob.api.CountSettingResponse;
import com.netbrasoft.gnuob.api.FindSetting;
import com.netbrasoft.gnuob.api.FindSettingById;
import com.netbrasoft.gnuob.api.FindSettingByIdResponse;
import com.netbrasoft.gnuob.api.FindSettingResponse;
import com.netbrasoft.gnuob.api.GNUOpenBusinessServiceException_Exception;
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

@Repository("SettingWebServiceRepository")
public class SettingWebServiceRepository {

	private SettingWebServiceImpl settingWebServiceImpl;

	public SettingWebServiceRepository() {
	}

	public long count(MetaData paramMetaData, Setting paramSetting) throws GNUOpenBusinessServiceException_Exception {
		CountSetting paramCountSetting = new CountSetting();
		paramCountSetting.setSetting(paramSetting);
		CountSettingResponse countSettingResponse = getSettingWebServiceImpl().countSetting(paramCountSetting, paramMetaData);
		return countSettingResponse.getReturn();
	}

	public Setting find(MetaData paramMetaData, Setting paramSetting) throws GNUOpenBusinessServiceException_Exception {
		FindSettingById paramFindSettingById = new FindSettingById();
		paramFindSettingById.setSetting(paramSetting);
		FindSettingByIdResponse findSettingByIdResponse = getSettingWebServiceImpl().findSettingById(paramFindSettingById, paramMetaData);
		return findSettingByIdResponse.getReturn();

	}

	public List<Setting> find(MetaData paramMetaData, Setting paramSetting, Paging paramPaging, OrderBy paramOrderBy) throws GNUOpenBusinessServiceException_Exception {
		FindSetting paramFindSetting = new FindSetting();
		paramFindSetting.setSetting(paramSetting);
		paramFindSetting.setPaging(paramPaging);
		paramFindSetting.setOrderBy(paramOrderBy);
		FindSettingResponse findSettingResponse = getSettingWebServiceImpl().findSetting(paramFindSetting, paramMetaData);
		return findSettingResponse.getReturn();
	}

	private SettingWebServiceImpl getSettingWebServiceImpl() {
		if (settingWebServiceImpl == null) {
			SettingWebServiceImplService settingWebServiceImplService = new SettingWebServiceImplService(SettingWebServiceImplService.WSDL_LOCATION);
			settingWebServiceImpl = settingWebServiceImplService.getSettingWebServiceImplPort();
		}

		return settingWebServiceImpl;
	}

	public Setting merge(MetaData paramMetaData, Setting paramSetting) throws GNUOpenBusinessServiceException_Exception {
		MergeSetting paramMergeSetting = new MergeSetting();
		paramMergeSetting.setSetting(paramSetting);
		MergeSettingResponse mergeSettingResponse = getSettingWebServiceImpl().mergeSetting(paramMergeSetting, paramMetaData);
		return mergeSettingResponse.getReturn();
	}

	public Setting persist(MetaData paramMetaData, Setting paramSetting) throws GNUOpenBusinessServiceException_Exception {
		PersistSetting paramPersistSetting = new PersistSetting();
		paramPersistSetting.setSetting(paramSetting);
		PersistSettingResponse persistSettingResponse = getSettingWebServiceImpl().persistSetting(paramPersistSetting, paramMetaData);
		return persistSettingResponse.getReturn();
	}

	public Setting refresh(MetaData paramMetaData, Setting paramSetting) throws GNUOpenBusinessServiceException_Exception {
		RefreshSetting paramRefresSetting = new RefreshSetting();
		paramRefresSetting.setSetting(paramSetting);
		RefreshSettingResponse refresSettingResponse = getSettingWebServiceImpl().refreshSetting(paramRefresSetting, paramMetaData);
		return refresSettingResponse.getReturn();
	}

	public void remove(MetaData paramMetaData, Setting paramSetting) throws GNUOpenBusinessServiceException_Exception {
		RemoveSetting paramRemoveSetting = new RemoveSetting();
		paramRemoveSetting.setSetting(paramSetting);
		getSettingWebServiceImpl().removeSetting(paramRemoveSetting, paramMetaData);
	}
}
