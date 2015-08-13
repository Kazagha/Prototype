package Conf_Testing;

import java.io.File;

import net.arcanesanctuary.Configuration.*;

public class ExampleNode {
	
	public static void main (String[] args)
	{
		// Utilities for testing
		Util u = new Util();
		// Create the root node 
		ConfNode root = new ConfNode("UserSettings", null, null);	
		// Create a new variable
		root.add(new String[] {"First Name", "Last Name", "E-mail"});
		// Add placeholder nodes
		u.addConfNodes(root);
		// Prompt the user for input 
		root.prompt(true);
		// Specific prompt
		root.prompt(false, new String[] { "Name" });		
		// Get variables 
		System.out.format("Name: %s%nCompanion: %s %n", root.get("FirstName"), root.get("Type"));
		System.out.format("Bonus: %s%n", root.get("Bonus"));
		// null the specified variables
		root.nullValues(new String[] { "Environment" });
		// Save the config file
		XMLController xml = new XMLController(new File("test_file.xml"));
		xml.save(root);
	}
}
