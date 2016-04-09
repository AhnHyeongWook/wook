import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
 
public class JavaSerializationSample {
    @SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, ClassNotFoundException {
 
    	FileOutputStream fos = new FileOutputStream("d:\\serial\\serial.txt", false);
    	BufferedOutputStream bos = new BufferedOutputStream(fos);
    	ObjectOutputStream out = new ObjectOutputStream(bos);    	
    	
    	
    	VO vo1 = new VO("ob1", "aaa@domain.com", 11);
    	VO vo2 = new VO("ob2", "bbb@domain.com", 12);
    	ArrayList<VO> list = new ArrayList<>();
    	list.add(vo1);
    	list.add(vo2);
    	 
    	out.writeObject(vo1); // first object
    	out.writeObject(vo2); // second object
    	out.writeObject(list); // third object
        out.close();
        
        
        FileInputStream fis = new FileInputStream("d:\\serial\\serial.txt");
    	BufferedInputStream bis = new BufferedInputStream(fis);
    	ObjectInputStream ois = new ObjectInputStream(bis);
    	
    	
        VO v1 = (VO) ois.readObject(); // first object
        VO v2 = (VO) ois.readObject(); // second object
        ArrayList<VO> vlist = (ArrayList<VO>) ois.readObject(); // third object
         
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(vlist.get(0));
        System.out.println(vlist.get(1).getEmail()); // 리스트 1번째의 이메일주소를 읽어들임
         
        ois.close();
      
    }
    
}
 
class VO implements Serializable {
    private static final long serialVersionUID = -395246598280398285L;
    
    private String name;
    private int age;
    transient private String email; // transient은 직렬화 할때, 초기값으로 저장시키고 직렬화에 참여시키지 않음
    public VO(String name, String email, int age) {
    	this.name = name;
    	this.age = age;
    	this.email = email;	
	}

   
   
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getAge() {
        return age;
    }
 
    public void setAge(int age) {
        this.age = age;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
}
