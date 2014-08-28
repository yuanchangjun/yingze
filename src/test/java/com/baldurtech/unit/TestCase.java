package com.baldurtech.unit;

import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Method;
import java.util.Set;
import org.reflections.Reflections;
public class TestCase
{	
	static boolean testResult = true;
	public static void main(String[] args)throws Exception
	{		
		if(args.length > 0)
		{
			String testPackage = args[0];
			Reflections reflections = new Reflections(testPackage);
			Set<Class<? extends TestCase>> allTestCases = 
			reflections.getSubTypesOf(TestCase.class);
		
			for(Class clazz:allTestCases)
			{
				System.out.println("Testing:" + clazz.getName());
				runAllTests(clazz);
			}
		}
		
		outputTestReport();
	}
	
	private static List<Method> getAllTestMethods(Class clazz)
	{
		List<Method> testMethods = new ArrayList<Method>();
		Method[] methods = clazz.getDeclaredMethods();
		for(Method method: methods)
		{
			if(method.getName().startsWith("test"))
			{
				testMethods.add(method);
			}
		}
		return testMethods;
	}
	public static void runAllTests(Class clazz) throws Exception
	{
		for(Method method: getAllTestMethods(clazz))
		{
			System.out.println("	testing:" + method.getName());
			try
			{
				Object obj = clazz.newInstance();
				method.invoke(obj,new Object[]{});
			}
			catch(Exception e)
			{
				testResult = false;
                System.out.println("Unexpected exception!");
                e.printStackTrace();
			}
		}
	}
	
	public static void assertEquals(String expectedResult,String actualResult)
	{
		assertEquals(expectedResult,actualResult,expectedResult.equals(actualResult));
	}
	public static void assertEquals(int expectedResult,int actualResult)
	{
		assertEquals(expectedResult,actualResult,expectedResult == actualResult);
	}
	public static void assertTrue(boolean actualResult)
	{
		assertEquals(true, actualResult, true == actualResult);
	}
	public static void assertFalse(boolean actualResult)
	{
		assertEquals(false, actualResult, false == actualResult);
	}
	public static void assertNull(Object actualResult)
	{
		assertEquals(null, actualResult, actualResult == null);
	}
	public static void assertEquals(Object expectedResult,Object actualResult)
	{
		Boolean testResult = false;
		if(expectedResult == null && actualResult == null)
		{
			testResult = true;
		}
		else if(expectedResult != null)
		{
			testResult = expectedResult.equals(actualResult);
		}
		assertEquals(expectedResult, actualResult, testResult);
	}
	private static void assertEquals(Object expectedResult, Object actualResult, boolean testSuccess)
	{
		if(!testSuccess)
		{
			testResult = false;
			System.out.println("Expected '" + (expectedResult == null?"Null":expectedResult) + "' ,but '" + (actualResult == null?"Null":actualResult) + "'");
		}
	}
    
    public static void assertArrayEquals(Object[] expectedResult, Object[] actualResult)
    {
        if(actualResult.length != expectedResult.length)
        {
            testResult = false;
            System.out.println("The length of both arrays not equals.");
        }
        else
        {
            for(int index = 0; index < expectedResult.length; index++)
            {
                if(!actualResult[index].equals(expectedResult[index]))
                {
                    testResult = false;
                    System.out.println("  Array[" + index + "] expected `" + (expectedResult[index] == null?"NULL":expectedResult[index]) + "`, but `" + (actualResult[index] == null?"NULL":actualResult[index]) + "`");
                }
            }
        }
    }

	public static void outputTestReport()
	{
		if(testResult)
		{
			System.out.println("TEST SUCCESS");
		}
		else
		{
			System.out.println("TEST FAILED");
		}

	}
}