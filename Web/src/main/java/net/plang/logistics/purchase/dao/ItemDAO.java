package net.plang.logistics.purchase.dao;

import java.util.List;

import net.plang.logistics.purchase.to.ItemTO;

public interface ItemDAO {

    List<ItemTO> selectItemList();

}
