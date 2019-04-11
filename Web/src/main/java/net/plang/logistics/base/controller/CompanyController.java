package net.plang.logistics.base.controller;

import com.tobesoft.xplatform.data.PlatformData;
import net.plang.common.mapper.DatasetBeanMapper;
import net.plang.logistics.base.sf.ManagementServiceFacade;
import net.plang.logistics.base.to.CompanyTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CompanyController {
    @Autowired
    private ManagementServiceFacade managementServiceFacade;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @RequestMapping("/logistics/base/getCompanyList.do")
    public void getCompanyList(@RequestAttribute("outData") PlatformData outData) throws Exception {
        List<CompanyTO> companyList = managementServiceFacade.getCompanyList();

        datasetBeanMapper.beansToDataset(outData, companyList, CompanyTO.class);

    }

    @RequestMapping("/logistics/base/batchCompanayList.do")
    public void batchCompanyList(@RequestAttribute("inData") PlatformData inData) throws Exception {
        List<CompanyTO> batchCompanyList = datasetBeanMapper.datasetToBeans(inData, CompanyTO.class);

        managementServiceFacade.batchCompanyList(batchCompanyList);
    }

}
