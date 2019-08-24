package xox.enity;
/***
 * @author 2014140053 谢辉
 *xox回合制对战游戏_加强版
 */
public class Injury {
	private int physicalInjury;//物理伤害
	private int physicalResist;//物理防御
	private int magicInjury;//魔法伤害
	private int magicResist;//法术防御
	private int addblood;//每回合血量
	private double dizziness;//眩晕几率-->改为躲避率
	private double suckblood;//吸血率
	private int blood;//血量
	private double addInjury;//属性提升率
	
	
	
	
	
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
