package addCaculator;
import addCaculator.MathOperation;
public class Div extends MathOperation {

	@Override
	
	
	public int getNumberOfParameters() {
		return 2;
	}

	@Override
	public double compute(double[] parameters) {
	/*	if(parameters[0] == 0){
			System.out.println();
			return 0;
		}else*/
			return parameters[1]/parameters[0];
			
	}

	@Override
	public int getPriority(String s) {
		priority a = new priority();
		int b = a.getPriority(s);
		return b;
	}

	@Override
	public int operatorPosition() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
