package org.cmobile.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognizant.cmobile.api.service.LoadDataService;

@Controller
public class LoadDataController {

	
	@Autowired
	LoadDataService loadDataService;
	
	/** Method to load data. */
	@RequestMapping(value = "/loadData")
	public void loadData() 
			throws ParseException {
		loadDataService.loadData();
	}
}
