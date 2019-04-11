package net.plang.logistics.business.controller;

import java.util.List;

import com.tobesoft.xplatform.data.PlatformData;
import net.plang.common.mapper.DatasetBeanMapper;
import net.plang.logistics.business.sf.BusinessServiceFacade;
import net.plang.logistics.business.to.EstimateDetailTO;
import net.plang.logistics.business.to.EstimateTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EstimateController {
    @Autowired
    private BusinessServiceFacade businessServiceFacade;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @RequestMapping("/logistics/business/getEstimateList.do")
    public void getEstimateList(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        String empCode = inData.getVariable("empCode").getString();
        List<EstimateTO> estimateList = businessServiceFacade.getEstimateList(empCode);

        datasetBeanMapper.beansToDataset(outData, estimateList, EstimateTO.class);
    }

    @RequestMapping("/logistics/business/getEstimateDialog.do")
    public void getEstimateDialog(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        List<EstimateTO> estimateList = businessServiceFacade.getEstimateDialog();

        datasetBeanMapper.beansToDataset(outData, estimateList, EstimateTO.class);
    }

    @RequestMapping("/logistics/business/getEstimateDetailList.do")
    public void getEstimateDetailList(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        List<EstimateDetailTO> estimateDetailList = businessServiceFacade.getEstimateDetailList();

        datasetBeanMapper.beansToDataset(outData, estimateDetailList, EstimateDetailTO.class);
    }

    @RequestMapping("/logistics/business/registerEstimateDetail.do")
    public void registerEstimateDetail(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        List<EstimateTO> estimateList = datasetBeanMapper.datasetToBeans(inData, EstimateTO.class);
        List<EstimateDetailTO> estimateDetailList = datasetBeanMapper.datasetToBeans(inData, EstimateDetailTO.class);

        businessServiceFacade.registEstimateDetail(estimateList, estimateDetailList);
        getEstimateList(inData, outData);
        getEstimateDetailList(inData, outData);
    }
}
