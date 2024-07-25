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
	
	public void floor() {
		
		Stage stg = new Stage();
		Character c1 = new Character();
		
		while (true) {
			System.out.println("=====================");
			System.out.println(floor + " F");
			System.out.println("=====================");
			
			int event = (int)(Math.random()*3);
			
			switch (event) {
			case 0 : fightCase(stg, c1);
			case 1 : stg.heal(c1);
			case 2 : stg.box(c1);
			}
			
			floor++;
			System.out.println("ENTER를 누르면 다음 층으로 이동합니다.");
			int i = sc.nextInt();
			
		}
	}
	
	public void fightCase(Stage stg, Character c1) {
		
		int index = (int)(Math.random() * 2);
		
		if (index == 0) {Monster mob = new Slime();} 
		else {Monster mob = new Goblin();} 
		
		stg.fight(c1, mob);
	}
}
