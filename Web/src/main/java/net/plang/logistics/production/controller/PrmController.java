package net.plang.logistics.production.controller;

import java.util.List;

import com.tobesoft.platform.data.PlatformData;

import net.plang.common.controller.MiplatformController;
import net.plang.logistics.production.sf.ProductionServiceFacade;

import net.plang.logistics.production.to.PrmTO;
import net.plang.logistics.production.to.WorkInstructionTO;
import net.plang.logistics.purchase.to.StockTO;
import net.plang.logistics.purchase.to.WarehousingTO;

public class PrmController extends MiplatformController {

    private ProductionServiceFacade productionServiceFacade;

    public void setProductionServiceFacade(ProductionServiceFacade productionServiceFacade) {
        this.productionServiceFacade = productionServiceFacade;
    }

    public void findPrmList(PlatformData inData, PlatformData outData) throws Exception {

        List<PrmTO> mrpList = productionServiceFacade.findPrmList();

        datasetBeanMapper.beansToDataset(outData, mrpList, PrmTO.class);
    }

    public void registPrm(PlatformData inData, PlatformData outData) throws Exception {
//창고업무
        List<WorkInstructionTO> workInstructionList = datasetBeanMapper.datasetToBeans(inData, WorkInstructionTO.class);

        List<PrmTO> prmList = datasetBeanMapper.datasetToBeans(inData, PrmTO.class);

        List<StockTO> stockList = datasetBeanMapper.datasetToBeans(inData, StockTO.class);

        List<WarehousingTO> warehousingList = datasetBeanMapper.datasetToBeans(inData, WarehousingTO.class);
        productionServiceFacade.registPrm(workInstructionList, prmList, stockList, warehousingList);

        findPrmList(inData, outData);
    }
}
