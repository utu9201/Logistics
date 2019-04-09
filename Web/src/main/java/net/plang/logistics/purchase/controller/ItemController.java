package net.plang.logistics.purchase.controller;

import java.util.List;

import com.tobesoft.platform.data.PlatformData;
import net.plang.common.controller.MiplatformController;
import net.plang.logistics.purchase.sf.PurchaseServiceFacade;
import net.plang.logistics.purchase.to.ItemTO;

public class ItemController extends MiplatformController {


    private PurchaseServiceFacade purchaseServiceFacade;


    public void setPurchaseServiceFacade(PurchaseServiceFacade purchaseServiceFacade) {
        this.purchaseServiceFacade = purchaseServiceFacade;
    }

    public void findItemList(PlatformData inData, PlatformData outData) throws Exception {
        List<ItemTO> itemList = purchaseServiceFacade.findItemList();
        datasetBeanMapper.beansToDataset(outData, itemList, ItemTO.class);

    }

    public void batchItem(PlatformData inData, PlatformData outData) throws Exception {

        List<ItemTO> itemList = datasetBeanMapper.datasetToBeans(inData, ItemTO.class);

        purchaseServiceFacade.batchItem(itemList);

        findItemList(inData, outData);


    }


}
