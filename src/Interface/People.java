package Interface;
import java.util.List;

// ����ְ�����ӿ�
public interface People {

	public void add(People peo); //�������

	public List<People> getChild(); //��ȡ����������

	public Info getInfo(); //��ȡ������Ϣ

	public boolean deleteChild(String name); //ɾ������
}
