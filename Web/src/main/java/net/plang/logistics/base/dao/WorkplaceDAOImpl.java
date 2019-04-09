package net.plang.logistics.base.dao;

import java.util.List;

import net.plang.common.dao.IbatisSupportDAO;

import net.plang.logistics.base.to.WorkplaceTO;

public class WorkplaceDAOImpl extends IbatisSupportDAO implements WorkplaceDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<WorkplaceTO> selectWorkplaceList() {
        return (List<WorkplaceTO>) getSqlMapClientTemplate().queryForList("workplace.selectWorkplaceList");
    }

    @Override
    public void insertWorkplace(WorkplaceTO wpTO) {
        getSqlMapClientTemplate().insert("workplace.insertWorkplace", wpTO);
    }

    @Override
    public void updateWorkplace(WorkplaceTO wpTO) {
        getSqlMapClientTemplate().update("workplace.updateWorkplace", wpTO);
    }

    @Override
    public void deleteWorkplace(WorkplaceTO wpTO) {
        getSqlMapClientTemplate().delete("workplace.deleteWorkplace", wpTO);
    }
}
