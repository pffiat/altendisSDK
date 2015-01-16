package com.altendis;

import java.util.Comparator;

import com.liferay.calendar.model.CalendarBooking;

public class OrderEventByDate implements Comparator<CalendarBooking> {
	@Override
	public int compare(CalendarBooking o1, CalendarBooking o2) {
		if (o1.getStartTime() < o2.getStartTime()) {
			return -1;
		} else if (o2.getStartTime() < o1.getStartTime())
			return 1;
		else
			return 0;
	}
}