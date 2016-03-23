package addCaculator;

public class Atan extends MathOperation {

	@Override
	public int getNumberOfParameters() {
		if(Calculator.count == 1){
			return 2;
		}else
			return 1;
	}

	@Override
	public double compute(double[] parameters) {
		if(Calculator.count == 1){
			return Math.atan2(parameters[1], parameters[0]);
		}
		else
			return Math.atan(parameters[0]*Math.PI/180);
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
