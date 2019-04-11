package net.plang.logistics.business.controller;

import java.util.List;

import com.tobesoft.xplatform.data.PlatformData;
import net.plang.common.mapper.DatasetBeanMapper;
import net.plang.logistics.business.sf.BusinessServiceFacade;
import net.plang.logistics.business.to.CompleteDeliveryResultTO;
import net.plang.logistics.business.to.DeliveryResultTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeliveryResultController {
    @Autowired
    private BusinessServiceFacade businessServiceFacade;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @RequestMapping("/logistics/business/getDeliveryResultList.do")
    public void getDeliveryResultList(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {

        List<DeliveryResultTO> deliveryResultList = businessServiceFacade.getDeliveryResultList();

        datasetBeanMapper.beansToDataset(outData, deliveryResultList, DeliveryResultTO.class);

    }

    @RequestMapping("/logistics/business/registDeliveryResult.do")
    public void registDeliveryResult(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
//procedure를 쓸거기 때문에 밑에 3개는 이제 필요가 없음
//		List<ContractTO> contractList = datasetBeanMapper.datasetToBeans(inData, ContractTO.class);
//		List<ContractDetailTO> contractDetailList = datasetBeanMapper.datasetToBeans(inData, ContractDetailTO.class);
//		List<StockTO> stockList = datasetBeanMapper.datasetToBeans(inData, StockTO.class);

        List<DeliveryResultTO> deliveryResultList = datasetBeanMapper.datasetToBeans(inData, DeliveryResultTO.class);

        businessServiceFacade.registDeliveryResult(deliveryResultList);
        getDeliveryResultList(inData, outData);
    }

    @RequestMapping("/logistics/business/getCompleteDeliveryResultList.do")
    public void getCompleteDeliveryResultList(@RequestAttribute("inData") PlatformData inData, @RequestAttribute("outData") PlatformData outData) throws Exception {
        List<CompleteDeliveryResultTO> CompleteDeliveryResultList = businessServiceFacade.getCompleteDeliveryResultList();

        datasetBeanMapper.beansToDataset(outData, CompleteDeliveryResultList, CompleteDeliveryResultTO.class);
    }
}
