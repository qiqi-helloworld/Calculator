package addCaculator;

public class Ackerm extends MathOperation {

	@Override
	public int getNumberOfParameters() {
		return 3;
	}

	@Override
	public double compute(double[] parameters) {
		int a = new addPiece1().phi((int) (parameters[2]),
				(int) (parameters[1]), (int) (parameters[0]));
		return a + 0.0;
	}

	@Override
	public int getPriority(String s) {
		// TODO Auto-generated method stub
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
