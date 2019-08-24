package xox.connJdbc;
/***
 *对战记录控制
 * @author 2014140053 谢辉
 *xox回合制对战游戏
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xox.enity.HistoryLog;


public class HistoryLogJdbc {
	Allconn ac = new Allconn();
	List<HistoryLog> hllist = null;
	
//	Connection  conn = null;
	PreparedStatement ps = null;
	ResultSet rs=null;
	StringBuffer sql = null;
	public int insert(int id,String myhero,String foehero,int result){
		int row = 0;
		Connection conn = ac.getConnection();
		sql = new StringBuffer();
		sql.append("insert xox_historylog(xh_uid,xh_myhero,xh_foehero,xh_result,xh_Time) ");
		sql.append(" values (?,?,?,?,now()) ");
		try {
			ps = conn.prepareStatement(sql.toString());
			ps.setObject(1,id);
			ps.setObject(2,myhero);
			ps.setObject(3,foehero);
			ps.setObject(4,result);
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ac.closeAll(conn, ps,rs);
		}
		return row;
	}
	public List<HistoryLog> select(int uid){
		hllist = new ArrayList<HistoryLog>();
		Connection conn = ac.getConnection();
		sql = new StringBuffer();
		sql.append("select * from xox_historylog ");
		sql.append(" where xh_uid = ? ");
		try {
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, uid);
//			ps.setObject(1,uid);
			rs = ps.executeQuery();
			while(rs.next()){
				HistoryLog hl =new HistoryLog();
				hl.setHistoryLog(rs.getInt("xh_id"), rs.getInt("xh_uid"), rs.getString("xh_myhero"), rs.getString("xh_foehero"), rs.getInt("xh_result"), rs.getString("xh_Time"));
				hllist.add(hl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ac.closeAll(conn, ps,rs);
		}
		return hllist;
	}
}
