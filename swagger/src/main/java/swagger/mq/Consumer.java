package swagger.mq;

//import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * 消息消费者
 * @author Neil
 */
@Service
public class Consumer {
	
	/**
	 * 接收消息
	 * @param text
	 * @return
	 */
	//@JmsListener(destination = "name")
	//@SendTo("user") 将text又返回至user  MQ队列中
	public String receiveQueue(String text) {
		return text;
	}
}
