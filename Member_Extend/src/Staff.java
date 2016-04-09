
/** @className : Staff.java
 *  @auter : Ahn
 */
public class Staff extends Member
{
	private String work; // 업무
	private String position; // 직위
	
	public Staff(int id, String name, String work, String position, String phone, int memberType)
	{
		this.id = id;
		this.name = name;
		this.work = work;
		this.position = position;
		this.phone = phone;
		this.memberType = memberType;
	}
	
	// getter
	public String getWork() { return work; }
	public String getPosition() { return position; }

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
		System.out.println("work : " + work);
		System.out.println("position : " + position);
		System.out.println("phone_no : " + phone);
		System.out.println();
	}
} // end Staff.java
