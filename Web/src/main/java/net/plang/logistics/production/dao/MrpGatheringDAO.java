package net.plang.logistics.production.dao;

import java.util.List;
import java.util.Map;

import net.plang.logistics.production.to.MrpGatheringTO;
import net.plang.logistics.production.to.MrpGatheringTO2;

public interface MrpGatheringDAO {
    List<MrpGatheringTO> selectMrpGatheringList();

    void insertMrpGathering(MrpGatheringTO mrpGatheringTO);

    void updateMrpGathering(MrpGatheringTO mrpGatheringTO);

    void deleteMrpGathering(MrpGatheringTO mrpGatheringTO);

    List<MrpGatheringTO2> selectMrpGatheringList2(String mrpNo);

    void MrpGathering(Map<String, Object> paramMap);
}
