package com.sameer.SpringMVC_Hibernate_Image_Database.controller;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sameer.SpringMVC_Hibernate_Image_Database.dao.FlowerDao;
import com.sameer.SpringMVC_Hibernate_Image_Database.model.Flower;

@Controller
public class FlowerController {

	@Autowired
	private FlowerDao flowerDao;

	@RequestMapping(value = "/fetch")
	public ModelAndView listFlower(ModelAndView model) throws IOException {
		/**
		 * It is responsible to fetch records from database and return to the index.jsp
		 * file.
		 */

		List<Flower> listFlower = flowerDao.flowersList();

		model.addObject("listFlower", listFlower);
		model.setViewName("show");
		return model;
	}

	@RequestMapping(value = "/getFlowerPhoto/{id}")
	public void getFlowerPhoto(HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		/**
		 * This code is responsible to get images from JPA (model) and display.
		 */
		response.setContentType("image/jpg");
		Blob userrecord = flowerDao.getPhotoById(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(userrecord.getBytes(1, (int) userrecord.length()));
		response.getOutputStream().close();
	}

	@RequestMapping(value = "/InsertImage", method = RequestMethod.POST)
	public ModelAndView saveImage(@RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam("photo") MultipartFile photo) {
		try {
			flowerDao.insertRecords(Integer.parseInt(id), name, photo);
			return new ModelAndView("index", "msg", "Records succesfully inserted into database.");
		} catch (Exception e) {
			return new ModelAndView("index", "msg", "Error: " + e.getMessage());
		}

	}
}
