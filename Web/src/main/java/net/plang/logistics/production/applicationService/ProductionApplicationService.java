package net.plang.logistics.production.applicationService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.plang.logistics.business.to.ContractDetailTO;
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

public interface ProductionApplicationService {
    List<MpsTO> findMpsList();

    void registMps(List<MpsTO> mpsList, List<ContractDetailTO> contractDetailList);

    List<MrpTO> findMrpList();

    List<MrpGatheringTO> findMrpGatheringList();

    List<WorkInstructionTO> findWorkInstructionList();

    void batchMrpGathering(List<MrpGatheringTO> mrpGatheringList);

    void registWorkInstruction(List<WorkInstructionTO> workInstructionList, List<MrpGatheringTO> mrpGatheringList, List<MaterialPaymentTO> materialPaymentList, List<StockTO> stockList);

    List<PrmTO> findPrmList();

    void registPrm(List<WorkInstructionTO> workInstructionList, List<PrmTO> prmList, List<StockTO> stockList, List<WarehousingTO> warehousingList);

    List<MrpOpenTempTO> findMrpOpenTempProcessList(String mpsNo);

    List<MrpGatheringTO2> findMrpGatheringList2(List<MrpTO> mrpList);

    void registMrp(Map<String, Object> paramMap);

    void registMrpGathering(Map<String, Object> paramMap);

    List<MaterialCheckTempTO> findMaterialCheckTempList(Map<String, Object> paramMap);

    List<MrpOpenTempTO> findMrpOpenTempProcessList(HashMap<String, Object> paramMap);

}
