package net.plang.logistics.production.controller;

import java.util.List;

import com.tobesoft.platform.data.PlatformData;

import net.plang.common.controller.MiplatformController;
import net.plang.logistics.business.to.ContractDetailTO;

import net.plang.logistics.production.sf.ProductionServiceFacade;

import net.plang.logistics.production.to.MpsTO;

public class MpsController extends MiplatformController {

    private ProductionServiceFacade productionServiceFacade;

    public void setProductionServiceFacade(ProductionServiceFacade productionServiceFacade) {
        this.productionServiceFacade = productionServiceFacade;
    }

    public void findMpsList(PlatformData inData, PlatformData outData) throws Exception {

        List<MpsTO> mpsList = productionServiceFacade.findMpsList();

        datasetBeanMapper.beansToDataset(outData, mpsList, MpsTO.class);
    }

    public void registerMps(PlatformData inData, PlatformData outData) throws Exception {

        List<MpsTO> mpsList = datasetBeanMapper.datasetToBeans(inData, MpsTO.class);

        List<ContractDetailTO> contractDetailList = datasetBeanMapper.datasetToBeans(inData, ContractDetailTO.class);
        productionServiceFacade.registMps(mpsList, contractDetailList);

        findMpsList(inData, outData);
    }
}
