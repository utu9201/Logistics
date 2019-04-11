package net.plang.logistics.base.controller;

import com.tobesoft.xplatform.data.PlatformData;
import net.plang.common.mapper.DatasetBeanMapper;
import net.plang.logistics.base.sf.ManagementServiceFacade;
import net.plang.logistics.base.to.PositionTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PositionController {
    @Autowired
    private ManagementServiceFacade managementServiceFacade;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @RequestMapping("/logistics/base/getPositionList.do")
    public void getPositionList(@RequestAttribute("outData") PlatformData outData) throws Exception {
        List<PositionTO> positionList = managementServiceFacade.getPositionList();
        datasetBeanMapper.beansToDataset(outData, positionList, PositionTO.class);
    }
}
