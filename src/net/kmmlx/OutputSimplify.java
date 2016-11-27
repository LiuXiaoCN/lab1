package net.kmmlx;

public class OutputSimplify {
      public void output(String[] List,int num,String assign,int[] sign){
    	  System.out.print("化简结果为：");
			Simplify ps = new Simplify(List, num, assign, sign);
			String result = ps.simplify();
			System.out.println(result);
      }
}
