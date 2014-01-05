ExWechat
========

ExWechat是一个java编写的微信类库。
Maven项目3步整合微信。

### 1. 加入Repository。

    <repository>
        <id>ExWechat-mvn-repo</id>
        <url>https://raw.github.com/ericxu131/ExWechat/mvn-repo/</url>
        <snapshots>
            <enabled>true</enabled>
            <updatePolicy>always</updatePolicy>
        </snapshots>
    </repository>

### 2. 加入Rependency。

    <dependency>
        <groupId>com.ericxu131</groupId>
        <artifactId>EXWechat</artifactId>
        <version>1.0-SNAPSHOT</version>
        <exclusions>
            <exclusion>
                <artifactId>javax.servlet-api</artifactId>
                <groupId>javax.servlet</groupId>
            </exclusion>
        </exclusions>
    </dependency>

### 3. 新建一个Servlet继承WechatServlet来接收微信的信息。

    import com.ericxu131.exwechat.WechatClient;
    import com.ericxu131.exwechat.model.WechatUser;
    import com.ericxu131.exwechat.model.event.ClickEvent;
    import com.ericxu131.exwechat.model.message.Message;
    import com.ericxu131.exwechat.model.message.TextMessage;
    import com.ericxu131.exwechat.web.WechatServlet;
    import javax.servlet.annotation.WebServlet;

    /**
     *
     * @author eric
     */
    @WebServlet(name = "MyWechatServlet", urlPatterns = {"/MyWechatServlet"})
    public class MyWechatServlet extends WechatServlet {

        @Override
        protected String getToken() {
            return "这里填写token";
        }

        @Override
        protected Message onMessage(Message message) {
            //接收文本信息
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                if ("hi".equals(textMessage.getContent())) {
                    //创建回复的信息
                    TextMessage responseMessage = replyTextMessage(message);

                    //创建一个Client来获取用户信息，这里要填写appid和secret
                    WechatClient wechatClient = new WechatClient("appid", "secret");
                    //获取用户信息
                    WechatUser wechatUser = wechatClient.getUserInfo(message.getFromUserName());
                    responseMessage.setContent(String.format("Hi:%s", wechatUser.getNickname()));
                    return responseMessage;
                }
            }
            //接收自定义菜单点击事件
            if (message instanceof ClickEvent) {
                ClickEvent clickEvent = (ClickEvent) message;
                if ("V1001_XXX".equals(clickEvent.getEventKey())) {
                    //处理逻辑写在这里
                }
            }
            return null;
        }

    }
