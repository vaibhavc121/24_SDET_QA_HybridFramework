package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;

public class RetryAnalyzerSample extends BaseClass
{
	@Test(retryAnalyzer = utilities.RetryAnalyzerClass.class)
	public void verifyRetryAnalyzer()
	{
		Assert.assertEquals("A", "B");
	}
}
