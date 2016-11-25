package net.kmmlx;

public class Simplify extends Operation {

	public Simplify(String[] List, int num, String assign, int[] sign) {
		super(List, num, assign, sign);
	}
	// 化简表达式
		public static String simplify() {
			String[] sim = List;
			int size = num;
			String[] strArr = new String[10];
			int index = 0;
			int first = 1;
			if(sim.length!=size)
				size=sim.length;
			
			for (int i = 1; i < assign.length(); i++) {
				if (' ' == assign.charAt(i)) {
					strArr[index++] = assign.substring(first, i);
					first = i + 1;
				}
			}
			strArr[index++] = assign.substring(first, assign.length());
			char[] indexChar = new char[index];
			String[] indexInt = new String[index];
			int[] sym = new int[index];
			for (int i = 0; i < index; i++) {
				indexChar[i] = strArr[i].charAt(0);
				if (strArr[i].charAt(2) == '-') {
					sym[i] = 0;
					indexInt[i] = strArr[i].substring(3, strArr[i].length());
				} else {
					sym[i] = 1;
					indexInt[i] = strArr[i].substring(2, strArr[i].length());
				}
			}
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < List[i].length(); j++) {
					for (int k = 0; k < index; k++) {
						if (List[i].charAt(j) == indexChar[k]) {
							sim[i] = List[i].substring(0, j) + indexInt[k] + List[i].substring(j + 1, List[i].length());
							if (sym[k] == 0) {
								if (sign[i] == 1) {
									sign[i] = 0;
								} else {
									sign[i] = 1;
								}
							}
						}
					}
				}
			}
			String com = new String();
			for (int i = 0; i < size; i++) {
				if (sign[i] == 1 && i > 0) {
					com += "+";
				} else if (sign[i] == 0) {
					com += "-";
				}
				MultiplicativeSimplification ms = new MultiplicativeSimplification(sim[i]);
				com += ms.compute();
			}
			return com;
		}
}
