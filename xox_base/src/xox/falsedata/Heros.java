package xox.falsedata;
/***
 *主函数
 * @author 2014140053 谢辉
 *xox回合制对战游戏
 */
/***
 *技能集合
 * @author 2014140053 谢辉
 *xox回合制对战游戏
 */

import java.util.ArrayList;
import java.util.List;

import xox.enity.Hero;
import xox.enity.Skill;
import xox.enity.User;

public class Heros {
	List<Hero> herolist = new ArrayList<Hero>();
	public List<Hero> heros(){
		Hero h1 = new Hero();
		Hero h2 = new Hero();
//		h.setHero(id, name, blood, skillList);
		List<Skill> sl1 = new ArrayList<Skill>();
		List<Skill> sl2 = new ArrayList<Skill>();
		Skill s1 = new Skill();
		Skill s2 = new Skill();
		Skill s3 = new Skill();
		Skill s4 = new Skill();
		Skill s5 = new Skill();
		Skill s6 = new Skill();
		Skill s7 = new Skill();
		Skill s8 = new Skill();
		
		s1.setSkill(1, "打狗一式", 100);
		sl1.add(s1);
		s2.setSkill(2, "打狗二式", 110);
		sl1.add(s2);
		s3.setSkill(3, "打狗三式", 150);
		sl1.add(s3);
		s4.setSkill(4, "横扫千军", 500);
		sl1.add(s4);
		h1.setHero(1, "沧海", 3000, sl1);
		herolist.add(h1);
		s5.setSkill(1, "降龙1式", 200);
		sl2.add(s5);
		s6.setSkill(2, "降龙5式", 150);
		sl2.add(s6);
		s7.setSkill(3, "降龙7式", 350);
		sl2.add(s7);
		s8.setSkill(4, "降龙9式", 500);
		sl2.add(s8);
		h2.setHero(2, "青竹", 3000, sl2);
		herolist.add(h2);
		return herolist;
	}
	
	
	
}
