package com.balakumaranstores.stat.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.balakumaranstores.stat.Model.Contacts;

@Component
public interface StoresDao {

	int saveData(Contacts contactsDao);

	List<Contacts> getDataAll();

	Contacts getData(int id);

	void getDeleteData(int id);

	void updateData(Contacts contacts);

}
