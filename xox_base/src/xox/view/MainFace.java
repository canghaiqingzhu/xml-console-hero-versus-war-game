package xox.view;
/***
 *��ҳ��
 * @author 2014140053 л��
 *xox�غ��ƶ�ս��Ϸ
 */

import java.util.Scanner;

import xox.connJdbc.UserJdbc;
import xox.enity.User;

public class MainFace {
	Scanner sc = new Scanner(System.in);
	UserJdbc uj = new UserJdbc();

	public void fist(){
		System.out.println("\txox�˻���ս��Ϸ��Ŀ˵��\n����ϷΪxox��������ʵ�ְ档\n"
				+ "��Լ�ǿ�棬û�м���װ�����ܣ������ݴ洢��java��List�����С�\n"
				+ "�����ο���"
				+ "\n���ڱ������ﲻ�У�������̫�淶��Ҳûʱ��ע�ͣ���Ǹ����"
				+ "\nлл��������׺�����~����\n\n");
		System.out.println("��ѡ�񣨲�ͬ�⣺0��ͬ�⣺1����");
		int row = sc.nextInt();
		if(row == 1){
			fristFace();
		}else{
			System.out.println("������ֹ������");
			System.exit(0);
		}
		
	}
	public void fristFace(){
		while(true){
			System.out.println("****************��ӭ����xox�˻���ս��Ϸ��ҳ****************\n\n");
			System.out.println("���˺ŵ�¼�������˺�����ע�ᣩ������\n");
			System.out.println("1.��¼");
			System.out.println("2.ע��");
			System.out.println("3.�˳�");
			System.out.println("��ѡ��1~3����");
			int row = sc.nextInt();
			switch (row) {
			case 1:
				System.out.println("---------------��¼ҳ��---------------");
				loginFace();
				break;
			case 2:
				System.out.println("---------------ע��ҳ��---------------");
				registerFace();
				break;
			case 3:
				System.out.println("***************�ټ����ڴ�����xox�˻���ս��Ϸ***************\n\n");
				System.exit(0);
				break;
			default:
				System.out.println("��!!!!!��Чѡ��!!!!!]");
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
			System.out.println("�Ƿ�ѡ��ID��¼��(1��/0��  ������0~1)");
			String selectif = sc.next();
			if(selectif.equals("1")){
				System.out.println("���������ID:");
				id = sc.nextInt();
				tf=true;
			}else if(selectif.equals("0")){
				System.out.println("����������˺���:");
				name = sc.next();
				tf=true;
			}else{
				System.out.println("��!!!!!��Чѡ��!!!!!��\n\n");
			}
		}while(tf==false);
		System.out.println("�������������:");
		password = sc.next();
		if(name==null){
			u = uj.loginId(id,password);
		}else{
			u = uj.loginName(name,password);
		}
		if(u.getName()==null){
			System.out.println("���������û������ڻ��������󣡣�����");
		}else{
			System.out.println("!!!!!��"+u.getName()+"����½�ɹ�!!!!!\n");
			AllActivityView aav = new AllActivityView();
			aav.ActivityView(u);
		}
	}
	private void registerFace() {
		System.out.println("�������˺���:");
		String name = sc.next();
		System.out.println("�������������:");
		String password = sc.next();
		int t = uj.insert(name,password);
		if(t>0){
			System.out.println("������ע��ɹ�������");
		}else{
			System.out.println("������ע��ʧ�ܣ�����");
		}
	}
}
