package net.plang.logistics.production.dao;

import java.util.List;
import java.util.Map;

import net.plang.common.dao.IbatisSupportDAO;
import net.plang.logistics.production.to.MrpGatheringTO;
import net.plang.logistics.production.to.MrpGatheringTO2;

public class MrpGatheringDAOImpl extends IbatisSupportDAO implements MrpGatheringDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<MrpGatheringTO> selectMrpGatheringList() {
        return (List<MrpGatheringTO>) getSqlMapClientTemplate().queryForList("mrpGathering.selectMrpGatheringList");

    }

    @Override
    public void insertMrpGathering(MrpGatheringTO mrpGatheringTO) {
        getSqlMapClientTemplate().insert("mrpGathering.insertMrpGathering", mrpGatheringTO);

    }

    @Override
    public void updateMrpGathering(MrpGatheringTO mrpGatheringTO) {
        getSqlMapClientTemplate().update("mrpGathering.updateMrpGathering", mrpGatheringTO);
    }

    @Override
    public void deleteMrpGathering(MrpGatheringTO mrpGatheringTO) {
        getSqlMapClientTemplate().delete("mrpGathering.deleteMrpGathering", mrpGatheringTO);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MrpGatheringTO2> selectMrpGatheringList2(String mrpNo) {
        return (List<MrpGatheringTO2>) getSqlMapClientTemplate().queryForList("mrpGathering.selectMrpGatheringList2", mrpNo);
    }

    public void MrpGathering(Map<String, Object> paramMap) {
        getSqlMapClientTemplate().queryForList("mrpGathering.registMrpGathering", paramMap);
    }

    ;
}
