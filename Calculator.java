//Anushna Bora 
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Calculator extends Calculate{
	
	public void Calc() throws java.io.IOException{
		boolean next;
		
		do {
			Integer iFirstNumber=0;
			Integer iSecondNumber=0;
			
			BufferedReader buffer= new BufferedReader(new InputStreamReader(System.in));

			// Gets User Input
			System.out.println("Please enter First Number: ");
			System.out.flush();	
			try {
			iFirstNumber=Integer.parseInt(buffer.readLine()); }
			catch(NumberFormatException e)
			{
				System.out.println("Enter numeric values only!!");
				System.exit(0);
			}
			System.out.println("Please enter the Operation (Add : +, Minus : -, Product : *, Divide : /):");
			System.out.flush();
			String option=buffer.readLine();

			System.out.println("Please enter Second Number: ");
			System.out.flush();

			try
			{
				iSecondNumber=Integer.parseInt(buffer.readLine(),10);
			}
			catch(NumberFormatException e)
			{
				System.out.println("Enter numeric values only!!");
				System.exit(0);
			}
			if (option.length() == 1) {
				Calculate c = new Calculate(iFirstNumber,option.charAt(0),iSecondNumber);
				c.doCalculation();
				c.getResult();
			}
			else {
				System.out.println("Invalid Operation!!!! Choose from the available operations.");
			}
			// Checks if the user would like to compute again
						System.out.println("Calculate again? (y/n)");
						System.out.flush();
						
						char response=(char)buffer.read();
						if ((response=='y') || (response=='Y'))
						{
							next=false;
						}
						else
						{
							next=true;
						}
						
					
		} while(!next);
	}
}
