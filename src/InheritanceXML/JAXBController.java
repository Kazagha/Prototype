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
		SubObject sub = new SubObject("Test", 10);
		Basic basic = new Basic("Name", 12);
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Basic.class);		
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		marshaller.marshal(basic, System.out);	
		
	}
}
