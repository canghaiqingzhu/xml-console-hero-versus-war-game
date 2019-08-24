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
		System.out.println("�˻�id��"+u.getId()+"\t�� �ƣ�"+u.getName()+"\t ���룺"+u.getPassword()+"\n");
		System.out.println("****************ս��****************");
		while(true){
			System.out.println("1.��ս");
			System.out.println("2.ս��");
			System.out.println("3.�����ϲ�");
			System.out.println("��ѡ��1~3����");
			int row = sc.nextInt();
			switch (row) {
			case 1:
				System.out.println("-------------------��սҳ��-------------------");
				warlogin();
				System.out.println("-------------------�˳���ս-------------------\n------------------������ѡ��------------------");
				break;
			case 2:
				System.out.println("-------------------ս��ҳ��-------------------\n");
				warlog();
				System.out.println("\n\n-------------------�˳�ս��-------------------\n------------------������ѡ��------------------");
				break;
			case 3:
				System.out.println("****************�˳�ս��****************\n");
				System.out.println("---------------��ת��---------------");
				return;
			default:
				System.out.println("��!!!!!��Чѡ��!!!!!��");
				break;
			}
		}
	}
	private void warlogin() {
		while(true){
			System.out.println("1.�Զ���Ӣ��");
			System.out.println("2.���Ӣ��");
			System.out.println("3.�����ϲ�");
			System.out.println("��ѡ��1~3����");
			int x = sc.nextInt();
			switch (x){
			case 1:
				System.out.println("**********�Զ���Ӣ��**********\n������Ӣ������");
				String name = sc.next();
				System.out.println("�������Ӣ��Ѫ����");
				int blood = sc.nextInt();
				List<Skill> sl = new ArrayList<Skill>();
				
				Skill s1 = new Skill();
				System.out.println("�������Ӣ�� 1 ���������˺�ֵ��");
				int magicInjury1= sc.nextInt();
				System.out.println("�������Ӣ�� 1 ���ܷ����˺�ֵ��");
				s1.setSkill(1, "",magicInjury1, sc.nextInt());
				sl.add(s1);
				
				Skill s2 = new Skill();
				System.out.println("�������Ӣ�� 2 ���������˺�ֵ��");
				int magicInjury2= sc.nextInt();
				System.out.println("�������Ӣ��2 ���ܷ����˺�ֵ��");
				s2.setSkill(2,"",magicInjury2, sc.nextInt());
				sl.add(s2);
				
				Skill s3 = new Skill();
				System.out.println("�������Ӣ�� 3 ���������˺�ֵ��");
				int magicInjury3= sc.nextInt();
				System.out.println("�������Ӣ�� 3 ���ܷ����˺�ֵ��");
				s3.setSkill(3,"",magicInjury3, sc.nextInt());
				sl.add(s3);
				Skill s4 = new Skill();
				System.out.println("�������Ӣ�� 4���������˺�ֵ��");
				int magicInjury4= sc.nextInt();
				System.out.println("�������Ӣ�� 4 ���ܷ����˺�ֵ��");
				s4.setSkill(4,"",magicInjury4, sc.nextInt());
				sl.add(s4);
				Hero myhero = new Hero();
				myhero.setHero(name, blood, sl);
				Hero foehero = new Hero();
				foehero = randomHero();
				challage(myhero,foehero);
				break;
			case 2:
				System.out.println("**********���Ӣ��**********");
				Hero myh = new Hero();
				myh  = randomHero();
				Hero foeh = new Hero();
				foeh = randomHero();
				challage(myh,foeh);
				break;
			case 3:
				return;
			default:
				System.out.println("��!!!!!��Чѡ��!!!!!��");
				break;
			}
		}		
		
	}
	private void warlog() {
		List<HistoryLog> hl = new ArrayList<HistoryLog>();
		System.out.println("��ǰ��ѯid:"+u.getId());
		hl = hlj.select(u.getId());
		if(hl.size()==0){
			System.out.println("��!!!!!��δ�����ս!!!!!��");
		}else{
			System.out.println("�ҷ�Ӣ��\t�з�Ӣ��\t��ս���\t����ʱ��");
			for(int i = 0; i<hl.size();i++){
				System.out.print( hl.get(i).getMyHero()+"\t"+hl.get(i).getFoeHero()+"\t");
				if(hl.get(i).getResult()==1){
					System.out.print("ʤ��");
				}else{
					System.out.println("ʧ��");
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
		System.out.println("========��++"+myhero.getName()+" PK "+foehero.getName()+"++��========");
		boolean tf = false;
		int myAllInjury=0;
		int foeAllInjury=0;
		int result = 0;
		int skillnum = 0;
		ControlWeapon cw = new ControlWeapon();
		List<Weapon> weaponlist = cw.readWeapons();
		while(tf == false){
			System.out.println("�ҵ�Ӣ�ۣ�"+myhero.getName()+"\tѪ����"+myhero.getBlood()+"\t��ң�"+myhero.getMoney());
			System.out.println("�з�Ӣ�ۣ�"+foehero.getName()+"\tѪ����"+foehero.getBlood()+"\t��ң�"+foehero.getMoney());
			boolean ttf = false;
			System.out.println("�Ƿ���װ����(1�ǡ���0��):");
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
				System.out.println("*��ӵ��4�����ܣ�������1~4��ѡ���ͷ�ĳ���ܣ�");
				skillnum = sc.nextInt();
				if(skillnum > 0 && skillnum < 5){
					skillnum  = skillnum - 1;
					ttf = true;
				}else{
					System.out.println("�����ַ���Ч����");
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
				System.out.println("�Է�Ӣ�۷�ɧ��λ,����ҷ�Ӣ�۵Ľ�������");
			}else{
				if(myskill.get(skillnum).getName()==null || myskill.get(skillnum).getName()==""){
					System.out.println("--�ҷ�Ӣ�۶�"+foehero.getName()+"ʹ�������ؼ��ܣ������"+myAllInjury+"���˺���");
				}else{
					System.out.println("--�ҷ�Ӣ�۶�"+foehero.getName()+"ʹ����"+myskill.get(skillnum).getName()+"�������"+myAllInjury+"���˺���");
				}
				myhero.setMoney(addmoney(myAllInjury));
				foehero.setBlood(foehero.getBlood()-myAllInjury);
				myhero.setBlood(myhero.getBlood()+(int)(myAllInjury*myhero.getInjury().getSuckblood()));
			}
			
			if(foehero.getBlood() < 1){
				System.out.println("�ҷ�Ӣ�� "+myhero.getName()+":˳���߲���������������\n\t"+myhero.getName()+"��ʤ����");
				result = 1;
				tf=true;
			}else{
				System.out.println("\n*ע�⣬�Է���ʼ����������");
				if(myhero.getInjury().getDizziness()>myrandom(1)){
					System.out.println("�ҷ�Ӣ�۷�ɧ��λ,����Է�Ӣ�۵Ľ�������");
				}else{
					System.out.println("--�з�Ӣ��"+foehero.getName()+"���ҷ�Ӣ��ʹ����"+foeskill.get(xx).getName()+"�������"+foeAllInjury+"���˺���");
					foehero.setMoney(addmoney(foeAllInjury));
					myhero.setBlood(myhero.getBlood()-foeAllInjury);
					if(myhero.getBlood() < 1){
						System.out.println("�з�Ӣ�� "+foehero.getName()+":˳���߲���������������\n\t"+foehero.getName()+"��ʤ����");
						result = 0;
						tf=true;
					}
				}
			}
		}

		HistoryLogJdbc hlj = new HistoryLogJdbc();
		int a = hlj.insert(u.getId(),myhero.getName(), foehero.getName(), result);
		if(a>0){
			System.out.println("���ݱ���ɹ�����");
		}else{
			System.out.println("���ݱ���ʧ�ܣ���");
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
			System.out.println("�㵱ǰ�Ľ��Ϊ��"+moneys+"\n��ѡ����Ҫ���װ��id��");
			int choose = sc.nextInt();
			for(int i =0;i<cw.readWeapons().size();i++){
				if(choose==cw.readWeapons().get(i).getId()){
					if(moneys > cw.readWeapons().get(i).getMoney()){
						moneys = moneys - cw.readWeapons().get(i).getMoney();
						weaponList.add(cw.readWeapons().get(i));
						System.out.println("���׳ɹ�����");
					}else{
						System.out.println("���㣡������ȡ��");
					}
				}else{
					count++;
				}
			}
			if(count==cw.readWeapons().size()){
				System.out.println("װ�������ڣ���");
			}
			System.out.println("�Ƿ�������򣿣���1������0����");
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
		int physicalInjury=0;//�����˺�
		int physicalResist=0;//�������
		int magicInjury=0;//ħ���˺�
		int magicResist=0;//��������
		int addblood=0;//ÿ���ӻ�Ѫ��
		double dizziness=0.0;//ѣ�μ���
		double suckblood=0.0;//��Ѫ��
		int blood=0;//Ѫ��
		double addInjury=0.0;//����������
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
		int physicalInjury = (int)((skill.getPhysicalInjury()+weapon.getPhysicalInjury())*(1+hero.getPhysicalInjury()));//�����˺�
		int physicalResist = (int) ((weapon.getPhysicalResist())*(1+hero.getPhysicalResist()));//�������
		int magicInjury = (int)((skill.getMagicInjury()+weapon.getMagicInjury())*(1+hero.getMagicInjury()));//ħ���˺�
		int magicResist = (int)((weapon.getMagicResist())*(1+hero.getMagicResist()));//��������
		int addblood = weapon.getAddblood();//ÿ���ӻ�Ѫ��
		double dizziness = skill.getDizziness()+weapon.getDizziness();//ѣ�μ���
		double suckblood = skill.getSuckblood()+weapon.getSuckblood();//��Ѫ��
		int blood =hero.getBlood() + weapon.getBlood();//Ѫ��
		double addInjury = weapon.getAddInjury();//����������
		Injury injury = new Injury();
		injury.setInjury(physicalInjury, physicalResist, magicInjury, magicResist, addblood, dizziness, suckblood, blood, addInjury);
		return injury;
	}
}
