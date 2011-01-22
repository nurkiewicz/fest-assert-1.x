package org.fest.assertions;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

/**
 * @author Tomasz Nurkiewicz
 * @since 16.01.11, 00:00
 */
public class CalendarAssert extends GenericAssert<CalendarAssert, Calendar> {

  public CalendarAssert(Calendar actual) {
    super(CalendarAssert.class, actual);
  }

  public CalendarAssert(Date actual) {
    this(toCalendar(actual));
  }

  private static Calendar toCalendar(Date actual) {
    if (actual == null)
      return null;
    final GregorianCalendar calendar = new GregorianCalendar();
    calendar.setTimeInMillis(actual.getTime());
    return calendar;
  }

  public CalendarAssert isBefore(Calendar date) {
    return this;
  }

  public CalendarAssert isBefore(Date date) {
    return this;
  }

  public CalendarAssert isBefore(int year) {
    return this;
  }

  public CalendarAssert isBefore(int year, int month) {
    return this;
  }

  public CalendarAssert isBefore(int year, int month, int day) {
    return this;
  }

  public CalendarAssert isBefore(int year, int month, int day, int hour) {
    return this;
  }

  public CalendarAssert isBefore(int year, int month, int day, int hour, int minute) {
    return this;
  }

  public CalendarAssert isBefore(int year, int month, int day, int hour, int minute, int second) {
    return this;
  }

  public CalendarAssert isNotBefore(Calendar date) {
    return this;
  }

  public CalendarAssert isNotBefore(Date date) {
    return this;
  }

  public CalendarAssert isNotBefore(int year) {
    return this;
  }

  public CalendarAssert isNotBefore(int year, int month) {
    return this;
  }

  public CalendarAssert isNotBefore(int year, int month, int day) {
    return this;
  }

  public CalendarAssert isNotBefore(int year, int month, int day, int hour) {
    return this;
  }

  public CalendarAssert isNotBefore(int year, int month, int day, int hour, int minute) {
    return this;
  }

  public CalendarAssert isNotBefore(int year, int month, int day, int hour, int minute, int second) {
    return this;
  }

  public CalendarAssert isAfter(Calendar date) {
    return this;
  }

  public CalendarAssert isAfter(Date date) {
    return this;
  }

  public CalendarAssert isAfter(int year) {
    return this;
  }

  public CalendarAssert isAfter(int year, int month) {
    return this;
  }

  public CalendarAssert isAfter(int year, int month, int day) {
    return this;
  }

  public CalendarAssert isAfter(int year, int month, int day, int hour) {
    return this;
  }

  public CalendarAssert isAfter(int year, int month, int day, int hour, int minute) {
    return this;
  }

  public CalendarAssert isAfter(int year, int month, int day, int hour, int minute, int second) {
    return this;
  }

  public CalendarAssert isNotAfter(Calendar date) {
    return this;
  }

  public CalendarAssert isNotAfter(Date date) {
    return this;
  }

  public CalendarAssert isNotAfter(int year) {
    return this;
  }

  public CalendarAssert isNotAfter(int year, int month) {
    return this;
  }

  public CalendarAssert isNotAfter(int year, int month, int day) {
    return this;
  }

  public CalendarAssert isNotAfter(int year, int month, int day, int hour) {
    return this;
  }

  public CalendarAssert isNotAfter(int year, int month, int day, int hour, int minute) {
    return this;
  }

  public CalendarAssert isNotAfter(int year, int month, int day, int hour, int minute, int second) {
    return this;
  }

  public CalendarAssert isInTheFuture() {
    return this;
  }

  public CalendarAssert isNotInTheFuture() {
    return this;
  }

  public CalendarAssert isInThePast() {
    return this;
  }

  public CalendarAssert isNotInThePast() {
    return this;
  }

  public CalendarAssert isBetween(Calendar fromInclusive, Calendar toInclusive) {
    return this;
  }

  public CalendarAssert isNotBetween(Calendar fromInclusive, Calendar toInclusive) {
    return this;
  }

  public CalendarAssert isBetween(Date fromInclusive, Date toInclusive) {
    return this;
  }

  public CalendarAssert isNotBetween(Date fromInclusive, Date toInclusive) {
    return this;
  }

  public CalendarAssert inSameYear(Calendar date) {
    return this;
  }

  public CalendarAssert notInSameYear(Calendar date) {
    return this;
  }

  public CalendarAssert inSameYear(Date date) {
    return this;
  }

  public CalendarAssert notInSameYear(Date date) {
    return this;
  }

  public CalendarAssert inSameYear(int year) {
    return this;
  }

  public CalendarAssert notInSameYear(int year) {
    return this;
  }

  public CalendarAssert inSameMonth(int year, int month) {
    return this;
  }

  public CalendarAssert notInSameMonth(int year, int month) {
    return this;
  }

  public CalendarAssert inSameMonth(Calendar date) {
    return this;
  }

  public CalendarAssert notInSameMonth(Calendar date) {
    return this;
  }

  public CalendarAssert inSameMonth(Date date) {
    return this;
  }

  public CalendarAssert notInSameMonth(Date date) {
    return this;
  }

  public CalendarAssert inSameMonth(int month) {
    return this;
  }

  public CalendarAssert notInSameMonth(int month) {
    return this;
  }

  public CalendarAssert inSameDay(int year, int month, int day) {
    return this;
  }

