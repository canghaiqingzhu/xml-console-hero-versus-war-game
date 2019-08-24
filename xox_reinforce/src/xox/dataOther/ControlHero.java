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
			System.out.println("---------------����Ӣ��---------------");
			System.out.println("1�����Ӣ��");
			System.out.println("2��ɾ��Ӣ��");
			System.out.println("3���޸�Ӣ��");
			System.out.println("4����ѯӢ��");
			System.out.println("5�������ϲ�");
			System.out.println("��ѡ��1~5����");
			int choice = input.nextInt();
			switch (choice) {
			case 1:
				System.out.println("����ӡ�");
				addHero(document);
				System.out.println("�ɹ�");
				break;
			case 2:
				System.out.println("��ɾ����");
				deleteHero(document);
				System.out.println("�ɹ�");
				break;
			case 3:
				System.out.println("���޸ġ�");
				updateHero(document);
				break;
			case 4:
				System.out.println("����ѯ��");
				readHero(document);
				break;
			case 5:
				System.out.println("-------------�˳�����Ӣ��-------------");
				System.out.println("����תҳ���С�������");
				t = true;
				break;
			default:
				System.out.println("��!!!!!��Ч����!!!!!��");
				break;
			}
		}
	}
	public void readHero(Document document) {
		Element heros = document.getRootElement();
		System.out.println("���\t����\t����\t�����˺�\t�￹\t�����˺�\t����\tѪ��");
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
		System.out.println("��Ҫ�޸ĵ�Ӣ������id��");
		Element e = (Element) document.selectSingleNode("//hero[@id='"+ input.next()+"']");
		Element name = e.element("name");
		Element intelligence = e.element("intelligence");
		Element physicalInjury = e.element("physicalInjury");
		Element physicalResist = e.element("physicalResist");
		Element magicInjury = e.element("magicInjury");
		Element magicResist = e.element("magicResist");
		Element blood = e.element("blood");
		
		System.out.println("�������޸ĵ�Ӣ��������");
		name.setText(input.next());
		System.out.println("�������޸ĵ�Ӣ��������");
		intelligence.setText(input.next());
		System.out.println("�������޸ĵ�Ӣ�������˺�������0С��1��������");
		physicalInjury.setText(input.next());
		System.out.println("�������޸ĵ�Ӣ�������˺�������0С��1��������");
		physicalResist.setText(input.next());
		System.out.println("�������޸ĵ�Ӣ��ħ���˺�������0С��1��������");
		magicInjury.setText(input.next());
		System.out.println("�������޸ĵ�Ӣ�۷���������0С��1��������");
		magicResist.setText(input.next());
		System.out.println("�������޸ĵ�Ӣ��Ѫ����");
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
		System.out.println("��ɾ����Ӣ������id��");
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
		
		//�����Ը�ֵ
		System.out.println("������Ӣ��������");
		name.setText(input.next());
		System.out.println("������Ӣ�۵�������");
		intelligence.setText(input.next());
		System.out.println("������Ӣ�۵������˺�������0С��1��������");
		physicalInjury.setText(input.next());
		System.out.println("������Ӣ�۵��������ֵ ������0С��1��������");
		physicalResist.setText(input.next());
		System.out.println("������Ӣ�۵ķ����˺�������0С��1��������");
		magicInjury.setText(input.next());
		System.out.println("������Ӣ�۵ķ�������ֵ������0С��1��������");
		magicResist.setText(input.next());
		System.out.println("������Ӣ�۵�Ѫ����");
		blood.setText(input.next());
		
		System.out.println("������Ӣ�۵�id��");
		hero.addAttribute("id", input.next());
		//��������ӵ���Ŀ¼��
		hero.add(name);
		hero.add(intelligence);
		hero.add(physicalInjury);
		hero.add(physicalResist);
		hero.add(magicInjury);
		hero.add(magicResist);
		hero.add(blood);
		//����Ŀ¼��ӵ���Ŀ¼��
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
