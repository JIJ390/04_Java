package stage;

import character.Character;
import monster.Goblin;
import monster.Monster;
import monster.Slime;

public class Stage {
	
	/**
	 * act 1 일 때 공격
	 * act 2 일 때 방어
	 * 
	 * 방어 하면 atk 가 0 이 됨
	 * 
	 * @param c1
	 * @param mob
	 */
	public void fight(Character c1, Monster mob) {
		
		System.out.println("------------------");
		System.out.println("[Battle log]");
		
		int dmg = 0;
		
		if (c1.getAct() == 1) {
			System.out.printf("'%s' 을 공격합니다\n", mob.getName());
			
			if (mob.getAct() == 1) dmg = mob.Damage(c1.getAtk());
			if (mob.getAct() == 2) {
				
				dmg = mob.Defense(c1.getAtk());
				System.out.printf("'%s' 가 피해를 '%d' 막았습니다\n",
								  mob.getName(), c1.getAtk() - dmg);
			}
			
			System.out.printf("'%s' 에게 피해를 '%d' 입혔습니다\n",mob.getName(), dmg);
			}
		
		if (hpCheck(mob)) return;
		
		if (mob.getAct() == 1) {
			System.out.printf("공격을 받았습니다\n");
			
			if (c1.getAct() == 1) dmg = c1.Damage(mob.getAtk());
			if (c1.getAct() == 2) {
				
				dmg = c1.Defense(mob.getAtk());
				System.out.printf("피해를 '%d' 막았습니다\n", mob.getAtk() - dmg);
			}
			
			System.out.printf("피해를 '%d' 받았습니다\n", dmg);
			}
		
		if (c1.getAct() == 2 && mob.getAct() == 2) System.out.println("아무 일도 일어나지 않았습니다");
	
			
	}
	
	public void heal(Character c1) {
		c1.setHp(c1.getHpMax());
	}
	
	public void box(Character c1) {
		
	}
	
	private boolean hpCheck(Monster mob) {
		if (mob.getHp() <= 0) {
			System.out.printf("'%s' 가 쓰러졌습니다\n", mob.getName());
			return true;
		}
		return false;
	}
	
}
