package xox.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


import xox.connJdbc.HistoryLogJdbc;
import xox.enity.Hero;
import xox.enity.HistoryLog;
import xox.enity.Skill;
import xox.enity.User;
import xox.falsedata.Heros;
/***
 *对战界面
 * @author 2014140053 谢辉
 *xox回合制对战游戏
 */

public class AllActivityView {
	Scanner sc = new Scanner(System.in);
	HistoryLogJdbc hlj = new HistoryLogJdbc();
	private User u = new User();
	public void ActivityView(User user){
		this.u =user;
		chooseHero();
	}
	public void chooseHero(){
		boolean t = false;
		System.out.println("账户id："+u.getId()+"\t名 称："+u.getName()+"\t 密码："+u.getPassword()+"\n");
		
		System.out.println("****************战场****************");
		while(t==false){
			System.out.println("1.对战");
			System.out.println("2.战绩");
			System.out.println("3.返回上层");
			System.out.println("请选择（1~3）：");
			int row = sc.nextInt();
			switch (row) {
			case 1:
				System.out.println("-------------------对战页面-------------------");
				warlogin();
				System.out.println("-------------------退出对战-------------------\n------------------请重新选择------------------");
				break;
			case 2:
				System.out.println("-------------------战绩页面-------------------\n");
				warlog();
				System.out.println("\n\n-------------------退出战绩-------------------\n------------------请重新选择------------------");
				break;
			case 3:
				System.out.println("****************退出战场****************\n");
				System.out.println("---------------跳转中---------------");
				t=true;
				break;
			default:
				System.out.println("【!!!!!无效选项!!!!!】");
				break;
			}
		}
	}
	private void warlogin() {
		boolean tt = false;
		while(tt==false){
			System.out.println("1.自定义英雄");
			System.out.println("2.随机英雄");
			System.out.println("3.返回上层");
			System.out.println("请选择（1~3）：");
			int x = sc.nextInt();
			switch (x){
			case 1:
				System.out.println("**********自定义英雄**********\n请输入英雄名：");
				String name = sc.next();
				System.out.println("请输入该英雄血量：");
				int blood = sc.nextInt();
				
				List<Skill> sl = new ArrayList<Skill>();
				Skill s1 = new Skill();
				System.out.println("请输入该英雄 1 技能伤害值：");
				s1.setSkill(1, "", sc.nextInt());
				sl.add(s1);
				Skill s2 = new Skill();
				System.out.println("请输入该英雄 2 技能伤害值：");
				s2.setSkill(2, "", sc.nextInt());
				sl.add(s2);
				Skill s3 = new Skill();
				System.out.println("请输入该英雄 3 技能伤害值：");
				s3.setSkill(3, "", sc.nextInt());
				sl.add(s3);
				Skill s4 = new Skill();
				System.out.println("请输入该英雄 4 技能伤害值：");
				s4.setSkill(4, "", sc.nextInt());
				sl.add(s4);
				Hero myhero = new Hero();
				myhero.setHero(name, blood, sl);
				Hero foehero = new Hero();
				foehero = randomHero();
				challage(myhero,foehero);
				break;
			case 2:
				System.out.println("**********随机英雄**********");
				Hero myh = new Hero();
				myh  = randomHero();
				Hero foeh = new Hero();
				foeh = randomHero();
				challage(myh,foeh);
				break;
			case 3:
				tt=true;
				break;
			default:
				System.out.println("【!!!!!无效选项!!!!!】");
				break;
			}
		}		
		
	}
	private void warlog() {
		List<HistoryLog> hl = new ArrayList<HistoryLog>();
		System.out.println("当前查询id:"+u.getId());
		hl = hlj.select(u.getId());
		if(hl.size()==0){
			System.out.println("【!!!!!尚未参与对战!!!!!】");
		}else{
			System.out.println("我方英雄\t敌方英雄\t对战情况\t结束时间");
			for(int i = 0; i<hl.size();i++){
				System.out.print( hl.get(i).getMyHero()+"\t"+hl.get(i).getFoeHero()+"\t");
				if(hl.get(i).getResult()==1){
					System.out.print("胜利");
				}else{
					System.out.println("失败");
				}
				System.out.println("\t" +hl.get(i).getPkTime());
			}
		}
	}
	public int myrandom(int t){
		int x = (int) (Math.random()*t);
		return x;
	}
	public Hero randomHero(){
		Hero h = new Hero();
		Heros hs = new Heros();
		h = hs.heros().get(myrandom(hs.heros().size()));
		return h;
	}

	public void challage(Hero h1,Hero h2) {
		Hero myhero = new Hero();
		List<Skill> myskill = new ArrayList<Skill>();
		myhero = h1;
		myskill = h1.getSkillList();
		Hero foehero= new Hero();
		List<Skill> foeskill = new ArrayList<Skill>();
		foehero = h2;
		foeskill = h2.getSkillList();
		System.out.println("我的英雄："+h1.getName()+"\t血量："+h1.getBlood());
		System.out.println("敌方英雄："+h2.getName()+"\t血量："+h2.getBlood());
		System.out.println("========【++"+myhero.getName()+" PK "+foehero.getName()+"++】========");
		boolean tf = false;
		int result = 0;
		int skillnum = 0;
		while(tf == false){
			boolean ttf = false;
			do{
				System.out.println("*你拥有4个技能，请输入1~4，选择释放某技能！");
				skillnum = sc.nextInt();
				if(skillnum > 0 && skillnum < 5){
					skillnum  = skillnum - 1;
					ttf = true;
				}else{
					System.out.println("输入字符无效！！");
				}
			}while(ttf = false);
			if(myskill.get(skillnum).getName()==null || myskill.get(skillnum).getName()==""){
				System.out.println("--我方英雄对"+foehero.getName()+"使用了神秘技能，造成了"+myskill.get(skillnum).getInjury()+"点伤害！");
			}else{
				System.out.println("--我方英雄对"+foehero.getName()+"使用了"+myskill.get(skillnum).getName()+"，造成了"+myskill.get(skillnum).getInjury()+"点伤害！");
			}
			foehero.setBlood(foehero.getBlood()-myskill.get(skillnum).getInjury());
			System.out.println("\n*注意，对方开始反击！！！");
			int xx = myrandom(4);
			System.out.println("--敌方英雄"+foehero.getName()+"对我方英雄使用了"+foeskill.get(xx).getName()+"，造成了"+foeskill.get(xx).getInjury()+"点伤害！");
			myhero.setBlood(myhero.getBlood()-foeskill.get(xx).getInjury());
			System.out.println("\n"+myhero.getName()+"血量："+myhero.getBlood()+">-------<"+foehero.getName()+"血量："+foehero.getBlood()+"\n");

			if(myhero.getBlood() < 1 || foehero.getBlood() < 1){
				if(foehero.getBlood() < 1){
					System.out.println(myhero.getName()+":顺我者昌，逆我者亡！！\n\t"+myhero.getName()+"获胜！！");
					result = 1;
				}else{
					System.out.println(foehero.getName()+":唯我独尊，孰与争锋！！\n\t"+foehero.getName()+"获胜！！");
				}
				tf=true;
			}
		}
		HistoryLogJdbc hlj = new HistoryLogJdbc();
		int a = hlj.insert(u.getId(),myhero.getName(), foehero.getName(), result);
		if(a>0){
			System.out.println("数据保存成功！！");
		}else{
			System.out.println("数据保存失败！！");
		}

	}
}
