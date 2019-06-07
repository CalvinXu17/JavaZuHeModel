package Method;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Interface.Info;
import Interface.People;

// 功能方法类
public class travelAllitem {

	private People root; // 根节点 即公司老板

	public travelAllitem(People root) {
		this.root = root;
	}

	// 删除某位员工 (递归查找并删除,并将被删除员工的子节点归并到被删除员工的父节点)
	public boolean deleteChild(String name, People roots) {
		
		People rroot = null;
		if (roots == null) {
			rroot = this.root;
		} else {
			rroot = roots;
		}
		if (!rroot.getChild().isEmpty()) {
			// 遍历子节点
			for (int i = 0; i < rroot.getChild().size(); i++) {
				People c = rroot.getChild().get(i);
				// 找到要删除的员工
				if (c.getInfo().getName().equals(name)) {
					rroot.deleteChild(name); //将其从根节点删除

					List<People> cChildlist = c.getChild(); //获取被删除节点的子节点list
					for (int j = 0; j < c.getChild().size(); j++) {
						People child = cChildlist.get(j);
						child.getInfo().setLevel(child.getInfo().getLevel() - 1); //将被删除节点的子节点的等级更新1级
						rroot.add(child); //将被删除节点的子节点归并到被删除节点的根节点下
					}
					return true;
				} else {
					if (deleteChild(name, c))
						return true;
				}
			}
		}
		return false;
	}

	// 以下方法核心思路是层序遍历树的节点

	// 计算薪水和
	public float getAllSalary() {
		float sumSalary = 0.0f;
		Queue<People> Q = new LinkedList<People>();
		Q.offer(root);
		// 利用队列层序遍历计算薪水和
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

	// 打印公司所有员工关系信息
	public void showAllInfo() {
		Queue<People> Q = new LinkedList<People>();

		Q.offer(root);
		// 利用队列层序遍历，逐层打印职工信息
		while (!Q.isEmpty()) {
			People p = Q.poll();
			if (p.getInfo().getLevel() == 1) {
				System.out.println("1级 公司老板:" + p.getInfo().getName() + " 薪水(基础 *1.5):" + p.getInfo().getSalary());
			} else {
				System.out.println(String.valueOf(p.getInfo().getLevel()) + "级 公司职工:" + p.getInfo().getName() + " 薪水:"
						+ p.getInfo().getSalary());
			}

			List<People> child = p.getChild();

			if (!child.isEmpty()) {
				System.out.print(p.getInfo().getName() + "直接管理员工信息:[ ");
				for (int i = 0; i < child.size(); i++) {
					People c = child.get(i);
					Info inf = c.getInfo();

					System.out.print(String.valueOf(inf.getLevel()) + "级:" + inf.getName());

					if (i != child.size() - 1) {
						System.out.print(" , ");
					} else {
						System.out.println(" ]\n");
					}
					Q.offer(c);
				}
			} else {
				System.out.println(p.getInfo().getName() + "无直接管理的员工\n");
			}
		}
	}

	// 给某位员工添加一个下属
	public boolean addRootChild(String rootname, People newchild) {

		Queue<People> Q = new LinkedList<People>();
		Q.offer(root);
		// 利用队列层序遍历找到并添加下属
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

	// 查找员工的信息
	public People FindOnePeople(String name) {
		Queue<People> Q = new LinkedList<People>();
		// 利用队列层序遍历找到员工并返回该员工对象
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
