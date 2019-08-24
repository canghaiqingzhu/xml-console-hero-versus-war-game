package xox.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;







import xox.connJdbc.HistoryLogJdbc;
import xox.dataOther.ControlHero;
import xox.dataOther.ControlSkill;
import xox.dataOther.ControlWeapon;
import xox.enity.Hero;
import xox.enity.HistoryLog;
import xox.enity.Injury;
import xox.enity.Skill;
import xox.enity.User;
import xox.enity.Weapon;

public class AllActivityView {
	Scanner sc = new Scanner(System.in);
	HistoryLogJdbc hlj = new HistoryLogJdbc();
	private User u = new User();
	public void ActivityView(User user){
		this.u =user;
		chooseHero();
	}
	public void chooseHero(){
		System.out.println("账户id："+u.getId()+"\t名 称："+u.getName()+"\t 密码："+u.getPassword()+"\n");
		System.out.println("****************战场****************");
		while(true){
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
				return;
			default:
				System.out.println("【!!!!!无效选项!!!!!】");
				break;
			}
		}
	}
	private void warlogin() {
		while(true){
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
				System.out.println("请输入该英雄 1 技能物理伤害值：");
				int magicInjury1= sc.nextInt();
				System.out.println("请输入该英雄 1 技能法术伤害值：");
				s1.setSkill(1, "",magicInjury1, sc.nextInt());
				sl.add(s1);
				
				Skill s2 = new Skill();
				System.out.println("请输入该英雄 2 技能物理伤害值：");
				int magicInjury2= sc.nextInt();
				System.out.println("请输入该英雄2 技能法术伤害值：");
				s2.setSkill(2,"",magicInjury2, sc.nextInt());
				sl.add(s2);
				
				Skill s3 = new Skill();
				System.out.println("请输入该英雄 3 技能物理伤害值：");
				int magicInjury3= sc.nextInt();
				System.out.println("请输入该英雄 3 技能法术伤害值：");
				s3.setSkill(3,"",magicInjury3, sc.nextInt());
				sl.add(s3);
				Skill s4 = new Skill();
				System.out.println("请输入该英雄 4技能物理伤害值：");
				int magicInjury4= sc.nextInt();
				System.out.println("请输入该英雄 4 技能法术伤害值：");
				s4.setSkill(4,"",magicInjury4, sc.nextInt());
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
				return;
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
		List<Skill> skillList=new ArrayList<Skill>();
		ControlHero ch = new ControlHero();
		h = ch.readHeres().get(myrandom(ch.readHeres().size()));
		ControlSkill cs = new ControlSkill();
		for(int i = 0 ; i < 4 ; i++){
			Skill s=new Skill();
			do{
				int randomnum = myrandom(cs.readSkills().size()),i2=0;
				for(int j=0;j<skillList.size();j++){
					if(randomnum!=skillList.get(j).getId()){
						i2++;
					}
				}
				if(i2==skillList.size()){
					s=cs.readSkills().get(randomnum);
					break;
				}
			}while(true);
			skillList.add(s);
		}
		h.setSkillList(skillList);
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
		System.out.println("========【++"+myhero.getName()+" PK "+foehero.getName()+"++】========");
		boolean tf = false;
		int myAllInjury=0;
		int foeAllInjury=0;
		int result = 0;
		int skillnum = 0;
		ControlWeapon cw = new ControlWeapon();
		List<Weapon> weaponlist = cw.readWeapons();
		while(tf == false){
			System.out.println("我的英雄："+myhero.getName()+"\t血量："+myhero.getBlood()+"\t金币："+myhero.getMoney());
			System.out.println("敌方英雄："+foehero.getName()+"\t血量："+foehero.getBlood()+"\t金币："+foehero.getMoney());
			boolean ttf = false;
			System.out.println("是否购买装备？(1是《》0否):");
			int adwe = sc.nextInt();
			if(adwe==1){
				Hero heromy = addWeaponToHero(myhero.getMoney());
				myhero.setMoney(heromy.getMoney());
				myhero.setWeaponList(heromy.getWeaponList());
			}	
//			Hero herofoe = addWeaponToHeroRandom(foehero.getMoney());
//			foehero.setMoney(herofoe.getMoney());
//			foehero.setWeaponList(herofoe.getWeaponList());
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
			myhero.setInjury(returnInjury(myhero,myskill.get(skillnum),addWeapon(myhero.getWeaponList(),myhero.getIntelligence())));
			myhero.setBlood(myhero.getInjury().getBlood()+myhero.getInjury().getAddblood());
			int xx = myrandom(4);
			foehero.setInjury(returnInjury(foehero,foeskill.get(xx),addWeapon(foehero.getWeaponList(),foehero.getIntelligence())));
			foehero.setBlood(foehero.getInjury().getBlood()+foehero.getInjury().getAddblood());
			
			myAllInjury=(int)((myhero.getInjury().getPhysicalInjury()-foehero.getInjury().getMagicResist()+myhero.getInjury().getMagicInjury()-foehero.getInjury().getMagicResist())*(1+myhero.getInjury().getAddInjury()));
			foeAllInjury=(int)((foehero.getInjury().getPhysicalInjury()-myhero.getInjury().getMagicResist()+foehero.getInjury().getMagicInjury()-myhero.getInjury().getMagicResist())*(1+foehero.getInjury().getAddInjury()));
			
			if(foehero.getInjury().getDizziness()>myrandom(1)){
				System.out.println("对方英雄风骚走位,躲过我方英雄的进攻！！");
			}else{
				if(myskill.get(skillnum).getName()==null || myskill.get(skillnum).getName()==""){
					System.out.println("--我方英雄对"+foehero.getName()+"使用了神秘技能，造成了"+myAllInjury+"点伤害！");
				}else{
					System.out.println("--我方英雄对"+foehero.getName()+"使用了"+myskill.get(skillnum).getName()+"，造成了"+myAllInjury+"点伤害！");
				}
				myhero.setMoney(addmoney(myAllInjury));
				foehero.setBlood(foehero.getBlood()-myAllInjury);
				myhero.setBlood(myhero.getBlood()+(int)(myAllInjury*myhero.getInjury().getSuckblood()));
			}
			
			if(foehero.getBlood() < 1){
				System.out.println("我方英雄 "+myhero.getName()+":顺我者昌，逆我者亡！！\n\t"+myhero.getName()+"获胜！！");
				result = 1;
				tf=true;
			}else{
				System.out.println("\n*注意，对方开始反击！！！");
				if(myhero.getInjury().getDizziness()>myrandom(1)){
					System.out.println("我方英雄风骚走位,躲过对方英雄的进攻！！");
				}else{
					System.out.println("--敌方英雄"+foehero.getName()+"对我方英雄使用了"+foeskill.get(xx).getName()+"，造成了"+foeAllInjury+"点伤害！");
					foehero.setMoney(addmoney(foeAllInjury));
					myhero.setBlood(myhero.getBlood()-foeAllInjury);
					if(myhero.getBlood() < 1){
						System.out.println("敌方英雄 "+foehero.getName()+":顺我者昌，逆我者亡！！\n\t"+foehero.getName()+"获胜！！");
						result = 0;
						tf=true;
					}
				}
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
	
	private Hero addWeaponToHeroRandom(int money) {
		int moneys = money;
		List<Weapon> weaponList = new ArrayList<Weapon>();
		ControlWeapon cw = new ControlWeapon();
		cw.readWeapon();
		for(int i =0;i<cw.readWeapons().size();i++){
			if(moneys > cw.readWeapons().get(i).getMoney()){
				moneys = moneys - cw.readWeapons().get(i).getMoney();
				weaponList.add(cw.readWeapons().get(i));
			}
		}
		Hero h = new Hero();
		h.setMoney(moneys);
		h.setWeaponList(weaponList);
		return h;
	}
	private Hero addWeaponToHero(int money) {
		int moneys = money;
		List<Weapon> weaponList = new ArrayList<Weapon>();
		ControlWeapon cw = new ControlWeapon();
		cw.readWeapon();
		do{
			int count=0;
			System.out.println("你当前的金额为："+moneys+"\n请选择你要买的装备id：");
			int choose = sc.nextInt();
			for(int i =0;i<cw.readWeapons().size();i++){
				if(choose==cw.readWeapons().get(i).getId()){
					if(moneys > cw.readWeapons().get(i).getMoney()){
						moneys = moneys - cw.readWeapons().get(i).getMoney();
						weaponList.add(cw.readWeapons().get(i));
						System.out.println("交易成功！！");
					}else{
						System.out.println("金额不足！！交易取消");
					}
				}else{
					count++;
				}
			}
			if(count==cw.readWeapons().size()){
				System.out.println("装备不存在！！");
			}
			System.out.println("是否结束购买？（是1《》否0）：");
			int tf = sc.nextInt();
			if(tf==0){
				break;
			}
		}while(true);
		Hero h = new Hero();
		h.setMoney(moneys);
		h.setWeaponList(weaponList);
		return h;
	}
	public int addmoney(int injury){
		if(injury<100){
			return 50;
		}else if(injury<200){
			return 100;
		}else if(injury<300){
			return 150;
		}else if(injury<400){
			return 200;
		}else if(injury<500){
			return 250;
		}else{
			return 300;
		}
	}
	
	
	public Weapon addWeapon(List<Weapon> weaponlist,int intelligence){
		Weapon weapon = new Weapon();
		int physicalInjury=0;//物理伤害
		int physicalResist=0;//物理防御
		int magicInjury=0;//魔法伤害
		int magicResist=0;//法术防御
		int addblood=0;//每分钟回血量
		double dizziness=0.0;//眩晕几率
		double suckblood=0.0;//吸血率
		int blood=0;//血量
		double addInjury=0.0;//属性提升率
		if(weaponlist!=null){
			for(int i=0;i < weaponlist.size();i++){
				physicalInjury=physicalInjury+weaponlist.get(i).getPhysicalInjury();
				physicalResist=physicalResist+weaponlist.get(i).getPhysicalResist();
				magicInjury=magicInjury+weaponlist.get(i).getMagicInjury();
				magicResist=magicResist+weaponlist.get(i).getMagicResist();
				addblood=addblood+weaponlist.get(i).getAddblood();
				dizziness=dizziness+weaponlist.get(i).getDizziness();
				suckblood=suckblood+weaponlist.get(i).getSuckblood();
				blood=blood+weaponlist.get(i).getBlood();
				if(weaponlist.get(i).getAddInjury()>intelligence){
					addInjury=addInjury+0.1;
				}
			}
		
		}
		weapon.setWeapon(physicalInjury, physicalResist, magicInjury, magicResist, addblood, dizziness, suckblood, blood, addInjury);
		return weapon;
	}
	
	public Injury returnInjury(Hero hero,Skill skill,Weapon weapon){
		int physicalInjury = (int)((skill.getPhysicalInjury()+weapon.getPhysicalInjury())*(1+hero.getPhysicalInjury()));//物理伤害
		int physicalResist = (int) ((weapon.getPhysicalResist())*(1+hero.getPhysicalResist()));//物理防御
		int magicInjury = (int)((skill.getMagicInjury()+weapon.getMagicInjury())*(1+hero.getMagicInjury()));//魔法伤害
		int magicResist = (int)((weapon.getMagicResist())*(1+hero.getMagicResist()));//法术防御
		int addblood = weapon.getAddblood();//每分钟回血量
		double dizziness = skill.getDizziness()+weapon.getDizziness();//眩晕几率
		double suckblood = skill.getSuckblood()+weapon.getSuckblood();//吸血率
		int blood =hero.getBlood() + weapon.getBlood();//血量
		double addInjury = weapon.getAddInjury();//属性提升率
		Injury injury = new Injury();
		injury.setInjury(physicalInjury, physicalResist, magicInjury, magicResist, addblood, dizziness, suckblood, blood, addInjury);
		return injury;
	}
}
