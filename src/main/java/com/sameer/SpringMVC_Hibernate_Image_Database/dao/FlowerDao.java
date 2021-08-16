package com.sameer.SpringMVC_Hibernate_Image_Database.dao;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.web.multipart.MultipartFile;

import com.sameer.SpringMVC_Hibernate_Image_Database.model.Flower;

public interface FlowerDao {

	public List<Flower> flowersList();
	
	public Blob getPhotoById(int id);
	
	public void insertRecords(int id, String name, MultipartFile photo) throws HibernateException, IOException;

}
