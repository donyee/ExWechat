/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ericxu131.exwechat.model.message;

import com.ericxu131.exwechat.model.message.TextMessage;
import com.ericxu131.exwechat.model.message.MessageType;
import static org.testng.Assert.*;
import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author eric
 */
public class TextMessageNGTest {

    public TextMessageNGTest() {
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
    public void testSomeMethod() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(TextMessage.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        StringReader reader = new StringReader("<xml>\n"
                + " <ToUserName><![CDATA[toUser]]></ToUserName>\n"
                + " <FromUserName><![CDATA[fromUser]]></FromUserName> \n"
                + " <CreateTime>1348831860</CreateTime>\n"
                + " <MsgType><![CDATA[text]]></MsgType>\n"
                + " <Content><![CDATA[this is a test]]></Content>\n"
                + " <MsgId>1234567890123456</MsgId>\n"
                + " </xml>");
        TextMessage textMessage = (TextMessage) unmarshaller.unmarshal(reader);
        assertEquals("toUser", textMessage.getToUserName());
        assertEquals("fromUser", textMessage.getFromUserName());
        assertEquals("1348831860", textMessage.getCreateTime());
        assertEquals(MessageType.TEXT, textMessage.getMsgType());

    }

}
