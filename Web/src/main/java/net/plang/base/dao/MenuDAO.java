package net.plang.base.dao;

import java.util.List;

import net.plang.base.to.MenuTO;

public interface MenuDAO {

    List<MenuTO> selectMenuList();
}
