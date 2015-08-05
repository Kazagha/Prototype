package net.arcanesanctuary.Configuration;

import java.io.File;

public class ExampleNode {
	
	public static void main (String[] args)
	{
		// Utilities for testing
		Util u = new Util();
		// Create the root node with placeholder nodes
		ConfNode root = u.getConfNodes();		
		// Create a new variable
		root.set("Name", "Enter your name ", null);
		root.set("Environment", "Enter the environment", null);
		// Prompt the user for input 
		root.prompt(true);
		// Specific prompt
		root.prompt(false, new String[] { "Bonus" });		
		// Get variables 
		System.out.format("Name: %s%nCompanion: %s %n", root.get("Name"), root.get("Companion"));
		System.out.format("Bonus: %s", root.get("Bonus"));
		// null the specified variables
		//config.nullValues(new String[] {"Password"});
		// Save the config file
		//config.save();
	}
}
