package kr.co.hong.common.util;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import oracle.jdbc.driver.OracleConnection;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
public class OracleCallBackHandler implements TypeHandler<Object> {
    Connection conn;

    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        // TODO Auto-generated method stub
        if (ps.getConnection().isWrapperFor(OracleConnection.class)) {
            this.conn = ps.getConnection().unwrap(OracleConnection.class);
        }
        ArrayDescriptor desc = ArrayDescriptor.createDescriptor("MPS_NO_ARRAY", conn);
        parameter = new ARRAY(desc, conn, (String[]) parameter);
        ps.setArray(i, (oracle.sql.ARRAY) parameter);
        System.out.println((oracle.sql.ARRAY) parameter);
        System.out.println(i);
    }
    @Override
    public Object getResult(ResultSet rs, String columnName) throws SQLException {
        // TODO Auto-generated method stub
        String value = "";
        try {
            if (StringUtils.isNotEmpty(rs.getString(columnName))) {
                value = new String(rs.getString(columnName).getBytes("8859_1"), "KSC5601");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return value;
    }
    @Override
    public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
        // TODO Auto-generated method stub
        System.out.println("columnIndex :: " + cs.getString(columnIndex));
        return cs.getString(columnIndex);
    }
    @Override
    public Object getResult(ResultSet arg0, int arg1) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
}
/*
 *
 *
 * package kr.co.hong.common.util;
 *
 * import java.sql.CallableStatement; import java.sql.Connection; import
 * java.sql.PreparedStatement; import java.sql.ResultSet; import
 * java.sql.SQLException;
 *
 * import org.apache.commons.lang.StringUtils; import
 * org.apache.ibatis.type.JdbcType; import org.apache.ibatis.type.TypeHandler;
 *
 *
 * import oracle.jdbc.driver.OracleConnection; import oracle.sql.ARRAY; import
 * oracle.sql.ArrayDescriptor; public class OracleCallBackHandler implements
 * TypeHandler<Object>{
 *
 *
 * Connection conn;
 *
 * @Override
 *
 * public Object getResult(ResultSet rs, String columnName) throws SQLException
 * {
 *
 * // TODO Auto-generated method stub
 *
 * String value = "";
 *
 * try {
 *
 * if(StringUtils.isNotEmpty(rs.getString(columnName))){
 *
 * value = new String(rs.getString(columnName).getBytes("8859_1") ,"KSC5601");
 *
 * }
 *
 * } catch (Exception e) {
 *
 * // TODO Auto-generated catch block
 *
 * e.printStackTrace();
 *
 * }
 *
 * //System.out.println("columnName :: " + value);
 *
 * return value;
 *
 * }
 *
 *
 *
 * @Override
 *
 * public Object getResult(CallableStatement cs, int columnIndex) throws
 * SQLException {
 *
 * // TODO Auto-generated method stub
 *
 * System.out.println("columnIndex :: " + cs.getString(columnIndex));
 *
 * return cs.getString(columnIndex);
 *
 * }
 *
 *
 *
 * @Override
 *
 * public void setParameter(PreparedStatement ps, int i, Object parameter,
 *
 * JdbcType arg3) throws SQLException {
 *
 *
 *
 *
 * //CommonsDbcpNativeJdbcExtractor extractor = new
 * CommonsDbcpNativeJdbcExtractor();
 *
 *
 * //extractor.getNativeConnection(ps.getConnection());
 *
 *
 * if (ps.getConnection().isWrapperFor(OracleConnection.class)) { this.conn =
 * ps.getConnection().unwrap(OracleConnection.class); }
 *
 * // TODO Auto-generated method stub
 *
 * ; ArrayDescriptor desc = ArrayDescriptor.createDescriptor("MPS_NO_ARRAY",
 * conn);
 *
 *
 * //parameter = new ARRAY(desc, conn, ((ArrayList) parameter).toArray());
 *
 * parameter = new ARRAY(desc, conn, (String[])parameter);
 *
 *
 *
 * ps.setArray(i, (oracle.sql.ARRAY)parameter);
 *
 * System.out.println((oracle.sql.ARRAY)parameter); System.out.println(i);
 *
 * }
 *
 *
 *
 * @Override public Object getResult(ResultSet arg0, int arg1) throws
 * SQLException { // TODO Auto-generated method stub return null; }
 *
 *
 * }
 */
