package addCaculator;
import addCaculator.Calculator;
public class addPiece1 {
	
		//deal with brackets;
		
		public double readBrackets(String s ,int i){
			StringBuffer ssub = new StringBuffer();
			
			int subi = i+1;
			while(s.charAt(subi) != ')'){
				ssub.append(s.charAt(subi));
				subi++;
			}
			
				String ss = ssub.toString();
				double a = new Calculator().compute(ss);
				Calculator.parameter= subi + 1;
				return a;
				
		}
		//deal with abstract;
		public double readAbstract(String s ,int i){
			StringBuffer ssub = new StringBuffer();
			int subi = i+1;
			while(subi < s.length() && s.charAt(subi)!='|'){
				ssub.append(s.charAt(subi));
				subi++;
			}
			String ss = ssub.toString();
			double a = Math.abs(new Calculator().compute(ss));
			Calculator.parameter= subi+1;
			return a;//*-的运算应该包含在compute中
		}
		//deal with minus ;
		public double minus(String s ,int i){
			int subi = i+1;
			StringBuffer ssub = new StringBuffer();
			if(s.charAt(subi) == '('){
				return -1*readBrackets(s,subi);
			}
			else if(s.charAt(i) == '|'){
				return -1*readAbstract(s,subi);
			}else{
				while(subi < s.length()&&((s.charAt(subi) >= '0' && s.charAt(subi) <= '9')||s.charAt(subi) == '.')){
					ssub.append(s.charAt(subi));
					subi++;
				}
			String ss = ssub.toString();
			double a = (Double.parseDouble(ss));
			Calculator.parameter = subi;
			return -1*a;
			}
		}
		public double se(String s, int j) {
			int subi = j + 1;
			if(s.charAt(subi) == '-'){
			return Math.pow(10,minus(s,subi));
			}else{
				if(s.charAt(subi) == '+')
					subi++;
				else{
					StringBuffer ch = new StringBuffer();
					while(subi < s.length() && s.charAt(subi) >= '0'&&s.charAt(subi) <= '9'){
						ch.append(s.charAt(subi));
						subi++;
					}
					Calculator.parameter = subi;
					double b =Math.pow(10,Double.parseDouble(ch.toString()));
					return b;
				}
			}
			return 0;
		}
		
		public int phi(int m,int n,int p){
	/*		if(!(m>=0&&n>=0&&p>=0)){
				Calculator.p("Ackerman function's parameters have to be nonegative , please check it carefully.");
				return 0;
			}*/
			int a = 0;
			if( p == 0){
				return m+n;
			}else if(n ==0 && p == 1){
				return 0;
			}else if(n==0 && p == 2){
				return 1;
			}else if( n == 0 && !(p <= 2)){
				return m;
			}else if( n>0 && p>0){
				 a = phi(m,phi(m,n-1,p),p-1);
			}else
				return 0;
			return a ;
		}
		
		public double acherman(String s,int i ){
			int subi = i+1;
			double a = 0;
			if(subi < s.length() && s.charAt(subi) == '('){
				int p = (int)(readBrackets(s,subi));
				double dn = Calculator.stack2.pop();
				double dm = Calculator.stack2.pop();
				int m = (int)(dm);
				int n = (int)(dn);
				a = phi(m,n,p);
			}else
				return 0;
			return a ;
		}
		
		
}
