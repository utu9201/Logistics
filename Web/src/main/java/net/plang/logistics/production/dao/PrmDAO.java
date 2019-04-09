package net.plang.logistics.production.dao;

import java.util.List;

import net.plang.logistics.production.to.PrmTO;

public interface PrmDAO {

    List<PrmTO> selectPrmList();

    void insertPrm(PrmTO prmTO);

}
