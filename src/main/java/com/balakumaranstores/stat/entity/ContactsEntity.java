package com.balakumaranstores.stat.entity;

import lombok.Data;

@Data
public class ContactsEntity {
	private int id;
	private String type;
    private String name;
    private String address;
    private long mobileNo;
    private String gstNo;
    private String zone;

}
