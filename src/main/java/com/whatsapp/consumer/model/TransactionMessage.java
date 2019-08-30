package com.whatsapp.consumer.model;

import lombok.Data;

@Data
public class TransactionMessage extends Message {
	private String contactNumber;
}
