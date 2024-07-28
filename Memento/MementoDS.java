package Memento;
import java.util.ArrayList;
import java.util.List;

// Memento: Commit class
class Commit {
    private final String state;

    public Commit(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// Originator: GitProject class
class GitProject {
    private String currentState;

    public void setState(String state) {
        this.currentState = state;
    }

    public String getState() {
        return currentState;
    }

    public Commit saveStateToCommit() {
        return new Commit(currentState);
    }

    public void restoreStateFromCommit(Commit commit) {
        this.currentState = commit.getState();
    }
}

// Caretaker: GitCommitManager class
class GitCommitManager {
    private final List<Commit> commits = new ArrayList<>();

    public void addCommit(Commit commit) {
        commits.add(commit);
    }

    public Commit getCommit(int index) {
        return commits.get(index);
    }
}

// Main class for testing
public class MementoDS {
    public static void main(String[] args) {
        GitProject project = new GitProject();

        GitCommitManager commitManager = new GitCommitManager();
        
        project.setState("Initial state");
        Commit commit1 = project.saveStateToCommit();
        commitManager.addCommit(commit1);

        project.setState("Updated state");
        Commit commit2 = project.saveStateToCommit();
        commitManager.addCommit(commit2);

        Commit firstCommit = commitManager.getCommit(0);
        project.restoreStateFromCommit(firstCommit);

        System.out.println("Restored state: " + project.getState());
    }
}


