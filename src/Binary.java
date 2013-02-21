import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class Binary {

	ArrayList<Integer> list = new ArrayList<Integer>();
	//break down the number into a sequence of binary number
	public void processBinary(long number){
		int  rest ;
		long newNumber;
		while (number != 0){
			rest = (int)(number % 2);
			newNumber = (number/2);
			list.add(rest);
			number = newNumber;
		}
	}

	//Since the list from the adding step is already reversed, in conjunction with the pow the output is calculated
	public long output(){
		long som = 0;
		for (int i = 0, j = list.size() - 1 ; i < list.size(); i++,j--){	
			som = (long) (som + (list.get(i).intValue() * Math.pow(2,j)));
		}
		return som;
	}

	//main method for getting the decimal number from the reversed binary number
	public void finalOuput(){
		long number;
		try {
			Scanner sc = new Scanner(System.in);
			Binary bin = new Binary();
			number = sc.nextLong();
			if ( number < 0 || number > 1000000000){
				extracted();
			}else{
				bin.processBinary(number);
				System.out.println(bin.output());
			}
			sc.close();

		}catch(ConstraintException e){
			e.printStackTrace();
		}

	}
	//method created to handle exceptions that might occur
	private void extracted() throws ConstraintException {
		throw new ConstraintException("Constraint not verified");
	}



	public static void main(String arg[]){
		Binary bin = new Binary();
		bin.finalOuput();
	}

}
