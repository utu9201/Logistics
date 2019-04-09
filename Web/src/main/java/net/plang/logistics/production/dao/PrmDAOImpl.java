package net.plang.logistics.production.dao;

import java.util.List;

import net.plang.common.dao.IbatisSupportDAO;
import net.plang.logistics.production.to.PrmTO;

public class PrmDAOImpl extends IbatisSupportDAO implements PrmDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<PrmTO> selectPrmList() {
        return (List<PrmTO>) getSqlMapClientTemplate().queryForList("prm.selectPrmList");
    }

    @Override
    public void insertPrm(PrmTO prmTO) {

        getSqlMapClientTemplate().insert("prm.insertPrm", prmTO);

    }

}
