package Interface;

import java.util.List;

public interface People {
	
	
	public void add(People peo);
	
	public List<People> getChild();
	
	public Info getInfo();
	
	public float getChildSalaries();

	public void deleteChild(String name);
}
