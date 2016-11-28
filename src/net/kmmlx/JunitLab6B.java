package net.kmmlx;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JunitLab6B {
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
		Simplify d =new Simplify(List,num,assign,sign);
		String rslt=d.simplify();
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
		Simplify d =new Simplify(List,num,assign,sign);
		String rslt=d.simplify();
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
		Simplify d =new Simplify(List,num,assign,sign);
		String rslt=d.simplify();
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
		Simplify d =new Simplify(List,num,assign,sign);
		String rslt=d.simplify();
		assertEquals("28*y-24*y*z",rslt);
	}
	@Test
	public void testL5() {
		String[] List=new String[2];
		List[0]="7*x*2*y";
		List[1]="8*3*y*z";
		int num=2;
		String assign=" x=2 y=1 z=0";
		int[] sign=new int[2];
		sign[0]=1;
		sign[1]=1;
		Simplify d =new Simplify(List,num,assign,sign);
		String rslt=d.simplify();
		assertEquals("28+0",rslt);
	}
	@Test
	public void testL6() {
		String[] List=new String[2];
		List[0]="7*x*2*&";
		int num=2;
		String assign=" x=2 y=1 z=0";
		int[] sign=new int[2];
		sign[0]=1;
		sign[1]=1;
		Simplify d =new Simplify(List,num,assign,sign);
		String rslt=d.simplify();
		assertEquals("Error",rslt);
	}

}
