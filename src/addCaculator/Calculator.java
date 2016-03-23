package addCaculator;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Calculator {
	  static Stack<String> stack1 = new Stack<String>();
	  static Stack<Double> stack2 = new Stack<Double>();
	  static Map<String,MathOperation>  finalmap = new HashMap<String,MathOperation>();
	  static int pri= 0;
	  static int count = 0;
	  static int parameter = 0;
	  static int priJugement = 0;
	  
	public void addOperator(String operation, MathOperation sub) {
		finalmap.put(operation, sub);
	}
	

	public double compute(String s) {

		int  i=0;
		stack1.push("#");
		StringBuffer ch = new StringBuffer();
		ch = null;
		addPiece1 saP = new addPiece1();
		
		
		for(i=0;i<s.length();i++){
			
			    if(i == 0 && s.charAt(i) == '-'){
			    	stack2.push(saP.minus(s,0));
			    	i = parameter;
			    }
			    
			    if( i+7 <= s.length() && s.substring(i,i+7).compareTo("Math.PI") == 0){
			    	stack2.push(Math.PI);
			    	i  += 7;
			    	ch = null;
			    }
			    
			    if(i < s.length() && (s.charAt(i) >= '0'&&s.charAt(i) <= '9'||s.charAt(i) == '.')){
					
					 StringBuffer sb = new StringBuffer();
					 sb.append(s.charAt(i));
					 int j = i+1;
					 int pp=0;
					 int jugeE = 0;
					 for(j=i+1;j<s.length();j++){
						 if(s.charAt(j) >= '0'&&s.charAt(j) <= '9'||s.charAt(j) == '.'){
							 sb.append(s.charAt(j));
						 }else if(s.charAt(j) == 'E' || s.charAt(j) == 'e'){
							 double a  = saP.se(s,j);
							 double b = Double.parseDouble(sb.toString());
							 sb.append('e');
							 stack2.push(a*b);
							 j = parameter;
							 jugeE = 1;
							 break;
						 }else if(s.charAt(j) == ','){
							 count ++;
							 stack2.push(Double.parseDouble(sb.toString())) ;
							 int a  = sb.toString().length();
							 sb.delete(0, a);
							 continue;
						 }else{
							 stack2.push(Double.parseDouble(sb.toString())) ;
							 pp=1;
							 break;
						 }
					 }
					 
					 if( (sb.toString().length() == 1 && pp ==0) || (j >= s.length() && jugeE == 0) )
						 	stack2.push(Double.parseDouble(sb.toString()));
					 i = j;
				 }//if
				 
				if(ch == null && i<s.length()){
					 if(s.charAt(i)>='a'&&s.charAt(i)<='z'){
						 StringBuffer sc = new StringBuffer();
						 sc.append(s.charAt(i));
						 for(int j=i+1;j<s.length();j++){
							 if(s.charAt(j)>='a'&&s.charAt(j)<='z')
									 sc.append(s.charAt(j));
							 else{
								 ch = sc;
								 pri = (new priority()).getPriority(ch.toString());
							 	 i = j-1;
							 	 break;
							 }
						 }//for
					 }else if((s.charAt(i)=='*'||s.charAt(i)=='/')&&s.charAt(i+1) == '-'){
						
						 StringBuffer sc = new StringBuffer();
						 sc.append(s.charAt(i));
						 i++;
						 sc.append(s.charAt(i));
						 ch = sc;
					 }else{
						 StringBuffer sc = new StringBuffer();
						 sc.append(s.charAt(i));
						 ch = sc;
					 }
			
			 }//BIG IF

			if(ch != null){
				
				if(ch.toString().compareTo("(") == 0 ){
					
						stack2.push(saP.readBrackets(s, i));
						i = parameter - 1;
						ch = null;
						
					 }else if(ch.toString().compareTo("|") == 0){
						 
						 stack2.push(saP.readAbstract(s, i));
						 i = parameter;
						 
					 }else if(ch.toString().length() == 2){
						 
						 String subch = ch.toString();
						 priorityCompare(String.valueOf(subch.charAt(0)),stack1.peek());
						 if(subch.charAt(1) == '-'){
							 stack2.push(saP.minus(s,i));
							 i = parameter ;
						 }//IF
						 
					 }else if(ch.toString().compareTo("¦×") == 0){
						 
						 stack2.push(saP.acherman(s, i));
						 i = parameter - 1;
						 ch = null;
						 
					 }else{
						 
						 priorityCompare(ch.toString(),stack1.peek());
						 if(priJugement == 1)
							 priorityCompare(ch.toString(),stack1.peek());
						 ch = null;
						 
					 }//else
				 }//BIG IF
			
			}//BIG FOR
				
/*			while(!stack1.empty()){
				p(stack1.pop());
			}
			while(!stack2.empty()){
				p(stack2.pop());
			}*/
			
			while(stack1.peek() != "#"&&!stack2.empty()){
				 String ss = stack1.pop();
				 MathOperation a = new Calculator().getclass(ss);
				 double[] parameters = new double[50];
				 for(int p=0;p<a.getNumberOfParameters();p++){
					if(!stack2.empty())
						parameters[p] = stack2.pop(); 
				}
				 stack2.push( (new Calculator()).getclass(ss).compute(parameters));
				
			 }
			stack1.pop();
			return stack2.pop();
	}

		
	public MathOperation getclass(String s){
		return  finalmap.get(s);
	}
	
	public  void priorityCompare(String a, String b){
		int pri1 = new priority().getPriority(a);
		int pri2 = new priority().getPriority(b);
		if(pri1 > pri2){
			stack1.push(a);
		}else{
			
			if(pri2 >= 100)
				priJugement = 1;
			else
				priJugement = 0;
			String ss = b;
			MathOperation as = new Calculator().getclass(ss);
			double[] parameters = new double[50];
			for(int p=0; p< as.getNumberOfParameters(); p++){
				if(!stack2.empty())
					parameters[p] = stack2.pop();
			 }//for
			 count = 0;
			 stack1.pop();
			 stack2.push((new Calculator()).getclass(ss).compute(parameters));
			 if(priJugement == 0)
				 stack1.push(a);
			}//else
		}

	public static void p(Object o){
		System.out.println(o);
	}

}
	




	