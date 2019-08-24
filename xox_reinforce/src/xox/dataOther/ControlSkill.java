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


import xox.enity.Skill;

public class ControlSkill {
	static Scanner input = new Scanner(System.in);
	
	public void skillface(){
		SAXReader saxReader = new SAXReader();
		Document document = null;
		try {
			document = saxReader.read("src/xox/dataOther/Skill.xml");	
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		boolean t = false;
		while(t==false){
			System.out.println("---------------本地技能---------------");
			System.out.println("1、添加技能");
			System.out.println("2、删除技能");
			System.out.println("3、修改技能");
			System.out.println("4、查询技能");
			System.out.println("5、返回上层");
			System.out.println("请选择（1~5）：");
			int choice = input.nextInt();
			switch (choice) {
			case 1:
				System.out.println("【添加】");
				addSkill(document);
				System.out.println("成功");
				break;
			case 2:
				System.out.println("【删除】");
				deleteSkill(document);
				System.out.println("成功");
				break;
			case 3:
				System.out.println("【修改】");
				updateSkill(document);
				break;
			case 4:
				System.out.println("【查询】");
				readSkill(document);
				break;
			case 5:
				System.out.println("-------------退出本地技能-------------");
				System.out.println("【跳转页面中。。。】");
				t = true;
				break;
			default:
				System.out.println("【!!!!!无效输入!!!!!】");
				break;
			}
		}
	}
	public void readSkill(Document document) {
		Element skills = document.getRootElement();
		System.out.println("序号\t姓名\t物伤\t法伤\t眩晕值\t吸血率");
		for(int i = 0;i<skills.elements("skill").size();i++){
			Element skill = (Element) skills.elements("skill").get(i);
			
			int id =Integer.parseInt(skill.attributeValue("id"));
			String name = skill.element("name").getText();
			int physicalInjury =  Integer.parseInt(skill.element("physicalInjury").getText());
			int magicInjury =  Integer.parseInt(skill.element("magicInjury").getText());
			double suckblood = Double.parseDouble(skill.element("suckblood").getText());
			double dizziness = Double.parseDouble(skill.element("dizziness").getText());
			System.out.println(id+"\t"+name+"\t"+physicalInjury+"\t"+magicInjury+"\t"+dizziness+"\t"+suckblood);
		}
	}
	
	public List<Skill> readSkills() {
		List<Skill> skilllist = new ArrayList<Skill>();
		SAXReader saxReader = new SAXReader();
		Document document = null;
		try {
			document = saxReader.read("src/xox/dataOther/Skill.xml");	
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element skills = document.getRootElement();
		for(int i = 0;i<skills.elements("skill").size();i++){
			Element skill = (Element) skills.elements("skill").get(i);
			int id =Integer.parseInt(skill.attributeValue("id"));
			String name = skill.element("name").getText();
			int physicalInjury =  Integer.parseInt(skill.element("physicalInjury").getText());
			int magicInjury =  Integer.parseInt(skill.element("magicInjury").getText());
			double suckblood = Double.parseDouble(skill.element("suckblood").getText());
			double dizziness = Double.parseDouble(skill.element("dizziness").getText());
			Skill s = new Skill();
			s.setSkill(id, name, physicalInjury, magicInjury, dizziness, suckblood);
			skilllist.add(s);
		}
		return skilllist;
	}
	private void updateSkill(Document document) {
		System.out.println("请要修改的技能输入id：");
		Element e = (Element) document.selectSingleNode("//skill[@id='"+ input.next()+"']");
		Element name = e.element("name");
		Element physicalInjury = e.element("physicalInjury");
		Element magicInjury = e.element("magicInjury");
		Element dizziness = e.element("dizziness");
		Element suckblood = e.element("suckblood");
		System.out.println("请输入修改的技能名：");
		name.setText(input.next());
		System.out.println("请输入修改的英雄物理伤害：");
		physicalInjury.setText(input.next());
		System.out.println("请输入修改的英雄魔法伤害：");
		magicInjury.setText(input.next());
		System.out.println("请输入修改的技能眩晕值（大于0小于1的数）：");
		dizziness.setText(input.next());
		System.out.println("请输入修改的技能吸血值（大于0小于1的数）：");
		suckblood.setText(input.next());
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer;
		try {
			writer = new XMLWriter(new FileOutputStream(new File("src/xox/dataOther/Skill.xml")),format);
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
	private void deleteSkill(Document document) {
		System.out.println("请删除的技能输入id：");
		Element e = (Element) document.selectSingleNode("//skill[@id='"+ input.next()+"']");
		e.getParent().remove(e);
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer;
		try {
			writer = new XMLWriter(new FileOutputStream(new File("src/xox/dataOther/Skill.xml")),format);
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
	private void addSkill(Document document) {
		Element skill = DocumentHelper.createElement("skill");
		Element name = DocumentHelper.createElement("name");
		Element physicalInjury = DocumentHelper.createElement("physicalInjury");
		Element magicInjury = DocumentHelper.createElement("magicInjury");
		Element dizziness = DocumentHelper.createElement("dizziness");
		Element suckblood = DocumentHelper.createElement("suckblood");
		//给属性赋值
		System.out.println("请输入技能姓名：");
		name.setText(input.next());
		System.out.println("请输入技能的物理伤害：");
		physicalInjury.setText(input.next());
		System.out.println("请输入技能的法术伤害：");
		magicInjury.setText(input.next());
		System.out.println("请输入技能的眩晕值：（大于0小于1的数）");
		dizziness.setText(input.next());
		System.out.println("请输入技能的吸血率：（大于0小于1的数）");
		suckblood.setText(input.next());
		System.out.println("请输入技能的id：");
		skill.addAttribute("id", input.next());
		//将属性添加到子目录下
		skill.add(name);
		skill.add(physicalInjury);
		skill.add(magicInjury);
		skill.add(dizziness);
		skill.add(suckblood);
		//将子目录添加到根目录下
		document.getRootElement().add(skill);
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer;
		try {
			writer = new XMLWriter(new FileOutputStream(new File("src/xox/dataOther/Skill.xml")),format);
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
