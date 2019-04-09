package net.plang.logistics.business.dao;

import java.util.List;

import net.plang.logistics.business.to.CustomerTO;

public interface CustomerDAO {

    List<CustomerTO> selectCustomerList();

    void insertCustomer(CustomerTO customerTO);

    void updateCustomer(CustomerTO customerTO);

    void deleteCustomer(CustomerTO customerTO);
}
