package net.plang.logistics.production.controller;

import java.util.HashMap;
import java.util.List;

import com.tobesoft.xplatform.data.PlatformData;

import net.plang.common.mapper.DatasetBeanMapper;
import net.plang.logistics.production.sf.ProductionServiceFacade;
import net.plang.logistics.production.to.MaterialCheckTempTO;
import net.plang.logistics.production.to.MrpGatheringTO;
import net.plang.logistics.production.to.WorkInstructionTO;
import net.plang.logistics.purchase.to.MaterialPaymentTO;
import net.plang.logistics.purchase.to.StockTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WorkInstructionController {
    @Autowired
    private ProductionServiceFacade productionServiceFacade;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @RequestMapping("/logistics/production/getWorkInstructionList.do")
    public void getWorkInstructionList(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        List<WorkInstructionTO> workInstructionList = productionServiceFacade.getWorkInstructionList();

        datasetBeanMapper.beansToDataset(outData, workInstructionList, WorkInstructionTO.class);
    }

    @RequestMapping("/logistics/production/getMaterialCheckTempList.do")
    public void getMaterialCheckTempList(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        HashMap<String, Object> paramMap = new HashMap<>();
        String mpsNo = inData.getVariable("mpsNo").getString();
        paramMap.put("mpsNo", mpsNo);

        List<MaterialCheckTempTO> materialCheckList = productionServiceFacade.getMaterialCheckTempList(paramMap);
        datasetBeanMapper.beansToDataset(outData, materialCheckList, MaterialCheckTempTO.class);
    }

    @RequestMapping("/logistics/production/registWorkInstruction.do")
    public void registWorkInstruction(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        //작업지시
        List<WorkInstructionTO> workInstruction = datasetBeanMapper.datasetToBeans(inData, WorkInstructionTO.class);
        List<MrpGatheringTO> mrpGatheringlList = datasetBeanMapper.datasetToBeans(inData, MrpGatheringTO.class);
        List<MaterialPaymentTO> materialPaymentList = datasetBeanMapper.datasetToBeans(inData, MaterialPaymentTO.class);
        List<StockTO> stockList = datasetBeanMapper.datasetToBeans(inData, StockTO.class);

        productionServiceFacade.registWorkInstruction(workInstruction, mrpGatheringlList, materialPaymentList, stockList);
        getWorkInstructionList(inData, outData);
    }
}
