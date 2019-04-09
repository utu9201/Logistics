package net.plang.logistics.production.dao;

import java.util.List;

import net.plang.logistics.production.to.MpsTO;

public interface MpsDAO {

    List<MpsTO> selectMpsList();

    void insertMps(MpsTO mpsTO);

    void updeteMps(MpsTO mpsTO);

}
