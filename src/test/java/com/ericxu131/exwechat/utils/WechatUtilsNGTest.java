package com.ericxu131.exwechat.utils;

import java.util.Map;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author eric
 */
public class WechatUtilsNGTest {

    public WechatUtilsNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test
    public void testSign() {
        WechatUtils.sign("edsf213", "123213", "tiklearn");
        assertTrue(true);
    }

    @Test
    public void testGetAccessToken() {
    }

}
