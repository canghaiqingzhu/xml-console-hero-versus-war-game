package xox.enity;
/***
 * @author 2014140053 л��
 *xox�غ��ƶ�ս��Ϸ_��ǿ��
 */
import java.util.List;

//Ӣ����
public class Hero {
	private int id;
	private String name;
	private int intelligence;//����
	private int money;//Ǯ
	private double physicalInjury;//�����˺�
	private double physicalResist;//�������
	private double magicInjury;//ħ���˺�
	private double magicResist;//��������
	private int blood;//Ѫ��
	private List<Skill> skillList;//���ܼ�
	private List<Weapon> weaponList;//������
	private Injury injury;
	
	public void setHero(String name,int blood,List<Skill> skillList) {
		this.name = name;
		this.blood = blood;
		this.skillList = skillList;
	}
	public void setHero(int id,String name,int intelligence,int money,double physicalInjury,double physicalResist,double magicInjury,
			double magicResist,int blood) {
		this.id = id;
		this.name = name;
		this.intelligence = intelligence;
		this.money = money;
		this.physicalInjury = physicalInjury;
		this.physicalResist = physicalResist;
		this.magicInjury = magicInjury;
		this.magicResist = magicResist;
		this.blood = blood;
	}
	public void setHero(int id,String name,int intelligence,int money,double physicalInjury,double physicalResist,double magicInjury,
			double magicResist,int blood,List<Skill> skillList,List<Weapon> weaponList) {
		this.id = id;
		this.name = name;
		this.intelligence = intelligence;
		this.money = money;
		this.physicalInjury = physicalInjury;
		this.physicalResist = physicalResist;
		this.magicInjury = magicInjury;
		this.magicResist = magicResist;
		this.blood = blood;
		this.skillList = skillList;
		this.weaponList = weaponList;
	}
	
	
	public Injury getInjury() {
		return injury;
	}
	public void setInjury(Injury injury) {
		this.injury = injury;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public List<Skill> getSkillList() {
		return skillList;
	}
	public void setSkillList(List<Skill> skillList) {
		this.skillList = skillList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public double getPhysicalInjury() {
		return physicalInjury;
	}
	public void setPhysicalInjury(double physicalInjury) {
		this.physicalInjury = physicalInjury;
	}
	public double getPhysicalResist() {
		return physicalResist;
	}
	public void setPhysicalResist(double physicalResist) {
		this.physicalResist = physicalResist;
	}
	public double getMagicInjury() {
		return magicInjury;
	}
	public void setMagicInjury(double magicInjury) {
		this.magicInjury = magicInjury;
	}
	public double getMagicResist() {
		return magicResist;
	}
	public void setMagicResist(double magicResist) {
		this.magicResist = magicResist;
	}
	public int getBlood() {
		return blood;
	}
	public void setBlood(int blood) {
		this.blood = blood;
	}
	public List<Weapon> getWeaponList() {
		return weaponList;
	}
	public void setWeaponList(List<Weapon> weaponList) {
		this.weaponList = weaponList;
	}
	
}
