package xox.enity;
/***
 * @author 2014140053 л��
 *xox�غ��ƶ�ս��Ϸ_��ǿ��
 */
public class Skill {
	private int id;
	private String name;
	private int physicalInjury;//�����˺�
	private int magicInjury;//ħ���˺� 
	private double dizziness;//ѣ�μ���
	private double suckblood;//��Ѫ��

	public void setSkill(int id,String name,int physicalInjury,int magicInjury) {
		this.id = id;
		this.name = name;
		this.physicalInjury = physicalInjury;
		this.magicInjury = magicInjury;
	}
	public void setSkill(int id,String name,int physicalInjury,int magicInjury,double dizziness,double suckblood) {
		this.id = id;
		this.name = name;
		this.physicalInjury = physicalInjury;
		this.magicInjury = magicInjury;
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
	public int getPhysicalInjury() {
		return physicalInjury;
	}
	public void setPhysicalInjury(int physicalInjury) {
		this.physicalInjury = physicalInjury;
	}

	public int getMagicInjury() {
		return magicInjury;
	}
	public void setMagicInjury(int magicInjury) {
		this.magicInjury = magicInjury;
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

	
	
}
