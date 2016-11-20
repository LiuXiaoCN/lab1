package net.kuangmeng;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class junitforM {
	Main myMain;
	@Before
	public void setup()
	{
		myMain=new Main();
	}
	
	@Test
	public void testL1() {
		String[] List=new String[2];
		List[0]="7*x*2*y";
		List[1]="8*3*y*z";
		int num=2;
		String assign=" x=2";
		int[] sign=new int[2];
		sign[0]=1;
		sign[1]=0;
		String rslt=myMain.simplify(List, num, assign, sign);
		assertEquals("28*y-24*y*z",rslt);
	}
	@Test
	public void testL2() {
		String[] List=new String[2];
		List[0]="7*x*2*y";
		List[1]="8*3*y*z";
		int num=2;
		String assign=" x=-2 x=3";
		int[] sign=new int[2];
		sign[0]=1;
		sign[1]=0;
		String rslt=myMain.simplify(List, num, assign, sign);
		assertEquals("-28*y-24*y*z",rslt);
	}
	@Test
	public void testL3() {
		String[] List=new String[2];
		List[0]="7*x*2*y";
		List[1]="8*3*y*z";
		int num=2;
		String assign=" w=2";
		int[] sign=new int[2];
		sign[0]=1;
		sign[1]=0;
		String rslt=myMain.simplify(List, num, assign, sign);
		assertEquals("14*x*y-24*y*z",rslt);
	}
	@Test
	public void testL4() {
		String[] List=new String[2];
		List[0]="7*x*2*y";
		List[1]="8*3*y*z";
		int num=4;
		String assign=" x=2";
		int[] sign=new int[2];
		sign[0]=1;
		sign[1]=0;
		String rslt=myMain.simplify(List, num, assign, sign);
		assertEquals("28*y-24*y*z",rslt);
	}

}
