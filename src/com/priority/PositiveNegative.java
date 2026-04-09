package com.priority;

import org.testng.annotations.Test;

public class PositiveNegative {
	
	@Test(priority = 1)
	public void add()
	{
		System.out.println("this is add method");
	}
	
	@Test(priority = -3)
	public void sub()
	{
		System.out.println("this is sub method");
	}
	
	@Test(priority = 4)
	public void multiply()
	{
		System.out.println("this is multiply method");
	}
	
	@Test(priority = -2)
	public void div()
	{
		System.out.println("this is div method");
	}

}
