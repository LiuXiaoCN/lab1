package net.kmmlx;

import java.util.Scanner;

public class InputAssign {
	  public String input(){
		  @SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
	        // 开始读入指令
			System.out.print("请输入命令：");
			String cmd = in.next();
			return cmd;
      }
	  public String inputassign(){
		  Scanner in = new Scanner(System.in);
		 String assign = in.nextLine();
		 return assign;
	  }
	  public String inputassign2(){
		  Scanner in = new Scanner(System.in);
		 String assign = in.next();
		 return assign;
	  }
}
