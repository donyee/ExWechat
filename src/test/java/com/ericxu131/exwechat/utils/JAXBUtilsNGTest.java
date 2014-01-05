package com.ericxu131.exwechat.utils;

import com.ericxu131.exwechat.model.message.TextMessage;
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
public class JAXBUtilsNGTest {

    public JAXBUtilsNGTest() {
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
    public void testObjectToXml() {
        TextMessage textMessage = new TextMessage();
        textMessage.setContent("<a href=\"http://google.com/index.xhtml?id=xxxx132\">");
        textMessage.setCreateTime("123456");
        assertEquals("<xml><CreateTime>123456</CreateTime><MsgType>text</MsgType><Content><![CDATA[<a href=\"http://google.com/index.xhtml?id=xxxx132\">]]></Content></xml>", JAXBUtils.objectToXml(textMessage, TextMessage.class));
    }
}
