package net.plang.logistics.purchase.controller;

import java.util.List;

import com.tobesoft.xplatform.data.PlatformData;
import net.plang.common.mapper.DatasetBeanMapper;
import net.plang.logistics.purchase.sf.PurchaseServiceFacade;
import net.plang.logistics.purchase.to.BomDeployTO;
import net.plang.logistics.purchase.to.BomTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BomController {
    @Autowired
    private PurchaseServiceFacade purchaseServiceFacade;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @RequestMapping("/logistics/purchase/getBomList.do")
    public void getBomList(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        List<BomTO> bomList = purchaseServiceFacade.getBomList();
        datasetBeanMapper.beansToDataset(outData, bomList, BomTO.class);

    }

    @RequestMapping("/logistics/purchase/getBomDeployList.do")
    public void getBomDeployList(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        String itemCode = inData.getVariable("itemCode").getString();
        String deployCondition = inData.getVariable("deployCondition").getString();

        List<BomDeployTO> bomDeployList = purchaseServiceFacade.getBomDeployList(itemCode, deployCondition);
        datasetBeanMapper.beansToDataset(outData, bomDeployList, BomDeployTO.class);
    }
}
