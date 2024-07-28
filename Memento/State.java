package Memento;

public interface State {
    public void commit();
    public void stage();
    public void untrack();
    public void modify();
}
