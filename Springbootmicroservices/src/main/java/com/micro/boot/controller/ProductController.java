package com.micro.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.micro.boot.model.Product;
import com.micro.boot.pojo.ResponsePojo;
import com.micro.boot.service.ProductServiceImpl;

@Controller
@RequestMapping(path="/rest")
public class ProductController {

	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@ResponseBody
	@PostMapping(path = "/addDevice", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponsePojo addDevice(@RequestBody Product product) {
		Product prod = productServiceImpl.addProduct(product);
		ResponsePojo response = new ResponsePojo();
		if (prod.getSerialId() != null) {
			response.setStatus("Product Successfully saved");
		} else {
			response.setStatus("Product not saved ");
		}
		return response;

	}
}
