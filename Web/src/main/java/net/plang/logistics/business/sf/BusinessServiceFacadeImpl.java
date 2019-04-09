package net.plang.logistics.business.sf;

import java.util.List;

import net.plang.logistics.business.applicationService.BusinessApplicationService;
import net.plang.logistics.business.to.CompleteDeliveryResultTO;
import net.plang.logistics.business.to.ContractDetailTO;
import net.plang.logistics.business.to.ContractTO;
import net.plang.logistics.business.to.CustomerTO;
import net.plang.logistics.business.to.DeliveryResultTO;
import net.plang.logistics.business.to.EstimateDetailTO;
import net.plang.logistics.business.to.EstimateTO;

public class BusinessServiceFacadeImpl implements BusinessServiceFacade {

    private BusinessApplicationService businessApplicationService;

    public void setBusinessApplicationService(BusinessApplicationService businessApplicationService) {
        this.businessApplicationService = businessApplicationService;
    }

    @Override
    public List<EstimateTO> findEstimateList(String empCode) {
        return businessApplicationService.findEstimateList(empCode);
    }

    @Override
    public List<EstimateDetailTO> findEstimateDetailList() {
        return businessApplicationService.findEstimateDetailList();
    }

    @Override
    public List<ContractTO> findContractList() {
        return businessApplicationService.findContractList();
    }

    @Override
    public List<ContractDetailTO> findContractDetailList() {
        return businessApplicationService.findContractDetailList();
    }

    @Override
    public List<CustomerTO> findCustomerList() {
        return businessApplicationService.findCustomerList();
    }

    @Override
    public void registEstimateDetail(List<EstimateTO> estimateList, List<EstimateDetailTO> estimateDetailList) {
        businessApplicationService.batchEstimate(estimateList, estimateDetailList);

    }

    @Override
    public List<EstimateTO> findEstimateDialog() {
        return businessApplicationService.findEstimateDialog();
    }

    @Override
    public void registContract(List<ContractTO> contractList, List<ContractDetailTO> contractDetailList) {
        businessApplicationService.batchContract(contractList, contractDetailList);
    }

    @Override
    public List<DeliveryResultTO> findDeliveryResultList() {
        return businessApplicationService.findDeliveryResultList();
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
    public List<ContractDetailTO> findRangedContractDetailList(String fromDate, String toDate) {
        return businessApplicationService.findRangedContractDetailList(fromDate, toDate);
    }


    @Override
    public List<CompleteDeliveryResultTO> findCompleteDeliveryResultList() {
        return businessApplicationService.findCompleteDeliveryResultList();
    }
}
