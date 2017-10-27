public enum Status {
    accepted("Accepted"),
    timeLimitExceeded("Time Limit Exceeded"),
    wrongAnswer("Wrong Answer"),;

    final String s;

    Status(String s) {
        this.s = s;
    }
}
