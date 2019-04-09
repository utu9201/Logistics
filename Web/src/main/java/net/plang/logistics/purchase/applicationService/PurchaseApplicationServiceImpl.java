package net.plang.logistics.purchase.applicationService;

import java.util.HashMap;
import java.util.List;

import net.plang.logistics.production.applicationService.ProductionApplicationService;
import net.plang.logistics.purchase.dao.*;
import net.plang.logistics.purchase.to.BomDeployTO;
import net.plang.logistics.purchase.to.BomTO;
import net.plang.logistics.purchase.to.ItemTO;
import net.plang.logistics.purchase.to.MaterialPaymentTO;
import net.plang.logistics.purchase.to.OrderDetailTO;
import net.plang.logistics.purchase.to.OrderGatheringTO;
import net.plang.logistics.purchase.to.OrderInfoTO;
import net.plang.logistics.purchase.to.StockTO;
import net.plang.logistics.purchase.to.WarehousingTO;

public class PurchaseApplicationServiceImpl implements PurchaseApplicationService {

    private ItemDAO itemDAO;
    private BomDAO bomDAO;
    private OrderGatheringDAO orderGatheringDAO;
    private OrderInfoDAO orderInfoDAO;
    private OrderDetailDAO orderDetailDAO;
    private StockDAO stockDAO;
    private MaterialPaymentDAO materialPaymentDAO;
    private WarehousingDAO warehousingDAO;

    public void setWarehousingDAO(WarehousingDAO warehousingDAO) {
        this.warehousingDAO = warehousingDAO;
    }

    public void setMaterialPaymentDAO(MaterialPaymentDAO materialPaymentDAO) {
        this.materialPaymentDAO = materialPaymentDAO;
    }

    public void setOrderGatheringDAO(OrderGatheringDAO orderGatheringDAO) {
        this.orderGatheringDAO = orderGatheringDAO;
    }

    public void setStockDAO(StockDAO stockDAO) {
        this.stockDAO = stockDAO;
    }

    private ProductionApplicationService productionApplicationService;

    public void setProductionApplicationService(ProductionApplicationService productionApplicationService) {
        this.productionApplicationService = productionApplicationService;
    }

    public void setOrderInfoDAO(OrderInfoDAO orderInfoDAO) {
        this.orderInfoDAO = orderInfoDAO;
    }

    public void setOrderDetailDAO(OrderDetailDAO orderDetailDAO) {
        this.orderDetailDAO = orderDetailDAO;
    }

    public void setBomDAO(BomDAO bomDAO) {
        this.bomDAO = bomDAO;
    }

