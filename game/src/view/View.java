package view;


import java.util.Scanner;

import character.Character;
import monster.Goblin;
import monster.Monster;
import monster.Slime;
import stage.Stage;

public class View {

	Scanner sc = new Scanner(System.in);
	private int floor = 1;
	
	Stage stg = new Stage();
	
	Character c1 = new Character();
	
	public void floor() {
		
		System.out.println("게임을 시작 하려면 'ENTER' 를 입력하세요");
		sc.nextLine();
		
		while (true) {
			System.out.println("=====================");
			System.out.println(floor + " F");
			System.out.println("=====================");
			
			int event = (int)(Math.random() * 7);
			
			switch (event) {
			case 0, 1, 2, 3 : {
				System.out.println("전투");
				fightCase();
				
				break;
			}
			case 4, 5 : {
				System.out.println("축복");
				blessCase();
				
				break;
			}
			case 6 : {
				System.out.println("보상");
				giftCase();
				
				break;
			}
			}
			
			floor++;
			
			System.out.println("'ENTER'를 누르면 다음 층으로 이동합니다.");
			sc.nextLine();
			
		}
	}
	
	private void fightCase() {
		
		int random = (int)(Math.random() * 2);
		int turn = 1;
		
		Monster mob = null;
		
		if (random == 0) {
			mob = new Slime();
			System.out.printf("'%s' 이 나타났다!!\n", mob.getName());} 
		
		if (random == 1) {
			mob = new Goblin();
			System.out.printf("'%s' 이 나타났다!!\n", mob.getName());} 
		
		System.out.println("=====================");
		
		do {
			System.out.printf("[Turn %d]\n", turn);
			System.out.println();
			
			System.out.println(mob.getName());
			System.out.println();
			
			System.out.printf("적 체력 [%d / %d]\n", mob.getHp(), mob.getHpMax());
			
			mob.setAct((int)(Math.random() * 2) + 1);
			
			if (mob.getAct() == 1) System.out.println("적 공격 준비 중");
			if (mob.getAct() == 2) System.out.println("적 방어 준비 중");
			
			System.out.println("------------------");
			System.out.printf("내 체력 [%d / %d]\n", c1.getHp(), c1.getHpMax());
			System.out.println("1. 공격   2. 방어 3. 내 정보");
			
			System.out.print("어떻게 할까?  ");
			c1.setAct(sc.nextInt());	
	
			switch (c1.getAct()) {
			case 1, 2 : stg.fight(c1, mob);	break;
			case 3 : status(); turn--; break;
			}
			
			turn++;
			
			System.out.println("------------------");
			
		} while(mob.getHp() > 0);
		
		System.out.println("전투가 종료되었습니다\n");
		System.out.println("[보상]");
		
		System.out.printf("경험치를 '%d' 획득하였습니다\n", mob.getDropExp());
		c1.expPlus(mob.getDropExp());
		c1.LevelCheck();
		
		sc.nextLine();
		System.out.println();
		
	}
	
	private void status() {
		System.out.println("=========================");
		System.out.println("[상태창]");
		System.out.println("레벨      : " + c1.getLevel());
		System.out.println("공격력    : " + c1.getAtk());
		System.out.println("방어력    : " + c1.getDef());
		System.out.println("최대 체력 : " + c1.getHpMax());
		System.out.println("EXP       : " + c1.getExp());
		System.out.println("=========================");
		
	}

	private void blessCase() {
		stg.heal(c1); 
	}
	
	private void giftCase() {
		
		stg.box(c1); 
	}
}
