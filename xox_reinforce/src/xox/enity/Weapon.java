package xox.enity;
/***
 * @author 2014140053 л��
 *xox�غ��ƶ�ս��Ϸ_��ǿ��
 */
//������
public class Weapon {
	private int id;
	private String name;
	private int money;//Ǯ
	private int addintell;//�ﵽĳ������������ֵ
	private int physicalInjury;//�����˺�
	private int physicalResist;//�������
	private int magicInjury;//ħ���˺�
	private int magicResist;//��������
	private int addblood;//ÿ���ӻ�Ѫ��
	private double dizziness;//ѣ�μ���-->��Ϊ�����
	private double suckblood;//��Ѫ��
	private int blood;//Ѫ��
	//���١�����
	private double addInjury;//����������
	
	public void setWeapon(int id,String name,int money,int addintell,int physicalInjury,int physicalResist,int magicInjury,
			int magicResist,int addblood,double dizziness,double suckblood,int blood) {
		this.id = id;
		this.name = name;
		this.money = money;
		this.addintell = addintell;
		this.physicalInjury = physicalInjury;
		this.physicalResist = physicalResist;
		this.magicInjury = magicInjury;
		this.magicResist = magicResist;
		this.addblood = addblood;
		this.dizziness = dizziness;
		this.suckblood = suckblood;
		this.blood = blood;
	}
	
	public void setWeapon(int physicalInjury,int physicalResist,int magicInjury,
			int magicResist,int addblood,double dizziness,double suckblood,int blood,double addInjury) {
		this.physicalInjury = physicalInjury;
		this.physicalResist = physicalResist;
		this.magicInjury = magicInjury;
		this.magicResist = magicResist;
		this.addblood = addblood;
		this.dizziness = dizziness;
		this.suckblood = suckblood;
		this.blood = blood;
		this.addInjury = addInjury;
	}
	
	public double getAddInjury() {
		return addInjury;
	}

	public void setAddInjury(double addInjury) {
		this.addInjury = addInjury;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public double getDizziness() {
		return dizziness;
	}

	public void setDizziness(double dizziness) {
		this.dizziness = dizziness;
	}

	public double getSuckblood() {
		return suckblood;
	}

	public void setSuckblood(double suckblood) {
		this.suckblood = suckblood;
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
	public int getAddintell() {
		return addintell;
	}
	public void setAddintell(int addintell) {
		this.addintell = addintell;
	}
	public int getPhysicalInjury() {
		return physicalInjury;
	}
	public void setPhysicalInjury(int physicalInjury) {
		this.physicalInjury = physicalInjury;
	}
	public int getPhysicalResist() {
		return physicalResist;
	}
	public void setPhysicalResist(int physicalResist) {
		this.physicalResist = physicalResist;
	}
	public int getMagicInjury() {
		return magicInjury;
	}
	public void setMagicInjury(int magicInjury) {
		this.magicInjury = magicInjury;
	}
	public int getMagicResist() {
		return magicResist;
	}
	public void setMagicResist(int magicResist) {
		this.magicResist = magicResist;
	}
	public int getAddblood() {
		return addblood;
	}
	public void setAddblood(int addblood) {
		this.addblood = addblood;
	}
	public int getBlood() {
		return blood;
	}
	public void setBlood(int blood) {
		this.blood = blood;
	}
}
