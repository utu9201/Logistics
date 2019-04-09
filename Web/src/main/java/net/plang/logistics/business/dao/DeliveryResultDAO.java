package net.plang.logistics.business.dao;

import java.util.List;

import net.plang.logistics.business.to.CompleteDeliveryResultTO;
import net.plang.logistics.business.to.DeliveryResultTO;

public interface DeliveryResultDAO {

    List<DeliveryResultTO> selectDeliveryResultList();

    List<CompleteDeliveryResultTO> selectCompleteDeliveryResultList();

    void insertDeliveryResult(DeliveryResultTO selectDeliveryTO);

    void updateDeliveryResult(DeliveryResultTO selectDeliveryTO);

    void callRegistDeliveryResult(String contractDetailNo, String deliveryAmount, String description);
}
