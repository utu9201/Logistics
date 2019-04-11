package net.plang.base.dao;

import java.util.List;

import net.plang.base.to.CodeTO;

public interface CodeDAO {

    List<CodeTO> selectCodeList();
    // 코드 리스트 조회

    String getSerialCode(String findSeq);

}
