package net.plang.logistics.production.controller;

import java.util.List;

import com.tobesoft.xplatform.data.PlatformData;
import net.plang.common.mapper.DatasetBeanMapper;
import net.plang.logistics.business.to.ContractDetailTO;

import net.plang.logistics.production.sf.ProductionServiceFacade;

import net.plang.logistics.production.to.MpsTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MpsController {
    @Autowired
    private ProductionServiceFacade productionServiceFacade;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @RequestMapping("/logistics/production/getMpsList.do")
    public void getMpsList(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        List<MpsTO> mpsList = productionServiceFacade.getMpsList();

        datasetBeanMapper.beansToDataset(outData, mpsList, MpsTO.class);
    }

    @RequestMapping("/logistics/production/registerMps.do")
    public void registerMps(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        List<MpsTO> mpsList = datasetBeanMapper.datasetToBeans(inData, MpsTO.class);

        List<ContractDetailTO> contractDetailList = datasetBeanMapper.datasetToBeans(inData, ContractDetailTO.class);
        productionServiceFacade.registMps(mpsList, contractDetailList);

        getMpsList(inData, outData);
    }
}
