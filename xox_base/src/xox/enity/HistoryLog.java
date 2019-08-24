package xox.enity;
/***
 *对战记录类
 * @author 2014140053 谢辉
 *xox回合制对战游戏
 */

public class HistoryLog {
	private int id;
	private int uid;
	private String myHero;
	private String foeHero;
	private int result;
	private String pkTime;
	
	public void setHistoryLog(int id,int uid,String myHero,String foeHero,int result,String pkTime) {
		this.id = id;
		this.uid = uid;
		this.myHero = myHero;
		this.foeHero = foeHero;
		this.result = result;
		this.pkTime = pkTime;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getMyHero() {
		return myHero;
	}
	public void setMyHero(String myHero) {
		this.myHero = myHero;
	}
	public String getFoeHero() {
		return foeHero;
	}
	public void setFoeHero(String foeHero) {
		this.foeHero = foeHero;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getPkTime() {
		return pkTime;
	}
	public void setPkTime(String pkTime) {
		this.pkTime = pkTime;
	}
	
	
}
