package net.plang.base.dao;

import net.plang.base.to.ContractReportTO;
import net.plang.common.dao.IbatisSupportDAO;

import java.util.List;

public class ReportDAOImpl extends IbatisSupportDAO implements ReportDAO {
    @Override
    public List<ContractReportTO> getContractReport(String contractNo) {
        return (List<ContractReportTO>) getSqlMapClientTemplate().queryForList("report.selectContractReport", contractNo);
    }
}
