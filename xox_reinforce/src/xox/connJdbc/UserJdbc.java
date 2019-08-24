package xox.connJdbc;
/***
 * @author 2014140053 谢辉
 *xox回合制对战游戏_加强版
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import xox.enity.User;

public class UserJdbc {
	Allconn ac = new Allconn();
	Connection  conn = ac.getConnection();
	PreparedStatement ps = null;
	ResultSet rs=null;
	StringBuffer sql = null;
	User u = null;
	public User loginName(String name,String password){
		u = new User();
		sql = new StringBuffer();
		sql.append("select * from xox_user ");
		sql.append(" where xu_username = ? ");
		sql.append(" and xu_password = ? ");
		try {
			ps = conn.prepareStatement(sql.toString());
			ps.setObject(1,name);
			ps.setObject(2,password);
			rs = ps.executeQuery();
			if(rs.next()){
				u.setUser(rs.getInt("xu_id"),rs.getString("xu_username"),rs.getString("xu_password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ac.closeAll(conn, ps,null);
		}
		return u;
	}
	public User loginId(int id,String password){
		u = new User();
		sql = new StringBuffer();
		sql.append("select * from xox_user ");
		sql.append(" where xu_id = ? ");
		sql.append(" and xu_password = ? ");
		try {
			ps = conn.prepareStatement(sql.toString());
			ps.setObject(1,id);
			ps.setObject(2,password);
			rs = ps.executeQuery();
			if(rs.next()){
				u.setUser(rs.getInt("xu_id"),rs.getString("xu_username"),rs.getString("xu_password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ac.closeAll(conn, ps,null);
		}
		return u;
	}
	public int insert(String name,String password){
		int row = 0;
		sql = new StringBuffer();
		sql.append("insert xox_user(xu_username,xu_password) ");
		sql.append(" values (?,?) ");
		try {
			ps = conn.prepareStatement(sql.toString());
			ps.setObject(1,name);
			ps.setObject(2,password);
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ac.closeAll(conn, ps,null);
		}
		return row;
	}
}
