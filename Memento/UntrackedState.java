package Memento;

public class UntrackedState implements State {

    @Override
    public void commit() {
    }
    @Override
    public void stage() {
        System.out.println("File staged for commit.");
    }

    @Override
    public void untrack() {
    }

    @Override
    public void modify() {
        System.out.println("File modified.");
    }
}
