package craft;

import java.util.Random;
import java.util.Scanner;

public class CraftCalc {
	Scanner s;
	Random rand;
	int price;
	int dc;
	int skill;
	int progress;
	int roll;
	int weeks;
	
	public CraftCalc() {
		s = new Scanner(System.in);
		rand = new Random();
		weeks = 0;
		
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
			weeks++;
			
			if((skill + roll - dc) >= 0) {
				progress += (skill + roll) * dc;
				System.out.format("Week: %d%nCheck: %d %nProgress: %d/%d(sp)%n", weeks, roll + skill, progress, price);				
			} else {
				System.out.format("Week: %d%nCheck: %d (Failed %d) %nProgress: %d/%d(sp)%n", weeks, roll + skill, roll + skill - dc, progress, price);
			}
		}
	}

	/**
	 * The method nextInt(4) will return 0, 1, 2 and 3. The range starts at zero.
	 * The range is determined by (min - max) plus 1 
	 * The min value offsets the start of the range, as the minimum value is zero  
	 * @return - A random number between the min and max
	 */
	public int d20() {
		int min = 1; 
		int max = 20; 
		return rand.nextInt((max - min) + 1) + min;
	}
	
	public static void main (String[] args) {
		CraftCalc c = new CraftCalc();
		c.roll(); 
	} 
}
