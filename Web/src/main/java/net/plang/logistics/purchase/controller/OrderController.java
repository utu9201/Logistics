package net.plang.logistics.purchase.controller;

import java.util.HashMap;
import java.util.List;

import com.tobesoft.xplatform.data.PlatformData;
import net.plang.common.mapper.DatasetBeanMapper;
import net.plang.logistics.purchase.sf.PurchaseServiceFacade;

import net.plang.logistics.purchase.to.OrderDetailTO;
import net.plang.logistics.purchase.to.OrderGatheringTO;
import net.plang.logistics.purchase.to.OrderInfoTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

public class OrderController {
    @Autowired
    private PurchaseServiceFacade purchaseServiceFacade;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @RequestMapping("/logistics/purchase/getOrderInfoList.do")
    public void getOrderInfoList(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        List<OrderInfoTO> orderInfoList = purchaseServiceFacade.getOrderInfoList();

        datasetBeanMapper.beansToDataset(outData, orderInfoList, OrderInfoTO.class);

    }

    @RequestMapping("/logistics/purchase/getOrderDetailList.do")
    public void getOrderDetailList(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        List<OrderDetailTO> orderDetailList = purchaseServiceFacade.getOrderDetailList();

        datasetBeanMapper.beansToDataset(outData, orderDetailList, OrderDetailTO.class);

    }

    @RequestMapping("/logistics/purchase/getOrderGatheringList.do")
    public void getOrderGatheringList(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        List<OrderGatheringTO> orderGatheringList = purchaseServiceFacade.getOrderGatheringList();

        datasetBeanMapper.beansToDataset(outData, orderGatheringList, OrderGatheringTO.class);

    }

    @RequestMapping("/logistics/purchase/registerOrder.do")
    public void registerOrder(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {

        List<OrderInfoTO> orderInfoList = datasetBeanMapper.datasetToBeans(inData, OrderInfoTO.class);

        List<OrderDetailTO> orderDetailList = datasetBeanMapper.datasetToBeans(inData, OrderDetailTO.class);

        List<OrderGatheringTO> orderGatheringList = datasetBeanMapper.datasetToBeans(inData, OrderGatheringTO.class);

        purchaseServiceFacade.registOrder(orderInfoList, orderDetailList, orderGatheringList);

//        getOrderInfoList(inData, outData);
//        getOrderDetailList(inData, outData);

    }

    @RequestMapping("/logistics/purchase/registOrderGathering.do")
    public void registOrderGathering(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {

        List<OrderGatheringTO> orderGatheringList = datasetBeanMapper.datasetToBeans(inData, OrderGatheringTO.class);

        purchaseServiceFacade.registOrderGathering(orderGatheringList);

    }

    @RequestMapping("/logistics/purchase/cancelOrder.do")
    public void cancelOrder(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        List<OrderDetailTO> orderDetailList = datasetBeanMapper.datasetToBeans(inData, OrderDetailTO.class);
        String empCode = inData.getVariable("empCode").getString();
        HashMap<String, String> result = purchaseServiceFacade.cancelOrder(orderDetailList, empCode);

        outData.getVariableList().add("errorCode", result.get("errorCode"));
        outData.getVariableList().add("errorMsg", result.get("errorMsg"));
    }


}
