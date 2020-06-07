package com.balakumaranstores.stat.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="contacts")
@Data
public class Contacts implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id", updatable = false, nullable = false)
	private int id;
	
	private String type;
	
    private String name;
    
    private String address;
    
    private long mobileno;
    
    private String gstno;
    
    private String zone;
    
}
