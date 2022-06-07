package com.epam.rd.autocode.observer.git;

import static com.epam.rd.autocode.observer.git.Event.Type.COMMIT;
import static com.epam.rd.autocode.observer.git.Event.Type.MERGE;

public class GitRepoObservers {
  public static Repository newRepository() {
    return new RepositoryImpl();
  }

  public static WebHook mergeToBranchWebHook(String branchName) {
    return new WebHookImpl(branchName, MERGE);
  }

  public static WebHook commitToBranchWebHook(String branchName) {
    return new WebHookImpl(branchName, COMMIT);
  }
}
