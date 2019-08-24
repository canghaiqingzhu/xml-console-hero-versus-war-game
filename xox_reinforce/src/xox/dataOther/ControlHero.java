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

public class ControlHero {
	static Scanner input = new Scanner(System.in);
	
	public void heroface(){
		SAXReader saxReader = new SAXReader();
		Document document = null;
		try {
			document = saxReader.read("src/xox/dataOther/Hero.xml");	
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		boolean t = false;
		while(t==false){
			System.out.println("---------------本地英雄---------------");
			System.out.println("1、添加英雄");
			System.out.println("2、删除英雄");
			System.out.println("3、修改英雄");
			System.out.println("4、查询英雄");
			System.out.println("5、返回上层");
			System.out.println("请选择（1~5）：");
			int choice = input.nextInt();
			switch (choice) {
			case 1:
				System.out.println("【添加】");
				addHero(document);
				System.out.println("成功");
				break;
			case 2:
				System.out.println("【删除】");
				deleteHero(document);
				System.out.println("成功");
				break;
			case 3:
				System.out.println("【修改】");
				updateHero(document);
				break;
			case 4:
				System.out.println("【查询】");
				readHero(document);
				break;
			case 5:
				System.out.println("-------------退出本地英雄-------------");
				System.out.println("【跳转页面中。。。】");
				t = true;
				break;
			default:
				System.out.println("【!!!!!无效输入!!!!!】");
				break;
			}
		}
	}
	public void readHero(Document document) {
		Element heros = document.getRootElement();
		System.out.println("序号\t姓名\t智力\t物理伤害\t物抗\t法术伤害\t法抗\t血量");
		for(int i = 0;i<heros.elements("hero").size();i++){
			Element hero = (Element) heros.elements("hero").get(i);
			int id =Integer.parseInt(hero.attributeValue("id"));
			String name = hero.element("name").getText();
			int intelligence =  Integer.parseInt(hero.element("intelligence").getText());
			double physicalInjury = Double.parseDouble(hero.element("physicalInjury").getText());
			double physicalResist = Double.parseDouble(hero.element("physicalResist").getText());
			double magicInjury = Double.parseDouble(hero.element("magicInjury").getText());
			double magicResist = Double.parseDouble(hero.element("magicResist").getText());
			int blood = Integer.parseInt(hero.element("blood").getText());
			System.out.println(id+"\t"+name+"\t"+intelligence+"\t"+physicalInjury+"\t"+physicalResist+"\t"+magicInjury+"\t"+magicResist+"\t"+blood);
		}
	}
	
	public List<Hero> readHeres() {
		List<Hero> herolist = new ArrayList<Hero>();
		SAXReader saxReader = new SAXReader();
		Document document = null;
		try {
			document = saxReader.read("src/xox/dataOther/Hero.xml");	
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element heros = document.getRootElement();
		for(int i = 0;i<heros.elements("hero").size();i++){
			Element hero = (Element) heros.elements("hero").get(i);
			int id =Integer.parseInt(hero.attributeValue("id"));
			String name = hero.element("name").getText();
			int intelligence =  Integer.parseInt(hero.element("intelligence").getText());
			double physicalInjury = Double.parseDouble(hero.element("physicalInjury").getText());
			double physicalResist = Double.parseDouble(hero.element("physicalResist").getText());
			double magicInjury = Double.parseDouble(hero.element("magicInjury").getText());
			double magicResist = Double.parseDouble(hero.element("magicResist").getText());
			int blood = Integer.parseInt(hero.element("blood").getText());
			Hero h = new Hero();
			h.setHero(id, name, intelligence, 0, physicalInjury, physicalResist, magicInjury, magicResist, blood);
			herolist.add(h);
		}
		return herolist;
	}
	private void updateHero(Document document) {
		System.out.println("请要修改的英雄输入id：");
		Element e = (Element) document.selectSingleNode("//hero[@id='"+ input.next()+"']");
		Element name = e.element("name");
		Element intelligence = e.element("intelligence");
		Element physicalInjury = e.element("physicalInjury");
		Element physicalResist = e.element("physicalResist");
		Element magicInjury = e.element("magicInjury");
		Element magicResist = e.element("magicResist");
		Element blood = e.element("blood");
		
		System.out.println("请输入修改的英雄姓名：");
		name.setText(input.next());
		System.out.println("请输入修改的英雄智力：");
		intelligence.setText(input.next());
		System.out.println("请输入修改的英雄物理伤害（大于0小于1的数）：");
		physicalInjury.setText(input.next());
		System.out.println("请输入修改的英雄物理伤害（大于0小于1的数）：");
		physicalResist.setText(input.next());
		System.out.println("请输入修改的英雄魔法伤害（大于0小于1的数）：");
		magicInjury.setText(input.next());
		System.out.println("请输入修改的英雄法抗（大于0小于1的数）：");
		magicResist.setText(input.next());
		System.out.println("请输入修改的英雄血量：");
		blood.setText(input.next());
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer;
		try {
			writer = new XMLWriter(new FileOutputStream(new File("src/xox/dataOther/Hero.xml")),format);
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
	private void deleteHero(Document document) {
		System.out.println("请删除的英雄输入id：");
		Element e = (Element) document.selectSingleNode("//hero[@id='"+ input.next()+"']");
		e.getParent().remove(e);
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer;
		try {
			writer = new XMLWriter(new FileOutputStream(new File("src/xox/dataOther/Hero.xml")),format);
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
	private void addHero(Document document) {
		Element hero = DocumentHelper.createElement("hero");
		Element name = DocumentHelper.createElement("name");
		Element intelligence = DocumentHelper.createElement("intelligence");
		Element physicalInjury = DocumentHelper.createElement("physicalInjury");
		Element physicalResist = DocumentHelper.createElement("physicalResist");
		Element magicInjury = DocumentHelper.createElement("magicInjury");
		Element magicResist = DocumentHelper.createElement("magicResist");
		Element blood = DocumentHelper.createElement("blood");
		
		//给属性赋值
		System.out.println("请输入英雄姓名：");
		name.setText(input.next());
		System.out.println("请输入英雄的智力：");
		intelligence.setText(input.next());
		System.out.println("请输入英雄的物理伤害（大于0小于1的数）：");
		physicalInjury.setText(input.next());
		System.out.println("请输入英雄的物理防御值 （大于0小于1的数）：");
		physicalResist.setText(input.next());
		System.out.println("请输入英雄的法术伤害（大于0小于1的数）：");
		magicInjury.setText(input.next());
		System.out.println("请输入英雄的法术防御值（大于0小于1的数）：");
		magicResist.setText(input.next());
		System.out.println("请输入英雄的血量：");
		blood.setText(input.next());
		
		System.out.println("请输入英雄的id：");
		hero.addAttribute("id", input.next());
		//将属性添加到子目录下
		hero.add(name);
		hero.add(intelligence);
		hero.add(physicalInjury);
		hero.add(physicalResist);
		hero.add(magicInjury);
		hero.add(magicResist);
		hero.add(blood);
		//将子目录添加到根目录下
		document.getRootElement().add(hero);
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer;
		try {
			writer = new XMLWriter(new FileOutputStream(new File("src/xox/dataOther/Hero.xml")),format);
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
