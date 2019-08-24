package xox.view;
/***
 *主页面
 * @author 2014140053 谢辉
 *xox回合制对战游戏
 */

import java.util.Scanner;

import xox.connJdbc.UserJdbc;
import xox.enity.User;

public class MainFace {
	Scanner sc = new Scanner(System.in);
	UserJdbc uj = new UserJdbc();

	public void fist(){
		System.out.println("\txox人机对战游戏项目说明\n本游戏为xox基本功能实现版。\n"
				+ "相对加强版，没有加入装备功能，且数据存储在java的List集合中。\n"
				+ "仅供参考。"
				+ "\n由于本人鸟语不行，命名不太规范，也没时间注释，抱歉！！"
				+ "\n谢谢浏览——沧海青竹~天务\n\n");
		System.out.println("请选择（不同意：0或同意：1）：");
		int row = sc.nextInt();
		if(row == 1){
			fristFace();
		}else{
			System.out.println("程序中止。。。");
			System.exit(0);
		}
		
	}
	public void fristFace(){
		while(true){
			System.out.println("****************欢迎来到xox人机对战游戏首页****************\n\n");
			System.out.println("（账号登录，若无账号请先注册）！！！\n");
			System.out.println("1.登录");
			System.out.println("2.注册");
			System.out.println("3.退出");
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
				System.exit(0);
				break;
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
