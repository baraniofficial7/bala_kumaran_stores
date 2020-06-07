package com.balakumaranstores.stat.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.balakumaranstores.stat.entity.ContactsEntity;
import com.balakumaranstores.stat.service.StoresService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class StoresController {
	
	@Autowired
	StoresService storesService;
	
	@ResponseBody
	@PostMapping("/contacts/saveData")
	public int saveData(@RequestBody ContactsEntity contact) throws IOException {
		int customerId=storesService.saveData(contact);
		return customerId;
	}
	
	@ResponseBody
	@RequestMapping("/contacts/getDataAll")
	public List<ContactsEntity> getDataAll() throws IOException {
		List<ContactsEntity> contactValue=storesService.getDataAll();
		return contactValue;
	}
	
	@ResponseBody
	@RequestMapping("/contacts/getData")
	public ContactsEntity getData(@RequestParam String id) throws IOException {
		int customerId=Integer.parseInt(id);
		ContactsEntity contactValue=storesService.getData(customerId);
		return contactValue;
	}
	
	@ResponseBody
	@PutMapping("/contacts/editData/{id}")
	public ContactsEntity updateData(@PathVariable("id") String id,@RequestBody ContactsEntity contact) throws IOException {
		int customerId=Integer.parseInt(id);
		contact.setId(customerId);
		storesService.updateData(contact);
		return contact;
	}
	
	@ResponseBody
	@DeleteMapping("/contacts/deleteData/{id}")
	public ContactsEntity deleteData(@PathVariable("id") String id) throws IOException,NumberFormatException {
		int customerId=Integer.parseInt(id);
		ContactsEntity stateValue=storesService.getDeleteData(customerId);
		return stateValue;
	}
}
