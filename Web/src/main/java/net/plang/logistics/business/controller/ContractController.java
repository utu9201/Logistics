package net.plang.logistics.business.controller;

import java.util.List;

import com.tobesoft.xplatform.data.PlatformData;
import net.plang.common.mapper.DatasetBeanMapper;
import net.plang.logistics.business.sf.BusinessServiceFacade;
import net.plang.logistics.business.to.ContractDetailTO;
import net.plang.logistics.business.to.ContractTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContractController {
    @Autowired
    private BusinessServiceFacade businessServiceFacade;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @RequestMapping("/logistics/business/getContractList.do")
    public void getContractList(@RequestAttribute("outData") PlatformData outData) throws Exception {
        List<ContractTO> contractList = businessServiceFacade.getContractList();

        datasetBeanMapper.beansToDataset(outData, contractList, ContractTO.class);
    }

    @RequestMapping("/logistics/business/getContractDetailList.do")
    public void getContractDetailList(@RequestAttribute("outData") PlatformData outData) throws Exception {
        List<ContractDetailTO> contractDetailList = businessServiceFacade.getContractDetailList();

        datasetBeanMapper.beansToDataset(outData, contractDetailList, ContractDetailTO.class);
    }

    @RequestMapping("/logistics/business/getRangedContractDetailList.do")
    public void getRangedContractDetailList(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        String fromDate = inData.getVariable("fromDate").getString();
        String toDate = inData.getVariable("toDate").getString();

        List<ContractDetailTO> contractDetailList = businessServiceFacade.getRangedContractDetailList(fromDate, toDate);

        datasetBeanMapper.beansToDataset(outData, contractDetailList, ContractDetailTO.class);
    }

    @RequestMapping("/logistics/business/registContact.do")
    public void registContact(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        List<ContractTO> contractList = datasetBeanMapper.datasetToBeans(inData, ContractTO.class);
        List<ContractDetailTO> contractDetailList = datasetBeanMapper.datasetToBeans(inData, ContractDetailTO.class);

        businessServiceFacade.registContract(contractList, contractDetailList);

//        getContractList(inData, outData);
//        getContractDetailList(inData, outData);
        datasetBeanMapper.beansToDataset(outData, contractList, ContractTO.class);
        datasetBeanMapper.beansToDataset(outData, contractDetailList, ContractDetailTO.class);
    }
}
