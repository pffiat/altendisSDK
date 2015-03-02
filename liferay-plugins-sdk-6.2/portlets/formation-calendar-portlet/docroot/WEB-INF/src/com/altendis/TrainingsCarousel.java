package com.altendis;

import java.io.IOException;
import java.util.Collections;
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
 * Portlet implementation class FormationCarousel
 */
public class TrainingsCarousel extends MVCPortlet {

	@Override
	public void doView(final RenderRequest renderRequest, final RenderResponse renderResponse) throws IOException, PortletException {

		final ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			long calendarId = 0;

			final List<Calendar> cals = CalendarLocalServiceUtil.getCalendars(0, CalendarLocalServiceUtil.getCalendarsCount());
			for (final Calendar calendar : cals) {
				if (calendar.getGroupId() == themeDisplay.getLayout().getGroupId()) {
					calendarId = calendar.getCalendarId();
					break;
				}
			}

			// if we get the calendar
			if (calendarId > 0) {

				final java.util.Calendar cal = GregorianCalendar.getInstance();
				cal.setTime(new Date());
				cal.add(GregorianCalendar.YEAR, 1);

				final List<CalendarBooking> bookings = CalendarBookingLocalServiceUtil.getCalendarBookings(calendarId, new Date().getTime(),
						cal.getTimeInMillis());

				Collections.sort(bookings, new OrderEventByDate());

				renderRequest.setAttribute("bookings", bookings);
			}

			super.doView(renderRequest, renderResponse);

		} catch (final SystemException e) {
			e.printStackTrace();
		}
	}
}
