package net.plang.logistics.production.dao;

import java.util.List;
import java.util.Map;

import net.plang.logistics.production.to.MrpOpenTempTO;
import net.plang.logistics.production.to.MrpTO;

public interface MrpDAO {

    List<MrpTO> selectMrpList();

    void insertMrp(MrpTO mrpTO);

    void updateMrp(MrpTO mrpTO);

    List<MrpOpenTempTO> MrpOpenTempProcessList(String mpsNo);

    ///////여기부터 실험대상

    List<MrpOpenTempTO> MrpOpenTempProcessList(Map<String, Object> parameters);

    void MrpInsertProcess(Map<String, Object> parameters);

    void MrpGathering(Map<String, Object> parameters);

}
