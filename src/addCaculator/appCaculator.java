package addCaculator;
import java.util.Scanner;
public class appCaculator {
	
		public static void main(String[] args){
			
		   Calculator calc = new Calculator();
		   calc.addOperator("+", new Add());
		   calc.addOperator("-", new Sub());
		   calc.addOperator("*", new Mul());
		   calc.addOperator("/", new Div());
		   calc.addOperator("sin", new Sin());
		   calc.addOperator("asin", new Asin());
		   calc.addOperator("acos", new Acos());
		   calc.addOperator("cos", new Cos());
		   calc.addOperator("tan", new Tan());
		   calc.addOperator("log", new Log());
		   calc.addOperator("atan", new Atan());
		   calc.addOperator("e", new E());
		   calc.addOperator("^", new Pow());
		   calc.addOperator("!", new Fact());
		   System.out.println("PLEASE ENTER:");
		   Scanner s = new Scanner(System.in);
		   while(s.hasNext()){
			   String ss = s.nextLine();
			   System.out.println(calc.compute(ss));
		   }
		   s.close();
		}
		  
}