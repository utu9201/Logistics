package net.plang.logistics.purchase.controller;

import java.util.List;

import com.tobesoft.xplatform.data.PlatformData;
import net.plang.common.mapper.DatasetBeanMapper;
import net.plang.logistics.purchase.sf.PurchaseServiceFacade;
import net.plang.logistics.purchase.to.MaterialPaymentTO;
import net.plang.logistics.purchase.to.OrderDetailTO;
import net.plang.logistics.purchase.to.OrderInfoTO;
import net.plang.logistics.purchase.to.StockTO;
import net.plang.logistics.purchase.to.WarehousingTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

public class StockController {
    @Autowired
    private PurchaseServiceFacade purchaseServiceFacade;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @RequestMapping("/logistics/purchase/getStockList.do")
    public void getStockList(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        List<StockTO> stockList = purchaseServiceFacade.getStockList();

        datasetBeanMapper.beansToDataset(outData, stockList, StockTO.class);
    }

    @RequestMapping("/logistics/purchase/batchStock.do")
    public void batchStock(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        List<StockTO> stockList = datasetBeanMapper.datasetToBeans(inData, StockTO.class);

        purchaseServiceFacade.batchStock(stockList);
        getStockList(inData, outData);
    }

    @RequestMapping("/logistics/purchase/getMaterialPaymentList.do")
    public void getMaterialPaymentList(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        List<MaterialPaymentTO> materialPaymentList = purchaseServiceFacade.getMaterialPaymentList();

        datasetBeanMapper.beansToDataset(outData, materialPaymentList, MaterialPaymentTO.class);
    }

    @RequestMapping("/logistics/purchase/registMaterialPayment.do")
    public void registMaterialPayment(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        List<MaterialPaymentTO> materialPaymentList = datasetBeanMapper.datasetToBeans(inData, MaterialPaymentTO.class);

        purchaseServiceFacade.registMaterialPayment(materialPaymentList);
        getStockList(inData, outData);
    }

    @RequestMapping("/logistics/purchase/getWarehousingList.do")
    public void getWarehousingList(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        List<WarehousingTO> warehousingList = purchaseServiceFacade.getWarehousingList();

        datasetBeanMapper.beansToDataset(outData, warehousingList, WarehousingTO.class);
    }

    @RequestMapping("/logistics/purchase/registWarehousing.do")
    public void registWarehousing(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        List<OrderInfoTO> orderInfoList = datasetBeanMapper.datasetToBeans(inData, OrderInfoTO.class);
        List<OrderDetailTO> orderDetailList = datasetBeanMapper.datasetToBeans(inData, OrderDetailTO.class);
        List<StockTO> stockList = datasetBeanMapper.datasetToBeans(inData, StockTO.class);
        List<WarehousingTO> warehousingList = datasetBeanMapper.datasetToBeans(inData, WarehousingTO.class);

        purchaseServiceFacade.registWarehousing(orderInfoList, orderDetailList, stockList, warehousingList);
        getStockList(inData, outData);
        getWarehousingList(inData, outData);
    }
}
