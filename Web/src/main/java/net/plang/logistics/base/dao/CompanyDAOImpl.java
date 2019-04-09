package net.plang.logistics.base.dao;

import java.util.List;

import net.plang.common.dao.IbatisSupportDAO;
import net.plang.logistics.base.to.CompanyTO;

public class CompanyDAOImpl extends IbatisSupportDAO implements CompanyDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<CompanyTO> selectCompanyList() {
        return (List<CompanyTO>) getSqlMapClientTemplate().queryForList("company.selectCompanyList");
    }

    public void insertCompany(CompanyTO CompTO) {
        getSqlMapClientTemplate().insert("company.insertCompany", CompTO);
    }

    public void updateCompany(CompanyTO CompTO) {
        System.out.println(CompTO.getCompanyCode());
        getSqlMapClientTemplate().update("company.updateCompany", CompTO);
    }

    public void deleteCompany(CompanyTO CompTO) {
        getSqlMapClientTemplate().delete("company.deleteCompany", CompTO);
    }

}
