package InheritanceXML;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class SubObject extends BaseObject {

	int number;	
	public SubObject(String name, int num) {
		super(name);
		this.number = num;
	}
	
	public SubObject() {}
}
