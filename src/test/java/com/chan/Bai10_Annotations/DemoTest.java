package com.chan.Bai10_Annotations;

import org.testng.annotations.Test;

public class DemoTest {
    @Test(priority = 1, description = "Verify login CRM success")
    public void testLoginCRM(){
        System.out.println("Login");
    }

    @Test(priority = 2, description = "Verify logout CRM success")
    public void testLogoutCRM(){
        System.out.println("Logout");
    }

    @Test(priority = 3, description = "Verify log in fail with invalid email")
    public void testLoginFailWithEmailInvalid(){
        System.out.println("Invalid Email");
    }

    @Test(dependsOnMethods = {"testLoginCRM"})
    public void testAddNewCustomer(){
        System.out.println("Add customer");
    }
}
