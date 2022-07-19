package com.mosambee.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mosambee.errorhandling.ErrorHandling;
import com.mosambee.helper.Message;
import com.mosambee.model.Client;
import com.mosambee.repositary.MyRepositary;


import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class MyController {
	
	@Autowired
	private MyRepositary myRepositary;

	@GetMapping("/myform")
	public String myform(Model model) {
		
		log.debug("admin-detail/get/myrequest: {}","Just calling Form page"); 

		System.out.println("Opening my form..");
		
		model.addAttribute("client", new Client());
		
		return "form";
	}
	//RedirectAttributes redirectAttributes
	@RequestMapping(value =  "/addRecord" , method = RequestMethod.POST)
	public String addRecord(@Valid @ModelAttribute("client") Client client, BindingResult bindingResult, Model model, RedirectAttributes ra, HttpSession session)
	{
		try
		{
		 if(bindingResult.hasErrors())  
	     {  
			 ErrorHandling.errorsCollections( bindingResult, model);
			 //model.addAttribute("userList", bindingResult.getAllErrors());
			 
			 System.out.println("Error occure here  " + bindingResult.getAllErrors());
			 
				log.debug("addRecord/get/request {}", "Error founded");
				return "form";
	     }  
		 else
	        {  
	        	client.setRole("ROLE_USER");
	        	client.setEnabled(true);
	        	Client result = this.myRepositary.save(client);
	        	
	    		model.addAttribute("message", "Data Saved Succesfully...");
	    		ra.addFlashAttribute("user", client); 
	    		//redirectAttributes.addFlashAttribute("message", "Account created!");
	    		
	    		log.debug("User is Added...");
	    		System.out.println("Data Saved...");
	    		return "redirect:/registration-success";
	        }  
		}catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("message", new Message("Something Went wrong !! " + e.getMessage(), "alert-danger"));
			return "form";
		}
	}
	
	@RequestMapping(value = "registration-success", method = RequestMethod.GET)
	    public String handleRegistrationDone(@ModelAttribute("user") Client client, Model model){
		
		 if(client!=null) {
		 model.addAttribute("message", "Data Saved Succesfully...");
		 
		 }/*
		 if(client!=null)
		 {
			 model.addAttribute("message", "Data Saved Succesfully, But Account is Already Created");
		 }*/
	       System.out.println("user....: "+client);
	        return "form";
	    }
}
