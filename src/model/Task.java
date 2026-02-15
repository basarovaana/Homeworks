package model;

public class Task {

    String text;
    String deadline;
    boolean done;

    public Task(String text, String deadline) {
        this.text = text;
        this.deadline = deadline;
        this.done = false;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isDone() {
        return done;
    }

    public String getText() {
        return text;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setText(String text) {
        this.text = text;
    }
}