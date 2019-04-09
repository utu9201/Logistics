package net.plang.logistics.base.sf;

import java.util.List;

import net.plang.logistics.base.to.CompanyTO;
import net.plang.logistics.base.to.DeptTO;
import net.plang.logistics.base.to.PositionTO;
import net.plang.logistics.base.to.WorkplaceTO;

public interface ManagementServiceFacade {

    List<DeptTO> findDeptList();

    List<CompanyTO> findCompanyList();

    List<WorkplaceTO> findWorkplaceList();

    List<PositionTO> findPositionList();

    void batchDepartmentList(List<DeptTO> registDeptList);

    void batchCompanyList(List<CompanyTO> batchCompanyList);

    void batchWorkplaceList(List<WorkplaceTO> batchWorkplaceList);

}
