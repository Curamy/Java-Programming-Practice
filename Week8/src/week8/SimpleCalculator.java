package week8;

import java.util.Scanner;

class AddZeroException extends Exception{}

class SubtractZeroException extends Exception{}

class OutOfRangeException extends Exception{}

public class SimpleCalculator{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(Scanner scn = new Scanner(System.in);) {
			String exp = scn.nextLine();
			int i=0;
			for(; i<exp.length(); i++) {
				if(exp.charAt(i) == '+' || exp.charAt(i) == '-') {
					break;
				}
			}
			String n1 = exp.substring(0, i);
			int num1 = Integer.valueOf(n1);
			String n2 = exp.substring(i+1, exp.length());
			int num2 = Integer.valueOf(n2);
			char oper = exp.charAt(i);
			int result = 0;
			
			try {
				if(oper == '+') {
					if(num1 == 0 || num2 == 0) {
						throw new AddZeroException();
					}
					else if(num1 < 0 || num1 > 1000 || num2 < 0 || num2 > 1000) {
						throw new OutOfRangeException();
					}
					else {
						result = num1 + num2;
						if(result > 1000) {
							throw new OutOfRangeException();
						}
					}
				}
				else if(oper == '-') {
					if(num1 == 0 || num2 == 0) {
						throw new SubtractZeroException();
					}
					else if(num1 < 0 || num1 > 1000 || num2 < 0 || num2 > 1000) {
						throw new OutOfRangeException();
					}
					else {
						result = num1 - num2;
						if(result > 1000 || result < 0) {
							throw new OutOfRangeException();
						}
					}
				}
				System.out.println(result);
			} catch (AddZeroException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (SubtractZeroException e) {
				e.printStackTrace();
				// TODO: handle exception
			} catch (OutOfRangeException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

	}

}

