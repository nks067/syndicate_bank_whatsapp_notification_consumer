package com.whatsapp.consumer.listener;

import javax.jms.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.whatsapp.consumer.model.Message;




@Component
public class MessageListener {
private static final Logger logger=LoggerFactory.getLogger(MessageListener.class);
private final String LogHead="transaction.queue Consumer() :: ";	
	
	
	@JmsListener(destination="transaction.queue")
	public void receiveMessage(Message request) {
		try {
		logger.info(LogHead+"Recieved Message "+request.toString());
		System.out.println("print-and-post-message-queue-Listener :: Data-"+request.toString());
		//PpRequest pp=new PpRequest(null,request.getUin(),request.getName(),request.getMobile(),request.getDOB(),null,0,request.getEmail());
		//pp=ppRequestDAO.addRequest(pp);
		//logger.info(LogHead+"Loigged Into DataBase For Processing "+pp.toString());
		}catch(Exception e) {
			logger.error(LogHead+"Exception Occure "+e);
		}
	}
	
}
