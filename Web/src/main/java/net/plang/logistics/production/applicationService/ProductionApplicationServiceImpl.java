package net.plang.logistics.production.applicationService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.plang.logistics.business.applicationService.BusinessApplicationService;
import net.plang.logistics.business.to.ContractDetailTO;
import net.plang.logistics.production.dao.MpsDAO;
import net.plang.logistics.production.dao.MrpDAO;
import net.plang.logistics.production.dao.MrpGatheringDAO;
import net.plang.logistics.production.dao.PrmDAO;
import net.plang.logistics.production.dao.WorkInstructionDAO;
import net.plang.logistics.production.to.MaterialCheckTempTO;
import net.plang.logistics.production.to.MpsTO;
import net.plang.logistics.production.to.MrpGatheringTO;
import net.plang.logistics.production.to.MrpGatheringTO2;
import net.plang.logistics.production.to.MrpOpenTempTO;
import net.plang.logistics.production.to.MrpTO;
import net.plang.logistics.production.to.PrmTO;
import net.plang.logistics.production.to.WorkInstructionTO;
import net.plang.logistics.purchase.applicationService.PurchaseApplicationService;
import net.plang.logistics.purchase.to.MaterialPaymentTO;
import net.plang.logistics.purchase.to.StockTO;
import net.plang.logistics.purchase.to.WarehousingTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductionApplicationServiceImpl implements ProductionApplicationService {

    private MpsDAO mpsDAO;

    private MrpDAO mrpDAO;

    private MrpGatheringDAO mrpGatheringDAO;

    private WorkInstructionDAO workInstructionDAO;

    private PrmDAO prmDAO;

    @Autowired
    private PurchaseApplicationService purchaseApplicationSerivce;

    public void setPurchaseApplicationSerivce(PurchaseApplicationService purchaseApplicationSerivce) {
        this.purchaseApplicationSerivce = purchaseApplicationSerivce;
    }

    public void setPrmDAO(PrmDAO prmDAO) {
        this.prmDAO = prmDAO;
    }

    public void setWorkInstructionDAO(WorkInstructionDAO workInstructionDAO) {
        this.workInstructionDAO = workInstructionDAO;
    }

    private BusinessApplicationService businessApplicationService;

    public void setMrpDAO(MrpDAO mrpDAO) {
        this.mrpDAO = mrpDAO;
    }

    public void setMrpGatheringDAO(MrpGatheringDAO mrpGatheringDAO) {
        this.mrpGatheringDAO = mrpGatheringDAO;
    }

    public void setBusinessApplicationService(BusinessApplicationService businessApplicationService) {
        this.businessApplicationService = businessApplicationService;
    }

    public void setMpsDAO(MpsDAO mpsDAO) {
        this.mpsDAO = mpsDAO;
    }

    @Override
    public List<MpsTO> getMpsList() {
        return mpsDAO.selectMpsList();
    }

    @Override
    public void registMps(List<MpsTO> mpsList, List<ContractDetailTO> contractDetailList) {
        if (mpsList != null) {

            for (MpsTO mpsTO : mpsList) {

                switch (mpsTO.getStatus()) {

                    case "insert":
                        mpsDAO.insertMps(mpsTO);
                        break;
                    //case "update" : contractDAO.updateContract(contractTO); break;
                    //case "delete" : contractDAO.deleteContract(contractTO); break;

                }

            }

        }
        if (contractDetailList != null) {

            businessApplicationService.batchContract(null, contractDetailList);

        }
    }

    @Override
    public List<MrpTO> getMrpList() {
        return mrpDAO.selectMrpList();
    }

    @Override
    public List<MrpGatheringTO> getMrpGatheringList() {
        return mrpGatheringDAO.selectMrpGatheringList();
    }

    @Override
    public List<WorkInstructionTO> getWorkInstructionList() {
        return workInstructionDAO.selectWorkInstructionList();
    }

    @Override
    public void batchMrpGathering(List<MrpGatheringTO> mrpGatheringList) {

        for (MrpGatheringTO mrpGatheringTO : mrpGatheringList) {

            System.out.println(mrpGatheringTO.getStatus());

            switch (mrpGatheringTO.getStatus()) {
                case "insert":
                    mrpGatheringDAO.insertMrpGathering(mrpGatheringTO);
                    break;
                case "update":
                    mrpGatheringDAO.updateMrpGathering(mrpGatheringTO);
                    break;
                case "delete":
                    mrpGatheringDAO.deleteMrpGathering(mrpGatheringTO);
                    break;

            }

        }

    }

    @Override
    public void registWorkInstruction(List<WorkInstructionTO> workInstructionList,
                                      List<MrpGatheringTO> mrpGatheringList, List<MaterialPaymentTO> materialPaymentList, List<StockTO> stockList) {
        for (WorkInstructionTO workInstructionTO : workInstructionList) {
            switch (workInstructionTO.getStatus()) {
                case "insert":
                    workInstructionDAO.insertWorkInstruction(workInstructionTO);
                    break;
                case "update":
                    workInstructionDAO.updateWorkInstruction(workInstructionTO);
                    break;
                case "delete":
                    workInstructionDAO.deleteWorkInstruction(workInstructionTO);
                    break;

            }

        }
        if (mrpGatheringList != null) {
            batchMrpGathering(mrpGatheringList);
        }

        if (materialPaymentList != null) {
            purchaseApplicationSerivce.registMaterialPayment(materialPaymentList);
        }

        if (stockList != null) {
            purchaseApplicationSerivce.batchStock(stockList);
        }

    }

    @Override
    public List<PrmTO> getPrmList() {
        return prmDAO.selectPrmList();
    }

    @Override
    public void registPrm(List<WorkInstructionTO> workInstructionList, List<PrmTO> prmList, List<StockTO> stockList, List<WarehousingTO> warehousingList) {
        for (PrmTO prmTO : prmList) {

            switch (prmTO.getStatus()) {
                case "insert":
                    prmDAO.insertPrm(prmTO);
                    break;
                //case "update" : prmDAO.updatePrm(prmTO); break;
                //case "delete" : prmDAO.deletePrm(prmTO); break;

            }

        }

        registWorkInstruction(workInstructionList, null, null, null);

        purchaseApplicationSerivce.batchStock(stockList);

        purchaseApplicationSerivce.registWarehousing(null, null, null, warehousingList);
    }

    @Override
    public List<MrpOpenTempTO> getMrpOpenTempProcessList(String mpsNo) {
        System.out.println("프로시저 어플리케이션 시작");
        MpsTO mpsTO = new MpsTO();
        mpsTO.setMpsNo(mpsNo);
        mpsTO.setStatus("update");
        mpsTO.setMrpApplyStatus("Y");
        mpsDAO.updeteMps(mpsTO);
        MrpTO mrpTO = null;
        List<MrpOpenTempTO> mrpOpenList = mrpDAO.MrpOpenTempProcessList(mpsNo);

        int number = 1;

        for (MrpOpenTempTO mrpOpenTO : mrpOpenList) {
            mrpTO = new MrpTO();
            String mpsNumber = mrpOpenTO.getMpsNo();
            String mrpNo = "RP" + mpsNumber.substring(2) + Integer.toString(number);
            mrpTO.setMrpNo(mrpNo);
            mrpTO.setMpsNo(mpsNumber);
            mrpTO.setItemClassifcation(mrpOpenTO.getItemClassification());
            mrpTO.setItemCode(mrpOpenTO.getItemCode());
            mrpTO.setItemName(mrpOpenTO.getItemName());
            mrpTO.setUnitOfMrp(mrpOpenTO.getUnitOfMrp());
            mrpTO.setRequiredAmount(mrpOpenTO.getRequiredAmount());
            mrpTO.setOrderDate(mrpOpenTO.getOrderDate());
            mrpTO.setRequiredDate(mrpOpenTO.getRequiredDate());
            mrpTO.setMrpGatheringStatus("N");
            mrpDAO.insertMrp(mrpTO);
            number++;
        }

        return mrpOpenList;

    }

    @Override
    public List<MrpGatheringTO2> getMrpGatheringList2(List<MrpTO> mrplist) {

        String mrpNo = "";

        MrpTO mrpTO = new MrpTO();

        for (MrpTO mrpto : mrplist) {
            mrpNo += mrpto.getMrpNo() + ",";
        }

        if (mrpNo.length() != 0) {
            mrpNo = mrpNo.substring(0, mrpNo.length() - 1);
        }
        List<MrpGatheringTO2> mrpGatheringList = mrpGatheringDAO.selectMrpGatheringList2(mrpNo);
        for (MrpGatheringTO2 mrpGatheringTO2 : mrpGatheringList) {

            if (mrpGatheringTO2.getMrpNo().length() < 14) {

                mrpTO.setMrpNo(mrpGatheringTO2.getMrpNo());
                mrpTO.setMrpGatheringStatus("Y");
                mrpDAO.updateMrp(mrpTO);    // mrp취합여부 업데이트
            } else {

                String[] array = mrpGatheringTO2.getMrpNo().split(",");
                for (int i = 0; i < array.length; i++) {
                    System.out.println("qqqqqqqqqq" + mrpGatheringTO2.getMrpGatheringNo());
                    mrpTO.setMrpNo(array[i]);
                    mrpTO.setMrpGatheringNo(mrpGatheringTO2.getMrpGatheringNo());
                    mrpTO.setMrpGatheringStatus("Y");
                    mrpDAO.updateMrp(mrpTO);
                    ;
                }
            }

            MrpGatheringTO mrpgatheringTO = new MrpGatheringTO();
            //mrpgatheringTO.setMrpNo(mrpGatheringTO.getMrpNo());
            mrpgatheringTO.setMrpGatheringNo(mrpGatheringTO2.getMrpGatheringNo());
            mrpgatheringTO.setOrderOrProductionStatus(mrpGatheringTO2.getOrderOrProductionStatus());
            mrpgatheringTO.setItemCode(mrpGatheringTO2.getItemCode());
            mrpgatheringTO.setItemName(mrpGatheringTO2.getItemName());
            mrpgatheringTO.setUnitOfMrpGathering(mrpGatheringTO2.getUnitOfMrpGathering());
            mrpgatheringTO.setNecessaryAmount(mrpGatheringTO2.getNecessaryAmount());
            mrpgatheringTO.setDueDate(mrpGatheringTO2.getDueDate());
            mrpgatheringTO.setClaimDate(mrpGatheringTO2.getClaimDate());
            mrpgatheringTO.setOnGoingProcessStatus("N");
            mrpGatheringDAO.insertMrpGathering(mrpgatheringTO);      // mrpGathering 인서트
        }
        return mrpGatheringList;
    }

    ////////여기부터 실험대상들
    @SuppressWarnings("unchecked")
    @Override
    public List<MrpOpenTempTO> getMrpOpenTempProcessList(HashMap<String, Object> paramMap) {
        return mrpDAO.MrpOpenTempProcessList(paramMap);
    }

    @Override
    public void registMrp(Map<String, Object> paramMap) {

        mrpDAO.MrpInsertProcess(paramMap);

    }

    @Override
    public void registMrpGathering(Map<String, Object> paramMap) {

        mrpGatheringDAO.MrpGathering(paramMap);
    }

    @Override
    public List<MaterialCheckTempTO> getMaterialCheckTempList(Map<String, Object> paramMap) {
        return null;
    }
}
