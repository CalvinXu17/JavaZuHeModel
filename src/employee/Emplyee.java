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
	public List<People> getChild() {
		// TODO Auto-generated method stub
		return this.childlist;
	}

}
