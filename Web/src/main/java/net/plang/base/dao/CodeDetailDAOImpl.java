package net.plang.base.dao;

import java.util.List;

import net.plang.base.to.CodeDetailTO;
import net.plang.common.dao.IbatisSupportDAO;

public class CodeDetailDAOImpl extends IbatisSupportDAO implements CodeDetailDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<CodeDetailTO> selectCodeDetailList() {
        return (List<CodeDetailTO>) getSqlMapClientTemplate().queryForList("codeDetail.selectCodeDetailList");
    }

    @Override
    public void insertDetailCode(CodeDetailTO codeDetailTO) {
        getSqlMapClientTemplate().insert("codeDetail.insertDetailCode", codeDetailTO);
    }

    @Override
    public void updateDetailCode(CodeDetailTO codeDetailTO) {

        getSqlMapClientTemplate().update("codeDetail.updateDetailCode", codeDetailTO);
    }

    @Override
    public void deleteDetailCode(CodeDetailTO codeDetailTO) {
        getSqlMapClientTemplate().delete("codeDetail.deleteDetailCode", codeDetailTO);
    }

}
