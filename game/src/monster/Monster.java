package monster;

public class Monster {
	
	private String name;
	
	private int atk;
	private int def;
	private int hp;
	private int hpMax;
	
	private int act;
	
	private int dropExp;
	
	
	public Monster() {
		super();
	}

	public Monster(String name, int atk, int def, int hp, int hpMax, int act, int dropExp) {
		super();
		
		this.name = name;
		this.atk = atk;
		this.def = def;
		this.hp = hp;
		this.hpMax = hpMax;
		this.act = act;
		this.dropExp = dropExp;
	}



	// 메서드
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

	public int getAct() {
		return act;
	}

	public void setAct(int act) {
		this.act = act;
	}

	public int getDropExp() {
		return dropExp;
	}

	public void setDropExp(int dropExp) {
		this.dropExp = dropExp;
	}
	

}
