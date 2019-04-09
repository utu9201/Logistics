package net.plang.base.dao;

import java.util.List;

import net.plang.base.to.CodeDetailTO;

public interface CodeDetailDAO {

    List<CodeDetailTO> selectCodeDetailList();
    // 상세코드 리스트 조회

    void insertDetailCode(CodeDetailTO codeDetailTO);

    void updateDetailCode(CodeDetailTO codeDetailTO);

    void deleteDetailCode(CodeDetailTO codeDetailTOt);


}
