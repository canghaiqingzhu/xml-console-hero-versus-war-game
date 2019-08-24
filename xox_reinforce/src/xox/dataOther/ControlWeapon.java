package xox.dataOther;
/***
 * @author 2014140053 л��
 *xox�غ��ƶ�ս��Ϸ_��ǿ��
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import xox.enity.Hero;
import xox.enity.Weapon;

public class ControlWeapon {
	static Scanner input = new Scanner(System.in);
	
	public void weaponface(){
		SAXReader saxReader = new SAXReader();
		Document document = null;
		try {
			document = saxReader.read("src/xox/dataOther/Weapon.xml");	
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		boolean t = false;
		while(t==false){
			System.out.println("---------------����װ��---------------");
			System.out.println("1�����װ��");
			System.out.println("2��ɾ��װ��");
			System.out.println("3���޸�װ��");
			System.out.println("4����ѯװ��");
			System.out.println("5�������ϲ�");
			System.out.println("��ѡ��1~5����");
			int choice = input.nextInt();
			switch (choice) {
			case 1:
				System.out.println("����ӡ�");
				addWeapon(document);
				System.out.println("�ɹ�");
				break;
			case 2:
				System.out.println("��ɾ����");
				deleteWeapon(document);
				System.out.println("�ɹ�");
				break;
			case 3:
				System.out.println("���޸ġ�");
				updateWeapon(document);
				break;
			case 4:
				System.out.println("����ѯ��");
				readWeapon();
				break;
			case 5:
				System.out.println("-------------�˳�����װ��-------------");
				System.out.println("����תҳ���С�������");
				t = true;
				break;
			default:
				System.out.println("��!!!!!��Ч����!!!!!��");
				break;
			}
		}
	}
	

	public void readWeapon() {
		SAXReader saxReader = new SAXReader();
		Document document = null;
		try {
			document = saxReader.read("src/xox/dataOther/Weapon.xml");	
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element weapons = document.getRootElement();
		System.out.println("���\tװ����\t���\t��������\t����\t�￹\t����\t����\t��Ѫ��\t�����\t��Ѫ��\t��Ѫ��");
		for(int i = 0;i<weapons.elements("weapon").size();i++){
			Element weapon = (Element) weapons.elements("weapon").get(i);
			int id =Integer.parseInt(weapon.attributeValue("id"));
			String name = weapon.element("name").getText();
			int money =  Integer.parseInt(weapon.element("money").getText());
			int addintell =  Integer.parseInt(weapon.element("addintell").getText());
			int physicalInjury =  Integer.parseInt(weapon.element("physicalInjury").getText());
			int physicalResist =  Integer.parseInt(weapon.element("physicalResist").getText());
			int magicInjury =  Integer.parseInt(weapon.element("magicInjury").getText());
			int magicResist =  Integer.parseInt(weapon.element("magicResist").getText());
			int addblood =  Integer.parseInt(weapon.element("addblood").getText());
			double dizziness = Double.parseDouble(weapon.element("dizziness").getText());
			double suckblood = Double.parseDouble(weapon.element("suckblood").getText());
			int blood =  Integer.parseInt(weapon.element("blood").getText());
			System.out.println(id+"\t"+name+"\t"+money+"\t"+addintell+"\t"+physicalInjury+"\t"+physicalResist+"\t"+magicInjury+"\t"+magicResist+"\t"+addblood+"\t"+dizziness+"\t"+suckblood+"\t"+blood);
		}
	}
	
	public List<Weapon> readWeapons() {
		List<Weapon> weaponlist = new ArrayList<Weapon>();
		SAXReader saxReader = new SAXReader();
		Document document = null;
		try {
			document = saxReader.read("src/xox/dataOther/Weapon.xml");	
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element weapons = document.getRootElement();
		for(int i = 0;i<weapons.elements("weapon").size();i++){
			Element weapon = (Element) weapons.elements("weapon").get(i);
			int id =Integer.parseInt(weapon.attributeValue("id"));
			String name = weapon.element("name").getText();
			int money =  Integer.parseInt(weapon.element("money").getText());
			int addintell =  Integer.parseInt(weapon.element("addintell").getText());
			int physicalInjury =  Integer.parseInt(weapon.element("physicalInjury").getText());
			int physicalResist =  Integer.parseInt(weapon.element("physicalResist").getText());
			int magicInjury =  Integer.parseInt(weapon.element("magicInjury").getText());
			int magicResist =  Integer.parseInt(weapon.element("magicResist").getText());
			int addblood =  Integer.parseInt(weapon.element("addblood").getText());
			double dizziness = Double.parseDouble(weapon.element("dizziness").getText());
			double suckblood = Double.parseDouble(weapon.element("suckblood").getText());
			int blood =  Integer.parseInt(weapon.element("blood").getText());
			
			Weapon w = new Weapon();
			w.setWeapon(id, name, money,addintell, physicalInjury, physicalResist, magicInjury, magicResist, addblood, dizziness, suckblood, blood);
			weaponlist.add(w);
		}
		return weaponlist;
	}
	private void updateWeapon(Document document) {
		System.out.println("��Ҫ�޸ĵ�װ������id��");
		Element e = (Element) document.selectSingleNode("//weapon[@id='"+ input.next()+"']");
		Element name = e.element("name");
		Element money = e.element("money");
		Element addintell = e.element("addintell");
		Element physicalInjury = e.element("physicalInjury");
		Element physicalResist = e.element("physicalResist");
		Element magicInjury = e.element("magicInjury");
		Element magicResist = e.element("magicResist");
		Element addblood = e.element("addblood");
		Element dizziness = e.element("dizziness");
		Element suckblood = e.element("suckblood");
		Element blood = e.element("blood");
		
		
		System.out.println("�������޸ĵ�װ��������");
		name.setText(input.next());
		System.out.println("�������޸ĵ�װ����");
		money.setText(input.next());
		System.out.println("�������޸ĵ�װ��������");
		addintell.setText(input.next());
		System.out.println("�������޸ĵ�װ�������˺���");
		physicalInjury.setText(input.next());
		System.out.println("�������޸ĵ�װ�������˺���");
		physicalResist.setText(input.next());
		System.out.println("�������޸ĵ�װ��ħ���˺���");
		magicInjury.setText(input.next());
		System.out.println("�������޸ĵ�װ��������");
		magicResist.setText(input.next());
		System.out.println("�������޸ĵ�װ����Ѫ����");
		addblood.setText(input.next());
		System.out.println("�������޸ĵ�װ�����ֵ������0С��1��������");
		dizziness.setText(input.next());
		System.out.println("�������޸ĵ�װ����Ѫ�ʣ�����0С��1��������");
		suckblood.setText(input.next());
		System.out.println("�������޸ĵ�װ��Ѫ����");
		blood.setText(input.next());
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer;
		try {
			writer = new XMLWriter(new FileOutputStream(new File("src/xox/dataOther/Weapon.xml")),format);
			writer.write(document);
			writer.close();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}
	private void deleteWeapon(Document document) {
		System.out.println("��ɾ����װ������id��");
		Element e = (Element) document.selectSingleNode("//weapon[@id='"+ input.next()+"']");
		e.getParent().remove(e);
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer;
		try {
			writer = new XMLWriter(new FileOutputStream(new File("src/xox/dataOther/Weapon.xml")),format);
			writer.write(document);
			writer.close();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	private void addWeapon(Document document) {
		Element weapon = DocumentHelper.createElement("weapon");
		Element name = DocumentHelper.createElement("name");
		Element money = DocumentHelper.createElement("money");
		Element addintell = DocumentHelper.createElement("addintell");
		Element physicalInjury = DocumentHelper.createElement("physicalInjury");
		Element physicalResist = DocumentHelper.createElement("physicalResist");
		Element magicInjury = DocumentHelper.createElement("magicInjury");
		Element magicResist = DocumentHelper.createElement("magicResist");
		Element addblood = DocumentHelper.createElement("addblood");
		Element dizziness = DocumentHelper.createElement("dizziness");
		Element suckblood = DocumentHelper.createElement("suckblood");
		Element blood = DocumentHelper.createElement("blood");
		//�����Ը�ֵ
		System.out.println("������װ��������");
		name.setText(input.next());
		System.out.println("������װ����");
		money.setText(input.next());
		System.out.println("�������޸ĵ�װ��������");
		addintell.setText(input.next());
		System.out.println("�������޸ĵ�װ�������˺���");
		physicalInjury.setText(input.next());
		System.out.println("�������޸ĵ�װ�������˺���");
		physicalResist.setText(input.next());
		System.out.println("�������޸ĵ�װ��ħ���˺���");
		magicInjury.setText(input.next());
		System.out.println("�������޸ĵ�װ��������");
		magicResist.setText(input.next());
		System.out.println("�������޸ĵ�װ����Ѫ����");
		addblood.setText(input.next());
		System.out.println("�������޸ĵ�װ�����ֵ������0С��1��������");
		dizziness.setText(input.next());
		System.out.println("�������޸ĵ�װ����Ѫ�ʣ�����0С��1��������");
		suckblood.setText(input.next());
		System.out.println("�������޸ĵ�װ��Ѫ����");
		blood.setText(input.next());
		System.out.println("������װ����id��");
		weapon.addAttribute("id", input.next());
		//��������ӵ���Ŀ¼��
		weapon.add(name);
		weapon.add(money);
		weapon.add(addintell);
		weapon.add(physicalInjury);
		weapon.add(physicalResist);
		weapon.add(magicInjury);
		weapon.add(magicResist);
		weapon.add(addblood);
		weapon.add(dizziness);
		weapon.add(suckblood);
		weapon.add(blood);
		//����Ŀ¼��ӵ���Ŀ¼��
		document.getRootElement().add(weapon);
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer;
		try {
			writer = new XMLWriter(new FileOutputStream(new File("src/xox/dataOther/weapon.xml")),format);
			writer.write(document);
			writer.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
