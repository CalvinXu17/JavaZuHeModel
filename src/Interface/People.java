package Interface;
import java.util.List;

// 定义职工结点接口
public interface People {

	public void add(People peo); //添加下属

	public List<People> getChild(); //获取下属的链表

	public Info getInfo(); //获取个人信息

	public boolean deleteChild(String name); //删除下属
}
