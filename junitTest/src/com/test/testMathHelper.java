package com.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.main.mathHelper;

public class testMathHelper {
	
	mathHelper math =new mathHelper();


	@Test
public void testAdd(){
	assertEquals(10,math.add(2,3,5));
	assertEquals(20,math.add(10,1,9));
	assertEquals(9,math.sub(10,1));
	assertEquals(90,math.mul(10,1,9));
	assertEquals(3,math.div(9,3));
	
}
	
}
