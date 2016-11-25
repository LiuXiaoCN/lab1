package net.kmmlx;

public class OutputDerivative {
    public void output(String assign,String poly,String[] List,int num,int[] sign){
    	System.out.print("求导结果为：");
		if (!poly.contains(assign)) {
			System.out.print(0);
			System.exit(0);
		}
		PolyDerivative pd = new PolyDerivative(List,num,assign, sign);
		String result = pd.poly();
		System.out.println(result);
    }
}
