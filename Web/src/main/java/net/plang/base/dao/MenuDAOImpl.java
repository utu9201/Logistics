package net.plang.base.dao;

import java.util.List;

import net.plang.base.to.MenuTO;
import net.plang.common.dao.IbatisSupportDAO;

public class MenuDAOImpl extends IbatisSupportDAO implements MenuDAO {

    @SuppressWarnings("unchecked")
    public List<MenuTO> selectMenuList() {

        return (List<MenuTO>) getSqlMapClientTemplate().queryForList("menu.selectMenuList");
    }

}
