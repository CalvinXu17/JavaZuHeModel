package employee;

import Interface.Info;

public class EmpluyeeInfo implements Info {

	private String name;
	private int level;
	private float salary;
	
	public EmpluyeeInfo(String name,int level,float salary) {
		this.name = name;
		this.level = level;
		
		this.salary = salary;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return this.level;
	}

	@Override
	public float getSalary() {
		// TODO Auto-generated method stub
		return this.salary;
	}

}
