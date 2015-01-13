package com.altendis.contactme;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.altendis.contact.service.FormLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
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

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		String training = ParamUtil.getString(renderRequest, "training");
		String start = ParamUtil.getString(renderRequest, "start");
		String end = ParamUtil.getString(renderRequest, "end");

		LOG.info(training + " " + start + " " + end);
		super.doView(renderRequest, renderResponse);
	}

}
