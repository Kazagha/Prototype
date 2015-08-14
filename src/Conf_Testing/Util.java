package Conf_Testing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.tree.DefaultMutableTreeNode;

import net.arcanesanctuary.Configuration.Conf;

public class Util {
	Random rand;
	ArrayList<String> arrayL1;
	ArrayList<String> arrayL2;
	
	public Util() {		
		rand = new Random();
		arrayL1 = new ArrayList<String>();
		arrayL2 = new ArrayList<String>();
	}
	
	public void addConfs(Conf rootNode) {	
		populateArray(arrayL1);
		populateAttributes(arrayL2);
		
		for(int i = 0; i < random(1, 15); i++) {
			// Select randomly from the array
			String animal = arrayL1.get(random(0, arrayL1.size() - 1));
			Conf cn = new Conf("Companion", null, "");
			Conf cnType = new Conf("Type", null, animal);
			cn.appendChild(cnType);
						
			// Add 1-3 bonuses at random
			for(int j = 0; j < random(0, 3); j++) {
				String bonusStr = arrayL2.get(random(0, arrayL2.size() - 1));
				
				Conf bonus = new Conf("Bonus", "Provides a bonus to", bonusStr);
				cn.appendChild(bonus);				
			}
			
			// Add ConfData to the root
			rootNode.appendChild(cn);
		}
		
		//return rootNode;
	}
	
	public int random(int min, int max) { 
		return rand.nextInt((max - min) + 1) + min;
	}
	
	public void populateArray(ArrayList<String> array) {
		array.add("Ape (animal)");
		array.add("Bear, black (animal)");
		array.add("Bison (animal)");
		array.add("Boar (animal)");
		array.add("Cheetah (animal)");
		array.add("Crocodile (animal)");
		array.add("Dire badger");
		array.add("Dire bat");
		array.add("Dire weasel");
		array.add("Leopard (animal)");
		array.add("Lizard, monitor (animal)");
		array.add("Shark, Large (animal)");
		array.add("Snake, constrictor (animal)");
		array.add("Snake, Large viper (animal)");
		array.add("Wolverine (animal)");
	}
	
	public void populateAttributes(ArrayList<String> array) {
		array.add("STR");
		array.add("DEX");
		array.add("WIS");
		array.add("INT");
		array.add("CHA");
		array.add("CON");
	}
}
