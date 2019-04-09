package net.plang.logistics.production.controller;

import java.util.HashMap;
import java.util.List;

import com.tobesoft.platform.data.PlatformData;

import net.plang.common.controller.MiplatformController;

import net.plang.logistics.production.sf.ProductionServiceFacade;
import net.plang.logistics.production.to.MaterialCheckTempTO;
import net.plang.logistics.production.to.MrpGatheringTO;
import net.plang.logistics.production.to.WorkInstructionTO;
import net.plang.logistics.purchase.to.MaterialPaymentTO;
import net.plang.logistics.purchase.to.StockTO;

public class WorkInstructionController extends MiplatformController {
    private ProductionServiceFacade productionServiceFacade;

    public void setProductionServiceFacade(ProductionServiceFacade productionServiceFacade) {
        this.productionServiceFacade = productionServiceFacade;
    }

    public void findWorkInstructionList(PlatformData inData, PlatformData outData) throws Exception {

        List<WorkInstructionTO> workInstructionList = productionServiceFacade.findWorkInstructionList();

        datasetBeanMapper.beansToDataset(outData, workInstructionList, WorkInstructionTO.class);
    }

    public void findMaterialCheckTempList(PlatformData inData, PlatformData outData) throws Exception {

        HashMap<String, Object> paramMap = new HashMap<>();
        String mpsNo = inData.getVariable("mpsNo").getValue().asString();
        paramMap.put("mpsNo", mpsNo);

        List<MaterialCheckTempTO> materialCheckList = productionServiceFacade.findMaterialCheckTempList(paramMap);

        datasetBeanMapper.beansToDataset(outData, materialCheckList, MaterialCheckTempTO.class);
    }

    public void registWorkInstruction(PlatformData inData, PlatformData outData) throws Exception {
//작업지시
        List<WorkInstructionTO> workInstruction = datasetBeanMapper.datasetToBeans(inData, WorkInstructionTO.class);

        List<MrpGatheringTO> mrpGatheringlList = datasetBeanMapper.datasetToBeans(inData, MrpGatheringTO.class);

        List<MaterialPaymentTO> materialPaymentList = datasetBeanMapper.datasetToBeans(inData, MaterialPaymentTO.class);

        List<StockTO> stockList = datasetBeanMapper.datasetToBeans(inData, StockTO.class);

        productionServiceFacade.registWorkInstruction(workInstruction, mrpGatheringlList, materialPaymentList, stockList);

        findWorkInstructionList(inData, outData);
    }
}
