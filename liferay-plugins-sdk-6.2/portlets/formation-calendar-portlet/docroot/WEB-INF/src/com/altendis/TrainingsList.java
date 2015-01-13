package com.altendis;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.calendar.service.CalendarLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class FormationBanner
 */
public class TrainingsList extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			long calendarId = 0;

			List<Calendar> cals = CalendarLocalServiceUtil.getCalendars(0, 100);
			for (Calendar calendar : cals) {
				if (calendar.getGroupId() == themeDisplay.getLayout().getGroupId()) {
					calendarId = calendar.getCalendarId();
					break;
				}
			}

			// if we get the calendar
			if (calendarId > 0) {

				java.util.Calendar cal = GregorianCalendar.getInstance();
				cal.setTime(new Date());
				cal.add(GregorianCalendar.YEAR, 1);

				List<CalendarBooking> bookings = CalendarBookingLocalServiceUtil.getCalendarBookings(calendarId, new Date().getTime(),
						cal.getTimeInMillis());

				renderRequest.setAttribute("bookings", bookings);
			}

			super.doView(renderRequest, renderResponse);

		} catch (SystemException e) {
			e.printStackTrace();
		}

	}
}
