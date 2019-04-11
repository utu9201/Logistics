package net.plang.logistics.base.controller;

import com.tobesoft.xplatform.data.PlatformData;
import net.plang.common.mapper.DatasetBeanMapper;
import net.plang.logistics.base.sf.ManagementServiceFacade;
import net.plang.logistics.base.to.WorkplaceTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WorkplaceController {
    @Autowired
    private ManagementServiceFacade managementServiceFacade;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @RequestMapping("/logistics/base/getWorkplaceList.do")
    public void getWorkplaceList(@RequestAttribute("outData") PlatformData outData) throws Exception {
        List<WorkplaceTO> workplaceList = managementServiceFacade.getWorkplaceList();
        datasetBeanMapper.beansToDataset(outData, workplaceList, WorkplaceTO.class);
    }

    @RequestMapping("/logistics/base/batchWorkplaceList.do")
    public void batchWorkplaceList(@RequestAttribute("inData") PlatformData inData) throws Exception {
        List<WorkplaceTO> batchWorkplaceList = datasetBeanMapper.datasetToBeans(inData, WorkplaceTO.class);
        managementServiceFacade.batchWorkplaceList(batchWorkplaceList);
    }

}
