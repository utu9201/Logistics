package net.plang.logistics.business.controller;

import java.util.List;

import com.tobesoft.platform.data.PlatformData;

import net.plang.common.controller.MiplatformController;
import net.plang.logistics.business.sf.BusinessServiceFacade;
import net.plang.logistics.business.to.EstimateDetailTO;
import net.plang.logistics.business.to.EstimateTO;

public class EstimateController extends MiplatformController {

    private BusinessServiceFacade businessServiceFacade;

    public void setBusinessServiceFacade(BusinessServiceFacade businessServiceFacade) {
        this.businessServiceFacade = businessServiceFacade;
    }

    public void findEstimateList(PlatformData inData, PlatformData outData) throws Exception {
        String empCode = inData.getVariable("empCode").getValue().asString();
        List<EstimateTO> estimateList = businessServiceFacade.findEstimateList(empCode);
        datasetBeanMapper.beansToDataset(outData, estimateList, EstimateTO.class);

    }

    public void findEstimateDialog(PlatformData inData, PlatformData outData) throws Exception {
        List<EstimateTO> estimateList = businessServiceFacade.findEstimateDialog();
        datasetBeanMapper.beansToDataset(outData, estimateList, EstimateTO.class);

    }

    public void findEstimateDetailList(PlatformData inData, PlatformData outData) throws Exception {

        List<EstimateDetailTO> estimateDetailList = businessServiceFacade.findEstimateDetailList();

        datasetBeanMapper.beansToDataset(outData, estimateDetailList, EstimateDetailTO.class);

    }

    public void registerEstimateDetail(PlatformData inData, PlatformData outData) throws Exception {
        List<EstimateTO> estimateList = datasetBeanMapper.datasetToBeans(inData, EstimateTO.class);

        List<EstimateDetailTO> estimateDetailList = datasetBeanMapper.datasetToBeans(inData, EstimateDetailTO.class);

        businessServiceFacade.registEstimateDetail(estimateList, estimateDetailList);

        findEstimateList(inData, outData);
        findEstimateDetailList(inData, outData);

    }

}
