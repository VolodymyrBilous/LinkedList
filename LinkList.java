import java.util.Iterator;


public class LinkList {
    public Buss first;
    private Buss current;
    
	public LinkList() {
		first = null;
		current = null;
	}
	public Buss remove(Buss b){
		Buss current = first; // ����� ��������
		Buss previous = first;
		while(current.next != null)
				{
			if(current.bussNumber == b.bussNumber)
			   break; // �������  ������
			else
			{
			 previous = current; // ������� � ���������� ��������
			 current = current.next;
			}
		} // ���������� �������
		if(current == first) // ���� ������ �������,
		   first = first.next; // �������� first
		else // � ��������� ������
		   previous.next = current.next; // ������ ��� � ������
		return current;			
	}
	@Override
	public String toString() {
		Buss current = first;
		String res = "";
		while(current.next != null){
		     res = res + current.getName();
		}
		return res;
	}
	public Buss remove(int key) {

		Buss current = first; // ����� ��������
		Buss previous = first;
		while(current.bussNumber != key){
			if(current.next == null)
			   return null; // ������� �� ������
			else
			{
			 previous = current; // ������� � ���������� ��������
			 current = current.next;
			}
		} // ���������� �������
		if(current == first) // ���� ������ �������,
		   first = first.next; // �������� first
		else // � ��������� ������
		   previous.next = current.next; // ������ ��� � ������
		return current;		
			
	}
	public Buss find(int bn){
		current = first;
		while(current != null){
			if (current.bussNumber == bn)
				return current;
			else
			    current = current.next;
		}
		return null;
		
	}
	public Buss getFirst(){

		 return first;
		
	}
	public boolean isEmpty(){
    	return (first == null);
    }
	public void add(Buss b){
		current = first;
		if (current == null){

			first = b;
			b.next = null;
		}
		else{		

			while(current.next != null){
				current = current.next;

			}
    	    current.next = b;
    	    b.next = null;
		}

	}
    public void insertFist(Buss newBuss){
    	newBuss.next = first;
    	first = newBuss;
    }
}
