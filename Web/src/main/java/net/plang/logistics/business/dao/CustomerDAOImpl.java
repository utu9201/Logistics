package net.plang.logistics.business.dao;

import java.util.List;

import net.plang.common.dao.IbatisSupportDAO;
import net.plang.logistics.business.to.CustomerTO;

public class CustomerDAOImpl extends IbatisSupportDAO implements CustomerDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<CustomerTO> selectCustomerList() {
        return (List<CustomerTO>) getSqlMapClientTemplate().queryForList("customer.selectCustomerList");
    }

    @Override
    public void insertCustomer(CustomerTO customerTO) {
        getSqlMapClientTemplate().insert("customer.insertCustomer", customerTO);
    }

    @Override
    public void updateCustomer(CustomerTO customerTO) {
        getSqlMapClientTemplate().update("customer.updateCustomer", customerTO);
    }

    @Override
    public void deleteCustomer(CustomerTO customerTO) {
        getSqlMapClientTemplate().delete("customer.deleteCustomer", customerTO);
    }
}
