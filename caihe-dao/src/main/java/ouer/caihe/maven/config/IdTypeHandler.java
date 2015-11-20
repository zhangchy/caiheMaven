package ouer.caihe.maven.config;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.Alias;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DesUtil.DesUtil;

/**
 * 实体层的id主键使用String。本类则负责其间的可逆加密转换。
 * 
 * @author caihe
 */
@Alias("idHandler")
public final class IdTypeHandler extends BaseTypeHandler<String> {
	private static String desKey = "fxro45L7SYj6guWGV1csFi1imyV3dLeF";
	
	final static Logger log = LoggerFactory.getLogger(IdTypeHandler.class);
	public static void main(String[] args) {
		IdTypeHandler.desKey="fxro45L7SYj6guWGV1csFi1imyV3dLeF";
		System.out.println("==========================");
		System.out.println(IdTypeHandler.encode("1"));
		System.out.println("==========================");
	}

	/**
	 * 如果是特殊Id(空或者NULL)，则原值返回 
	 * @param s
	 * @return
	 */
	public static String encode(String s) {
		if (StringUtils.isBlank(s)) {
			return s;
		} else{
			String result = "";
	        try {
	        	result = DesUtil.encrypt(s,desKey);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
	        return result;
		}
	}

	/**
	 * 如果是特殊Id(空或者NULL)，则原值返回 
	 * @param s
	 * @return
	 */
	public static String decode(String s) {
		if (StringUtils.isBlank(s)) {
			return s;
		} else{
			String result = "";
	        try {
	        	result = DesUtil.decrypt(s,desKey);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
	        return result;
		}
	}

	//赋值不可空的 参数
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setString(i, decode(parameter));
	}
	//获取可空的 内容
	@Override
	public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
		final String l = rs.getString(columnName);
		return encode(l);
	}
	//获取可空的 内容
	@Override
	public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		final String s = rs.getString(columnIndex);
		return encode(s);
	}
	//获取可空的 内容
	@Override
	public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		final String s = cs.getString(columnIndex);
		return encode(s);
	}
	
}
