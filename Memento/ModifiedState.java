package Memento;

public class ModifiedState implements State {
    @Override
    public void commit() {
    }

    @Override
    public void stage() {
        System.out.println("File staged for commit.");
    }

    @Override
    public void untrack() {
        System.out.println("File untracked.");
    }

    @Override
    public void modify() {
        System.out.println("File modified.");
    }

}
