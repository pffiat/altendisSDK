/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.altendis.contact.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;

import com.altendis.contact.model.Form;
import com.altendis.contact.service.base.FormLocalServiceBaseImpl;
import com.altendis.contact.validator.FormValidator;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * The implementation of the form local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.altendis.contact.service.FormLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author pif
 * @see com.altendis.contact.service.base.FormLocalServiceBaseImpl
 * @see com.altendis.contact.service.FormLocalServiceUtil
 */
public class FormLocalServiceImpl extends FormLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.altendis.contact.service.FormLocalServiceUtil} to access the form local service.
	 */

	private static final Log LOG = LogFactoryUtil.getLog(FormLocalServiceImpl.class);
	private static final String EMAIL_SRC = "noreply@altendis.fr";
	private static final String EMAIL_SRC_NAME = "Altendis.fr";
	private static final String EMAIL_DEST = "liferay@altendis.fr";
	private static final String EMAIL_DEST_NAME = "Pascal Simon";
	private static final String EMAIL_TITLE = "Demande formation Liferay (email automatique)";

	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.altendis.contact.service.FormLocalServiceUtil} to access the form
	 * local service.
	 */

	public void addFormFromRequest(ActionRequest request) throws SystemException {

		final long primaryKey = CounterLocalServiceUtil.increment(Form.class.getName());
		LOG.debug("pK done");
		Form form = formPersistence.create(primaryKey);
		form.setNom(ParamUtil.getString(request, "nom"));
		form.setPrenom(ParamUtil.getString(request, "prenom"));
		form.setTelephone(ParamUtil.getString(request, "telephone"));
		form.setEmail(ParamUtil.getString(request, "email"));
		form.setComment(ParamUtil.getString(request, "comment"));
		form.setCreateDate(Calendar.getInstance().getTime());

		LOG.debug("form fill");

		if (FormValidator.validateForm(form)) {
			try {
				sendEmail(EMAIL_SRC, EMAIL_SRC_NAME, EMAIL_DEST, EMAIL_DEST_NAME, EMAIL_TITLE, subject(form));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			SessionMessages.add(request, "success");
			formPersistence.update(form);
			LOG.debug("success");
		} else {
			SessionErrors.add(request, "error");
			LOG.debug("error");
		}
	}

	private void sendEmail(String fromAddress, String fromName, String toAddress, String toName, String subject, String body)
			throws UnsupportedEncodingException {

		InternetAddress from = new InternetAddress(fromAddress, fromName);
		InternetAddress to = new InternetAddress(toAddress, toName);

		MailMessage mailMessage = new MailMessage(from, to, subject, body, true);

		MailServiceUtil.sendEmail(mailMessage);
	}

	private String subject(Form form) {

		return new StringBuilder("Nom: ").append(form.getNom()).append("<br /> Prenom: ").append(form.getPrenom()).append("<br /> Email: ")
				.append(form.getEmail()).append("<br /> Telephone: ").append(form.getTelephone()).append("<br /> <br /> Demande: ")
				.append(form.getComment()).toString();
	}
}