package net.plang.logistics.purchase.applicationService;

import java.util.HashMap;
import java.util.List;

import net.plang.logistics.purchase.to.BomDeployTO;
import net.plang.logistics.purchase.to.BomTO;
import net.plang.logistics.purchase.to.ItemTO;
import net.plang.logistics.purchase.to.MaterialPaymentTO;
import net.plang.logistics.purchase.to.OrderDetailTO;
import net.plang.logistics.purchase.to.OrderGatheringTO;
import net.plang.logistics.purchase.to.OrderInfoTO;
import net.plang.logistics.purchase.to.StockTO;
import net.plang.logistics.purchase.to.WarehousingTO;

public interface PurchaseApplicationService {
    List<ItemTO> findItemList();

    List<ItemTO> batchItem(List<ItemTO> itemList);

    List<BomTO> findBomList();

    List<BomDeployTO> findBomDeployList(String itemCode, String deployCondition);

    List<OrderInfoTO> findOrderInfoList();

    List<OrderDetailTO> findOrderDetailList();

    List<OrderGatheringTO> findOrderGatheringList();

    void registOrder(List<OrderInfoTO> orderInfoList, List<OrderDetailTO> orderDetailList, List<OrderGatheringTO> orderGatheringList);

    List<StockTO> findStockList();

    void batchStock(List<StockTO> stockList);

    List<MaterialPaymentTO> findMaterialPaymentList();

    void registMaterialPayment(List<MaterialPaymentTO> materialPaymentList);

    List<WarehousingTO> findWarehousingList();

    void registWarehousing(List<OrderInfoTO> orderInfoList, List<OrderDetailTO> orderDetailList, List<StockTO> stockList, List<WarehousingTO> warehousingList);

    void registOrderGathering(List<OrderGatheringTO> orderGatheringList);

    HashMap<String, String> cancelOrder(List<OrderDetailTO> orderDetailList, String empCode);
}
