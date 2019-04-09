package net.plang.logistics.purchase.dao;

import java.util.List;

import net.plang.logistics.purchase.to.WarehousingTO;

public interface WarehousingDAO {
    List<WarehousingTO> selectWarehousingList();

    void insertWarehousing(WarehousingTO warehousingTO);

    void updateWarehousing(WarehousingTO warehousingTO);

}
