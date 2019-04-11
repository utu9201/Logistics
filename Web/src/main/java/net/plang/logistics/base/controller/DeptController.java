package net.plang.logistics.base.controller;

import com.tobesoft.xplatform.data.PlatformData;
import net.plang.common.mapper.DatasetBeanMapper;
import net.plang.logistics.base.sf.ManagementServiceFacade;
import net.plang.logistics.base.to.DeptTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DeptController {
    @Autowired
    private ManagementServiceFacade managementServiceFacade;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @RequestMapping("/logistics/base/getDeptList.do")
    public void getDeptList(@RequestAttribute("outData") PlatformData outData) throws Exception {
        List<DeptTO> deptList = managementServiceFacade.getDeptList();
        datasetBeanMapper.beansToDataset(outData, deptList, DeptTO.class);
    }

    @RequestMapping("/logistics/base/batchDepartmentList.do")
    public void batchDepartmentList(@RequestAttribute("inData") PlatformData inData) throws Exception {
        List<DeptTO> batchDeptList = datasetBeanMapper.datasetToBeans(inData, DeptTO.class);
        managementServiceFacade.batchDepartmentList(batchDeptList);
    }

}
