package com.balakumaranstores.stat.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.balakumaranstores.stat.entity.ContactsEntity;

@Component
public interface StoresService {

	List<ContactsEntity> getDataAll();

	ContactsEntity getDeleteData(int customerId);

	int saveData(ContactsEntity contact);

	ContactsEntity getData(int id);

	void updateData(ContactsEntity contact);
	
}
