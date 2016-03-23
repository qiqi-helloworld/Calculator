package addCaculator;

public abstract class MathOperation {

	public abstract int getNumberOfParameters();
	
	public abstract double compute(final double[] parameters);

	
	public abstract int getPriority(String s);
	
	public abstract int operatorPosition();
	
	public abstract String getName();



	

}
//2² 