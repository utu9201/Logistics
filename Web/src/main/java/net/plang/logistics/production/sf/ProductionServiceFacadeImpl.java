package net.plang.logistics.production.sf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.plang.logistics.business.to.ContractDetailTO;
import net.plang.logistics.production.applicationService.ProductionApplicationService;
import net.plang.logistics.production.to.MaterialCheckTempTO;
import net.plang.logistics.production.to.MpsTO;
import net.plang.logistics.production.to.MrpGatheringTO;
import net.plang.logistics.production.to.MrpGatheringTO2;
import net.plang.logistics.production.to.MrpOpenTempTO;
import net.plang.logistics.production.to.MrpTO;
import net.plang.logistics.production.to.PrmTO;
import net.plang.logistics.production.to.WorkInstructionTO;
import net.plang.logistics.purchase.to.MaterialPaymentTO;
import net.plang.logistics.purchase.to.StockTO;
import net.plang.logistics.purchase.to.WarehousingTO;

public class ProductionServiceFacadeImpl implements ProductionServiceFacade {
    private ProductionApplicationService productionApplicationService;

    public void setProductionApplicationService(ProductionApplicationService productionApplicationService) {
        this.productionApplicationService = productionApplicationService;
    }

    @Override
    public List<MpsTO> findMpsList() {
        return productionApplicationService.findMpsList();
    }

    @Override
    public void registMps(List<MpsTO> mpsList, List<ContractDetailTO> contractDetailList) {
        productionApplicationService.registMps(mpsList, contractDetailList);
    }

    @Override
    public List<MrpTO> findMrpList() {
        return productionApplicationService.findMrpList();
    }

    ////////여기부터 실험대상들
    @Override
    public List<MrpGatheringTO> findMrpGatheringList() {
        return productionApplicationService.findMrpGatheringList();
    }

    @Override
    public List<WorkInstructionTO> findWorkInstructionList() {
        return productionApplicationService.findWorkInstructionList();
    }

    @Override
    public void batchMrpGathering(List<MrpGatheringTO> mrpGatheringList) {
        productionApplicationService.batchMrpGathering(mrpGatheringList);
    }

    @Override
    public void registWorkInstruction(List<WorkInstructionTO> workInstructionList,
                                      List<MrpGatheringTO> mrpGatheringList, List<MaterialPaymentTO> materialPaymentList,
                                      List<StockTO> stockList
    ) {
        productionApplicationService.registWorkInstruction(workInstructionList, mrpGatheringList, materialPaymentList, stockList);

    }

    @Override
    public List<PrmTO> findPrmList() {
        return productionApplicationService.findPrmList();
    }

    @Override
    public void registPrm(List<WorkInstructionTO> workInstructionList, List<PrmTO> prmList, List<StockTO> stockList, List<WarehousingTO> warehousingList) {
        productionApplicationService.registPrm(workInstructionList, prmList, stockList, warehousingList);
    }

    @Override
    public List<MrpOpenTempTO> findMrpOpenTempProcessList(String mpsNo) {
        return productionApplicationService.findMrpOpenTempProcessList(mpsNo);
    }

    @Override
    public List<MrpGatheringTO2> findMrpGatheringList2(List<MrpTO> mrpList) {
        return productionApplicationService.findMrpGatheringList2(mrpList);
    }

    @Override
    public List<MrpOpenTempTO> findMrpOpenTempProcessList(HashMap<String, Object> paramMap) {
        return productionApplicationService.findMrpOpenTempProcessList(paramMap);
    }

    @Override
    public void registMrp(Map<String, Object> paramMap) {

        productionApplicationService.registMrp(paramMap);
    }

    @Override
    public void registMrpGathering(Map<String, Object> paramMap) {
        productionApplicationService.registMrpGathering(paramMap);
    }

    @Override
    public List<MaterialCheckTempTO> findMaterialCheckTempList(Map<String, Object> paramMap) {
        return null;
    }
}
