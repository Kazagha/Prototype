package InheritanceXML;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BaseObject {

	String name; 
	public BaseObject(String name) 
	{
		this.name = name;
	}
	
	public BaseObject() {}
	
	public void setName(String s)
	{
		this.name = s;
	}
	
	public String getName()
	{
		return this.name;
	}
}
