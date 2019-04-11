package net.plang.logistics.business.sf;

import java.util.List;

import net.plang.common.mapper.DatasetBeanMapper;
import net.plang.logistics.business.applicationService.BusinessApplicationService;
import net.plang.logistics.business.to.CompleteDeliveryResultTO;
import net.plang.logistics.business.to.ContractDetailTO;
import net.plang.logistics.business.to.ContractTO;
import net.plang.logistics.business.to.CustomerTO;
import net.plang.logistics.business.to.DeliveryResultTO;
import net.plang.logistics.business.to.EstimateDetailTO;
import net.plang.logistics.business.to.EstimateTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceFacadeImpl implements BusinessServiceFacade {
    @Autowired
    private BusinessApplicationService businessApplicationService;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @Override
    public List<EstimateTO> getEstimateList(String empCode) {
        return businessApplicationService.getEstimateList(empCode);
    }

    @Override
    public List<EstimateDetailTO> getEstimateDetailList() {
        return businessApplicationService.getEstimateDetailList();
    }

    @Override
    public List<ContractTO> getContractList() {
        return businessApplicationService.getContractList();
    }

    @Override
    public List<ContractDetailTO> getContractDetailList() {
        return businessApplicationService.getContractDetailList();
    }

    @Override
    public List<CustomerTO> getCustomerList() {
        return businessApplicationService.getCustomerList();
    }

    @Override
    public void registEstimateDetail(List<EstimateTO> estimateList, List<EstimateDetailTO> estimateDetailList) {
        businessApplicationService.batchEstimate(estimateList, estimateDetailList);
    }

    @Override
    public List<EstimateTO> getEstimateDialog() {
        return businessApplicationService.getEstimateDialog();
    }

    @Override
    public void registContract(List<ContractTO> contractList, List<ContractDetailTO> contractDetailList) {
        businessApplicationService.batchContract(contractList, contractDetailList);
    }

    @Override
    public List<DeliveryResultTO> getDeliveryResultList() {
        return businessApplicationService.getDeliveryResultList();
    }

    @Override
    public void registDeliveryResult(List<DeliveryResultTO> deliveryResultList) {
        businessApplicationService.registDeliveryResult(deliveryResultList);
    }

    @Override
    public void batchCustomerList(List<CustomerTO> batchCustomerList) {
        businessApplicationService.batchCustomerList(batchCustomerList);
    }

    @Override
    public List<ContractDetailTO> getRangedContractDetailList(String fromDate, String toDate) {
        return businessApplicationService.getRangedContractDetailList(fromDate, toDate);
    }

    @Override
    public List<CompleteDeliveryResultTO> getCompleteDeliveryResultList() {
        return businessApplicationService.getCompleteDeliveryResultList();
    }
}
