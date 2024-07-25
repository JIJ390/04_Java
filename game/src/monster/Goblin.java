package monster;

public class Goblin extends Monster{
	private int atk = 10;
	private int def = 10;
	private int hp = 30;
	
	private int dropExp = 10;
	
	@Override
	public int Attack() {
		return atk;
	}

	@Override
	public int Defense(int dmg) {
		if (dmg >= def) return dmg - def;
		return 0;
	}

}
