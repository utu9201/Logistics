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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductionServiceFacadeImpl implements ProductionServiceFacade {
    @Autowired
    private ProductionApplicationService productionApplicationService;
    
    @Override
    public List<MpsTO> getMpsList() {
        return productionApplicationService.getMpsList();
    }

    @Override
    public void registMps(List<MpsTO> mpsList, List<ContractDetailTO> contractDetailList) {
        productionApplicationService.registMps(mpsList, contractDetailList);
    }

    @Override
    public List<MrpTO> getMrpList() {
        return productionApplicationService.getMrpList();
    }

    ////////여기부터 실험대상들
    @Override
    public List<MrpGatheringTO> getMrpGatheringList() {
        return productionApplicationService.getMrpGatheringList();
    }

    @Override
    public List<WorkInstructionTO> getWorkInstructionList() {
        return productionApplicationService.getWorkInstructionList();
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
    public List<PrmTO> getPrmList() {
        return productionApplicationService.getPrmList();
    }

    @Override
    public void registPrm(List<WorkInstructionTO> workInstructionList, List<PrmTO> prmList, List<StockTO> stockList, List<WarehousingTO> warehousingList) {
        productionApplicationService.registPrm(workInstructionList, prmList, stockList, warehousingList);
    }

    @Override
    public List<MrpOpenTempTO> getMrpOpenTempProcessList(String mpsNo) {
        return productionApplicationService.getMrpOpenTempProcessList(mpsNo);
    }

    @Override
    public List<MrpGatheringTO2> getMrpGatheringList2(List<MrpTO> mrpList) {
        return productionApplicationService.getMrpGatheringList2(mrpList);
    }

    @Override
    public List<MrpOpenTempTO> getMrpOpenTempProcessList(HashMap<String, Object> paramMap) {
        return productionApplicationService.getMrpOpenTempProcessList(paramMap);
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
    public List<MaterialCheckTempTO> getMaterialCheckTempList(Map<String, Object> paramMap) {
        return null;
    }
}
