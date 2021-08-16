package com.sameer.SpringMVC_Hibernate_Image_Database.dao;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.web.multipart.MultipartFile;

import com.sameer.SpringMVC_Hibernate_Image_Database.model.Flower;

public class FlowerDaoImpl implements FlowerDao {


	public List<Flower> flowersList() {

			Configuration conf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Flower.class);
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
			SessionFactory sf = conf.buildSessionFactory(reg);
			Session session = sf.openSession();

			session.beginTransaction();
			Query q = session.createQuery("from Flower");
			List<Flower> flowers = q.list();
			
			return flowers;
	}

	public Blob getPhotoById(int id) {
		Configuration conf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Flower.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		SessionFactory sf = conf.buildSessionFactory(reg);
		Session session = sf.openSession();

		session.beginTransaction();
		Query q = session.createQuery("from Flower where id = :ID");
		q.setParameter("ID", id);
		Flower flower = (Flower) q.uniqueResult();
		
		return flower.getPhoto();
	}

	public void insertRecords(int id, String name, MultipartFile photo) throws HibernateException, IOException {

		Configuration conf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Flower.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		SessionFactory sf = conf.buildSessionFactory(reg);
		Session session = sf.openSession();
		
		Flower flower = new Flower();
		flower.setId(id);
		flower.setName(name);
		Blob blob=Hibernate.getLobCreator(session).createBlob(photo.getInputStream(),photo.getSize());
		flower.setPhoto(blob);

		session.beginTransaction();
		session.save(flower);
		session.getTransaction().commit();
	}
}
