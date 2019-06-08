package application;

import java.util.List;
import java.util.Scanner;

import Interface.Info;
import Interface.People;
import employee.BossInfo;
import employee.EmployeeInfo;
import employee.Employee;
import Method.travelAllitem;

public class Main {
	
	public static void main(String[] args) {
		
		// 实例化公司老板（1级职工）
		Info bossinfo = new BossInfo("许老板", 1, 20000.0f);
		People boss = new Employee(bossinfo);

		// 实例化两个2级职工
		Info level2info1 = new EmployeeInfo("张杰", 2, 10000.0f);
		People level2p1 = new Employee(level2info1);

		Info level2info2 = new EmployeeInfo("张林", 2, 10000.0f);
		People level2p2 = new Employee(level2info2);

		// 添加两个2级职工为1级公司老板的下属
		boss.add(level2p1);
		boss.add(level2p2);

		// 实例化两个3级职工
		Info level3info1 = new EmployeeInfo("王斌", 3, 8000.0f);
		People level3p1 = new Employee(level3info1);

		Info level3info2 = new EmployeeInfo("李四", 3, 8000.0f);
		People level3p2 = new Employee(level3info2);

		// 将两个3级职工添加为2级职工张杰的下属
		level2p1.add(level3p1);
		level2p1.add(level3p2);

		// 实例化两个3级职工
		Info level3info3 = new EmployeeInfo("刘芳", 3, 8000.0f);
		People level3p3 = new Employee(level3info3);

		Info level3info4 = new EmployeeInfo("张三", 3, 8000.0f);
		People level3p4 = new Employee(level3info4);

		// 将两个3级职工添加为2级职工张林的下属
		level2p2.add(level3p3);
		level2p2.add(level3p4);

		// 实例化功能类，设置根节点为许老板
		travelAllitem method = new travelAllitem(boss);

		// 打印当前所有员工的信息
		System.out.println("公司当前所有人员关系:");
		method.showAllInfo();

		// 5项功能选择
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("选择功能:\n1:打印所有人员关系\n2:统计所有人员薪水和\n3:给员工添加下属\n4:删除员工\n5:查询员工\n0:退出\n请输入:");
			int N = 0;
			N = scan.nextInt();

			if (N == 0)
				break;

			switch (N) {
			case 1: {
				method.showAllInfo();
				break;
			}
			case 2: {
				System.out.print("公司当前所有员工薪水和: ");
				System.out.println(method.getAllSalary());
				break;
			}
			case 3: {
				System.out.println("请输入要添加下属的员工姓名:");
				String name1 = scan.next();
				System.out.println("请输入添加的员工的信息(姓名,薪水)以空格隔开:");
				String name2 = scan.next();
				float sala = scan.nextFloat();
				if (method.addRootChild(name1, new Employee(new EmployeeInfo(name2, 0, sala)))) {
					System.out.println("添加成功！");
				} else {
					System.out.println("添加失败！");
				}
				break;
			}
			case 4: {
				System.out.println("输入要删除员工的姓名:");
				String name1 = scan.next();
				if (method.deleteChild(name1, null)) {
					System.out.println("删除成功！");
				} else {
					System.out.println("删除失败！");
				}
				break;
			}
			case 5: {
				System.out.println("输入要查询职工的姓名:");
				String name1 = scan.next();
				People p = method.FindOnePeople(name1);
				if (p == null) {
					System.out.println("员工不存在!");
				} else {
					Info inf = p.getInfo();
					System.out.println(
							String.valueOf(inf.getLevel()) + "级职工:" + inf.getName() + " 薪水:" + inf.getSalary());
					List<People> child = p.getChild();
					if (!child.isEmpty()) {
						System.out.print(p.getInfo().getName() + "直接管理员工信息:[ ");
						for (int i = 0; i < child.size(); i++) {
							People c = child.get(i);

							Info inf1 = c.getInfo();

							System.out.print(String.valueOf(inf1.getLevel()) + "级:" + inf1.getName());

							if (i != child.size() - 1) {
								System.out.print(" , ");
							} else {
								System.out.println(" ]\n");
							}
						}
					} else {
						System.out.println(p.getInfo().getName() + "无直接管理的员工\n");
					}
				}
				break;
			}
			}
		}
		scan.close();
	}
}
