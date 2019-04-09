package net.plang.logistics.purchase.dao;

import java.util.List;

import net.plang.common.dao.IbatisSupportDAO;
import net.plang.logistics.purchase.to.ItemTO;

public class ItemDAOImpl extends IbatisSupportDAO implements ItemDAO {
    @SuppressWarnings("unchecked")
    @Override
    public List<ItemTO> selectItemList() {
        return (List<ItemTO>) getSqlMapClientTemplate().queryForList("item.selectItemList");
    }
}
