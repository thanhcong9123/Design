package Memento;

public class CommittedState implements State {

    @Override
    public void commit() {
        // Do nothing
    }

    @Override
    public void stage() {
        // Do nothing
    }

    @Override
    public void untrack() {
        // Do nothing
    }

    @Override
    public void modify() {
        System.out.println("Cannot modify a committed file.");
    }
}