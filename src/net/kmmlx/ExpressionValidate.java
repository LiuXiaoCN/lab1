package net.kmmlx;

public class ExpressionValidate {
    public boolean Validate(String poly){
    	int num = poly.length();
    	for(int i = 0;i<num;i++){
    		if(poly.charAt(i)=='^' || poly.charAt(i)=='-' || poly.charAt(i)=='+' || poly.charAt(i)=='*'){
    			if((poly.charAt(i+1)=='^' || poly.charAt(i+1)=='-' || poly.charAt(i+1)=='+' || poly.charAt(i+1)=='*') && i+1<num){
    				return false;
    			}
    		}
    	}
    	return true;
    }
}
