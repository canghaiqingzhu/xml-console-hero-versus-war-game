package xox.view;
/***
 * @author 2014140053 谢辉
 *xox回合制对战游戏_加强版
 */
import java.util.Scanner;

import xox.connJdbc.UserJdbc;
import xox.dataOther.ControlHero;
import xox.dataOther.ControlSkill;
import xox.dataOther.ControlWeapon;
import xox.enity.User;

public class MainFace {
	Scanner sc = new Scanner(System.in);
	UserJdbc uj = new UserJdbc();
	
	public void fist(){
		System.out.println("\txox人机对战游戏项目说明\n本游戏为xox加强版，相对于【xox基本功能实现版】而言，加强版添加了装备购买技能。\n"
				+ "并且实现本地英雄、技能、装备利用xml的存入，保证数据不会丢失。\n"
				+ "相对低版本，高版本数据类结构进行了调整，但游戏仍存在不足，比如说输入值的限制。"
				+ "\n谢谢——沧海青竹天务\n\n");
		System.out.println("请选择（不同意：0或同意：1）：");
		int row = sc.nextInt();
		if(row == 1){
			chooseface();
		}else{
			System.out.println("程序中止。。。");
			System.exit(0);
		}
		
	}
	
	public void chooseface(){
		while(true){
			System.out.println("***************!!!请选择界面!!!***************");
			System.out.println("1.xox人机对战游戏首页");
			System.out.println("2.编辑本地英雄");
			System.out.println("3.编辑本地技能");
			System.out.println("4.编辑本地装备");
			System.out.println("5.退出程序");
			System.out.println("请选择（1~3）：");
			int row = sc.nextInt();
			switch (row) {
			case 1:
				fristFace();
				break;
			case 2:
				ControlHero ch = new ControlHero();
				ch.heroface();
				break;
			case 3:
				ControlSkill cs = new ControlSkill();
				cs.skillface();
				break;
			case 4:
				ControlWeapon cw = new ControlWeapon();
				cw.weaponface();
				break;
			case 5:
				System.out.println("程序中止。。。");
				System.exit(0);
				break;
			default:
				System.out.println("【!!!!!无效选项!!!!!]");
				break;
			}
		}
	}
	public void fristFace(){
		while(true){
			System.out.println("****************欢迎来到xox人机对战游戏首页****************\n\n");
			System.out.println("（账号登录，若无账号请先注册）！！！\n");
			System.out.println("1.登录");
			System.out.println("2.注册");
			System.out.println("3.返回");
			System.out.println("请选择（1~3）：");
			int row = sc.nextInt();
			switch (row) {
			case 1:
				System.out.println("---------------登录页面---------------");
				loginFace();
				break;
			case 2:
				System.out.println("---------------注册页面---------------");
				registerFace();
				break;
			case 3:
				System.out.println("***************再见！期待再来xox人机对战游戏***************\n\n");
				return;
			default:
				System.out.println("【!!!!!无效选项!!!!!]");
				break;
			}
		}
	}
	private void loginFace() {
		User u = new User();
		boolean tf = false;
		int id=0;
		String name = null,password=null;
		do{
			System.out.println("是否选择ID登录？(1是/0否  请输入0~1)");
			String selectif = sc.next();
			if(selectif.equals("1")){
				System.out.println("请输入你的ID:");
				id = sc.nextInt();
				tf=true;
			}else if(selectif.equals("0")){
				System.out.println("请输入你的账号名:");
				name = sc.next();
				tf=true;
			}else{
				System.out.println("【!!!!!无效选项!!!!!】\n\n");
			}
		}while(tf==false);
		System.out.println("请输入你的密码:");
		password = sc.next();
		if(name==null){
			u = uj.loginId(id,password);
		}else{
			u = uj.loginName(name,password);
		}
		if(u.getName()==null){
			System.out.println("【！！！用户不存在或输入有误！！！】");
		}else{
			System.out.println("!!!!!【"+u.getName()+"】登陆成功!!!!!\n");
			AllActivityView aav = new AllActivityView();
			aav.ActivityView(u);
		}
	}
	private void registerFace() {
		System.out.println("请输入账号名:");
		String name = sc.next();
		System.out.println("请输入你的密码:");
		String password = sc.next();
		int t = uj.insert(name,password);
		if(t>0){
			System.out.println("【！！注册成功！！】");
		}else{
			System.out.println("【！！注册失败！！】");
		}
	}
}
