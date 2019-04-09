package net.plang.logistics.business.sf;

import java.util.List;

import net.plang.logistics.business.to.CompleteDeliveryResultTO;
import net.plang.logistics.business.to.ContractDetailTO;
import net.plang.logistics.business.to.ContractTO;
import net.plang.logistics.business.to.CustomerTO;
import net.plang.logistics.business.to.DeliveryResultTO;
import net.plang.logistics.business.to.EstimateDetailTO;
import net.plang.logistics.business.to.EstimateTO;

public interface BusinessServiceFacade {

    List<EstimateTO> findEstimateList(String empCode);

    List<EstimateTO> findEstimateDialog();

    void registEstimateDetail(List<EstimateTO> estimateList, List<EstimateDetailTO> estimateDetailList);

    List<EstimateDetailTO> findEstimateDetailList();

    List<ContractTO> findContractList();

    List<ContractDetailTO> findContractDetailList();

    void registContract(List<ContractTO> contractList, List<ContractDetailTO> contractDetailList);

    List<CustomerTO> findCustomerList();

    List<DeliveryResultTO> findDeliveryResultList();

    List<CompleteDeliveryResultTO> findCompleteDeliveryResultList();

    void registDeliveryResult(List<DeliveryResultTO> deliveryResultList);

    void batchCustomerList(List<CustomerTO> batchCustomerList);

    List<ContractDetailTO> findRangedContractDetailList(String fromDate, String toDate);


}
