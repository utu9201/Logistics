package net.plang.logistics.business.applicationService;

import java.util.List;

import net.plang.logistics.business.to.CompleteDeliveryResultTO;
import net.plang.logistics.business.to.ContractDetailTO;
import net.plang.logistics.business.to.ContractTO;
import net.plang.logistics.business.to.CustomerTO;
import net.plang.logistics.business.to.DeliveryResultTO;
import net.plang.logistics.business.to.EstimateDetailTO;
import net.plang.logistics.business.to.EstimateTO;

public interface BusinessApplicationService {

    List<EstimateTO> getEstimateList(String empCode);

    List<EstimateTO> getEstimateDialog();

    void batchEstimate(List<EstimateTO> estimateList, List<EstimateDetailTO> estimateDetailList);

    List<EstimateDetailTO> getEstimateDetailList();

    List<ContractTO> getContractList();

    List<ContractDetailTO> getContractDetailList();

    void batchContract(List<ContractTO> contractList, List<ContractDetailTO> contractDetailList);

    List<CustomerTO> getCustomerList();

    List<DeliveryResultTO> getDeliveryResultList();

    List<CompleteDeliveryResultTO> getCompleteDeliveryResultList();

    void registDeliveryResult(List<DeliveryResultTO> deliveryResultList);

    void batchCustomerList(List<CustomerTO> batchCustomerList);

    List<ContractDetailTO> getRangedContractDetailList(String fromDate, String toDate);

}
