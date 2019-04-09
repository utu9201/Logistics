package net.plang.logistics.production.dao;

import java.util.List;

import net.plang.common.dao.IbatisSupportDAO;

import net.plang.logistics.production.to.MpsTO;

public class MpsDAOImpl extends IbatisSupportDAO implements MpsDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<MpsTO> selectMpsList() {
        return (List<MpsTO>) getSqlMapClientTemplate().queryForList("mps.selectMpsList");
    }

    @Override
    public void insertMps(MpsTO mpsTO) {
        getSqlMapClientTemplate().insert("mps.insertMps", mpsTO);
    }

    @Override
    public void updeteMps(MpsTO mpsTO) {
        getSqlMapClientTemplate().update("mps.updateMps", mpsTO);
    }

}
