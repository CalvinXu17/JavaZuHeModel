package Method;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Interface.Info;
import Interface.People;

public class travelAllitem {

	private People root;

	public travelAllitem(People root) {
		this.root = root;
	}

	public float getAllSalary() {
		float sumSalary = 0.0f;

		Queue<People> Q = new LinkedList<People>();

		Q.offer(root);

		while (!Q.isEmpty()) {

			People p = Q.poll();

			sumSalary += p.getInfo().getSalary();

			List<People> child = p.getChild();

			for (int i = 0; i < child.size(); i++) {
				Q.offer(child.get(i));
			}
		}
		return sumSalary;
	}

	public void showAllInfo() {
		Queue<People> Q = new LinkedList<People>();

		Q.offer(root);

		while (!Q.isEmpty()) {

			People p = Q.poll();

			if (p.getInfo().getLevel() == 1) {
				System.out.println("1�� ��˾�ϰ�:" + p.getInfo().getName() + " нˮ(���� *1.5):" + p.getInfo().getSalary());
			} else {
				System.out.println(String.valueOf(p.getInfo().getLevel()) + "�� ��˾ְ��:" + p.getInfo().getName() + " нˮ:"
						+ p.getInfo().getSalary());
			}

			List<People> child = p.getChild();

			if (!child.isEmpty()) {
				System.out.print(p.getInfo().getName() + "ֱ�ӹ���Ա����Ϣ:[ ");
				for (int i = 0; i < child.size(); i++) {
					People c = child.get(i);

					Info inf = c.getInfo();

					System.out.print(String.valueOf(inf.getLevel()) + "��:" + inf.getName());

					if (i != child.size() - 1) {
						System.out.print(" , ");
					} else {
						System.out.println(" ]\n");
					}

					Q.offer(c);
				}
			} else {
				System.out.println(p.getInfo().getName() + "��ֱ�ӹ����Ա��\n");
			}
		}
	}

	public boolean addRootChild(String rootname, People newchild) {

		Queue<People> Q = new LinkedList<People>();

		Q.offer(root);

		while (!Q.isEmpty()) {

			People p = Q.poll();

			String pname = p.getInfo().getName();

			if (pname.equals(rootname)) {
				newchild.getInfo().setLevel(p.getInfo().getLevel() + 1);
				p.add(newchild);
				return true;
			}

			List<People> child = p.getChild();

			for (int i = 0; i < child.size(); i++) {
				Q.offer(child.get(i));
			}
		}
		return false;
	}

	public boolean deleteChild(String name) {
		Queue<People> Q = new LinkedList<People>();
		Q.offer(root);
		while (!Q.isEmpty()) {
			People p = Q.poll();

			if (p.deleteChild(name)) {
				return true;
			}

			List<People> child = p.getChild();

			for (int i = 0; i < child.size(); i++) {

				Q.offer(child.get(i));
			}
		}
		return false;
	}

	public People FindOnePeople(String name) {
		Queue<People> Q = new LinkedList<People>();

		Q.offer(root);

		while (!Q.isEmpty()) {

			People p = Q.poll();

			String pname = p.getInfo().getName();

			if (pname.equals(name)) {
				return p;
			}

			List<People> child = p.getChild();

			for (int i = 0; i < child.size(); i++) {
				Q.offer(child.get(i));
			}
		}
		return null;
	}
}
