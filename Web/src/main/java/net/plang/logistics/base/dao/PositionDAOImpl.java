package net.plang.logistics.base.dao;

import java.util.List;

import net.plang.common.dao.IbatisSupportDAO;
import net.plang.logistics.base.to.PositionTO;

public class PositionDAOImpl extends IbatisSupportDAO implements PositionDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<PositionTO> selectPositionList() {
        return (List<PositionTO>) getSqlMapClientTemplate().queryForList("position.selectPositionList");
    }

}
