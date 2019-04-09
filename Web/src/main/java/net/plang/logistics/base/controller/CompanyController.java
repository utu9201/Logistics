package net.plang.logistics.base.controller;

import java.util.List;

import com.tobesoft.platform.data.PlatformData;

import net.plang.common.controller.MiplatformController;
import net.plang.logistics.base.sf.ManagementServiceFacade;
import net.plang.logistics.base.to.CompanyTO;

public class CompanyController extends MiplatformController {

    private ManagementServiceFacade managementServiceFacade;

    public void setManagementServiceFacade(ManagementServiceFacade managementServiceFacade) {
        this.managementServiceFacade = managementServiceFacade;
    }

    public void findCompanyList(PlatformData inData, PlatformData outData) throws Exception {

        List<CompanyTO> companyList = managementServiceFacade.findCompanyList();

        datasetBeanMapper.beansToDataset(outData, companyList, CompanyTO.class);

    }

    public void batchCompanyList(PlatformData inData, PlatformData outData) throws Exception {

        List<CompanyTO> batchCompanyList = datasetBeanMapper.datasetToBeans(inData, CompanyTO.class);

        managementServiceFacade.batchCompanyList(batchCompanyList);
    }

}
