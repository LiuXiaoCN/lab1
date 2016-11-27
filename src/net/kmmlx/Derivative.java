package net.kmmlx;

public class Derivative extends Operation{

	public Derivative(String[] List, int num, String assign, int[] sign) {
		super(List, num, assign, sign);
	}
	/***
	 * @param List 多项式字符串每一项
	 * @param num  项数
	 * @param assign 求导的未知数符号
	 * @param sign 各项的符号
	 * @return result 求导后字符串
	 */
	public static String derivative() {
		String[] sim = List;
		int size = num;
		int[] items = new int[size];
		int i=0;
		while (i < size){
			items[i] = 0;
			int j = 0;
			while(j < sim[i].length()){
				if (sim[i].charAt(j) == assign.charAt(0)){
					items[i]++;
				}
				j++;
			}
			if (items[i] == 0){
				sim[i] = "";
			} else {
				j = 0;
				while(j < sim[i].length()) {
					if (sim[i].charAt(j) == assign.charAt(0)) {
						sim[i] = sim[i].substring(0, j) + String.valueOf(items[i])
								+ sim[i].substring(j + 1, sim[i].length());
						break;
					}
			//		j++;
				}
			}
			i++;
		}
		String com = new String();
		i = 0;
		while(i < size) {
			if (!sim[i].equals("")) {
				if (sign[i] == 1) {
					com += "+";
				} else {
					com += "-";
				}
				MultipSimplify ms =new MultipSimplify(sim[i]);
				com += ms.compute();
			}
			i++;
		}
		if (com.charAt(0) == '+') {
			com = com.substring(1);
		}
		AdditionSimplify sa = new AdditionSimplify(com);
		String result = sa.output();
		return result;
	}
}
