package net.plang.logistics.purchase.controller;

import java.util.List;

import com.tobesoft.platform.data.PlatformData;

import net.plang.common.controller.MiplatformController;
import net.plang.logistics.purchase.sf.PurchaseServiceFacade;
import net.plang.logistics.purchase.to.BomDeployTO;
import net.plang.logistics.purchase.to.BomTO;

public class BomController extends MiplatformController {

    private PurchaseServiceFacade purchaseServiceFacade;

    public void setPurchaseServiceFacade(PurchaseServiceFacade purchaseServiceFacade) {
        this.purchaseServiceFacade = purchaseServiceFacade;
    }

    public void findBomList(PlatformData inData, PlatformData outData) throws Exception {
        List<BomTO> bomList = purchaseServiceFacade.findBomList();
        datasetBeanMapper.beansToDataset(outData, bomList, BomTO.class);

    }

    public void findBomDeployList(PlatformData inData, PlatformData outData) throws Exception {
        String itemCode = inData.getVariable("itemCode").getValue().asString();
        String deployCondition = inData.getVariable("deployCondition").getValue().asString();

        List<BomDeployTO> bomDeployList = purchaseServiceFacade.findBomDeployList(itemCode, deployCondition);
        datasetBeanMapper.beansToDataset(outData, bomDeployList, BomDeployTO.class);
    }
}
