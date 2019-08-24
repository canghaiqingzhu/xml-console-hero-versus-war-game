package xox.enity;
/***
 *英雄类
 * @author 2014140053 谢辉
 *xox回合制对战游戏
 */

import java.util.List;

public class Hero {
	private int id;
	private String name;
	private int blood;//血量
	private List<Skill> skillList;//技能集
	
	public void setHero(String name,int blood,List<Skill> skillList) {
		this.name = name;
		this.blood = blood;
		this.skillList = skillList;
	}
	
	public void setHero(int id,String name,int blood,List<Skill> skillList) {
		this.id = id;
		this.name = name;
		this.blood = blood;
		this.skillList = skillList;
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
	public int getBlood() {
		return blood;
	}
	public void setBlood(int blood) {
		this.blood = blood;
	}
	public List<Skill> getSkillList() {
		return skillList;
	}
	public void setSkillList(List<Skill> skillList) {
		this.skillList = skillList;
	}
	
	
}
