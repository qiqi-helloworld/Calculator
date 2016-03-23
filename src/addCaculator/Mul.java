package addCaculator;

public class Mul extends MathOperation {

	@Override
	public int getNumberOfParameters() {
		return 2;
	}

	@Override
	public double compute(double[] parameters) {
		return parameters[0]*parameters[1];
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
