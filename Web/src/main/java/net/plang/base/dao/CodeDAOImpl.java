package net.plang.base.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.plang.base.to.CodeTO;
import net.plang.common.dao.IbatisSupportDAO;

public class CodeDAOImpl extends IbatisSupportDAO implements CodeDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<CodeTO> selectCodeList() {

        return (List<CodeTO>) getSqlMapClientTemplate().queryForList("base.selectCodeList");
    }

    @Override
    public String takeSerialCode(String findSeq) {
        Map<String, Object> map = new HashMap<>();

        map.put("findSeq", findSeq);
        return (String) getSqlMapClientTemplate().queryForObject("base.takeSerialCode", map);
    }

}
