package employee;

import java.util.ArrayList;
import java.util.List;

import Interface.Info;
import Interface.People;

public class Employee implements People {

	private List<People> childlist;

	private Info info;

	public Employee(Info info) {
		this.childlist = new ArrayList<People>();
		this.info = info;
	}

	@Override
	public void add(People peo) {
		childlist.add(peo);
	}

	@Override
	public boolean deleteChild(String name) {
		for (int i = 0; i < childlist.size(); i++) {
			String ename = childlist.get(i).getInfo().getName();
			if (ename.equals(name)) {
				childlist.remove(i);
				return true;
			}
		}
		return false;
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
		for (int i = 0; i < childlist.size(); i++) {
			sum += childlist.get(i).getInfo().getSalary();
		}
		return sum;
	}

}
