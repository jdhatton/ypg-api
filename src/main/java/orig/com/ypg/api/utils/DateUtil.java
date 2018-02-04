package orig.com.ypg.api.utils;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
  public static final long ONE_MINUTE = 60000;
  public static final long ONE_HOUR = 3600000;
  public static final long TWO_DAYS = 172800000;

  public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
  public static final long DAY = 24 * 3600 * 1000;

  public static synchronized String serialize(Date date) {
    if (date == null) return "";
    DateTimeFormatter fmt = ISODateTimeFormat.dateTime();
    return fmt.print(new DateTime(date));

  }

  public static synchronized String format(Date date) {
    if (date == null) return "";
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    return df.format(date);
  }
  
  public static synchronized Date parse(String date) {
    try {
      DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
      return df.parse(date);
    } catch (ParseException e) {
      return null;
    }
  }

  public static synchronized String fullDate(Date date) {
    if (date != null) {
      DateFormat df = new SimpleDateFormat("EEE, MMM d, yyyy");
      return df.format(date);
    } else {
      return "";
    }
  }

  public static synchronized boolean fuzzyMatch(Date d, String term) {
    // If date matches exactly, ie 1/8/1976
    try {
      Date date = DateFormat.getDateInstance(DateFormat.SHORT).parse(term);
      if (d.equals(date)) {
        return true;
      }
    } catch (ParseException e) {
      // A parse exception just means the term isn't a date
    }

    Calendar dateOfContent = Calendar.getInstance();
    dateOfContent.setTime(d);

    // If day matches exactly
    String dayOfMonth = dateOfContent.get(Calendar.DAY_OF_MONTH) + "";
    String dayOfMonthWithSuffix = dayOfMonth + getOrdinalFor(dateOfContent.get(Calendar.DAY_OF_MONTH));
    if (term.equalsIgnoreCase(dayOfMonth) || term.equalsIgnoreCase(dayOfMonthWithSuffix)) {
      return true;
    }

    // If month matches
    String monthNum = (dateOfContent.get(Calendar.MONTH) + 1) + "";
    Format monthFormatter = new SimpleDateFormat("MMMM");
    String month = monthFormatter.format(d); // substring on
                                             // month name
    if (term.equalsIgnoreCase(monthNum) || StringUtils.containsIgnoreCase(month, term)) {
      return true;
    }

    // If year matches exactly
    String year = dateOfContent.get(Calendar.YEAR) + "";
    if (term.equals(year)) {
      return true;
    }

    return false;
  }

  public static synchronized String getOrdinalFor(int value) {
    int hundredRemainder = value % 100;
    int tenRemainder = value % 10;
    if (hundredRemainder - tenRemainder == 10) {
      return "th";
    }

    switch (tenRemainder) {
      case 1:
        return "st";
      case 2:
        return "nd";
      case 3:
        return "rd";
      default:
        return "th";
    }
  }

  public static synchronized String now() {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
    return sdf.format(cal.getTime());

  }

  /**
   * Method to compare two date and provide the resulting interval in days
   * between the two dates.
   * 
   * @param d1
   *          beginning date
   * @param d2
   *          ending date.
   * @return The number of days between the two dates.
   */
  public static synchronized int daysBetweenDates(Date d1, Date d2) {

    DateTime startDate = new DateTime(d1);
    DateTime endDate = new DateTime(d2);

    LocalDate firstDate = startDate.toLocalDate();
    LocalDate secondDate = endDate.toLocalDate();

    Days d = Days.daysBetween(firstDate, secondDate);
    int days = d.getDays();
    return days;
  }


  public static ArrayList<SimpleDateFormat> getDateFormats() {
    Calendar hundredYearsAgo = Calendar.getInstance();
    hundredYearsAgo.set(hundredYearsAgo.get(Calendar.YEAR) - 100, hundredYearsAgo.get(Calendar.MONTH),
        hundredYearsAgo.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
    Date startDate = hundredYearsAgo.getTime();
    ArrayList<SimpleDateFormat> formats = new ArrayList<SimpleDateFormat>();
    String[] toAdd = {"MM-dd-yy", "MM-dd-yyyy", "MM/dd/yy", "MM/dd/yyyy", "yyyy-MM-dd", "yyyy/MM/dd", "d MMM yy", "d MMM yyyy", "MMM d yy",
        "MMM d yyyy", "MMM. d yyyy", "MMM. d, yyyy", "MMM d, yyyy"};
    for (String s : toAdd) {
      SimpleDateFormat format = new SimpleDateFormat(s);
      format.set2DigitYearStart(startDate);
      formats.add(format);
    }
    return formats;
  }

  public static int getAge(Date date) {
    return getAge(date, Calendar.getInstance().getTime());
  }

  public static int getAge(Date birthDate, Date endDate) {
    Calendar now = Calendar.getInstance();
    Calendar before = Calendar.getInstance();
    now.setTime(endDate);
    before.setTime(birthDate);
    // This will be correct if the user has celebrated their birthday this year
    int years = now.get(Calendar.YEAR) - before.get(Calendar.YEAR);
    // The user has not gotten to their birth month yet, so their age is -1 from
    // above.
    if (now.get(Calendar.MONTH) < before.get(Calendar.MONTH)) {
      years--;
      // The user's birthday is this month, have they hit their birthday yet?
    } else if (now.get(Calendar.MONTH) == before.get(Calendar.MONTH)) {
      if (now.get(Calendar.DAY_OF_MONTH) < before.get(Calendar.DAY_OF_MONTH)) {
        years--;
      }
    }
    return years;
  }

  public static String formatDateForDisplay(Date postDate) {
    Calendar calendar = Calendar.getInstance();
    int today = calendar.get(Calendar.DAY_OF_YEAR);
    int thisYear = calendar.get(Calendar.YEAR);

    calendar.setTime(postDate);
    int postDay = calendar.get(Calendar.DAY_OF_YEAR);
    int postYear = calendar.get(Calendar.YEAR);

    long delta = System.currentTimeMillis() - postDate.getTime();

    if (delta < ONE_MINUTE) return "Less than a minute ago";
    else if (delta < ONE_HOUR) {
      long minutes = delta / ONE_MINUTE;
      if (minutes == 1) return "One minute ago";
      return minutes + " minutes ago";
    } else if (thisYear == postYear) {
      if (today == postDay) {
        long hours = delta / ONE_HOUR;
        if (hours == 1) return "One hour ago";
        return hours + " hours ago";
      } else if (today == postDay + 1) {
        return "Yesterday at " + new DateTime(postDate).toString(DateTimeFormat.forPattern("ha"));
      } else
        return new DateTime(postDate).toString(DateTimeFormat.forPattern("MMMM d 'at' ha"));
    } else
      return new DateTime(postDate).toString(DateTimeFormat.forPattern("MMMM d, y 'at' ha"));
  }
}
