package net.kmmlx;

import java.util.Scanner;

public class Instream {
	public static void main(String[] args) {
		// 提示用户开始输入多项式
		System.out.print("请输入多项式：");
		// 读入多项式
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String poly = in.nextLine();
		// 新建字符串数组保存每一项
		String[] List = new String[100];
		// 整形数组保存每一项的符号
		int[] sign = new int[10];
		// 进行化简并返回项数
		Expression exp =new Expression(poly, List, sign);
		int num = exp.expresstion();
		// 开始读入指令
		System.out.print("请输入命令：");
		String cmd = in.next();
		String assign = new String();
		if (cmd.equals("!simplify")) {
			// 读入化简的var序列
			assign = in.nextLine();
			if (assign.length() < 4 || !Character.isDigit(assign.charAt(assign.length() - 1))) {
				System.out.println("指令有误！");
				System.exit(1);
			} else {
				for (int i = 0; i < assign.length() - 1; i++) {
					if ((Character.isDigit(assign.charAt(i)) && Character.isLetter(assign.charAt(i + 1)))
							|| (Character.isLetter(assign.charAt(i)) && Character.isDigit(assign.charAt(i + 1)))) {
						System.out.println("指令有误！");
						System.exit(1);
					}
				}
			}
			System.out.print("化简结果为：");
			Simplify s = new Simplify(List, num, assign, sign);
			String result = s.simplify();
			System.out.println(result);
		} else if (cmd.equals("!d/d")) {
			// 读入求导变量
			assign = in.next();
			if (assign.length() > 1 || !Character.isLetter(assign.charAt(0))) {
				System.out.println("指令有误！");
				System.exit(1);
			}
			System.out.print("求导结果为：");
			if (!poly.contains(assign)) {
				System.out.print(0);
				System.exit(0);
			}
			Derivative d = new Derivative(List, num, assign, sign);
			String result = d.derivative();
			System.out.println(result);
		} else {
			// 错误命令判断
			System.out.println("命令有误！");
			System.exit(0);
		}
	}

	
}
