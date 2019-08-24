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
 *��ս����
 * @author 2014140053 л��
 *xox�غ��ƶ�ս��Ϸ
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
		System.out.println("�˻�id��"+u.getId()+"\t�� �ƣ�"+u.getName()+"\t ���룺"+u.getPassword()+"\n");
		
		System.out.println("****************ս��****************");
		while(t==false){
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
				t=true;
				break;
			default:
				System.out.println("��!!!!!��Чѡ��!!!!!��");
				break;
			}
		}
	}
	private void warlogin() {
		boolean tt = false;
		while(tt==false){
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
				System.out.println("�������Ӣ�� 1 �����˺�ֵ��");
				s1.setSkill(1, "", sc.nextInt());
				sl.add(s1);
				Skill s2 = new Skill();
				System.out.println("�������Ӣ�� 2 �����˺�ֵ��");
				s2.setSkill(2, "", sc.nextInt());
				sl.add(s2);
				Skill s3 = new Skill();
				System.out.println("�������Ӣ�� 3 �����˺�ֵ��");
				s3.setSkill(3, "", sc.nextInt());
				sl.add(s3);
				Skill s4 = new Skill();
				System.out.println("�������Ӣ�� 4 �����˺�ֵ��");
				s4.setSkill(4, "", sc.nextInt());
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
				tt=true;
				break;
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
		System.out.println("�ҵ�Ӣ�ۣ�"+h1.getName()+"\tѪ����"+h1.getBlood());
		System.out.println("�з�Ӣ�ۣ�"+h2.getName()+"\tѪ����"+h2.getBlood());
		System.out.println("========��++"+myhero.getName()+" PK "+foehero.getName()+"++��========");
		boolean tf = false;
		int result = 0;
		int skillnum = 0;
		while(tf == false){
			boolean ttf = false;
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
			if(myskill.get(skillnum).getName()==null || myskill.get(skillnum).getName()==""){
				System.out.println("--�ҷ�Ӣ�۶�"+foehero.getName()+"ʹ�������ؼ��ܣ������"+myskill.get(skillnum).getInjury()+"���˺���");
			}else{
				System.out.println("--�ҷ�Ӣ�۶�"+foehero.getName()+"ʹ����"+myskill.get(skillnum).getName()+"�������"+myskill.get(skillnum).getInjury()+"���˺���");
			}
			foehero.setBlood(foehero.getBlood()-myskill.get(skillnum).getInjury());
			System.out.println("\n*ע�⣬�Է���ʼ����������");
			int xx = myrandom(4);
			System.out.println("--�з�Ӣ��"+foehero.getName()+"���ҷ�Ӣ��ʹ����"+foeskill.get(xx).getName()+"�������"+foeskill.get(xx).getInjury()+"���˺���");
			myhero.setBlood(myhero.getBlood()-foeskill.get(xx).getInjury());
			System.out.println("\n"+myhero.getName()+"Ѫ����"+myhero.getBlood()+">-------<"+foehero.getName()+"Ѫ����"+foehero.getBlood()+"\n");

			if(myhero.getBlood() < 1 || foehero.getBlood() < 1){
				if(foehero.getBlood() < 1){
					System.out.println(myhero.getName()+":˳���߲���������������\n\t"+myhero.getName()+"��ʤ����");
					result = 1;
				}else{
					System.out.println(foehero.getName()+":Ψ�Ҷ����������棡��\n\t"+foehero.getName()+"��ʤ����");
				}
				tf=true;
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
}
