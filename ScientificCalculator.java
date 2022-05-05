//Anushna Bora 
import java.io.*;
import java.util.Scanner;

public class ScientificCalculator extends Calculate{
     char cOperator;
     double dblNum;
     
	public ScientificCalculator() {
		super();
	}

	public ScientificCalculator(double dblNum ,char cOperator) {
		super(dblNum,cOperator);
		this.cOperator = cOperator;
		this.dblNum = dblNum;
	}
	public void Calc() throws java.io.IOException{
		boolean next;
		
		do {
		Double d = new Double(0);	
		BufferedReader buffer= new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Please enter the operation to perform: \n Sine-s \n Cosine-c \n Tan-t \n Logarithm-l \n NaturalLog-z \n Square Root-r \n InverseSine- i \n InverseCos- o \n InverseTan-j \n Power of a Number-m \n Decimal to Binary-d \n Binary to Decimal-b");
		System.out.flush();
		String option = buffer.readLine();
		System.out.println("Please enter a value: ");
		System.out.flush();
		
		try
		{
			d=Double.valueOf(buffer.readLine());
		}
		catch(NumberFormatException e)
		{
			System.out.println("Enter numeric values only!!");
			System.exit(0);
		}
		
		if(option.length()==1)
		{
			// Creates Class Instance
			ScientificCalculator sc=new ScientificCalculator(d,option.charAt(0));

			// Calls Super Class Methods
			sc.doCalculation();
			sc.getResult();
		}
		else
		{
			System.out.println("Invalid Operation!!!! Choose from the available operations.");
		}
		
		// Checks if the user would like to compute again
		System.out.println("Calculate again? (y/n)?");
		System.out.println("");
		System.out.println("Show Previous Calculation: p");
		System.out.println();
		System.out.println("Store for later use"+ "(s)");
		System.out.flush();
		char aa=(char)buffer.read();
		if ((aa=='y') || (aa=='Y'))
		{
			System.out.println("Your saved memo is: ");
            File file = new File("History.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String abc = br.readLine();
            System.out.println(abc);
			next=false;
		}
		else if(aa=='p')
		{
			
            File file = new File("calculationHistory.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String abc = br.readLine();
            System.out.println(abc);
			next=false;
		}
		else if(aa=='s') {
			System.out.println("do you want to add previous one or your own?");
			System.out.println("previous :::p");
			System.out.println("your own :::o");
			Scanner sc = new Scanner(System.in);
			String mc = sc.next();
			if(mc.equals("p")) {
				
            File file = new File("calculationHistory.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String memo1 = br.readLine();
            FileWriter fw = new FileWriter("History.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(memo1);
            bw.close();
            System.out.println("success!!");
            
		}
			else{
			System.out.println("add number of your choice: ");	
			String mc2 = sc.next();
			String memo2 = mc2;
			 FileWriter fw = new FileWriter("History.txt");
	            BufferedWriter bw = new BufferedWriter(fw);
	            bw.write(memo2);
	            bw.close();
	            System.out.println("success!!");
			}
			next = false;
			}
		else {
			next = true;
		}
		}while(!next);
		}
     
}
