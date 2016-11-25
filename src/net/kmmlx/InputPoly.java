package net.kmmlx;

import java.util.Scanner;

public class InputPoly {
	public String input(){
	// 提示用户开始输入多项式
			System.out.print("请输入多项式：");
			// 读入多项式
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			String poly = in.nextLine();
			return poly;
	}
}
