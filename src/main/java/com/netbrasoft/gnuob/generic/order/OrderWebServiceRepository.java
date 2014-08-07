package com.netbrasoft.gnuob.generic.order;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.netbrasoft.gnuob.api.CountOrder;
import com.netbrasoft.gnuob.api.CountOrderResponse;
import com.netbrasoft.gnuob.api.FindOrder;
import com.netbrasoft.gnuob.api.FindOrderById;
import com.netbrasoft.gnuob.api.FindOrderByIdResponse;
import com.netbrasoft.gnuob.api.FindOrderResponse;
import com.netbrasoft.gnuob.api.GNUOpenBusinessServiceException_Exception;
import com.netbrasoft.gnuob.api.MergeOrder;
import com.netbrasoft.gnuob.api.MergeOrderResponse;
import com.netbrasoft.gnuob.api.MetaData;
import com.netbrasoft.gnuob.api.Order;
import com.netbrasoft.gnuob.api.OrderBy;
import com.netbrasoft.gnuob.api.OrderWebServiceImpl;
import com.netbrasoft.gnuob.api.OrderWebServiceImplService;
import com.netbrasoft.gnuob.api.Paging;
import com.netbrasoft.gnuob.api.PersistOrder;
import com.netbrasoft.gnuob.api.PersistOrderResponse;
import com.netbrasoft.gnuob.api.RefreshOrder;
import com.netbrasoft.gnuob.api.RefreshOrderResponse;
import com.netbrasoft.gnuob.api.RemoveOrder;

@Repository("OrderWebServiceRepository")
public class OrderWebServiceRepository {

	private static final String GNUOB_ORDER_WEB_SERVICE = System.getProperty("gnuob.order-service.url", "http://localhost:8080/gnuob-soap/OrderWebServiceImpl?wsdl");
	private OrderWebServiceImpl orderWebServiceImpl;

	public OrderWebServiceRepository() {
		try {
			OrderWebServiceImplService orderWebServiceImplService = new OrderWebServiceImplService(new URL(GNUOB_ORDER_WEB_SERVICE));
			orderWebServiceImpl = orderWebServiceImplService.getOrderWebServiceImplPort();
		} catch (MalformedURLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public long count(MetaData paramMetaData, Order paramOrder) throws GNUOpenBusinessServiceException_Exception {
		CountOrder paramCountOrder = new CountOrder();
		paramCountOrder.setOrder(paramOrder);
		CountOrderResponse countOrderResponse = orderWebServiceImpl.countOrder(paramCountOrder, paramMetaData);
		return countOrderResponse.getReturn();
	}

	public Order find(MetaData paramMetaData, Order paramOrder) throws GNUOpenBusinessServiceException_Exception {
		FindOrderById paramFindOrderById = new FindOrderById();
		paramFindOrderById.setOrder(paramOrder);
		FindOrderByIdResponse findOrderByIdResponse = orderWebServiceImpl.findOrderById(paramFindOrderById, paramMetaData);
		return findOrderByIdResponse.getReturn();

	}

	public List<Order> find(MetaData paramMetaData, Order paramOrder, Paging paramPaging, OrderBy paramOrderBy) throws GNUOpenBusinessServiceException_Exception {
		FindOrder paramFindOrder = new FindOrder();
		paramFindOrder.setOrder(paramOrder);
		paramFindOrder.setPaging(paramPaging);
		paramFindOrder.setOrderBy(paramOrderBy);
		FindOrderResponse findOrderResponse = orderWebServiceImpl.findOrder(paramFindOrder, paramMetaData);
		return findOrderResponse.getReturn();
	}

	public Order merge(MetaData paramMetaData, Order paramOrder) throws GNUOpenBusinessServiceException_Exception {
		MergeOrder paramMergeOrder = new MergeOrder();
		paramMergeOrder.setOrder(paramOrder);
		MergeOrderResponse mergeOrderResponse = orderWebServiceImpl.mergeOrder(paramMergeOrder, paramMetaData);
		return mergeOrderResponse.getReturn();
	}

	public Order persist(MetaData paramMetaData, Order paramOrder) throws GNUOpenBusinessServiceException_Exception {
		PersistOrder paramPersistOrder = new PersistOrder();
		paramPersistOrder.setOrder(paramOrder);
		PersistOrderResponse persistOrderResponse = orderWebServiceImpl.persistOrder(paramPersistOrder, paramMetaData);
		return persistOrderResponse.getReturn();
	}

	public Order refresh(MetaData paramMetaData, Order paramOrder) throws GNUOpenBusinessServiceException_Exception {
		RefreshOrder paramRefreshOrder = new RefreshOrder();
		paramRefreshOrder.setOrder(paramOrder);
		RefreshOrderResponse refreshOrderResponse = orderWebServiceImpl.refreshOrder(paramRefreshOrder, paramMetaData);
		return refreshOrderResponse.getReturn();
	}

	public void remove(MetaData paramMetaData, Order paramOrder) throws GNUOpenBusinessServiceException_Exception {
		RemoveOrder paramRemoveOrder = new RemoveOrder();
		paramRemoveOrder.setOrder(paramOrder);
		orderWebServiceImpl.removeOrder(paramRemoveOrder, paramMetaData);
	}
}
