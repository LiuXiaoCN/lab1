package net.kmmlx;

public class Operation {
    protected static String[] List;
    protected static int num;
    protected static int[] sign;
    protected static String assign;
    public Operation(String[] List, int num, String assign, int[] sign){
    	this.List = List;
    	this.num = num;
    	this.assign = assign;
    	this.sign = sign;
    }
	public  String[] getList() {
		return List;
	}
	public void setList(String[] list) {
		List = list;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int[] getSign() {
		return sign;
	}
	public void setSign(int[] sign) {
		this.sign = sign;
	}
	public String getAssign() {
		return assign;
	}
	public void setAssign(String assign) {
		this.assign = assign;
	}
    
}
