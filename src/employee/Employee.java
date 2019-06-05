package employee;

import java.util.ArrayList;
import java.util.List;

import Interface.Info;
import Interface.People;

// ʵ��People�ӿڣ�����ʵ������˾Ա������
public class Employee implements People {

	// ���ģʽʹ��:
	private List<People> childlist; // �������������list
	private Info info; // ���Ա����Ϣ

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
