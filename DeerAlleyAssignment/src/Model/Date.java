package Model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date {

	private int starDay, startMonth, startYear, dayOfWeek;
	private int endDay, endMonth, endYear, endDayOfWeek;

	public Date(int startDay, int startMonth, int startYear, int endDay,
			int endMonth, int endYear) {
		this.starDay = startDay;
		this.startMonth = startMonth;
		this.startYear = startYear;
		Calendar c = GregorianCalendar.getInstance();
		c.set(startYear, startMonth - 1, startDay); // The month index counter
													// starts at 0 which is
													// January
		this.dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

		this.endDay = endDay;
		this.endMonth = endMonth;
		this.endYear = endYear;
		Calendar c2 = GregorianCalendar.getInstance();
		c2.set(endYear, endMonth - 1, endDay);
		this.endDayOfWeek = c2.get(Calendar.DAY_OF_WEEK);
	}

	public Date() {

		Calendar calendar = GregorianCalendar.getInstance();

		this.starDay = calendar.get(Calendar.DAY_OF_MONTH);
		this.startMonth = calendar.get(Calendar.MONTH) + 1;
		this.startYear = calendar.get(Calendar.YEAR);
		this.dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

	}

	public int getDayOfWeekStart() {
		return dayOfWeek;
	}

	public int getDayOfWeekEnd() {
		return this.endDayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public void setDate(int startDay, int startMonth, int startYear, int endDay, int endMonth, int endYear){
	      this.starDay = startDay;
	      this.startMonth = startMonth;
	      this.startYear = startYear;
	      this.endDay = endDay;
	      this.endMonth = endMonth;
	      this.endYear = endYear;
	   }

	public Date copy() {
		return new Date(starDay, startMonth, startYear, endDay, endMonth,
				endYear);
	}

	public String toString() {
		return dayOfWeekStart() + " " + String.format("%02d", starDay) + "/"
				+ String.format("%02d", getStartMonth()) + "/"
				+ String.format("%02d", startYear) + "\n" + dayOfWeekEnd()
				+ " " + String.format("%02d", endDay) + "/"
				+ String.format("%02d", getEndMonth()) + "/"
				+ String.format("%02d", endYear);

	}

	public String dayOfWeekStart() {

		if (this.dayOfWeek == 2) {
			return "Monday";
		} else if (this.dayOfWeek == 3) {
			return "Tuesday";
		} else if (this.dayOfWeek == 4) {
			return "Wednesday";
		} else if (this.dayOfWeek == 5) {
			return "Thursday";
		} else if (this.dayOfWeek == 6) {
			return "Friday";
		} else if (this.dayOfWeek == 7) {
			return "Saturday";
		} else {
			return "Sunday";
		}
	}

	public String dayOfWeekEnd() {

		if (this.endDayOfWeek == 2) {
			return "Monday";
		} else if (this.endDayOfWeek == 3) {
			return "Tuesday";
		} else if (this.endDayOfWeek == 4) {
			return "Wednesday";
		} else if (this.endDayOfWeek == 5) {
			return "Thursday";
		} else if (this.dayOfWeek == 6) {
			return "Friday";
		} else if (this.endDayOfWeek == 7) {
			return "Saturday";
		} else {
			return "Sunday";
		}
	}

	public int getStartDay() {
		return starDay;
	}

	public int getStartMonth() {
		return startMonth;
	}

	public int getStartYear() {
		return startYear;
	}

	public int getEndDay() {
		return endDay;
	}

	public int getEndMonth() {
		return endMonth;
	}

	public int getEndYear() {
		return endYear;
	}

	public boolean equals(Object other) {
		if (!(other instanceof Date)) {
			return false;
		}

		Date date = (Date) other;

		return this.starDay == date.starDay
				&& this.startMonth == date.startMonth
				&& this.startYear == date.startYear;

	}

	public static void main(String[] args) {
		Date date = new Date(4, 5, 2015, 4, 7, 2015);
		System.out.println(date.toString());
	}

}
