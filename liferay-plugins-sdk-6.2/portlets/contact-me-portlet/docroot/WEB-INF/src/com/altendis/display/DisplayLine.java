package com.altendis.display;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

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
	
	@Override
	public void doView(final RenderRequest renderRequest, final RenderResponse renderResponse) throws PortletException, IOException {
		
		super.doView(renderRequest, renderResponse);
	}
	
	public void deleteLine(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException {
		long formId = ParamUtil.getLong(actionRequest, "formId");
		LOG.info("formId : "+formId);
		FormLocalServiceUtil.deleteForm(formId);
	}

}
