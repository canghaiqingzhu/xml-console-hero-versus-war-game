package xox.enity;
/***
 *用户类
 * @author 2014140053 谢辉
 *xox回合制对战游戏
 */

public class User {
	private int id;
	private String name;
	private String password;
	
	public void setUser(int id,String name,String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
