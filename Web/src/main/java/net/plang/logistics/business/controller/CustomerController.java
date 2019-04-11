package net.plang.logistics.business.controller;

import java.util.List;

import com.tobesoft.xplatform.data.PlatformData;
import net.plang.common.mapper.DatasetBeanMapper;
import net.plang.logistics.business.sf.BusinessServiceFacade;
import net.plang.logistics.business.to.CustomerTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
    @Autowired
    private BusinessServiceFacade businessServiceFacade;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @RequestMapping("/logistics/business/getCustomerList.do")
    public void getCustomerList(@RequestAttribute("outData") PlatformData outData) throws Exception {
        List<CustomerTO> customerList = businessServiceFacade.getCustomerList();

        datasetBeanMapper.beansToDataset(outData, customerList, CustomerTO.class);

    }

    @RequestMapping("/logistics/business/batchCustomerList.do")
    public void batchCustomerList(@RequestAttribute("inData") PlatformData inData) throws Exception {
        List<CustomerTO> batchCustomerList = datasetBeanMapper.datasetToBeans(inData, CustomerTO.class);

        businessServiceFacade.batchCustomerList(batchCustomerList);
    }
}
