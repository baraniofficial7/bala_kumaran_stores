package com.balakumaranstores.stat.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.balakumaranstores.stat.Model.Contacts;
import com.balakumaranstores.stat.dao.StoresDao;
import com.balakumaranstores.stat.entity.ContactsEntity;

@Component
public class StoresServiceImpl implements StoresService{

	@Autowired
	StoresDao storesDao;
	
	@Override
	public List<ContactsEntity> getDataAll() {
		List<Contacts> contactList = new ArrayList<Contacts>();
		List<ContactsEntity> contactEntityList = new ArrayList<ContactsEntity>();
		contactList=storesDao.getDataAll();
		contactEntityList=contactList.stream().map(mapper->{
			ContactsEntity contactsEntity= new ContactsEntity();
			contactsEntity.setId(mapper.getId());
			contactsEntity.setType(mapper.getType());
			contactsEntity.setName(mapper.getName());
			contactsEntity.setAddress(mapper.getAddress());
			contactsEntity.setMobileNo(mapper.getMobileno());
			contactsEntity.setGstNo(mapper.getGstno());
			contactsEntity.setZone(mapper.getZone());
			return contactsEntity;
		}).collect(Collectors.toList());
		return contactEntityList;
	}


	@Override
	public ContactsEntity getDeleteData(int id) {
		ContactsEntity contacts= new ContactsEntity();
		storesDao.getDeleteData(id);
		return contacts;
	}

	@Override
	public int saveData(ContactsEntity contact) {
		Contacts contacts=getContacts(contact);
		int customerId=storesDao.saveData(contacts);
		return customerId;
		
	}

	@Override
	public ContactsEntity getData(int id) {
		Contacts contact = new Contacts();
		contact=storesDao.getData(id);
		ContactsEntity contactsEntity= new ContactsEntity();
			contactsEntity.setId(contact.getId());
			contactsEntity.setType(contact.getType());
			contactsEntity.setName(contact.getName());
			contactsEntity.setAddress(contact.getAddress());
			contactsEntity.setMobileNo(contact.getMobileno());
			contactsEntity.setGstNo(contact.getGstno());
			contactsEntity.setZone(contact.getZone());
		return contactsEntity;
	}


	public void updateData(ContactsEntity contact) {
		Contacts contacts=getContacts(contact);
		storesDao.updateData(contacts);
	}
	
	private Contacts getContacts(ContactsEntity contact) {
		Contacts contacts= new Contacts();
		contacts.setId(contact.getId());
		contacts.setType(contact.getType());
		contacts.setName(contact.getName());
		contacts.setAddress(contact.getAddress());
		contacts.setMobileno(contact.getMobileNo());
		contacts.setGstno(contact.getGstNo());
		contacts.setZone(contact.getZone());
		return contacts;
	}
	
}
