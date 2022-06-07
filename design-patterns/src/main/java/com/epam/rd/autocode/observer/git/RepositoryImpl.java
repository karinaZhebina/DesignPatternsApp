package com.epam.rd.autocode.observer.git;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RepositoryImpl implements Repository {

  private List<WebHook> commitWebHooks = new ArrayList<>();
  private List<WebHook> mergeWebHooks = new ArrayList<>();

  private List<Event> events = new ArrayList<>();

  @Override
  public void addWebHook(WebHook webHook) {
    if (webHook.type().equals(Event.Type.COMMIT)) {
      commitWebHooks.add(webHook);
    } else if (webHook.type().equals(Event.Type.MERGE)) {
      mergeWebHooks.add(webHook);
    } else throw new IllegalArgumentException();
  }

  @Override
  public Commit commit(String branch, String author, String[] changes) {
    Commit newCommit = new Commit(author, changes);
    if (commitWebHooks != null && !commitWebHooks.isEmpty()) {
      List<Commit> commits = new LinkedList<>();
      commits.add(newCommit);
      Event commitEvent = new Event(Event.Type.COMMIT, branch, commits);
      events.add(commitEvent);

      for (WebHook webHook : commitWebHooks) {
        if (webHook.branch().equals(branch)) {
          webHook.onEvent(commitEvent);
        }
      }
    }
    return newCommit;
  }

  @Override
  public void merge(String sourceBranch, String targetBranch) {
    if (mergeWebHooks != null && !mergeWebHooks.isEmpty()) {
      List<Commit> commits = new LinkedList<>();
      for (Event event : events) {
        if (event.branch().equals(sourceBranch)) {
          commits.addAll(event.commits());
        }
      }
      Event mergeEvent = new Event(Event.Type.MERGE, targetBranch, commits);
      for (WebHook webHook : mergeWebHooks) {
        if (webHook.branch().equals(targetBranch) && !webHook.caughtEvents().contains(mergeEvent)) {
          webHook.onEvent(mergeEvent);
        }
      }
    }
  }

}
