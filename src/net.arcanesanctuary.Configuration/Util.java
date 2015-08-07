package net.arcanesanctuary.Configuration;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.tree.DefaultMutableTreeNode;

public class Util {
	Random rand;
	ArrayList<String> arrayL1;
	ArrayList<String> arrayL2;
	
	public Util() {		
		rand = new Random();
		arrayL1 = new ArrayList<String>();
		arrayL2 = new ArrayList<String>();
	}
	
	public void addConfNodes(ConfNode rootNode) {	
		populateArray(arrayL1);
		populateAttributes(arrayL2);
		
		//ConfNode rootNode = new ConfNode("root", "The root node", null);
		//ConfNode rootNode = cn;
		
		for(int i = 0; i < random(1, 15); i++) {
			// Select randomly from the array
			String animal = arrayL1.get(random(0, arrayL1.size() - 1));
			ConfNode cn = new ConfNode("Companion", null, "");
			ConfNode cnType = new ConfNode("Type", null, animal);
			cn.add(cnType);
						
			// Add 1-3 bonuses at random
			for(int j = 0; j < random(0, 3); j++) {
				String bonusStr = arrayL2.get(random(0, arrayL2.size() - 1));
				
				ConfNode bonus = new ConfNode("Bonus", "Provides a bonus to", bonusStr);
				cn.add(bonus);				
			}
			
			// Add ConfData to the root
			rootNode.add(cn);
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
