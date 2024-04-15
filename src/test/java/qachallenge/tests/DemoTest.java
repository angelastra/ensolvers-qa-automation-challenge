package qachallenge.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class DemoTest {
    @Test
    @Severity(SeverityLevel.TRIVIAL)
    public void demo1(){
        Assert.assertTrue(false);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void demo2(){
        Assert.assertTrue(true);
    }
}
