package net.kmmlx;

public class SimplifyingOfAdition {
	 private static String com;
	 static Judge judge = new Judge();
	 public SimplifyingOfAdition(String com){
		 this.com = com;
	 }
	// 加式化简
			public static String output(){
				String com = getCom();
				int intcom = 0;
				String backstr = new String();
				// 默认不超过10项
				String[] poly = new String[10];
				int[] sign = new int[10];
				int first = 0;
				int index = 0;
				if (com.charAt(0) == '-') {
					sign[0] = 0;
				} else {
					sign[0] = 1;
				}
				for (int i = 0; i < com.length(); i++) {
					if ((com.charAt(i) == '+' || com.charAt(i) == '-') && i > 0) {
						if (com.charAt(i) == '+') {
							sign[index + 1] = 1;
						} else {
							sign[index + 1] = 0;
						}
						poly[index++] = com.substring(first, i);
						first = i + 1;
					}
				}
				poly[index++] = com.substring(first, com.length());
				if (poly[0].charAt(0) == '-') {
					poly[0] = poly[0].substring(1);
				}
				for (int i = 0; i < index; i++) {
					if (judge.isNumeric(poly[i])){
						if (sign[i] == 1) {
							intcom += Integer.parseInt(poly[i].trim());
						} else {
							intcom -= Integer.parseInt(poly[i].trim());
						}
					}
				}
				if (intcom != 0) {
					backstr += String.valueOf(intcom);
				}
				for (int i = 0; i < index; i++) {
					if ((poly[i].contains("*") || Character.isLetter(poly[i].charAt(0))) && sign[i] == 1) {
						backstr += "+" + poly[i].trim();
					} else if ((poly[i].contains("*") || Character.isLetter(poly[i].charAt(0))) && sign[i] == 0) {
						backstr += "-" + poly[i].trim();
					}
				}
				if (backstr.charAt(0) == '+') {
					backstr = backstr.substring(1);
				}
				return backstr;
			}
			public static String getCom() {
				return com;
			}
			public void setCom(String com) {
				this.com = com;
			}
}
