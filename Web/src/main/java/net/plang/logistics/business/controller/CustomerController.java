package net.plang.logistics.business.controller;

import java.util.List;

import com.tobesoft.platform.data.PlatformData;

import net.plang.common.controller.MiplatformController;
import net.plang.logistics.business.sf.BusinessServiceFacade;
import net.plang.logistics.business.to.CustomerTO;

public class CustomerController extends MiplatformController {
    private BusinessServiceFacade businessServiceFacade;

    public void setBusinessServiceFacade(BusinessServiceFacade businessServiceFacade) {
        this.businessServiceFacade = businessServiceFacade;
    }

    public void findCustomerList(PlatformData inData, PlatformData outData) throws Exception {

        List<CustomerTO> customerList = businessServiceFacade.findCustomerList();

        datasetBeanMapper.beansToDataset(outData, customerList, CustomerTO.class);

    }

    public void batchCustomerList(PlatformData inData, PlatformData outData) throws Exception {
        List<CustomerTO> batchCustomerList = datasetBeanMapper.datasetToBeans(inData, CustomerTO.class);
        businessServiceFacade.batchCustomerList(batchCustomerList);
    }
}
