package employee;

import java.util.ArrayList;
import java.util.List;

import Interface.Info;
import Interface.People;

public class Emplyee implements People {

	private List<People> childlist;
	
	private Info info;
	
	public Emplyee(Info info) {
		this.childlist = new ArrayList<People>();
		this.info = info;
	}
	
	@Override
	public void add(People peo) {
		childlist.add(peo);
	}
	
	@Override
	public void deleteChild(String name) {
		boolean suc = false;
		for(int i=0;i<childlist.size();i++) {
			String ename = childlist.get(i).getInfo().getName();		
			if(ename.equals(name)) {
				childlist.remove(i);
				suc = true;
				break;
			}
		}
		
		if(suc) {
			System.out.println("É¾³ý³É¹¦£¡");
		} else {
			System.out.println("É¾³ýÊ§°Ü£¡");
		}
	}

	@Override
	public List<People> getChild() {
		// TODO Auto-generated method stub
		return this.childlist;
	}
	
	@Override
	public Info getInfo() {
		// TODO Auto-generated method stub
		return this.info;
	}
	
	@Override
	public float getChildSalaries() {
		float sum = 0.0f;
		for(int i=0;i<childlist.size();i++) {
			sum += childlist.get(i).getInfo().getSalary();
		}
		return sum;
	}

}
