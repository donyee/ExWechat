package com.ericxu131.exwechat;

import com.ericxu131.exwechat.model.WechatQRCode;
import com.ericxu131.exwechat.model.WechatUser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 *
 * @author eric
 */
public class WechatClientNGTest {

    public WechatClientNGTest() {
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
    public void testSend() {

    }

    @Test
    public void test() {
        WechatClient wechatClient = new WechatClient("wxaf1578e09211f853", "8aae2799c892416c634e6f225cace6da");
        WechatQRCode code = wechatClient.qrCodeCreate(90, QRCodeCreateActionName.QR_SCENE, "test2", 10);
        System.out.println(code.getTicket());
        System.out.println(code.getExpireSeconds());
    }

}
