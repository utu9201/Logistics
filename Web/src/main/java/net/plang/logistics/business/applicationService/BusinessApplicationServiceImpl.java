package net.plang.logistics.business.applicationService;

import net.plang.logistics.business.dao.*;
import net.plang.logistics.business.to.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BusinessApplicationServiceImpl implements BusinessApplicationService {
    private EstimateDAO estimateDAO;
    private EstimateDetailDAO estimateDetailDAO;
    private ContractDAO contractDAO;
    private ContractDetailDAO contractDetailDAO;
    private CustomerDAO customerDAO;
    private DeliveryResultDAO deliveryResultDAO;

//    @Autowired
//    private PurchaseApplicationService purchaseApplicationService;

    @Override
    public List<EstimateTO> getEstimateList(String empCode) {
        return estimateDAO.selectEstimateList(empCode);
    }

    @Override
    public List<EstimateDetailTO> getEstimateDetailList() {
        return estimateDetailDAO.selectEstimateDetailList();
    }

    @Override
    public List<ContractTO> getContractList() {
        return contractDAO.selectContractList();
    }

    @Override
    public List<ContractDetailTO> getContractDetailList() {
        return contractDetailDAO.selectContractDetailList();
    }

    @Override
    public List<CustomerTO> getCustomerList() {
        return customerDAO.selectCustomerList();
    }

    @Override
    public void batchEstimate(List<EstimateTO> estimateList, List<EstimateDetailTO> estimateDetailList) {
        for (EstimateTO estimateTO : estimateList) {
            String fakeEstimateNo = null;
            String estimateNo = null;
            if (estimateTO.getStatus() == "insert" || estimateTO.getStatus().equals("insert")) {
                estimateNo = estimateDAO.selectEstimateNo(estimateTO.getPersonCodeInCharge());
                fakeEstimateNo = estimateTO.getEstimateNo();
                estimateTO.setEstimateNo(estimateNo);
            }
            switch (estimateTO.getStatus()) {
                case "insert":
                    estimateDAO.insertEstimate(estimateTO);
                    for (EstimateDetailTO estimateDetailTO : estimateDetailList) {
                        if (estimateDetailTO.getEstimateNo() == fakeEstimateNo ||
                                estimateDetailTO.getEstimateNo().equals(fakeEstimateNo)) {
                            estimateDetailTO.setEstimateNo(estimateNo);
                            String fakeEstimateDetailCodeNo = estimateDetailTO.getEstimateDetailNo();

                            if (fakeEstimateDetailCodeNo.length() < 2) {
                                fakeEstimateDetailCodeNo = "0" + fakeEstimateDetailCodeNo;
                            }

                            estimateDetailTO.setEstimateDetailNo(estimateNo + "-" + fakeEstimateDetailCodeNo);
                            estimateDetailDAO.insertEstimateDetail(estimateDetailTO);
                            estimateDetailTO.setStatus("normal");

                        }
                    }
                    break;
                case "update":
                    estimateDAO.updateEstimate(estimateTO);
                    break;
                case "delete":
                    estimateDAO.deleteEstimate(estimateTO);
                    break;

            }

        }

        if (estimateDetailList != null) {
            for (EstimateDetailTO estimateDetailTO : estimateDetailList) {

                switch (estimateDetailTO.getStatus()) {

                    case "insert":
                        estimateDetailDAO.insertEstimateDetail(estimateDetailTO);
                        break;
                    case "update":
                        estimateDetailDAO.updateEstimateDetail(estimateDetailTO);
                        break;
                    case "delete":
                        estimateDetailDAO.deleteEstimateDetail(estimateDetailTO);
                        break;

                }

            }

        }

    }

    @Override
    public List<EstimateTO> getEstimateDialog() {
        return estimateDAO.selectEstimateDialog();
    }

    @Override
    public void batchContract(List<ContractTO> contractList, List<ContractDetailTO> contractDetailList) {

        List<EstimateTO> estimateList = null;

        if (contractList != null) {

            //수주가 완료되면 테이블 estimate에 ContractStatus를 y로 바꿔주기 위한 list
            estimateList = new ArrayList<>();

            for (ContractTO contractTO : contractList) {

                String contractNo = contractDAO.selectContractNo(contractTO.getPersonCodeInCharge());
                String fakeContractNo = contractTO.getContractNo();
                contractTO.setContractNo(contractNo);

                switch (contractTO.getStatus()) {

                    case "insert":
                        contractDAO.insertContract(contractTO);
                        // EstimateTO estimateTO = new EstimateTO();

                        for (ContractDetailTO contractDetailTO : contractDetailList) {
                            if (contractDetailTO.getContractNo() == fakeContractNo ||
                                    contractDetailTO.getContractNo().equals(fakeContractNo)) {
                                contractDetailTO.setContractNo(contractNo);
                                String fakeEstimateDetailCodeNo = contractDetailTO.getContractDetailNo();

                                if (fakeEstimateDetailCodeNo.length() < 2) {
                                    fakeEstimateDetailCodeNo = "0" + fakeEstimateDetailCodeNo;
                                }

                                contractDetailTO.setContractDetailNo(contractNo + "-" + fakeEstimateDetailCodeNo);
                                contractDetailDAO.insertContractDetail(contractDetailTO);
                                contractDetailTO.setStatus("normal");

                            }
                        }


                        EstimateTO estimateTO = new EstimateTO();
                        //이 부분은 estimate에 가서 contractStatus만 y로 바꿔주는 부분이라
                        //그대로 사용하며 ibatis 동적쿼리를 이용해서 생산성 있게 수정
                        estimateTO.setEstimateNo(contractTO.getEstimateNo());
                        estimateTO.setContractStatus("Y");
                        estimateTO.setStatus("update");
                        estimateList.add(estimateTO);

                        break;
                    case "update":
                        contractDAO.updateContract(contractTO);
                        break;
                    case "delete":
                        contractDAO.deleteContract(contractTO);

                        estimateTO = new EstimateTO();
                        estimateTO.setEstimateNo(contractTO.getEstimateNo());
                        estimateTO.setContractStatus("N");
                        estimateTO.setStatus("update");
                        estimateList.add(estimateTO);
                        break;
                }
            }
        }

        if (estimateList != null) {
            System.out.println("여기 왔나요??");
            batchEstimate(estimateList, null);
        }

        if (contractDetailList != null) {
            for (ContractDetailTO contractDetailTO : contractDetailList) {

                switch (contractDetailTO.getStatus()) {

                    case "insert":
                        contractDetailDAO.insertContractDetail(contractDetailTO);
                        break;
                    case "update":
                        contractDetailDAO.updateContractDetail(contractDetailTO);
                        break;
                    case "delete":
                        contractDetailDAO.deleteContractDetail(contractDetailTO);
                        break;
                }
            }
        }
    }

    @Override
    public List<DeliveryResultTO> getDeliveryResultList() {
        return deliveryResultDAO.selectDeliveryResultList();
    }

    @Override
    public void registDeliveryResult(List<DeliveryResultTO> deliveryResultList) {
//procedure쓸거라서 주석처리
//		for (DeliveryResultTO deliveryResultTO : deliveryResultList) {
//			switch (deliveryResultTO.getStatus()) {
//				case "insert":
//					deliveryResultDAO.insertDeliveryResult(deliveryResultTO);
//					break;
//				case "update" : deliveryResultDAO.updateDeliveryResult(deliveryResultTO);
//					break;
//				// case "delete" : deliveryResultDAO.deleteDeliveryResult(deliveryResultTO);
//				// break;
//			}
//		}
//		batchContract(contractList, contractDetailList);
//		purchaseApplicationService.batchStock(stockList);
        for (DeliveryResultTO deliveryResultTO : deliveryResultList) {
            deliveryResultDAO.callRegistDeliveryResult(deliveryResultTO.getContractDetailNo(),
                    deliveryResultTO.getDeliveryAmount(), deliveryResultTO.getDescription());
        }
    }

    @Override
    public void batchCustomerList(List<CustomerTO> batchCustomerList) {
        if (batchCustomerList != null) {
            for (CustomerTO customerTO : batchCustomerList) {
                switch (customerTO.getStatus()) {
                    case "insert":
                        customerDAO.insertCustomer(customerTO);
                        break;
                    case "update":
                        customerDAO.updateCustomer(customerTO);
                        break;
                    case "delete":
                        customerDAO.deleteCustomer(customerTO);
                        break;
                }
            }
        }
    }

    @Override
    public List<ContractDetailTO> getRangedContractDetailList(String fromDate, String toDate) {
        return contractDetailDAO.selectRangedContractDetailList(fromDate, toDate);
    }


    @Override
    public List<CompleteDeliveryResultTO> getCompleteDeliveryResultList() {
        return deliveryResultDAO.selectCompleteDeliveryResultList();
    }
}
