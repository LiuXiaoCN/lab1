package net.kmmlx;

public class OutputSimplify {
      public void output(String[] List,int num,String assign,int[] sign){
    	  System.out.print("化简结果为：");
			PolySimplify ps = new PolySimplify(List, num, assign, sign);
			String result = ps.poly();
			System.out.println(result);
      }
}
