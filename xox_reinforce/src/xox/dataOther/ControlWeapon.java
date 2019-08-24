package xox.dataOther;
/***
 * @author 2014140053 谢辉
 *xox回合制对战游戏_加强版
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
			System.out.println("---------------本地装备---------------");
			System.out.println("1、添加装备");
			System.out.println("2、删除装备");
			System.out.println("3、修改装备");
			System.out.println("4、查询装备");
			System.out.println("5、返回上层");
			System.out.println("请选择（1~5）：");
			int choice = input.nextInt();
			switch (choice) {
			case 1:
				System.out.println("【添加】");
				addWeapon(document);
				System.out.println("成功");
				break;
			case 2:
				System.out.println("【删除】");
				deleteWeapon(document);
				System.out.println("成功");
				break;
			case 3:
				System.out.println("【修改】");
				updateWeapon(document);
				break;
			case 4:
				System.out.println("【查询】");
				readWeapon();
				break;
			case 5:
				System.out.println("-------------退出本地装备-------------");
				System.out.println("【跳转页面中。。。】");
				t = true;
				break;
			default:
				System.out.println("【!!!!!无效输入!!!!!】");
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
		System.out.println("序号\t装备名\t金额\t智力属性\t物伤\t物抗\t法伤\t法抗\t回血量\t躲避率\t吸血率\t加血量");
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
		System.out.println("请要修改的装备输入id：");
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
		
		
		System.out.println("请输入修改的装备姓名：");
		name.setText(input.next());
		System.out.println("请输入修改的装备金额：");
		money.setText(input.next());
		System.out.println("请输入修改的装备智力：");
		addintell.setText(input.next());
		System.out.println("请输入修改的装备物理伤害：");
		physicalInjury.setText(input.next());
		System.out.println("请输入修改的装备物理伤害：");
		physicalResist.setText(input.next());
		System.out.println("请输入修改的装备魔法伤害：");
		magicInjury.setText(input.next());
		System.out.println("请输入修改的装备法抗：");
		magicResist.setText(input.next());
		System.out.println("请输入修改的装备回血量：");
		addblood.setText(input.next());
		System.out.println("请输入修改的装备躲避值（大于0小于1的数）：");
		dizziness.setText(input.next());
		System.out.println("请输入修改的装备吸血率（大于0小于1的数）：");
		suckblood.setText(input.next());
		System.out.println("请输入修改的装备血量：");
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
		System.out.println("请删除的装备输入id：");
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
		//给属性赋值
		System.out.println("请输入装备姓名：");
		name.setText(input.next());
		System.out.println("请输入装备金额：");
		money.setText(input.next());
		System.out.println("请输入修改的装备智力：");
		addintell.setText(input.next());
		System.out.println("请输入修改的装备物理伤害：");
		physicalInjury.setText(input.next());
		System.out.println("请输入修改的装备物理伤害：");
		physicalResist.setText(input.next());
		System.out.println("请输入修改的装备魔法伤害：");
		magicInjury.setText(input.next());
		System.out.println("请输入修改的装备法抗：");
		magicResist.setText(input.next());
		System.out.println("请输入修改的装备回血量：");
		addblood.setText(input.next());
		System.out.println("请输入修改的装备躲避值（大于0小于1的数）：");
		dizziness.setText(input.next());
		System.out.println("请输入修改的装备吸血率（大于0小于1的数）：");
		suckblood.setText(input.next());
		System.out.println("请输入修改的装备血量：");
		blood.setText(input.next());
		System.out.println("请输入装备的id：");
		weapon.addAttribute("id", input.next());
		//将属性添加到子目录下
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
		//将子目录添加到根目录下
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
