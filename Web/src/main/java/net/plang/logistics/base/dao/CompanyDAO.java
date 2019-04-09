package net.plang.logistics.base.dao;

import java.util.List;

import net.plang.logistics.base.to.CompanyTO;

public interface CompanyDAO {

    List<CompanyTO> selectCompanyList();

    void insertCompany(CompanyTO CompTO);

    void updateCompany(CompanyTO CompTO);

    void deleteCompany(CompanyTO CompTO);
}
