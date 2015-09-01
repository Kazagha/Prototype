package Conf_Testing;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import net.arcanesanctuary.Configuration.Conf;

public class Conf_XML_Test {
	public static void main(String[] args) {
		
		File fileName = new File("settings.xml");
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Conf.class);
			
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			
			Conf root = new Conf();
						
			if(fileName.exists()) {
				// Load the file if it exists
				root = (Conf) unmarshaller.unmarshal(fileName);
			} else {
				// Otherwise create the file
				fileName.createNewFile();
				
				root = new Conf("Settings", "Server Settings", null);
				root.appendChildren(new String[] { "Username", "Server"});
				root.appendChild(new Conf("Environment", "Input environment", null));
			}
						
			// Add Children Nodes
			root.appendChildren(new String[] { "Input", "Input" });
			root.appendChild().setVar("Input");
			root.appendChild(new Conf("InputDesc", "Prompt with description", null));
			
			// Edit Children nodes
			root.getNode("Input").setDesc("Prompt the user for input");
			
			// Prompt for specific variables
			root.prompt(true, new String[] { "Input" });
			// Prompt for all null variables
			root.prompt(true);
			
			// Fetch information
			String conn = 
					  root.get("Server") 
					+ "-"  
					+ root.get("Environment");
			System.out.format("%s%n", conn);
			
			// Delete the specified child
			root.removeChild("InputDesc");
			// Delete all children that match the specified variable
			root.removeChildren(new String[] { "Input" });
			
			// Null the value of the specified variable
			root.setNullValues(new String[] { "Environment" } );
						
			// Prepare the marshaller
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			// Print to console then save to file
			marshaller.marshal(root, System.out);
			marshaller.marshal(root, fileName);
			
		} catch (Exception e) {
			System.out.format("Error %s%n", e);
			e.printStackTrace();
		}
	}
}