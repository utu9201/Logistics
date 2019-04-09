package net.plang.logistics.business.controller;

import java.util.List;

import com.tobesoft.platform.data.PlatformData;
import net.plang.common.controller.MiplatformController;
import net.plang.logistics.business.sf.BusinessServiceFacade;
import net.plang.logistics.business.to.CompleteDeliveryResultTO;
import net.plang.logistics.business.to.DeliveryResultTO;

public class DeliveryResultController extends MiplatformController {

    private BusinessServiceFacade businessServiceFacade;

    public void setBusinessServiceFacade(BusinessServiceFacade businessServiceFacade) {
        this.businessServiceFacade = businessServiceFacade;
    }

    public void findDeliveryResultList(PlatformData inData, PlatformData outData) throws Exception {

        List<DeliveryResultTO> deliveryResultList = businessServiceFacade.findDeliveryResultList();

        datasetBeanMapper.beansToDataset(outData, deliveryResultList, DeliveryResultTO.class);

    }

    public void registDeliveryResult(PlatformData inData, PlatformData outData) throws Exception {
//procedure를 쓸거기 때문에 밑에 3개는 이제 필요가 없음
//		List<ContractTO> contractList = datasetBeanMapper.datasetToBeans(inData, ContractTO.class);
//
//		List<ContractDetailTO> contractDetailList = datasetBeanMapper.datasetToBeans(inData, ContractDetailTO.class);
//
//		List<StockTO> stockList = datasetBeanMapper.datasetToBeans(inData, StockTO.class);


        List<DeliveryResultTO> deliveryResultList = datasetBeanMapper.datasetToBeans(inData, DeliveryResultTO.class);


        businessServiceFacade.registDeliveryResult(deliveryResultList);

        findDeliveryResultList(inData, outData);
    }

    public void findCompleteDeliveryResultList(PlatformData inData, PlatformData outData) throws Exception {

        List<CompleteDeliveryResultTO> CompleteDeliveryResultList = businessServiceFacade.findCompleteDeliveryResultList();

        datasetBeanMapper.beansToDataset(outData, CompleteDeliveryResultList, CompleteDeliveryResultTO.class);

    }
}
