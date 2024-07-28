package Bridge;
// Abstraction
interface VersionControlSystem {
    void commit(String message);
    void checkout(String branch);
    void merge(String branch);
}

// Concrete implementation 1
class Git implements VersionControlSystem {
    @Override
    public void commit(String message) {
        System.out.println("Git: Commit - " + message);
    }

    @Override
    public void checkout(String branch) {
        System.out.println("Git: Checkout branch - " + branch);
    }

    @Override
    public void merge(String branch) {
        System.out.println("Git: Merge branch - " + branch);
    }
}

// Concrete implementation 2
class Mercurial implements VersionControlSystem {
    @Override
    public void commit(String message) {
        System.out.println("Mercurial: Commit - " + message);
    }

    @Override
    public void checkout(String branch) {
        System.out.println("Mercurial: Checkout branch - " + branch);
    }

    @Override
    public void merge(String branch) {
        System.out.println("Mercurial: Merge branch - " + branch);
    }
}

// Abstraction implementation using Bridge pattern
abstract class Project {
    protected VersionControlSystem vcs;

    public Project(VersionControlSystem vcs) {
        this.vcs = vcs;
    }

    abstract void develop();
}

// Refined abstraction 1
class JavaProject extends Project {
    public JavaProject(VersionControlSystem vcs) {
        super(vcs);
    }

    @Override
    void develop() {
        System.out.println("Java project development");
        vcs.commit("Java code changes");
    }
}

// Refined abstraction 2
class PythonProject extends Project {
    public PythonProject(VersionControlSystem vcs) {
        super(vcs);
    }

    @Override
    void develop() {
        System.out.println("Python project development");
        vcs.commit("Python code changes");
    }
}

public class LabBridge {
    public static void main(String[] args) {
        // Using Git
        VersionControlSystem git = new Git();
        Project javaProject = new JavaProject(git);
        Project pythonProject = new PythonProject(git);

        javaProject.develop();
        pythonProject.develop();

        // Using Mercurial
        VersionControlSystem mercurial = new Mercurial();
        Project javaProjectMercurial = new JavaProject(mercurial);
        Project pythonProjectMercurial = new PythonProject(mercurial);

        javaProjectMercurial.develop();
        pythonProjectMercurial.develop();
    }
}
