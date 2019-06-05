package common.service.mq;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * 消息生产者
 * @author Neil
 *
 */
@Service("producer")
public class Producer {
	@Autowired
	private JmsMessagingTemplate jsmTemplate;
	
	/**
	 * 发送消息
	 * @param destination是发送到的队列，message是待发送的消息  
	 */
	public void sendMessage(String key,final String value) {
		Destination destination = new ActiveMQQueue(key);
		this.jsmTemplate.convertAndSend(destination, value);
	}
	
	
	
	
	
	
	
	
	
}