    public void setItemDAO(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    @Override
    public List<ItemTO> findItemList() {
        return itemDAO.selectItemList();
    }

    @Override
    public List<ItemTO> batchItem(List<ItemTO> itemList) {
        return null;
    }

    @Override
    public List<BomTO> findBomList() {
        return bomDAO.selectBomList();
    }

    @Override
    public List<BomDeployTO> findBomDeployList(String itemCode, String deployCondition) {
        return bomDAO.selectBomDeployList(itemCode, deployCondition);
    }

    @Override
    public List<OrderInfoTO> findOrderInfoList() {
        return orderInfoDAO.selectOrderInfoList();
    }

    @Override
    public List<OrderDetailTO> findOrderDetailList() {
        return orderDetailDAO.selectOrderDetailList();
    }

    @Override
    public void registOrder(List<OrderInfoTO> orderInfoList, List<OrderDetailTO> orderDetailList,
                            List<OrderGatheringTO> orderGatheringList) {

        for (OrderInfoTO orderInfoTO : orderInfoList) {

            switch (orderInfoTO.getStatus()) {
                case "insert":
                    orderInfoDAO.insertOrderInfo(orderInfoTO);
                    break;
                case "update":
                    orderInfoDAO.updateOrderInfo(orderInfoTO);
                    break;
            }
        }
        for (OrderDetailTO orderDetailTO : orderDetailList) {
//			System.out.println(orderDetailTO.getOrderAmount()+orderDetailTO.getItemName());
            switch (orderDetailTO.getStatus()) {
                case "insert":
                    orderDetailDAO.insertOrderDetail(orderDetailTO);
                    break;
                case "update":
                    orderDetailDAO.updateOrderDetail(orderDetailTO);
                    break;
            }
        }
        if (orderGatheringList != null) {
            registOrderGathering(orderGatheringList);
        }
    }

    @Override
    public List<OrderGatheringTO> findOrderGatheringList() {

        return orderGatheringDAO.selectOrderGatheringList();
    }

    @Override
    public List<StockTO> findStockList() {
        return stockDAO.selectStockList();
    }

    @Override
    public void batchStock(List<StockTO> stockList) {

        for (StockTO stockTO : stockList) {
            stockDAO.updateStock(stockTO);

	/*		switch(stockTO.getStatus()) {
			case "insert" : stockDAO.insertStock(stockTO); break;
			case "update" : stockDAO.updateStock(stockTO); break;
			case "delete" : stockDAO.deleteStock(stockTO); break;

			}*/

        }
    }

    @Override
    public List<MaterialPaymentTO> findMaterialPaymentList() {
        return materialPaymentDAO.selectMaterialPaymentList();
    }

    @Override
    public void registMaterialPayment(List<MaterialPaymentTO> materialPaymentList) {

        for (MaterialPaymentTO materialPaymentTO : materialPaymentList) {
            switch (materialPaymentTO.getStatus()) {
                case "insert":
                    materialPaymentDAO.insertMaterialPayment(materialPaymentTO);
                    break;
                //case "update" : materialPaymentDAO.updatematerialPayment(materialPaymentTO); break;
                //case "delete" : materialPaymentDAO.deletematerialPayment(materialPaymentTO); break;

            }

        }
    }

    @Override
    public List<WarehousingTO> findWarehousingList() {
        return warehousingDAO.selectWarehousingList();
    }

    @Override
    public void registWarehousing(List<OrderInfoTO> orderInfoList, List<OrderDetailTO> orderDetailList,
                                  List<StockTO> stockList, List<WarehousingTO> warehousingList) {
        if (orderInfoList != null && orderDetailList != null) {
            registOrder(orderInfoList, orderDetailList, null);
        }

        if (stockList != null) {
            batchStock(stockList);
        }
        for (WarehousingTO warehousingTO : warehousingList) {

            warehousingDAO.insertWarehousing(warehousingTO);
/*			switch(warehousingTO.getStatus()) {
			case "insert" : warehousingDAO.insertWarehousing(warehousingTO); break;
			case "update" : warehousingDAO.updateWarehousing(warehousingTO); break;
			}*/

        }
    }

    @Override
    public void registOrderGathering(List<OrderGatheringTO> orderGatheringList) {
        for (OrderGatheringTO orderGatheringTO : orderGatheringList) {
            switch (orderGatheringTO.getStatus()) {
                case "insert":
                    //orderGatheringNo 생성해주는 곳
                    String orderGatheringNo = orderGatheringDAO.selectOrderGatheringNo();
                    orderGatheringTO.setOrderGatheringNo(orderGatheringNo);
                    orderGatheringDAO.insertOrderGathering(orderGatheringTO);
                    break;
                case "update":
                    orderGatheringDAO.updateOrderGathering(orderGatheringTO);
                    break;
            }
        }

    }

    @Override
    //발주취소
    public HashMap<String, String> cancelOrder(List<OrderDetailTO> orderDetailList, String empCode) {
        HashMap<String, String> result = null;
        for (OrderDetailTO orderDetailTO : orderDetailList) {
            switch (orderDetailTO.getStatus()) {
                case "delete":
                    result = orderDetailDAO.callCancelOrder(orderDetailTO, empCode);
                    break;

            }
        }
        return result;
    }

}
