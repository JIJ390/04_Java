package monster;

public class Dragon extends Monster{

	private int atk = 30;
	private int def = 30;
	private int hp = 50;
	
	private int dropExp = 20;
	
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
