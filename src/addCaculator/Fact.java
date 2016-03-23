package addCaculator;

public class Fact extends MathOperation {

	@Override
	public int getNumberOfParameters() {
		return 1;
	}

	@Override
	public double compute(double[] parameters) {
		int a = (int)(parameters[0]);
		if(a==1||a==0) return 1;
		else{
			double sum =1;
			for(int i= 1;i<= a;i++){
				sum *= i;
			}
			return sum;
		}
	}

	@Override
	public int getPriority(String s) {
		priority a = new priority();
		int b = a.getPriority(s);
		return b;
	}

	@Override
	public int operatorPosition() {
		return 0;
	}

	@Override
	public String getName() {
		return null;
	}

}
