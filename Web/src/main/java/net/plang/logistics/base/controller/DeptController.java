package net.plang.logistics.base.controller;

import java.util.List;

import com.tobesoft.platform.data.PlatformData;

import net.plang.common.controller.MiplatformController;
import net.plang.logistics.base.sf.ManagementServiceFacade;
import net.plang.logistics.base.to.DeptTO;

public class DeptController extends MiplatformController {

    private ManagementServiceFacade managementServiceFacade;

    public void setManagementServiceFacade(ManagementServiceFacade managementServiceFacade) {
        this.managementServiceFacade = managementServiceFacade;
    }

    public void findDeptList(PlatformData inData, PlatformData outData) throws Exception {

        List<DeptTO> deptList = managementServiceFacade.findDeptList();

        datasetBeanMapper.beansToDataset(outData, deptList, DeptTO.class);

    }

    public void batchDepartmentList(PlatformData inData, PlatformData outData) throws Exception {
        List<DeptTO> batchDeptList = datasetBeanMapper.datasetToBeans(inData, DeptTO.class);
        managementServiceFacade.batchDepartmentList(batchDeptList);
    }

}
