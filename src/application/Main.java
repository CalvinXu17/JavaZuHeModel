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
		
		// ʵ������˾�ϰ壨1��ְ����
		Info bossinfo = new BossInfo("���ϰ�", 1, 20000.0f);
		People boss = new Employee(bossinfo);

		// ʵ��������2��ְ��
		Info level2info1 = new EmployeeInfo("�Ž�", 2, 10000.0f);
		People level2p1 = new Employee(level2info1);

		Info level2info2 = new EmployeeInfo("����", 2, 10000.0f);
		People level2p2 = new Employee(level2info2);

		// �������2��ְ��Ϊ1����˾�ϰ������
		boss.add(level2p1);
		boss.add(level2p2);

		// ʵ��������3��ְ��
		Info level3info1 = new EmployeeInfo("����", 3, 8000.0f);
		People level3p1 = new Employee(level3info1);

		Info level3info2 = new EmployeeInfo("����", 3, 8000.0f);
		People level3p2 = new Employee(level3info2);

		// ������3��ְ�����Ϊ2��ְ���Žܵ�����
		level2p1.add(level3p1);
		level2p1.add(level3p2);

		// ʵ��������3��ְ��
		Info level3info3 = new EmployeeInfo("����", 3, 8000.0f);
		People level3p3 = new Employee(level3info3);

		Info level3info4 = new EmployeeInfo("����", 3, 8000.0f);
		People level3p4 = new Employee(level3info4);

		// ������3��ְ�����Ϊ2��ְ�����ֵ�����
		level2p2.add(level3p3);
		level2p2.add(level3p4);

		// ʵ���������࣬���ø��ڵ�Ϊ���ϰ�
		travelAllitem method = new travelAllitem(boss);

		// ��ӡ��ǰ����Ա������Ϣ
		System.out.println("��˾��ǰ������Ա��ϵ:");
		method.showAllInfo();

		// 5���ѡ��
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("ѡ����:\n1:��ӡ������Ա��ϵ\n2:ͳ��������Աнˮ��\n3:��Ա���������\n4:ɾ��Ա��\n5:��ѯԱ��\n0:�˳�\n������:");
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
				System.out.print("��˾��ǰ����Ա��нˮ��: ");
				System.out.println(method.getAllSalary());
				break;
			}
			case 3: {
				System.out.println("������Ҫ���������Ա������:");
				String name1 = scan.next();
				System.out.println("��������ӵ�Ա������Ϣ(����,нˮ)�Կո����:");
				String name2 = scan.next();
				float sala = scan.nextFloat();
				if (method.addRootChild(name1, new Employee(new EmployeeInfo(name2, 0, sala)))) {
					System.out.println("��ӳɹ���");
				} else {
					System.out.println("���ʧ�ܣ�");
				}
				break;
			}
			case 4: {
				System.out.println("����Ҫɾ��Ա��������:");
				String name1 = scan.next();
				if (method.deleteChild(name1, null)) {
					System.out.println("ɾ���ɹ���");
				} else {
					System.out.println("ɾ��ʧ�ܣ�");
				}
				break;
			}
			case 5: {
				System.out.println("����Ҫ��ѯְ��������:");
				String name1 = scan.next();
				People p = method.FindOnePeople(name1);
				if (p == null) {
					System.out.println("Ա��������!");
				} else {
					Info inf = p.getInfo();
					System.out.println(
							String.valueOf(inf.getLevel()) + "��ְ��:" + inf.getName() + " нˮ:" + inf.getSalary());
					List<People> child = p.getChild();
					if (!child.isEmpty()) {
						System.out.print(p.getInfo().getName() + "ֱ�ӹ���Ա����Ϣ:[ ");
						for (int i = 0; i < child.size(); i++) {
							People c = child.get(i);

							Info inf1 = c.getInfo();

							System.out.print(String.valueOf(inf1.getLevel()) + "��:" + inf1.getName());

							if (i != child.size() - 1) {
								System.out.print(" , ");
							} else {
								System.out.println(" ]\n");
							}
						}
					} else {
						System.out.println(p.getInfo().getName() + "��ֱ�ӹ����Ա��\n");
					}
				}
				break;
			}
			}
		}
		scan.close();
	}
}
