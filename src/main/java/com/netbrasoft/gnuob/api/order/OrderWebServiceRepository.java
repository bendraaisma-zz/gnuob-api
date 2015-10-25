package com.netbrasoft.gnuob.api.order;

import java.util.List;

import org.javasimon.aop.Monitored;
import org.springframework.stereotype.Repository;

import com.netbrasoft.gnuob.api.CountOrder;
import com.netbrasoft.gnuob.api.CountOrderResponse;
import com.netbrasoft.gnuob.api.FindOrder;
import com.netbrasoft.gnuob.api.FindOrderById;
import com.netbrasoft.gnuob.api.FindOrderByIdResponse;
import com.netbrasoft.gnuob.api.FindOrderResponse;
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
import com.netbrasoft.gnuob.api.generic.GenericTypeWebServiceRepository;

@Monitored
@Repository("OrderWebServiceRepository")
public class OrderWebServiceRepository<O extends Order> implements GenericTypeWebServiceRepository<O> {

  private OrderWebServiceImpl orderWebServiceImpl;

  public OrderWebServiceRepository() {}

  @Override
  public long count(MetaData paramMetaData, O paramOrder) {
    final CountOrder paramCountOrder = new CountOrder();
    paramCountOrder.setOrder(paramOrder);
    final CountOrderResponse countOrderResponse = getOrderWebServiceImpl().countOrder(paramCountOrder, paramMetaData);
    return countOrderResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public O find(MetaData paramMetaData, O paramOrder) {
    final FindOrderById paramFindOrderById = new FindOrderById();
    paramFindOrderById.setOrder(paramOrder);
    final FindOrderByIdResponse findOrderByIdResponse = getOrderWebServiceImpl().findOrderById(paramFindOrderById, paramMetaData);
    return (O) findOrderByIdResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<O> find(MetaData paramMetaData, O paramOrder, Paging paramPaging, OrderBy paramOrderBy) {
    final FindOrder paramFindOrder = new FindOrder();
    paramFindOrder.setOrder(paramOrder);
    paramFindOrder.setPaging(paramPaging);
    paramFindOrder.setOrderBy(paramOrderBy);
    final FindOrderResponse findOrderResponse = getOrderWebServiceImpl().findOrder(paramFindOrder, paramMetaData);
    return (List<O>) findOrderResponse.getReturn();
  }

  private OrderWebServiceImpl getOrderWebServiceImpl() {
    if (orderWebServiceImpl == null) {
      final OrderWebServiceImplService orderWebServiceImplService = new OrderWebServiceImplService(OrderWebServiceImplService.WSDL_LOCATION);
      orderWebServiceImpl = orderWebServiceImplService.getOrderWebServiceImplPort();
    }
    return orderWebServiceImpl;
  }

  @SuppressWarnings("unchecked")
  @Override
  public O merge(MetaData paramMetaData, O paramOrder) {
    final MergeOrder paramMergeOrder = new MergeOrder();
    paramMergeOrder.setOrder(paramOrder);
    final MergeOrderResponse mergeOrderResponse = getOrderWebServiceImpl().mergeOrder(paramMergeOrder, paramMetaData);
    return (O) mergeOrderResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public O persist(MetaData paramMetaData, O paramOrder) {
    final PersistOrder paramPersistOrder = new PersistOrder();
    paramPersistOrder.setOrder(paramOrder);
    final PersistOrderResponse persistOrderResponse = getOrderWebServiceImpl().persistOrder(paramPersistOrder, paramMetaData);
    return (O) persistOrderResponse.getReturn();
  }

  @SuppressWarnings("unchecked")
  @Override
  public O refresh(MetaData paramMetaData, O paramOrder) {
    final RefreshOrder paramRefreshOrder = new RefreshOrder();
    paramRefreshOrder.setOrder(paramOrder);
    final RefreshOrderResponse refreshOrderResponse = getOrderWebServiceImpl().refreshOrder(paramRefreshOrder, paramMetaData);
    return (O) refreshOrderResponse.getReturn();
  }

  @Override
  public void remove(MetaData paramMetaData, O paramOrder) {
    final RemoveOrder paramRemoveOrder = new RemoveOrder();
    paramRemoveOrder.setOrder(paramOrder);
    getOrderWebServiceImpl().removeOrder(paramRemoveOrder, paramMetaData);
  }
}
