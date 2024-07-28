import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class Repository {
    protected List<Observer> observers = new ArrayList<>();
    private String repositoryName;

    public Repository(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void newCommit(String commitMessage) {
        notifyObservers("New commit in " + repositoryName + ": " + commitMessage);
    }

    public void newIssue(String issueTitle) {
        notifyObservers("New issue opened in " + repositoryName + ": " + issueTitle);
    }
}

class User implements Observer {
    private String username;

    public User(String username) {
        this.username = username;
    }

    @Override
    public void update(String message) {
        System.out.println(username + " received notification: " + message);
    }
}

public class ObserverPatternLab {
    public static void main(String[] args) {
        Repository myRepo = new Repository("MyRepo");

        User user1 = new User("User1");
        User user2 = new User("User2");

        myRepo.addObserver(user1);
        myRepo.addObserver(user2);

        myRepo.newCommit("Added feature X");
        myRepo.newIssue("Bug found in feature Y");

        myRepo.removeObserver(user1);

        myRepo.newCommit("Fixed bug in feature Y");
        myRepo.newIssue("Enhancement request for feature Z");
    }
}
