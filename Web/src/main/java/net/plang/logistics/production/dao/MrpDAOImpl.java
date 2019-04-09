package net.plang.logistics.production.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.plang.common.dao.IbatisSupportDAO;
import net.plang.logistics.production.to.MrpOpenTempTO;
import net.plang.logistics.production.to.MrpTO;

public class MrpDAOImpl extends IbatisSupportDAO implements MrpDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<MrpTO> selectMrpList() {
        return (List<MrpTO>) getSqlMapClientTemplate().queryForList("mrp.selectMrpList");
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MrpOpenTempTO> MrpOpenTempProcessList(String mpsNo) {
        HashMap<String, Object> map = new HashMap<>();
        String[] mpsNoArray = {mpsNo};
        map.put("mpsNo", mpsNoArray);
        System.out.println("프로시저 시작");
        return (List<MrpOpenTempTO>) getSqlMapClientTemplate().queryForList("mrp.MrpOpenTempProcessList", map);
    }

    @Override
    public void insertMrp(MrpTO mrpTO) {

        getSqlMapClientTemplate().insert("mrp.insertMrp", mrpTO);

    }

    @Override
    public void updateMrp(MrpTO mrpTO) {
        getSqlMapClientTemplate().update("mrp.updateMrp", mrpTO);
    }

    @Override
    public List<MrpOpenTempTO> MrpOpenTempProcessList(Map<String, Object> parameters) {
        return (List<MrpOpenTempTO>) getSqlMapClientTemplate().queryForList("mrp.MrpOpenTempProcessList", parameters);
    }

    @Override
    public void MrpInsertProcess(Map<String, Object> parameters) {
        getSqlMapClientTemplate().queryForList("mrp.MrpInsertProcess", parameters);

    }

    @Override
    public void MrpGathering(Map<String, Object> parameters) {

    }
}
