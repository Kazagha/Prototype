package InheritanceXML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import net.arcanesanctuary.Configuration.Conf;

public class JAXBController 
{
	public JAXBController()
	{

	}
	
	public static void main (String[] args) throws JAXBException 
	{
		Basic basic = new Basic("Name", 12);
		BaseObject base = new BaseObject("Base Object");
		SubObject sub = new SubObject("Test", 10);		
		
		JAXBContext jaxbContext = JAXBContext.newInstance(SubObject.class);		
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		marshaller.marshal(sub, System.out);	
		
	}
}
