package net.plang.logistics.purchase.sf;

import java.util.HashMap;
import java.util.List;

import net.plang.logistics.purchase.applicationService.PurchaseApplicationService;
import net.plang.logistics.purchase.to.BomDeployTO;
import net.plang.logistics.purchase.to.BomTO;
import net.plang.logistics.purchase.to.ItemTO;
import net.plang.logistics.purchase.to.MaterialPaymentTO;
import net.plang.logistics.purchase.to.OrderDetailTO;
import net.plang.logistics.purchase.to.OrderGatheringTO;
import net.plang.logistics.purchase.to.OrderInfoTO;
import net.plang.logistics.purchase.to.StockTO;
import net.plang.logistics.purchase.to.WarehousingTO;

public class PurchaseServiceFacadeImpl implements PurchaseServiceFacade {

    private PurchaseApplicationService purchaseApplicationService;

    public void setPurchaseApplicationService(PurchaseApplicationService purchaseApplicationService) {
        this.purchaseApplicationService = purchaseApplicationService;
    }

    @Override
    public List<ItemTO> findItemList() {

        return purchaseApplicationService.findItemList();
    }

    @Override
    public List<ItemTO> batchItem(List<ItemTO> itemList) {
        return null;
    }

    @Override
    public List<BomTO> findBomList() {
        return purchaseApplicationService.findBomList();
    }

    @Override
    public List<BomDeployTO> findBomDeployList(String itemCode, String deployCondition) {
        return purchaseApplicationService.findBomDeployList(itemCode, deployCondition);
    }

    @Override
    public List<OrderInfoTO> findOrderInfoList() {
        return purchaseApplicationService.findOrderInfoList();
    }

    @Override
    public List<OrderDetailTO> findOrderDetailList() {
        return purchaseApplicationService.findOrderDetailList();
    }

    @Override
    public void registOrder(List<OrderInfoTO> orderInfoList, List<OrderDetailTO> orderDetailList,
                            List<OrderGatheringTO> orderGatheringList) {
        purchaseApplicationService.registOrder(orderInfoList, orderDetailList, orderGatheringList);
    }

    @Override
    public List<OrderGatheringTO> findOrderGatheringList() {
        return purchaseApplicationService.findOrderGatheringList();
    }

    @Override
    public List<StockTO> findStockList() {
        return purchaseApplicationService.findStockList();
    }

    @Override
    public void batchStock(List<StockTO> stockList) {
        purchaseApplicationService.batchStock(stockList);
    }

    @Override
    public List<MaterialPaymentTO> findMaterialPaymentList() {
        return purchaseApplicationService.findMaterialPaymentList();
    }

    @Override
    public void registMaterialPayment(List<MaterialPaymentTO> materialPaymentList) {
        purchaseApplicationService.registMaterialPayment(materialPaymentList);
    }

    @Override
    public List<WarehousingTO> findWarehousingList() {
        return purchaseApplicationService.findWarehousingList();
    }

    @Override
    public void registWarehousing(List<OrderInfoTO> orderInfoList, List<OrderDetailTO> orderDetailList,
                                  List<StockTO> stockList, List<WarehousingTO> warehousingList) {
        purchaseApplicationService.registWarehousing(orderInfoList, orderDetailList, stockList, warehousingList);
    }

    @Override
    public void registOrderGathering(List<OrderGatheringTO> orderGatheringList) {
        purchaseApplicationService.registOrderGathering(orderGatheringList);
    }

    @Override
    public HashMap<String, String> cancelOrder(List<OrderDetailTO> orderDetailList, String empCode) {
        return purchaseApplicationService.cancelOrder(orderDetailList, empCode);
    }
}
