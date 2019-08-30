package com.whatsapp.consumer.service;

import org.springframework.stereotype.Component;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;


@Slf4j
@Component
public class WhatsAppClient {
	public static final String ACCOUNT_SID="ACb5b7c658df0d2df0896fcfcb088910af";
	public static final String AUTH_TOKEN="a7468cb857083014e90de6eef48e3be4";
	
	
	public void sendNotification(com.messageproducer.model.TransactionMessage msg) {
		String logHead="WhatsAppClient.class sendNotification() :: Message Id-{"+msg.getMessageId()+"} | ";
	    try {
	        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

	        // Build a filter for the MessageList
	        List<NameValuePair> params = new ArrayList<NameValuePair>();
	        params.add(new BasicNameValuePair("Body", msg.getMessage()));
	        params.add(new BasicNameValuePair("To", "+"+msg.getContactNumber())); //Add real number here
	        params.add(new BasicNameValuePair("From","+19403103938"));

	        MessageFactory messageFactory = client.getAccount().getMessageFactory();
	        Message message = messageFactory.create(params);
	        System.out.println();
	        log.info(logHead+"Message Sending Status :: "+message.getStatus());
	        log.info(logHead+"Message Response :: "+message.toString());
	    } 
	    catch (TwilioRestException e) {
	    	log.error(logHead+"Message Exception :: "+e);
	    }
	}
}
