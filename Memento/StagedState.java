package Memento;

public class StagedState implements State {

    @Override
    public void commit() {
        System.out.println("File committed.");
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
        System.out.println("File modified.");
    }

}
