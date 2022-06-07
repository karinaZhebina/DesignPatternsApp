package com.epam.rd.autocode.observer.git;

import java.util.LinkedList;
import java.util.List;

public class WebHookImpl implements WebHook {

  private String branch;
  private Event.Type type;
  private List<Event> events = new LinkedList<>();

  public List<Event> getEvents() {
    return events;
  }

  public WebHookImpl(String branch, Event.Type type) {
    this.branch = branch;
    this.type = type;
  }

  private String getBranch() {
    return branch;
  }

  private Event.Type getType() {
    return type;
  }

  @Override
  public String branch() {
    return getBranch();
  }

  @Override
  public Event.Type type() {
    return getType();
  }

  @Override
  public List<Event> caughtEvents() {
    return this.getEvents();
  }

  @Override
  public void onEvent(Event event) {
    getEvents().add(event);
  }
}
