package org.fest.assertions;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Tomasz Nurkiewicz
 * @since 16.01.11, 00:00
 */
public class DateAssert extends GenericAssert<DateAssert, Date> {
  
  public DateAssert(Date actual) {
    super(DateAssert.class, actual);
  }

  public DateAssert isBefore(Date date) {
    return this;
  }

  public DateAssert isBefore(int year) {
    return this;
  }

  public DateAssert isBefore(int year, int month) {
    return this;
  }

  public DateAssert isBefore(int year, int month, int day) {
    return this;
  }

  public DateAssert isBefore(int year, int month, int day, int hour) {
    return this;
  }

  public DateAssert isBefore(int year, int month, int day, int hour, int minute) {
    return this;
  }

  public DateAssert isBefore(int year, int month, int day, int hour, int minute, int second) {
    return this;
  }

  public DateAssert isAfter(Date date) {
    return this;
  }

  public DateAssert isAfter(int year) {
    return this;
  }

  public DateAssert isAfter(int year, int month) {
    return this;
  }

  public DateAssert isAfter(int year, int month, int day) {
    return this;
  }

  public DateAssert isAfter(int year, int month, int day, int hour) {
    return this;
  }

  public DateAssert isAfter(int year, int month, int day, int hour, int minute) {
    return this;
  }

  public DateAssert isAfter(int year, int month, int day, int hour, int minute, int second) {
    return this;
  }

  public DateAssert notBefore(Date date) {
    return this;
  }

  public DateAssert notBefore(int year) {
    return this;
  }

  public DateAssert notBefore(int year, int month) {
    return this;
  }

  public DateAssert notBefore(int year, int month, int day) {
    return this;
  }

  public DateAssert notBefore(int year, int month, int day, int hour) {
    return this;
  }

  public DateAssert notBefore(int year, int month, int day, int hour, int minute) {
    return this;
  }

  public DateAssert notBefore(int year, int month, int day, int hour, int minute, int second) {
    return this;
  }

  public DateAssert notAfter(Date date) {
    return this;
  }

  public DateAssert notAfter(int year) {
    return this;
  }

  public DateAssert notAfter(int year, int month) {
    return this;
  }

  public DateAssert notAfter(int year, int month, int day) {
    return this;
  }

  public DateAssert notAfter(int year, int month, int day, int hour) {
    return this;
  }

  public DateAssert notAfter(int year, int month, int day, int hour, int minute) {
    return this;
  }

  public DateAssert notAfter(int year, int month, int day, int hour, int minute, int second) {
    return this;
  }

  public DateAssert isBetween(Date fromInclusive, Date toInclusive) {
    return this;
  }

  public DateAssert inYear(int year) {
    return this;
  }

  public DateAssert inMonth(int year, int month) {
    return this;
  }

  public DateAssert inMonth(int month) {
    return this;
  }

  public DateAssert inDay(int year, int month, int day) {
    return this;
  }

  public DateAssert inDay(int day) {
    return this;
  }

  public DateAssert inHour(int year, int month, int day, int hour, int minute) {
    return this;
  }

  public DateAssert inHour(int hour) {
    return this;
  }

  public DateAssert inMinute(int year, int month, int day, int hour, int minute) {
    return this;
  }

  public DateAssert inMinute(int minute) {
    return this;
  }

  public DateAssert inSecond(int year, int month, int day, int hour, int minute, int second) {
    return this;
  }

  public DateAssert inSecond(int minute) {
    return this;
  }

  public DateAssert isCloseTo(Date date) {
    return this;
  }

  public DateAssert isCloseTo(Date date, TimeUnit timeUnit) {
    return this;
  }


}
