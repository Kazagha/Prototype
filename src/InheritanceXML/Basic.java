package InheritanceXML;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={ "name", "num" })
public class Basic {

	String name;
	int num;
	public Basic(String name, int num)
	{
		this.name = name;
		this.num = num;
	}
	
	public Basic() {}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String s)
	{
		this.name = s;
	}
	
	public int getNum()
	{
		return num;
	}
	
	public void setNum(int i)
	{
		this.num = i;
	}
}
