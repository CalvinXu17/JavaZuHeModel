package application;

import java.util.Scanner;

import Interface.Info;
import Interface.People;
import employee.BossInfo;
import employee.EmployeeInfo;
import employee.Employee;
import Method.travelAllitem;

public class Main {

	public static void main(String[] args) {

		Info bossinfo = new BossInfo("许老板", 1, 20000.0f);
		People boss = new Employee(bossinfo);

		Info level2info1 = new EmployeeInfo("侯杰", 2, 10000.0f);
		People level2p1 = new Employee(level2info1);

		Info level2info2 = new EmployeeInfo("张林", 2, 10000.0f);
		People level2p2 = new Employee(level2info2);

		boss.add(level2p1);
		boss.add(level2p2);

		Info level3info1 = new EmployeeInfo("王斌", 3, 8000.0f);
		People level3p1 = new Employee(level3info1);

		Info level3info2 = new EmployeeInfo("李四", 3, 8000.0f);
		People level3p2 = new Employee(level3info2);

		level2p1.add(level3p1);
		level2p1.add(level3p2);

		Info level3info3 = new EmployeeInfo("刘芳", 3, 8000.0f);
		People level3p3 = new Employee(level3info3);

		Info level3info4 = new EmployeeInfo("张三", 3, 8000.0f);
		People level3p4 = new Employee(level3info4);

		level2p2.add(level3p3);
		level2p2.add(level3p4);

		travelAllitem t = new travelAllitem(boss);

		System.out.println("公司当前所有人员关系:");
		t.showAllInfo();

		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("选择功能:\n1:打印所有人员关系\n2:统计所有人员薪水和\n3:给员工添加下属\n4:删除员工\n5:查询员工\n0:退出");
			int N = 0;
			N = scan.nextInt();

			if( N == 0)
				break;
			
			switch (N) {
				
			}
		}

		scan.close();
		// System.out.println(t.getAllSalary());

		// t.addRootChild("侯杰", new Emplyee(new EmpluyeeInfo("123", 0,
		// 9000.0f)));

		// t.showAllInfo();

		// System.out.println(t.FindOnePeople("侯杰").getInfo().getName());

	}
}
