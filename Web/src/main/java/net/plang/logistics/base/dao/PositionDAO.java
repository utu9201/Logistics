package net.plang.logistics.base.dao;

import java.util.List;

import net.plang.logistics.base.to.PositionTO;

public interface PositionDAO {

    List<PositionTO> selectPositionList();

}
