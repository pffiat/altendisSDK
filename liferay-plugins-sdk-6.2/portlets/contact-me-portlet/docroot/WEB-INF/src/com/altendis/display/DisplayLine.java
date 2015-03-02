package com.altendis.display;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.altendis.contact.service.FormLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class DisplayLine
 */
public class DisplayLine extends MVCPortlet {
 
	private static final Log LOG = LogFactoryUtil.getLog(DisplayLine.class);

	public void deleteLine(final ActionRequest actionRequest, final ActionResponse actionResponse) throws PortalException, SystemException {
		final long formId = ParamUtil.getLong(actionRequest, "formId");
		LOG.info("formId : "+formId);
		FormLocalServiceUtil.deleteForm(formId);
	}
}
