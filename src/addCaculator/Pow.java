package addCaculator;

public class Pow extends MathOperation {

	@Override
	public int getNumberOfParameters() {
		return 2;
	}

	@Override
	public double compute(double[] parameters) {
		return Math.pow(parameters[1],parameters[0]);
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
