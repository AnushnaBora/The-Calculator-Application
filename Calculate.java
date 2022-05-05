//Anushna Bora 

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Calculate extends iCalc {

	public Calculate() {
		
	}
	private double dblNum = 0;
	private char Operator;	
	private int iFirstNum;
	private int iSecondNum;
	private int iResult;
    private double dblResult; 
    private boolean typeDouble = false;
    private boolean typeInt = false;
	
	public Calculate(double dblNum, char cOperator) {
		
		this.dblNum = dblNum;
		this.Operator = cOperator;
		typeDouble = true;
	}

	public Calculate(int iFirstNum, char cOperator,  int iSecondNum) {
		
		Operator = cOperator;
		this.iFirstNum = iFirstNum;
		this.iSecondNum = iSecondNum;
		typeInt = true;
	}
	public void doCalculation() {
		File file = new File("calculationhistory.txt");
		file.deleteOnExit();
		
		try {
			FileWriter fw;
		
			fw = new FileWriter(file);
		    BufferedWriter bw = new BufferedWriter(fw);
		    bw.newLine();
//			iResult = 0;
//		    dblResult = 0.0;
		
		switch (Operator) {
		   
		case '+':
			checkInt();
			iResult = iFirstNum + iSecondNum;
			fw.append(iFirstNum + "" + Operator + "" + iSecondNum+ "=" + iResult);
			fw.close();
			break;
			
		case '-':
			checkInt();
			iResult = iFirstNum - iSecondNum;
			bw.newLine();
			fw.append(iFirstNum + "" + Operator + "" + iSecondNum+ "=" + iResult);
			fw.close();
			break;
			
		case '*':
			checkInt();
			iResult = iFirstNum * iSecondNum;
			bw.newLine();
			fw.write(iFirstNum + "" + Operator + "" + iSecondNum+ "=" + iResult);
			fw.close();
			break;
			
		case '/':
			checkInt();
			if(!checkSecondNum()) {
				iResult = iFirstNum / iSecondNum;
				bw.newLine();
				fw.write(iFirstNum + "" + Operator + "" + iSecondNum+ "=" + iResult);
				fw.close();
				break;
				}
		case 'S':
		case 's':
			checkDouble();
			dblResult = Math.sin(dblNum);
			fw.write("Sin"+""+dblNum+""+""+"="+dblResult);
			fw.close();
			break;	
		case 'C':
		case 'c':
			checkDouble();
			dblResult = Math.cos(dblNum);
			fw.write("Cos"+""+dblNum+""+""+"="+dblResult);
			fw.close();
			break;		
		case 'T':
		case 't':
			checkDouble();
			dblResult = Math.tan(dblNum);
			fw.write("Tan"+""+dblNum+""+""+"="+dblResult);
			fw.close();
			break;	
		case 'L':
		case 'l':
			checkDouble();
			dblResult = Math.log(dblNum);
			fw.write("Log"+""+dblNum+""+""+"="+dblResult);
			fw.close();
			break;
		case 'z':
		case 'Z':
			checkDouble();
			dblResult = Math.log(dblNum);
			break;	
		case 'r':
		case 'R':
			checkDouble();
			dblResult = Math.sqrt(dblNum);
			fw.write("Sqrt"+""+dblNum+""+""+"="+dblResult);
			fw.close();
			break;
		case 'i':
		case 'I':
			checkDouble();
			dblResult = Math.asin(dblNum);
			fw.write("InverseSine"+""+dblNum+""+""+"="+dblResult);
			fw.close();
			break;
		case 'o':
		case 'O':
			checkDouble();
			dblResult = Math.acos(dblNum);
			fw.write("InverseCos"+""+dblNum+""+""+"="+dblResult);
			fw.close();
			break;
		case 'j':
		case 'J':
			checkDouble();
			dblResult = Math.atan(dblNum);
			fw.write("InverseTan"+""+dblNum+""+""+"="+dblResult);
			fw.close();
			break;	
		case 'm':
		case 'M':
			Scanner s = new Scanner(System.in);
			int mth;
			System.out.println("Enter the number to get the power of it: ");
			mth = s.nextInt();
			checkDouble();
			dblResult = (double)Math.round(Math.pow(dblNum,mth));
			fw.write(mth + ""+ "root of"+ ""+ dblNum+ " "+ ""+ "="+dblResult);
			fw.close();
			break;
		case 'd':
		case 'D':
			Scanner sc = new Scanner(System.in);
			int dcm=0;
			System.out.println("Enter decimal number to convert it to binary: ");
			dcm = sc.nextInt();
			System.out.println("Binary representation of "+ dcm);
			String bin = Integer.toBinaryString(dcm);
			System.out.println(Integer.toBinaryString(dcm));
			fw.write("Binary value of "+""+dcm+""+""+"="+bin);
			fw.close();
			break;
		case 'b':
		case 'B':
			System.out.println("Enter binary values to convert it to decimal: ");
			Scanner sca = new Scanner(System.in);
			String bi2d = sca.nextLine();
			System.out.println("Decimal number = "+ Integer.parseInt(bi2d, 2));
			break;
		case 'N':
		case 'n':
			System.exit(0);
		default:
//			iResult = 0;
//			dblResult = 0.0;
			System.out.println("Invalid choice!! Choose from the menu. \\\\n\\\\n");
			break;
		
		}			
		}catch (IOException e) {
					
					e.printStackTrace();
				}
		
	}
    public void getResult() {
    	if (typeInt) {
    		System.out.println("Result is: "+ iResult);
    	} else if(typeDouble) {
    		System.out.println("Result is: "+ dblResult);
    	}
    }
	private void checkDouble() {
		if(!typeDouble) {
			dblResult = 0.0;
			System.out.println("Please enter float number!!!");
			System.exit(0);
		}
		
	}

	private boolean checkSecondNum() {
		if (iSecondNum == 0) {
			System.out.println("Zero can't be used as a denominator");
			System.exit(0);
			return true;
		} else {
		return false; }
	}

	private void checkInt() {
		if (!typeInt) {
			iResult = 0;
			System.out.println("Please enter numeric digits to perform operations!!\n");
			System.exit(0);
		}
	
	
	}
}


