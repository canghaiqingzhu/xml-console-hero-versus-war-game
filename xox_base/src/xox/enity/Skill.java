package xox.enity;
/***
 *������
 * @author 2014140053 л��
 *xox�غ��ƶ�ս��Ϸ
 */

public class Skill {
	private int id;
	private String name;
	private int injury;//�˺�
	public void setSkill(int id,String name,int injury) {
		this.id = id;
		this.name = name;
		this.injury = injury;
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
	public int getInjury() {
		return injury;
	}
	public void setInjury(int injury) {
		this.injury = injury;
	}
	
	
}
