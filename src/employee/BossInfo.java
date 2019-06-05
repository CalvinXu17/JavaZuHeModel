package employee;

import Interface.Info;

// 实现Info接口，公司老板信息(薪水在基础上乘1.5)
public class BossInfo implements Info {

	private String name;
	private int level;
	private float salary;

	public BossInfo(String name, int level, float salary) {
		this.name = name;
		this.level = level;
		this.salary = salary * 1.5f;
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
