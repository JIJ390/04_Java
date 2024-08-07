package character;

public class Character {

	private int atk = 10;
	private int def = 10;
	private int hp = 20;
	private int hpMax = 20;
	private int act = 0;
	
	private int level = 1;
	private int exp = 0;
	private int expMax = 20;
	
	public Character() {
		
	}
	
	public int Damage(int dmg) {
		hp -= dmg;
		return dmg;
	}
	
	public int Defense(int dmg) {
		if (dmg >= def) {
			hp -= (dmg - def);
			return dmg - def;
		}
		return 0;
	}
	
	public void expPlus(int exp) {
		this.exp += exp;
	}
	
	public void LevelCheck() {

		if (exp >= expMax) {
			System.out.println("레벨이 1 상승했습니다!!");
			System.out.println("공격력 10 증가");
			System.out.println("방어력 10 증가");
			System.out.println("최대 체력 10 증가");
			System.out.println("체력이 회복되었습니다");
			
			level ++;
			atk += 10;
			def += 10;
			hpMax += 10;
			hp = hpMax;
			
			exp -= expMax;
		}
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
	
	public int getAct() {
		return act;
	}

	public void setAct(int act) {
		this.act = act;
	}

	public int getHpMax() {
		return hpMax;
	}

	public void setHpMax(int hpMax) {
		this.hpMax = hpMax;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getExpMax() {
		return expMax;
	}

	public void setExpMax(int expMax) {
		this.expMax = expMax;
	}

	
	
	
	
}
