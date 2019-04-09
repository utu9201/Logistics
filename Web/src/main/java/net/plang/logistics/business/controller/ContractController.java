package net.plang.logistics.business.controller;

import java.util.List;

import com.tobesoft.platform.data.PlatformData;

import net.plang.common.controller.MiplatformController;
import net.plang.logistics.business.sf.BusinessServiceFacade;
import net.plang.logistics.business.to.ContractDetailTO;
import net.plang.logistics.business.to.ContractTO;

public class ContractController extends MiplatformController {

    private BusinessServiceFacade businessServiceFacade;

    public void setBusinessServiceFacade(BusinessServiceFacade businessServiceFacade) {
        this.businessServiceFacade = businessServiceFacade;
    }

    public void findContractList(PlatformData inData, PlatformData outData) throws Exception {

        List<ContractTO> contractList = businessServiceFacade.findContractList();

        datasetBeanMapper.beansToDataset(outData, contractList, ContractTO.class);

    }

    public void findContractDetailList(PlatformData inData, PlatformData outData) throws Exception {

        List<ContractDetailTO> contractDetailList = businessServiceFacade.findContractDetailList();

        datasetBeanMapper.beansToDataset(outData, contractDetailList, ContractDetailTO.class);

    }

    public void findRangedContractDetailList(PlatformData inData, PlatformData outData) throws Exception {

        String fromDate = inData.getVariable("fromDate").getValue().asString();
        String toDate = inData.getVariable("toDate").getValue().asString();

        List<ContractDetailTO> contractDetailList = businessServiceFacade.findRangedContractDetailList(fromDate, toDate);

        datasetBeanMapper.beansToDataset(outData, contractDetailList, ContractDetailTO.class);

    }

    public void registerContract(PlatformData inData, PlatformData outData) throws Exception {

        List<ContractTO> contractList = datasetBeanMapper.datasetToBeans(inData, ContractTO.class);

        List<ContractDetailTO> contractDetailList = datasetBeanMapper.datasetToBeans(inData, ContractDetailTO.class);

        businessServiceFacade.registContract(contractList, contractDetailList);

        findContractList(inData, outData);
        findContractDetailList(inData, outData);

    }
}
