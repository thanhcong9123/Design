package Memento;

public class GitTest {
    public static void main(String[] args) {
        Git git = new Git();

        git.modify();
        git.stage();
        git.commit();

        
        git.untrack();
        git.modify();
        git.stage();
        git.commit();

    }
}
