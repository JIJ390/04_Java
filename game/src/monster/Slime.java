package monster;

public class Slime extends Monster{
	
	private String name = "슬라임";
	
	private int atk   = 5;
	private int def   = 5;
	private int hp    = 20;
	private int hpMax = 20;
	
	private int dropExp = 5;

	private int act;
	
	
	public int Damage(int dmg) {
		hp -= dmg;
		return dmg;
	}
	
	public int Defense(int dmg) {
		if (dmg >= def) return dmg - def;
		return 0;
	}
	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getHpMax() {
		return hpMax;
	}

	public void setHpMax(int hpMax) {
		this.hpMax = hpMax;
	}

	public int getDropExp() {
		return dropExp;
	}

	public void setDropExp(int dropExp) {
		this.dropExp = dropExp;
	}

	public int getAct() {
		return act;
	}

	public void setAct(int act) {
		this.act = act;
	}
	
	

	
	
	
}
