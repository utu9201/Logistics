package net.plang.logistics.purchase.controller;

import java.util.HashMap;
import java.util.List;

import com.tobesoft.platform.data.PlatformData;

import net.plang.common.controller.MiplatformController;
import net.plang.logistics.purchase.sf.PurchaseServiceFacade;

import net.plang.logistics.purchase.to.OrderDetailTO;
import net.plang.logistics.purchase.to.OrderGatheringTO;
import net.plang.logistics.purchase.to.OrderInfoTO;

public class OrderController extends MiplatformController {

    private PurchaseServiceFacade purchaseServiceFacade;

    public void setPurchaseServiceFacade(PurchaseServiceFacade purchaseServiceFacade) {
        this.purchaseServiceFacade = purchaseServiceFacade;
    }

    public void findOrderInfoList(PlatformData inData, PlatformData outData) throws Exception {
        List<OrderInfoTO> orderInfoList = purchaseServiceFacade.findOrderInfoList();

        datasetBeanMapper.beansToDataset(outData, orderInfoList, OrderInfoTO.class);

    }

    public void findOrderDetailList(PlatformData inData, PlatformData outData) throws Exception {
        List<OrderDetailTO> orderDetailList = purchaseServiceFacade.findOrderDetailList();

        datasetBeanMapper.beansToDataset(outData, orderDetailList, OrderDetailTO.class);

    }

    public void findOrderGatheringList(PlatformData inData, PlatformData outData) throws Exception {
        List<OrderGatheringTO> orderGatheringList = purchaseServiceFacade.findOrderGatheringList();

        datasetBeanMapper.beansToDataset(outData, orderGatheringList, OrderGatheringTO.class);

    }

    public void registerOrder(PlatformData inData, PlatformData outData) throws Exception {

        List<OrderInfoTO> orderInfoList = datasetBeanMapper.datasetToBeans(inData, OrderInfoTO.class);

        List<OrderDetailTO> orderDetailList = datasetBeanMapper.datasetToBeans(inData, OrderDetailTO.class);

        List<OrderGatheringTO> orderGatheringList = datasetBeanMapper.datasetToBeans(inData, OrderGatheringTO.class);

        purchaseServiceFacade.registOrder(orderInfoList, orderDetailList, orderGatheringList);

//        findOrderInfoList(inData, outData);
//        findOrderDetailList(inData, outData);

    }

    public void registOrderGathering(PlatformData inData, PlatformData outData) throws Exception {

        List<OrderGatheringTO> orderGatheringList = datasetBeanMapper.datasetToBeans(inData, OrderGatheringTO.class);

        purchaseServiceFacade.registOrderGathering(orderGatheringList);

    }

    public void cancelOrder(PlatformData inData, PlatformData outData) throws Exception {
        List<OrderDetailTO> orderDetailList = datasetBeanMapper.datasetToBeans(inData, OrderDetailTO.class);
        String empCode = inData.getVariable("empCode").getValue().asString();
        HashMap<String, String> result = purchaseServiceFacade.cancelOrder(orderDetailList, empCode);

        outData.getVariableList().addStr("errorCode", result.get("errorCode"));
        outData.getVariableList().addStr("errorMsg", result.get("errorMsg"));
    }


}
