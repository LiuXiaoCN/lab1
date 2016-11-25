package net.kmmlx;

import java.util.Scanner;

public class IOstream {
	public static void main(String[] args) {
		InputPoly ip = new InputPoly();
		String poly = ip.input();
		// 新建字符串数组保存每一项
		String[] List = new String[100];
		// 整形数组保存每一项的符号
		int[] sign = new int[10];
		OutputExpression oe =new OutputExpression();
		int num = oe.output(poly, List, sign);
		InputAssign ia =new InputAssign();
		String cmd = ia.input();
		String assign = new String();
		if (cmd.equals("!simplify")) {
		// 读入化简的var序列
			assign = ia.inputassign();
			if (assign.length() < 4 || !Character.isDigit(assign.charAt(assign.length() - 1))) {
				System.out.println("指令有误！");
				System.exit(1);
			} else {
				for (int i = 0; i < assign.length() - 1; i++){
					if ((Character.isDigit(assign.charAt(i)) && Character.isLetter(assign.charAt(i + 1)))
							|| (Character.isLetter(assign.charAt(i)) && Character.isDigit(assign.charAt(i + 1)))) {
						System.out.println("指令有误！");
						System.exit(1);
					}
				}
			}
			OutputSimplify os =new OutputSimplify();
			os.output(List, num, assign, sign);
		} else if (cmd.equals("!d/d")) {
			// 读入求导变量
			assign = ia.inputassign2();
			if (assign.length() > 1 || !Character.isLetter(assign.charAt(0))) {
				System.out.println("指令有误！");
				System.exit(1);
			}
			OutputDerivative od =new OutputDerivative();
			od.output(assign, poly, List, num, sign);
		} else {
			// 错误命令判断
			System.out.println("命令有误！");
			System.exit(0);
		}
	}
	}
