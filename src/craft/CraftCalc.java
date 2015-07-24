package craft;

import java.util.Scanner;

public class CraftCalc {
	Scanner s;
	int price;
	int dc;
	int skill;
	int progress;
	int roll;
	
	public CraftCalc() {
		s = new Scanner(System.in);
		
		System.out.println("Price: ");
		price = (Integer.valueOf(s.nextInt())) * 10;
		System.out.println("DC: ");
		dc = Integer.valueOf(s.nextInt());
		System.out.println("Skill: ");
		skill = Integer.valueOf(s.nextInt());
	}
	
	public void roll() {
		while(progress < price) {
			s.nextLine();
			int roll = d20();		
			
			if((skill + roll - dc) > 0) {
				progress += (skill + roll) * dc;
				System.out.format("Check: %d %nProgress: %d/%d(sp)%n", roll + skill, progress, price);				
			} else {
				System.out.format("Check: %d (Failed %d) %nProgress: %d/%d(sp)%n", roll + skill, roll + skill - dc, progress, price);
			}
				
		}
	}
	
	public int d20() {
		return (int) (1 + (Math.random() * 19)) ;
	}
	
	public static void main (String[] args) {
		CraftCalc c = new CraftCalc();
		c.roll();
	} 
}
