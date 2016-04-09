
/** @className : Faculty.java
 *  @auter : Ahn
 */
public class Faculty extends Member
{
	private String department;
	private String degree; // 학위
	
	public Faculty(int id, String name, String department, String degree, String phone, int memberType)
	{
		this.id = id;
		this.name = name;
		this.department = department;
		this.degree = degree;
		this.phone = phone;
		this.memberType = memberType;
	}
	
	// getter
	public String getDepartment() { return department; }
	public String getDegree() { return degree; }

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
		System.out.println("degree : " + degree);
		System.out.println("phone_no : " + phone);
		System.out.println();
	}
} // end Faculty.java
