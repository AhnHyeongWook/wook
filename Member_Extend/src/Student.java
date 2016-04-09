
/** @className : Student.java
 *  @auter : Ahn
 */
public class Student extends Member
{
	private String department;
	private int grade;
	
	public Student() { }
	public Student(int id, String name, String department, int grade, String phone, int memberType) 
	{
		this.id = id;
		this.name = name;
		this.department = department;
		this.grade = grade;
		this.phone = phone;
		this.memberType = memberType;
	}

	// getter
	public String getDepartment() { return department; }
	public int getGrade() { return grade; }

	/**@Over_ridden : @see Member#printMember()
	 * @Update_date : 2016. 3. 26.
	 * @Return_type : void
	 * @Explanation : process actionPerformens
	 */
	@Override
	public void printMember() 
	{
		System.out.println("id : " + id);
		System.out.println("name : " + name);
		System.out.println("department : " + department);
		System.out.println("grade : " + grade);
		System.out.println("phone_no : " + phone);
		System.out.println();
	}	
} // end Student.java
