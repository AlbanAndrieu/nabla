def results = manager.build.testResultAction;
if(results != null) {
    def tests = results.getTotalCount();
    def skipped = results .getSkipCount();
    if (skipped > 0) {
        if (skipped == tests) { manager.listener.logger.println("ERROR: All tests skipped - marking build as failed"); manager.buildFailure();
        } else {
    manager.listener.logger.println("WARNING: Some tests were skipped - marking build as unstable");
    manager.buildUnstable();
}
    } else {
manager.listener.logger.println("INFO: Test results evaluated - no skipped tests");
}
}