package xox.enity;
/***
 * @author 2014140053 л��
 *xox�غ��ƶ�ս��Ϸ_��ǿ��
 */
public class Injury {
	private int physicalInjury;//�����˺�
	private int physicalResist;//�������
	private int magicInjury;//ħ���˺�
	private int magicResist;//��������
	private int addblood;//ÿ�غ�Ѫ��
	private double dizziness;//ѣ�μ���-->��Ϊ�����
	private double suckblood;//��Ѫ��
	private int blood;//Ѫ��
	private double addInjury;//����������
	
	
	
	
	
	public void setInjury(int physicalInjury,int physicalResist,int magicInjury,int magicResist,int addblood,double dizziness,double suckblood,
			int blood,double addInjury) {
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
	public int getBlood() {
		return blood;
	}
	public void setBlood(int blood) {
		this.blood = blood;
	}
	public double getAddInjury() {
		return addInjury;
	}
	public void setAddInjury(double addInjury) {
		this.addInjury = addInjury;
	}
	
	
	
}
