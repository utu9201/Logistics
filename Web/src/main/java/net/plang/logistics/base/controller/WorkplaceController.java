package net.plang.logistics.base.controller;

import java.util.List;

import com.tobesoft.platform.data.PlatformData;

import net.plang.common.controller.MiplatformController;
import net.plang.logistics.base.sf.ManagementServiceFacade;

import net.plang.logistics.base.to.WorkplaceTO;

public class WorkplaceController extends MiplatformController {

    private ManagementServiceFacade managementServiceFacade;

    public void setManagementServiceFacade(ManagementServiceFacade managementServiceFacade) {
        this.managementServiceFacade = managementServiceFacade;
    }

    public void findWorkplaceList(PlatformData inData, PlatformData outData) throws Exception {

        List<WorkplaceTO> workplaceList = managementServiceFacade.findWorkplaceList();

        datasetBeanMapper.beansToDataset(outData, workplaceList, WorkplaceTO.class);

    }

    public void batchWorkplaceList(PlatformData inData, PlatformData outData) throws Exception {
        List<WorkplaceTO> batchWorkplaceList = datasetBeanMapper.datasetToBeans(inData, WorkplaceTO.class);

        managementServiceFacade.batchWorkplaceList(batchWorkplaceList);

    }

}
