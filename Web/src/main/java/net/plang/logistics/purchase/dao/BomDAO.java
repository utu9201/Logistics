package net.plang.logistics.purchase.dao;

import java.util.List;

import net.plang.logistics.purchase.to.BomDeployTO;
import net.plang.logistics.purchase.to.BomTO;

public interface BomDAO {

    List<BomTO> selectBomList();

    List<BomDeployTO> selectBomDeployList(String itemCode, String deployCondition);

}
