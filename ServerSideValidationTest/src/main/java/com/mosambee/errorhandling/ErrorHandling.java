package com.mosambee.errorhandling;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ErrorHandling {
	
	public static void errorsCollections(BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {

			List<FieldError> error = bindingResult.getFieldErrors();

			StringBuilder clientName = new StringBuilder();
			StringBuilder clientProjectPrice = new StringBuilder();
			StringBuilder clientContact = new StringBuilder();
			StringBuilder clientEmail = new StringBuilder();

			for (FieldError field : error) {
				String fieldName = field.getField();
				String message = field.getDefaultMessage();

				if (fieldName.equals("clientName")) {
					clientName.append(message + " ");
					model.addAttribute(fieldName, clientName);
				} else if (fieldName.equals("clientProjectPrice")) {
					clientProjectPrice.append(message + " ");
					model.addAttribute(fieldName, clientProjectPrice);
				} else if (fieldName.equals("clientContact")) {
					clientContact.append(message + " ");
					model.addAttribute(fieldName, clientContact);
				} else if (fieldName.equals("clientEmail")) {
					clientEmail.append(message + " ");
					model.addAttribute(fieldName, clientEmail);
				}
			}

			log.debug("addRecord/get/request {}",
					clientName + " " + clientProjectPrice + " " + clientContact + " " + clientEmail);
		}
	}
}