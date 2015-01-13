package com.altendis.contactme;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.altendis.contact.service.FormLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ContactMe
 */
public class ContactMe extends MVCPortlet {


	private static final Log LOG = LogFactoryUtil.getLog(ContactMe.class);


	public void addForm(final ActionRequest request, final ActionResponse response) throws SystemException, IOException {
		LOG.debug("add request");
		FormLocalServiceUtil.addFormFromRequest(request);
	}

} 
