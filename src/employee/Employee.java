package employee;

import java.util.ArrayList;
import java.util.List;

import Interface.Info;
import Interface.People;

// 实现People接口，用于实例化公司员工对象
public class Employee implements People {

	// 组合模式使用:
	private List<People> childlist; // 组合所有下属的list
	private Info info; // 组合员工信息

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
}
