import java.io.IOException;
import java.util.Scanner;

/** @className : Main.java
 * @auter : Ahn
 */
public class Main 
{
	// object 
	private Scanner s = new Scanner(System.in);
	private MemberList ml = new MemberList();
	
	// variable
	private int select;

	/**@Method_name : main
	 * @Update_date : 2016. 3. 26.
	 * @Return_type : void
	 * @Explanation : 
	 */
	public void main() throws ClassNotFoundException, IOException 
	{
		System.out.println("Member Manager Program Ver 1.0 Java");

		while (true)
		{
			System.out.println("[ Menu ]");
			System.out.println("1. insert Member \t 2. delete Member \t 3. update Member \t 4.print Member \t 5.exit");
			System.out.print("select -> ");
			select = s.nextInt();
			System.out.println();

			switch (select)
			{
			case 1:	// insert Member
				System.out.println("1. Student \t 2. Faculty \t 3. Staff");
				System.out.print("select -> ");
				int memberType = s.nextInt();
				System.out.println();
				
				ml.insertMember(memberType);
				break;

			case 2: // delete Member
				ml.deleteMember();
				break;
				
			case 3:
				// update Member
				break;
				
			case 4:
				ml.printMember();
				break;

			case 5:
				System.out.println("exiting program..");
				System.exit(1);
				break;

			default:
				System.out.println("input menu's number.");
				break;
			}
		}
	} // end main method

	public static void main(String[] args) throws ClassNotFoundException, IOException
	{
		Main m = new Main();
		m.main();
	}
} // end Main.java
