package addCaculator;

public class Log extends MathOperation {

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
			if(parameters[1] == 1){
				System.out.println("输入有误 请重新输入：");
				return 0;
			}else 
				return Math.log(parameters[0])/Math.log(parameters[1]);
		}else
			return Math.log(parameters[0]);
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
