package tech.ineb.lib.common.models;

import tech.ineb.lib.common.models.ex.IntervalUnitNotFoundEx;

public enum TimeFrame {
  SECOND(0, 's'),

  SECONDS10(1, 'S'),

  MINUTE(2, 'M'),

  HOUR(3, 'H'),

  DAY(4, 'D'),

  WEEK(5, 'W'),

  MONTH(6, 'M'),

  YEAR(7, 'Y');

  private final Integer code;
  private final Character intervalCode;

  TimeFrame(Integer code, Character intervalCode) {
    this.code = code;
    this.intervalCode = intervalCode;
  }

  public Integer getCode() {
    return code;
  }

  public Character getIntervalCode() {
    return intervalCode;
  }

  public static TimeFrame findByCode(Character intervalCode) throws IntervalUnitNotFoundEx {
    for (TimeFrame timeFrame : TimeFrame.values()) {
      if (timeFrame.getIntervalCode().equals(intervalCode)) return timeFrame;
    }
    throw new IntervalUnitNotFoundEx("Date interval=" + intervalCode + " not found");
  }
}
