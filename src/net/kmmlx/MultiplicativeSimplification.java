package net.kmmlx;

public class MultiplicativeSimplification {
	 private static String str;
	 static Judge judge = new Judge();
	 public MultiplicativeSimplification(String str){
		 this.str = str;
	 }
	// 乘式化简
		public static String compute() {
			String revert = new String();
			if (!str.contains("*")) {
				return str;
			} else {
				String[] item = new String[10];
				int index = 0;
				int first = 0;
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == '*') {
						item[index++] = str.substring(first, i);
						first = i + 1;
					}
				}
				item[index++] = str.substring(first, str.length());
				int size = index;
				int[] num = new int[size];
				for (int i = 0; i < size; i++) {
					num[i] = 1;
					if (Character.isDigit(item[i].charAt(0))) {
						num[i] = Integer.parseInt(item[i].trim());
					}
				}
				int numsize = 1;
				for (int i = 0; i < size; i++) {
					numsize *= num[i];
				}
				revert += String.valueOf(numsize);
				for (int i = 0; i < size; i++) {
					if (Character.isLetter(item[i].charAt(0))) {
						revert += "*" + item[i];
					}
				}
			}
			return revert;
		}
		public static String getStr() {
			return str;
		}
		public static void setStr(String str) {
			MultiplicativeSimplification.str = str;
		}
}
