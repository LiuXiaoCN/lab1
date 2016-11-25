package net.kmmlx;

public class OutputExpression {
  public int output(String poly,String[] List,int[] sign){
	// 进行化简并返回项数
			Expression exp =new Expression(poly, List, sign);
			int num = exp.expresstion();
			return num;
  }
}
