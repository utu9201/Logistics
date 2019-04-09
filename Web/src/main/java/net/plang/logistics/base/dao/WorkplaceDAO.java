package net.plang.logistics.base.dao;

import java.util.List;

import net.plang.logistics.base.to.WorkplaceTO;

public interface WorkplaceDAO {

    List<WorkplaceTO> selectWorkplaceList();

    void insertWorkplace(WorkplaceTO wpTO);

    void updateWorkplace(WorkplaceTO wpTO);

    void deleteWorkplace(WorkplaceTO wpTO);
}
