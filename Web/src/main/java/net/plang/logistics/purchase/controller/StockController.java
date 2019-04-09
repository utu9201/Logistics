package net.plang.logistics.purchase.controller;

import java.util.List;

import com.tobesoft.platform.data.PlatformData;

import net.plang.common.controller.MiplatformController;
import net.plang.logistics.purchase.sf.PurchaseServiceFacade;
import net.plang.logistics.purchase.to.MaterialPaymentTO;
import net.plang.logistics.purchase.to.OrderDetailTO;
import net.plang.logistics.purchase.to.OrderInfoTO;
import net.plang.logistics.purchase.to.StockTO;
import net.plang.logistics.purchase.to.WarehousingTO;

public class StockController extends MiplatformController {
    private PurchaseServiceFacade purchaseServiceFacade;

    public void setPurchaseServiceFacade(PurchaseServiceFacade purchaseServiceFacade) {
        this.purchaseServiceFacade = purchaseServiceFacade;
    }

    public void findStockList(PlatformData inData, PlatformData outData) throws Exception {
        List<StockTO> stockList = purchaseServiceFacade.findStockList();
        for (StockTO st : stockList) {
            System.out.print(st.getItemCode());
        }
        datasetBeanMapper.beansToDataset(outData, stockList, StockTO.class);

    }

    public void batchStock(PlatformData inData, PlatformData outData) throws Exception {
        List<StockTO> stockList = datasetBeanMapper.datasetToBeans(inData, StockTO.class);

        purchaseServiceFacade.batchStock(stockList);

        findStockList(inData, outData);
    }

    public void findMaterialPaymentList(PlatformData inData, PlatformData outData) throws Exception {
        List<MaterialPaymentTO> materialPaymentList = purchaseServiceFacade.findMaterialPaymentList();

        datasetBeanMapper.beansToDataset(outData, materialPaymentList, MaterialPaymentTO.class);

    }

    public void registMaterialPayment(PlatformData inData, PlatformData outData) throws Exception {
        List<MaterialPaymentTO> materialPaymentList = datasetBeanMapper.datasetToBeans(inData, MaterialPaymentTO.class);

        purchaseServiceFacade.registMaterialPayment(materialPaymentList);

        findStockList(inData, outData);
    }

    public void findWarehousingList(PlatformData inData, PlatformData outData) throws Exception {
        List<WarehousingTO> warehousingList = purchaseServiceFacade.findWarehousingList();

        datasetBeanMapper.beansToDataset(outData, warehousingList, WarehousingTO.class);

    }

    public void registWarehousing(PlatformData inData, PlatformData outData) throws Exception {

        List<OrderInfoTO> orderInfoList = datasetBeanMapper.datasetToBeans(inData, OrderInfoTO.class);

        List<OrderDetailTO> orderDetailList = datasetBeanMapper.datasetToBeans(inData, OrderDetailTO.class);

        List<StockTO> stockList = datasetBeanMapper.datasetToBeans(inData, StockTO.class);

        List<WarehousingTO> warehousingList = datasetBeanMapper.datasetToBeans(inData, WarehousingTO.class);

        purchaseServiceFacade.registWarehousing(orderInfoList, orderDetailList, stockList, warehousingList);

        findStockList(inData, outData);

        findWarehousingList(inData, outData);
    }
}
