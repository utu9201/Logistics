package net.plang.base.dao;

import net.plang.base.to.ContractReportTO;

import java.util.List;

public interface ReportDAO {
    List<ContractReportTO> selectContractReport(String contractNo);
}
