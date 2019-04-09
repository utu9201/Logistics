package net.plang.logistics.base.controller;

import java.util.List;

import com.tobesoft.platform.data.PlatformData;

import net.plang.common.controller.MiplatformController;
import net.plang.logistics.base.sf.ManagementServiceFacade;
import net.plang.logistics.base.to.PositionTO;

public class PositionController extends MiplatformController {
    private ManagementServiceFacade managementServiceFacade;

    public void setManagementServiceFacade(ManagementServiceFacade managementServiceFacade) {
        this.managementServiceFacade = managementServiceFacade;
    }

    public void findPositionList(PlatformData inData, PlatformData outData) throws Exception {

        List<PositionTO> positionList = managementServiceFacade.findPositionList();
        datasetBeanMapper.beansToDataset(outData, positionList, PositionTO.class);

    }
}
