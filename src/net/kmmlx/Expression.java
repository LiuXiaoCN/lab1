package net.kmmlx;

public class Expression {
	private static String poly;
	public String getPoly() {
		return poly;
	}
	public void setPoly(String poly) {
		this.poly = poly;
	}
	public String[] getList() {
		return List;
	}
	public void setList(String[] list) {
		List = list;
	}
	public int[] getSign() {
		return sign;
	}
	public void setSign(int[] sign) {
		this.sign = sign;
	}
	private static String[] List;
	private static int[] sign;
	public Expression(String poly,String[] List,int[] sign){
		this.poly = poly;
		this.sign = sign;
		this.List = List;
	}
	// 存储表达式，并输出表达式
	public static int expresstion(){
		// 处理空格
		char[] chars = poly.toCharArray();
		String result = new String();
		for (char ch : chars) {
			if (ch != ' ' && ch != '\t') {
				result += ch;
			}
		}
		int size = result.length();
		// 判断多项式是否有误
		for (int i = 0; i < size; i++) {
			if (!(Character.isLetter(result.charAt(i)) || Character.isDigit(result.charAt(i)))
					&& !(Character.isLetter(result.charAt(i + 1)) || Character.isDigit(result.charAt(i + 1)))) {
				System.out.println("多项式有误！");
				System.exit(1);
			}
		}
		// 多项式分割
		int first = 0;
		int t = 0;
		char[] element = new char[10];
		int index = 0;
		if (result.charAt(0) == '-') {
			sign[0] = 0;
		} else {
			sign[0] = 1;
		}
		for (int i = 0; i < size; i++) {
			if (Character.isLetter(result.charAt(i))) {
				element[index++] = result.charAt(i);
			}
			if (i > 0 && !Character.isLetter(result.charAt(i)) && !Character.isDigit(result.charAt(i))) {
				if (result.charAt(i) == '+' || result.charAt(i) == '-') {
					if (result.charAt(i) == '+') {
						sign[t + 1] = 1;
					} else {
						sign[t + 1] = 0;
					}
					List[t++] = result.substring(first, i);
					first = i + 1;
				}
			}
		}
		List[t++] = result.substring(first);
		if (List[0].charAt(0) == '-') {
			List[0] = List[0].substring(1);
		}
		for (int i = 0; i < index - 1; i++) {
			for (int j = i + 1; j < index; j++) {
				if (element[i] == element[j] && element[i] != ' ') {
					element[j] = ' ';
				}
			}
		}
		int arity = 0;
		for (int i = 0; i < index; i++) {
			if (element[i] != ' ') {
				arity++;
			}
		}
		// 计算次数
		int[] time = new int[t];
		for (int i = 0; i < t; i++) {
			for (int j = 0; j < List[i].length(); j++) {
				if (Character.isLetter(List[i].charAt(j))) {
					time[i]++;
				} else if (List[i].charAt(j) == '^') {
					time[i] += Integer.parseInt(String.valueOf(List[i].charAt(j + 1))) - 1;
				}
			}
		}
		for (int i = 1; i < t; i++) {
			if (time[i] > time[0]) {
				time[0] = time[i];
			}
		}
		System.out.println("该多项式为" + arity + "元" + time[0] + "次" + t + "项式：" + result);
		// 化简List，处理省略*的情况
		for (int i = 0; i < t; i++) {
			int len = List[i].length();
			char[] chs = new char[100];
			int suffix = 0;
			for (int j = 0; j < len - 1; j++) {
				chs[suffix++] = List[i].charAt(j);
				if ((Character.isDigit(List[i].charAt(j)) && Character.isLetter(List[i].charAt(j + 1)))
						|| (Character.isLetter(List[i].charAt(j)) && Character.isLetter(List[i].charAt(j + 1)))) {
					chs[suffix++] = '*';
				}
			}
			chs[suffix++] = List[i].charAt(len - 1);
			List[i] = String.valueOf(chs);
		}
		// 化简List ，处理^
		for (int i = 0; i < t; i++) {
			List[i] = List[i].trim();
			int len = List[i].length();
			char[] chs = new char[100];
			int suffix = 0;
			if (len <= 2) {
				continue;
			} else {
				chs[suffix++] = List[i].charAt(0);
				for (int j = 1; j < len; j++) {
					if (List[i].charAt(j) == '^') {
						int num = Integer.parseInt(String.valueOf(List[i].charAt(j + 1)));
						for (int k = 0; k < num - 1; k++) {
							chs[suffix++] = '*';
							chs[suffix++] = List[i].charAt(j - 1);
						}
					} else if (List[i].charAt(j - 1) != '^') {
						chs[suffix++] = List[i].charAt(j);
					}
				}
			}
			List[i] = String.valueOf(chs);
		}
		return t;
	}
}
