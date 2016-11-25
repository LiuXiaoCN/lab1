package net.kuangmeng;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Junit2Test {
    Main myMain2;
	@Before
	public void setUp() throws Exception {
		myMain2 = new Main();
	}

	@Test
	public void testDerivative1() {
		String[] List = new String[2];
		List[0] = "1";
		List[1] = "x*x";
		int num = 2;
		String assign = "x";
		int[] sign = new int[2];
		sign[0]=1;
		sign[1]=1;
		String rslt=myMain2.derivative(List,num,assign,sign);
		assertEquals("2*x",rslt);
	}
	@Test
	public void testDerivative2() {
		String[] List = new String[2];
		List[0] = "x";
		List[1] = "x*x";
		int num = 2;
		String assign = "x";
		int[] sign = new int[2];
		sign[0]=0;
		sign[1]=0;
		String rslt=myMain2.derivative(List,num,assign,sign);
		assertEquals("-1-2*x",rslt);
	}
	@Test
	public void testDerivative3() {
		String[] List = new String[3];
		List[0] = "1";
		List[1] = "x*y";
		List[2] = "x*x*x";
		int num = 3;
		String assign = "x";
		int[] sign = new int[3];
		sign[0]=0;
		sign[1]=0;
		sign[2]=1;
		String rslt=myMain2.derivative(List,num,assign,sign);
		assertEquals("-1*y+3*x*x",rslt);
	}
	@Test
	public void testDerivative4() {
		String[] List = new String[2];
		List[0] = "x*y";
		List[1] = "x*x";
		int num = 2;
		String assign = "x";
		int[] sign = new int[2];
		sign[0]=1;
		sign[1]=0;
		String rslt=myMain2.derivative(List,num,assign,sign);
		assertEquals("1*y-2*x",rslt);
	}
	@Test
	public void testDerivative5() {
		String[] List = new String[4];
		List[0] = "x*y";
		List[1] = "x*x";
		List[2] = "12";
		List[3] = "y*y";
		int num = 4;
		String assign = "x";
		int[] sign = new int[4];
		sign[0]=1;
		sign[1]=1;
		sign[2]=1;
		sign[3]=1;
		String rslt=myMain2.derivative(List,num,assign,sign);
		assertEquals("1*y+2*x",rslt);
	}
	@Test
	public void testDerivative6() {
		String[] List = new String[3];
		List[0] = "x*y";
		List[1] = "x*x";
		List[2] = "12";
		int num = 3;
		String assign = "x";
		int[] sign = new int[3];
		sign[0]=1;
		sign[1]=1;
		sign[2]=1;
		String rslt=myMain2.derivative(List,num,assign,sign);
		assertEquals("1*y+2*x",rslt);
	}
}
