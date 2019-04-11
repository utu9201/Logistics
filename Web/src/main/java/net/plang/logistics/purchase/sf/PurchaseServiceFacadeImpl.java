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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceFacadeImpl implements PurchaseServiceFacade {
    @Autowired
    private PurchaseApplicationService purchaseApplicationService;

    @Override
    public List<ItemTO> getItemList() {
        return purchaseApplicationService.getItemList();
    }

    @Override
    public List<ItemTO> batchItem(List<ItemTO> itemList) {
        return null;
    }

    @Override
    public List<BomTO> getBomList() {
        return purchaseApplicationService.getBomList();
    }

    @Override
    public List<BomDeployTO> getBomDeployList(String itemCode, String deployCondition) {
        return purchaseApplicationService.getBomDeployList(itemCode, deployCondition);
    }

    @Override
    public List<OrderInfoTO> getOrderInfoList() {
        return purchaseApplicationService.getOrderInfoList();
    }

    @Override
    public List<OrderDetailTO> getOrderDetailList() {
        return purchaseApplicationService.getOrderDetailList();
    }

    @Override
    public void registOrder(List<OrderInfoTO> orderInfoList, List<OrderDetailTO> orderDetailList,
                            List<OrderGatheringTO> orderGatheringList) {
        purchaseApplicationService.registOrder(orderInfoList, orderDetailList, orderGatheringList);
    }

    @Override
    public List<OrderGatheringTO> getOrderGatheringList() {
        return purchaseApplicationService.getOrderGatheringList();
    }

    @Override
    public List<StockTO> getStockList() {
        return purchaseApplicationService.getStockList();
    }

    @Override
    public void batchStock(List<StockTO> stockList) {
        purchaseApplicationService.batchStock(stockList);
    }

    @Override
    public List<MaterialPaymentTO> getMaterialPaymentList() {
        return purchaseApplicationService.getMaterialPaymentList();
    }

    @Override
    public void registMaterialPayment(List<MaterialPaymentTO> materialPaymentList) {
        purchaseApplicationService.registMaterialPayment(materialPaymentList);
    }

    @Override
    public List<WarehousingTO> getWarehousingList() {
        return purchaseApplicationService.getWarehousingList();
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
