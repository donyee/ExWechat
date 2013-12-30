package com.ericxu131.exwechat.model.event;

import com.ericxu131.exwechat.utils.JAXBUtils;
import javax.xml.bind.JAXBException;
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
public class ClickEventNGTest {

    public ClickEventNGTest() {
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
        ClickEvent clickEvent = JAXBUtils.parserString("<xml>\n"
                + "<ToUserName><![CDATA[toUser]]></ToUserName>\n"
                + "<FromUserName><![CDATA[FromUser]]></FromUserName>\n"
                + "<CreateTime>123456789</CreateTime>\n"
                + "<MsgType><![CDATA[event]]></MsgType>\n"
                + "<Event><![CDATA[CLICK]]></Event>\n"
                + "<EventKey><![CDATA[EVENTKEY]]></EventKey>\n"
                + "</xml>", ClickEvent.class);
        assertEquals("toUser", clickEvent.getToUserName());
    }
}
