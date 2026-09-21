package com.chan.Bai10_Annotations;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DemoAnnotation {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }

    @Test
    public void test_method_01(){
        System.out.println("Method 01");
    }

    @Test
    public void test_method_02(){
        System.out.println("Method 02");
    }

    @Test
    public void test_method_03(){
        System.out.println("Method 03");
    }
}
