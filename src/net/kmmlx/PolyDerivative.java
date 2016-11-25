package net.kmmlx;

public class PolyDerivative {
	private String[] List;
	private int num;
	private String assign;
	private int[] sign;
    public String[] getList() {
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
	public String getAssign() {
		return assign;
	}
	public void setAssign(String assign) {
		this.assign = assign;
	}
	public int[] getSign() {
		return sign;
	}
	public void setSign(int[] sign) {
		this.sign = sign;
	}
	public PolyDerivative(String[] List,int num,String assign,int[] sign){
		this.List = List;
		this.num = num;
		this.assign = assign;
		this.sign = sign;
	}
	public String poly(){
		Derivative d = new Derivative(List, num, assign, sign);
		String result = d.derivative();
		return result;
    }
}
