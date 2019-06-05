package employee;

import Interface.Info;

// 实现Info接口，职工信息（薪水不加倍）
public class EmployeeInfo implements Info {

	private String name;
	private int level;
	private float salary;

	public EmployeeInfo(String name, int level, float salary) {
		this.name = name;
		this.level = level;

		this.salary = salary;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getLevel() {
		return this.level;
	}

	@Override
	public float getSalary() {
		return this.salary;
	}

	@Override
	public void setLevel(int level) {
		this.level = level;
	}

}
