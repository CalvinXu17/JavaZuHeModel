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

		Info bossinfo = new BossInfo("���ϰ�", 1, 20000.0f);
		People boss = new Employee(bossinfo);

		Info level2info1 = new EmployeeInfo("���", 2, 10000.0f);
		People level2p1 = new Employee(level2info1);

		Info level2info2 = new EmployeeInfo("����", 2, 10000.0f);
		People level2p2 = new Employee(level2info2);

		boss.add(level2p1);
		boss.add(level2p2);

		Info level3info1 = new EmployeeInfo("����", 3, 8000.0f);
		People level3p1 = new Employee(level3info1);

		Info level3info2 = new EmployeeInfo("����", 3, 8000.0f);
		People level3p2 = new Employee(level3info2);

		level2p1.add(level3p1);
		level2p1.add(level3p2);

		Info level3info3 = new EmployeeInfo("����", 3, 8000.0f);
		People level3p3 = new Employee(level3info3);

		Info level3info4 = new EmployeeInfo("����", 3, 8000.0f);
		People level3p4 = new Employee(level3info4);

		level2p2.add(level3p3);
		level2p2.add(level3p4);

		travelAllitem t = new travelAllitem(boss);

		System.out.println("��˾��ǰ������Ա��ϵ:");
		t.showAllInfo();

		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("ѡ����:\n1:��ӡ������Ա��ϵ\n2:ͳ��������Աнˮ��\n3:��Ա���������\n4:ɾ��Ա��\n5:��ѯԱ��\n0:�˳�");
			int N = 0;
			N = scan.nextInt();

			if( N == 0)
				break;
			
			switch (N) {
				
			}
		}

		scan.close();
		// System.out.println(t.getAllSalary());

		// t.addRootChild("���", new Emplyee(new EmpluyeeInfo("123", 0,
		// 9000.0f)));

		// t.showAllInfo();

		// System.out.println(t.FindOnePeople("���").getInfo().getName());

	}
}
