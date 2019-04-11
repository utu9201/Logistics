package net.plang.logistics.base.application;

import java.util.List;

import net.plang.logistics.base.to.CompanyTO;
import net.plang.logistics.base.to.DeptTO;
import net.plang.logistics.base.to.PositionTO;
import net.plang.logistics.base.to.WorkplaceTO;

public interface ManagementApplicationService {

    List<DeptTO> getDeptList();

    List<CompanyTO> getCompanyList();

    List<WorkplaceTO> getWorkplaceList();

    List<PositionTO> getPositionList();

    void batchDepartmentList(List<DeptTO> batchDeptList);

    void batchCompanyList(List<CompanyTO> batchCompanyList);

    void batchWorkplaceList(List<WorkplaceTO> batchWorkplaceList);

}
