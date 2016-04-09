
/** @className : Member.java
 *  @auter : Ahn
 */
abstract public class Member 
{
	protected int id;
	protected String name;
	protected String phone;
	protected int memberType;
	
	public Member() {}
	
	// getter
	public int getId() { return id; }
	public String getName() { return name; }
	public String getPhone() { return phone; }
	public int getMemberType() { return memberType; }
	abstract public void printMember();
} // end Member.java
