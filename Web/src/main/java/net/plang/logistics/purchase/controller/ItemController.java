package net.plang.logistics.purchase.controller;

import java.util.List;

import com.tobesoft.xplatform.data.PlatformData;
import net.plang.common.mapper.DatasetBeanMapper;
import net.plang.logistics.purchase.sf.PurchaseServiceFacade;
import net.plang.logistics.purchase.to.ItemTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

public class ItemController {
    @Autowired
    private PurchaseServiceFacade purchaseServiceFacade;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @RequestMapping("/logistics/purchase/getItemList.do")
    public void getItemList(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        List<ItemTO> itemList = purchaseServiceFacade.getItemList();

        datasetBeanMapper.beansToDataset(outData, itemList, ItemTO.class);
    }

    @RequestMapping("/logistics/purchase/batchItem.do")
    public void batchItem(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        List<ItemTO> itemList = datasetBeanMapper.datasetToBeans(inData, ItemTO.class);

        purchaseServiceFacade.batchItem(itemList);
        getItemList(inData, outData);
    }
}
