package com.whatsapp.consumer.service;

import org.springframework.stereotype.Component;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Slf4j
@Component
public class WhatsAppClient {
	public static final String ACCOUNT_SID="ACb45516734cd35efef11469cd8c3b0fd4";
	public static final String AUTH_TOKEN="310bb80f44f6580ebadf434d349066c9";
	
	
	public void sendNotification(com.messageproducer.model.TransactionMessage msg) {
		String logHead="WhatsAppClient.class sendNotification() :: Message Id-{"+msg.getMessageId()+"} | ";
	    try {
	        /*TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

	        // Build a filter for the MessageList
	        List<NameValuePair> params = new ArrayList<NameValuePair>();
	        params.add(new BasicNameValuePair("Body", msg.getMessage()));
	        params.add(new BasicNameValuePair("To", "whatsapp:+"+msg.getContactNumber())); //Add real number here
	        params.add(new BasicNameValuePair("From","whatsapp:+19403103938"));

	        MessageFactory messageFactory = client.getAccount().getMessageFactory();
	        Message message = messageFactory.create(params);
	     //   System.out.println();*/
	    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	        Message message = Message.creator(
	                new com.twilio.type.PhoneNumber("whatsapp:+"+msg.getContactNumber()),
	                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),msg.getMessage())
	            .create();

	        System.out.println(message.getSid());
	        log.info(logHead+"Message Sending Status :: "+message.getStatus());
	        log.info(logHead+"Message Response :: "+message.toString());
	    } 
	    catch (Exception e) {
	    	log.error(logHead+"Message Exception :: "+e);
	    }
	}
}
