package com.scp.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.scp.spring.mvc.beans.ProductBean;
import com.scp.spring.mvc.service.ProductService;


@Controller // i want inject prodservice inside this...
public class ProductController {

	@Autowired
	ProductService prodService;
	
	//http://localhost:8080/warname/urlpattern/products   -- GET  -- form bydefault get - address -- get
	
	static{
		System.out.println("inside product controller...!");
	}
	
	
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String listProducts(Model model) {
		model.addAttribute("productbn", new ProductBean());
		model.addAttribute("listProducts", this.prodService.getAllProduct());
		return "product";
	}
	
	//For add and update person both
	@RequestMapping(value= "/save", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("productbn") ProductBean p){
		
		if(p.getProductId() == 0){
			//new person, add it
			this.prodService.addProduct(p);
		}else{
			//existing person, call update
			this.prodService.updateProduct(p);
		}
		
		return "redirect:/products";  //http://localhost:8091/javanewmvc/products
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeProduct(@PathVariable("id") int id){
        this.prodService.deleteProduct(id);
        return "redirect:/products";
    }
 
    @RequestMapping("/edit/{id}")
    public ModelAndView editProduct(@PathVariable("id") int id, Model model){
        model.addAttribute("productbn", this.prodService.getProduct(id));
        model.addAttribute("listProducts", this.prodService.getAllProduct());
        return new ModelAndView("product");
    }

}

