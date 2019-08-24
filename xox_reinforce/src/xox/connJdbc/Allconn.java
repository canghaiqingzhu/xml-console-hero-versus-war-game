package xox.connJdbc;
/***
 * @author 2014140053 谢辉
 *xox回合制对战游戏_加强版
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.dom4j.*;
import org.dom4j.io.*;


public class Allconn {
	public Connection getConnection(){
		Connection conn = null;
		try {
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read("src/database.xml");
			Element root = document.getRootElement();
			Element mysql = (Element) root.elements("mysql").get(0);
			String DRIVER = mysql.element("driver").getText();
			String URL = mysql.element("url").getText();
			String USER = mysql.element("user").getText();
			String PWD = mysql.element("password").getText();
			Class.forName(DRIVER);
			conn = (Connection) DriverManager.getConnection(URL,USER,PWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public void closeAll(Connection conn,Statement pstmt,ResultSet rs){
		try{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
