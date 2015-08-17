package Conf_Testing;

import java.io.File;

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
			
			Conf root = (Conf) unmarshaller.unmarshal(fileName);	
			
			root.setVar("User");
			root.setDesc("Enter your username");
			root.setVal("test.user");
			
			Util u = new Util();
			u.addConfs(root);
			
			//String bonus = root.get("Bonus");
			System.out.println(root.get("Bonus").getVal());
					
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			marshaller.marshal(root, System.out);
			marshaller.marshal(root, fileName);
			
		} catch (Exception e) {
			System.out.format("Error %s%n %s", e, e.getStackTrace());
		}
	}
}