  public CalendarAssert notInSameDay(int year, int month, int day) {
    return this;
  }

  public CalendarAssert inSameDay(Calendar date) {
    return this;
  }

  public CalendarAssert notInSameDay(Calendar date) {
    return this;
  }

  public CalendarAssert inSameDay(Date date) {
    return this;
  }

  public CalendarAssert notInSameDay(Date date) {
    return this;
  }

  public CalendarAssert inSameDay(int day) {
    return this;
  }

  public CalendarAssert notInSameDay(int day) {
    return this;
  }

  public CalendarAssert inSameDayOfWeek(int dayOfWeek) {
    return this;
  }

  public CalendarAssert notInSameDayOfWeek(int dayOfWeek) {
    return this;
  }

  public CalendarAssert inSameDayOfWeek(Calendar date) {
    return this;
  }

  public CalendarAssert notInSameDayOfWeek(Calendar date) {
    return this;
  }

  public CalendarAssert inSameDayOfWeek(Date date) {
    return this;
  }

  public CalendarAssert notInSameDayOfWeek(Date date) {
    return this;
  }

  public CalendarAssert inSameHour(int year, int month, int day, int hour, int minute) {
    return this;
  }

  public CalendarAssert notInSameHour(int year, int month, int day, int hour, int minute) {
    return this;
  }

  public CalendarAssert inSameHour(Calendar date) {
    return this;
  }

  public CalendarAssert notInSameHour(Calendar date) {
    return this;
  }

  public CalendarAssert inSameHour(Date date) {
    return this;
  }

  public CalendarAssert notInSameHour(Date date) {
    return this;
  }

  public CalendarAssert inSameHour(int hour) {
    return this;
  }

  public CalendarAssert notInSameHour(int hour) {
    return this;
  }

  public CalendarAssert inSameMinute(int year, int month, int day, int hour, int minute) {
    return this;
  }

  public CalendarAssert notInSameMinute(int year, int month, int day, int hour, int minute) {
    return this;
  }

  public CalendarAssert inSameMinute(Calendar date) {
    return this;
  }

  public CalendarAssert notInSameMinute(Calendar date) {
    return this;
  }

  public CalendarAssert inSameMinute(Date date) {
    return this;
  }

  public CalendarAssert notInSameMinute(Date date) {
    return this;
  }

  public CalendarAssert inSameMinute(int minute) {
    return this;
  }

  public CalendarAssert notInSameMinute(int minute) {
    return this;
  }

  public CalendarAssert inSameSecond(int year, int month, int day, int hour, int minute, int second) {
    return this;
  }

  public CalendarAssert notInSameSecond(int year, int month, int day, int hour, int minute, int second) {
    return this;
  }

  public CalendarAssert inSameSecond(Calendar date) {
    return this;
  }

  public CalendarAssert notInSameSecond(Calendar date) {
    return this;
  }

  public CalendarAssert inSameSecond(Date date) {
    return this;
  }

  public CalendarAssert notInSameSecond(Date date) {
    return this;
  }

  public CalendarAssert inSameSecond(int second) {
    return this;
  }

  public CalendarAssert notInSameSecond(int second) {
    return this;
  }

  public CalendarAssert isCloseTo(Calendar date) {
    return this;
  }

  public CalendarAssert isNotCloseTo(Calendar date) {
    return this;
  }

  public CalendarAssert isCloseTo(Date date) {
    return this;
  }

  public CalendarAssert isNotCloseTo(Date date) {
    return this;
  }

  public CalendarAssert isCloseTo(Calendar date, TimeUnit timeUnit) {
    return this;
  }

  public CalendarAssert isNotCloseTo(Calendar date, TimeUnit timeUnit) {
    return this;
  }

  public CalendarAssert isCloseTo(Date date, TimeUnit timeUnit) {
    return this;
  }

  public CalendarAssert isNotCloseTo(Date date, TimeUnit timeUnit) {
    return this;
  }

  public CalendarAssert isCloseTo(Calendar date, TimeUnit timeUnit, long tolerance) {
    return this;
  }

  public CalendarAssert isNotCloseTo(Calendar date, TimeUnit timeUnit, long tolerance) {
    return this;
  }

  public CalendarAssert isCloseTo(Date date, TimeUnit timeUnit, long tolerance) {
    return this;
  }

  public CalendarAssert isNotCloseTo(Date date, TimeUnit timeUnit, long tolerance) {
    return this;
  }

  public static Calendar now() {
    return new GregorianCalendar();
  }

  public static Calendar date(int year) {
    return new GregorianCalendar(year, Calendar.JANUARY, 1, 0, 0, 0);
  }

  public static Calendar date(int year, int month) {
    return new GregorianCalendar(year, month, 1, 0, 0, 0);
  }

  public static Calendar date(int year, int month, int day) {
    return new GregorianCalendar(year, month, day, 0, 0, 0);
  }

  public static Calendar date(int year, int month, int day, int hour) {
    return new GregorianCalendar(year, month, day, hour, 0, 0);
  }

  public static Calendar date(int year, int month, int day, int hour, int minute) {
    return new GregorianCalendar(year, month, day, hour, minute, 0);
  }

  public static Calendar date(int year, int month, int day, int hour, int minute, int second) {
    return new GregorianCalendar(year, month, day, hour, minute, second);
  }

}
