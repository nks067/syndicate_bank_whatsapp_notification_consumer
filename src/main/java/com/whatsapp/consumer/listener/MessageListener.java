package com.whatsapp.consumer.listener;

import javax.jms.ObjectMessage;
import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.messageproducer.model.Message;
import com.messageproducer.model.TransactionMessage;

import lombok.extern.slf4j.Slf4j;




@Component
@Slf4j
public class MessageListener {
private static final Logger logger=LoggerFactory.getLogger(MessageListener.class);
private final String LogHead="transaction.queue Consumer() :: ";	
	
	
	@JmsListener(destination="transaction.queue")
	public void receiveMessage(org.apache.activemq.Message object) {
		String logHead="WhatsAppClient.class sendNotification() :: ";
		try {
			
		//	TransactionMessage msg = (TransactionMessage) object;
		ObjectMessage objMsg=(ObjectMessage)object;
		TransactionMessage msg=(TransactionMessage)objMsg.getObject();
		logHead+=logHead+"Message Id-{"+msg.getMessageId()+"} | ";
		logger.info(logHead+"Recieved Message "+msg.toString());
		//PpRequest pp=new PpRequest(null,request.getUin(),request.getName(),request.getMobile(),request.getDOB(),null,0,request.getEmail());
		//pp=ppRequestDAO.addRequest(pp);
		//logger.info(LogHead+"Loigged Into DataBase For Processing "+pp.toString());
		}catch(Exception e) {
			logger.error(logHead+"Exception Occure "+e);
		}
	}
	
}
