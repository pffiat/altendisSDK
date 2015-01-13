package com.altendis.contact.validator;

import com.altendis.contact.model.Form;
import com.liferay.portal.kernel.util.Validator;

public class FormValidator {

	public static boolean validateForm(Form form) {

		if ( Validator.isNull(form.getNom())) {
			return false;
		}
		if ( Validator.isNull(form.getEntreprise())) { 
			return false;
		}
		if ( ! Validator.isEmailAddress(form.getEmail())) {
			return false;
		}
		if ( Validator.isNull(form.getComment())) {
			return false;
		}
		return true;
	}

}
