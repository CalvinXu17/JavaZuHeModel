package Interface;

// 定义职工信息接口(有两种实现，分别为BossInfo和EmployeeInfo)
public interface Info {

	public String getName(); //获取姓名

	public int getLevel(); //获取职工等级

	public float getSalary(); //获取薪水

	public void setLevel(int level); //设置职工等级
}
