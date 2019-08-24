package xox.enity;
/***
 *技能类
 * @author 2014140053 谢辉
 *xox回合制对战游戏
 */

public class Skill {
	private int id;
	private String name;
	private int injury;//伤害
	public void setSkill(int id,String name,int injury) {
		this.id = id;
		this.name = name;
		this.injury = injury;
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
	public int getInjury() {
		return injury;
	}
	public void setInjury(int injury) {
		this.injury = injury;
	}
	
	
}
