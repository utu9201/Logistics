package net.plang.logistics.purchase.dao;

import java.util.List;

import net.plang.logistics.purchase.to.MaterialPaymentTO;

public interface MaterialPaymentDAO {

    List<MaterialPaymentTO> selectMaterialPaymentList();

    void insertMaterialPayment(MaterialPaymentTO materialPaymentTO);
}
