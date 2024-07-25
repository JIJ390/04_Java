package monster;

public class Slime extends Monster{
	
	private int atk = 5;
	private int def = 5;
	private int hp = 20;
	
	private int dropExp = 5;

	
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
