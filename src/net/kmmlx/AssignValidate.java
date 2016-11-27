package net.kmmlx;

public class AssignValidate {
   public int Validate(String assign){
	    if(assign.equals("!simplify")){
	    	return 1;
	    }else if(assign.equals("!d/d")){
	    	return 2;
	    }
	    return 0;
   }
}
