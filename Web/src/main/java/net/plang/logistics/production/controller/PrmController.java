package net.plang.logistics.production.controller;

import java.util.List;

import com.tobesoft.xplatform.data.PlatformData;
import net.plang.common.mapper.DatasetBeanMapper;
import net.plang.logistics.production.sf.ProductionServiceFacade;

import net.plang.logistics.production.to.PrmTO;
import net.plang.logistics.production.to.WorkInstructionTO;
import net.plang.logistics.purchase.to.StockTO;
import net.plang.logistics.purchase.to.WarehousingTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrmController {
    @Autowired
    private ProductionServiceFacade productionServiceFacade;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @RequestMapping("/logistics/production/getPrmList.do")
    public void getPrmList(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        List<PrmTO> mrpList = productionServiceFacade.getPrmList();

        datasetBeanMapper.beansToDataset(outData, mrpList, PrmTO.class);
    }

    @RequestMapping("/logistics/production/registPrm.do")
    public void registPrm(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        //창고업무
        List<WorkInstructionTO> workInstructionList = datasetBeanMapper.datasetToBeans(inData, WorkInstructionTO.class);
        List<PrmTO> prmList = datasetBeanMapper.datasetToBeans(inData, PrmTO.class);
        List<StockTO> stockList = datasetBeanMapper.datasetToBeans(inData, StockTO.class);
        List<WarehousingTO> warehousingList = datasetBeanMapper.datasetToBeans(inData, WarehousingTO.class);

        productionServiceFacade.registPrm(workInstructionList, prmList, stockList, warehousingList);
        getPrmList(inData, outData);
    }
}
