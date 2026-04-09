package com.priority;

import org.testng.annotations.Test;

//By Default, NoPriority runs Alphabetically 

public class NoPriority {
	
	@Test
	public void add()
	{
		System.out.println("this is add method");
	}
	
	@Test
	public void sub()
	{
		System.out.println("this is sub method");
	}
	
	@Test
	public void multiply()
	{
		System.out.println("this is multiply method");
	}
	
	@Test
	public void div()
	{
		System.out.println("this is div method");
	}

}
