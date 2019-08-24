package xox.enity;
/***
 * @author 2014140053 谢辉
 *xox回合制对战游戏_加强版
 */
public class Skill {
	private int id;
	private String name;
	private int physicalInjury;//物理伤害
	private int magicInjury;//魔法伤害 
	private double dizziness;//眩晕几率
	private double suckblood;//吸血率

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
