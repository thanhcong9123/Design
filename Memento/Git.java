package Memento;

public class Git {
    private State state;

    public Git() {
        this.state = new UntrackedState();
    }

    public void commit() {
        state.commit();
    }

    public void stage() {
        state.stage();
    }

    public void untrack() {
        state.untrack();
    }

    public void modify() {
        state.modify();
    }
}

