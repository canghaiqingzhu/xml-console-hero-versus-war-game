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
			System.out.println("---------------���ؼ���---------------");
			System.out.println("1����Ӽ���");
			System.out.println("2��ɾ������");
			System.out.println("3���޸ļ���");
			System.out.println("4����ѯ����");
			System.out.println("5�������ϲ�");
			System.out.println("��ѡ��1~5����");
			int choice = input.nextInt();
			switch (choice) {
			case 1:
				System.out.println("����ӡ�");
				addSkill(document);
				System.out.println("�ɹ�");
				break;
			case 2:
				System.out.println("��ɾ����");
				deleteSkill(document);
				System.out.println("�ɹ�");
				break;
			case 3:
				System.out.println("���޸ġ�");
				updateSkill(document);
				break;
			case 4:
				System.out.println("����ѯ��");
				readSkill(document);
				break;
			case 5:
				System.out.println("-------------�˳����ؼ���-------------");
				System.out.println("����תҳ���С�������");
				t = true;
				break;
			default:
				System.out.println("��!!!!!��Ч����!!!!!��");
				break;
			}
		}
	}
	public void readSkill(Document document) {
		Element skills = document.getRootElement();
		System.out.println("���\t����\t����\t����\tѣ��ֵ\t��Ѫ��");
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
		System.out.println("��Ҫ�޸ĵļ�������id��");
		Element e = (Element) document.selectSingleNode("//skill[@id='"+ input.next()+"']");
		Element name = e.element("name");
		Element physicalInjury = e.element("physicalInjury");
		Element magicInjury = e.element("magicInjury");
		Element dizziness = e.element("dizziness");
		Element suckblood = e.element("suckblood");
		System.out.println("�������޸ĵļ�������");
		name.setText(input.next());
		System.out.println("�������޸ĵ�Ӣ�������˺���");
		physicalInjury.setText(input.next());
		System.out.println("�������޸ĵ�Ӣ��ħ���˺���");
		magicInjury.setText(input.next());
		System.out.println("�������޸ĵļ���ѣ��ֵ������0С��1��������");
		dizziness.setText(input.next());
		System.out.println("�������޸ĵļ�����Ѫֵ������0С��1��������");
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
		System.out.println("��ɾ���ļ�������id��");
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
		//�����Ը�ֵ
		System.out.println("�����뼼��������");
		name.setText(input.next());
		System.out.println("�����뼼�ܵ������˺���");
		physicalInjury.setText(input.next());
		System.out.println("�����뼼�ܵķ����˺���");
		magicInjury.setText(input.next());
		System.out.println("�����뼼�ܵ�ѣ��ֵ��������0С��1������");
		dizziness.setText(input.next());
		System.out.println("�����뼼�ܵ���Ѫ�ʣ�������0С��1������");
		suckblood.setText(input.next());
		System.out.println("�����뼼�ܵ�id��");
		skill.addAttribute("id", input.next());
		//��������ӵ���Ŀ¼��
		skill.add(name);
		skill.add(physicalInjury);
		skill.add(magicInjury);
		skill.add(dizziness);
		skill.add(suckblood);
		//����Ŀ¼��ӵ���Ŀ¼��
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
