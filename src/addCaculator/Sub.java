package addCaculator;

public class Sub extends MathOperation {

	@Override
	public int getNumberOfParameters() {
		return 2;
	}

	@Override
	public double compute(double[] parameters) {
		return parameters[1]-parameters[0];
	}

	@Override
	public int getPriority(String s) {
		return 0;
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
