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
		
		File fileName = new File("xml_test.xml");
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Conf.class);
			
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			
			Conf root = new Conf();
			
			if(fileName.exists()) {
				root = (Conf) unmarshaller.unmarshal(fileName);
			}			
			
			root.setVar("User");
			root.setDesc("Enter your username");
			root.setVal("test.user");
			
			//System.out.print(root.contains("Bonus"));
			
			// Add new Children
			//root.newChild().setVar("new");
			//root.appendChild(new Conf("Test", null, null));
			
			// Delete Children
			//root.del("New Child");
			
			// Prompt User for input 
			root.prompt(true, new String[] { "Bonus" });
												
			Util u = new Util();
			//u.addConfs(root);
			
			//System.out.println(root.get("Bonus").getVal());
					
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			marshaller.marshal(root, System.out);
			marshaller.marshal(root, fileName);
			
		} catch (Exception e) {
			System.out.format("Error %s%n", e);
			e.printStackTrace();
		}
	}
}