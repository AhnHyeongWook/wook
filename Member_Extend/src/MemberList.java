import java.util.Scanner;

/** @className : MemberList.java
 *  @auter : Ahn
 */
public class MemberList 
{
	private Member[] memberList = new Member[100];
	private Scanner s = new Scanner(System.in);
	private int count = 0;
	
	
	public MemberList()
	{
	
	}
	
	/**@Method_name : insertMember
	 * @Update_date : 2016. 4. 1.
	 * @Return_type : void
	 * @Explanation : 
	 */
	public void insertMember(int memberType)
	{
		
		// student
		if( memberType == 1 )
		{
			System.out.println("< Insert Student Imformation >");
			System.out.print("id  : ");
			int i_id = s.nextInt();
			
			System.out.print("name : ");
			String i_name = s.next();
			
			System.out.print("department : ");
			String i_department = s.next();
			
			System.out.print("grade : ");
			int i_grade = s.nextInt();
			
			System.out.print("phone_no : ");
			String i_phone_no = s.next(); 
						
			memberList[count] = new Student(i_id, i_name, i_department, i_grade, i_phone_no, memberType);

	        System.out.println("[Success] inser id : " + i_id);
	        System.out.println();
	        count ++;
		}
		
		// faculty
		else if( memberType == 2 )
		{
			System.out.println("< Insert Faculty Imformation >");
			System.out.print("id  : ");
			int i_id = s.nextInt();
			
			System.out.print("name : ");
			String i_name = s.next();
			
			System.out.print("department : ");
			String i_department = s.next();
			
			System.out.print("grade : ");
			String i_degree = s.next();
			
			System.out.print("phone_no : ");
			String i_phone_no = s.next(); 
						
			memberList[count] = new Faculty(i_id, i_name, i_department, i_degree, i_phone_no, memberType);

	        System.out.println("[Success] inser id : " + i_id);
	        System.out.println();
	        count ++;
		}
		
		// staff
		else 
		{
			System.out.println("< Insert Staff Imformation >");
			System.out.print("id  : ");
			int i_id = s.nextInt();
			
			System.out.print("name : ");
			String i_name = s.next();
			
			System.out.print("department : ");
			String i_work = s.next();
			
			System.out.print("grade : ");
			String i_position = s.next();
			
			System.out.print("phone_no : ");
			String i_phone_no = s.next(); 
						
			memberList[count] = new Staff(i_id, i_name, i_work, i_position, i_phone_no, memberType);

	        System.out.println("[Success] inser id : " + i_id);
	        System.out.println();
	        count ++;
		}

	}// end insertMember method
	
	public void deleteMember()
	{
		int deleteId;
		System.out.println("< Delete Student Imformation >");
		System.out.print("Input delete Id : ");

		deleteId = s.nextInt();
			
		if (findMember(deleteId) == -1) 
		{
			System.out.println("- not found id");
			System.out.println();

		}

		else 
		{
			for (int i = findMember(deleteId); i < count - 1; i++)
				memberList[i] = memberList[i + 1];
		}

		count--;
		System.out.println("[Success] delete id : " + deleteId);
		System.out.println();
	}// end deleteMember method
	
	public void updateMember()
	{
		
	}// end updateMember method
	
	/**@Method_name : printMember
	 * @Update_date : 2016. 4. 1.
	 * @Return_type : void
	 * @Explanation : 
	 */
	public void printMember()
	{
		for (int i = 0; i < count; i++)
		{
			if( memberList[i].getMemberType() == 1 )
				System.out.println("[Student]");
			
			else if( memberList[i].getMemberType() == 2 )
				System.out.println("[Faculty]");
			
			else if( memberList[i].getMemberType() == 3 )
				System.out.println("[Staff]");
			
			memberList[i].printMember();
		}
	}// end printMember method
	
	public int findMember(int findId)
	{
		for (int i = 0; i < memberList.length; i++)
		{			
			if( memberList[i].getId() == findId )
				return i;
		}
		return -1;
	}// end findMember method
}// end MemberList.java
