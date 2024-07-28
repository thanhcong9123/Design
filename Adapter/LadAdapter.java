package Adapter;

// GitHub Interface
interface GitHub {
    void commit(String message);

    void push();

    void pull();
}

// Mercurial Third-Party System
class Mercurial {
    void hgCommit(String message) {
        // Implementation for committing in Mercurial
    }

    void hgPush() {
        // Implementation for pushing in Mercurial
    }

    void hgPull() {
        // Implementation for pulling in Mercurial
    }
}

// Adapter Class to integrate Mercurial with GitHub
class MercurialGitHubAdapter implements GitHub {
    private Mercurial mercurial;

    public MercurialGitHubAdapter(Mercurial mercurial) {
        this.mercurial = mercurial;
    }

    @Override
    public void commit(String message) {
        mercurial.hgCommit(message);
    }

    @Override
    public void push() {
        mercurial.hgPush();
    }

    @Override
    public void pull() {
        mercurial.hgPull();
    }
}

// GitHub Simulation
class GitHubSimulation {
    private GitHub gitHub;

    public GitHubSimulation(GitHub gitHub) {
        this.gitHub = gitHub;
    }

    public void performGitHubWorkflow() {
        gitHub.commit("Commit message");
        gitHub.push();
        gitHub.pull();
    }
}

public class LadAdapter {
    public static void main(String[] args) {
        // Initialize Mercurial
        Mercurial mercurial = new Mercurial();

        // Create the adapter
        GitHub gitHub = new MercurialGitHubAdapter(mercurial);

        // Initialize GitHub simulation with the adapter
        GitHubSimulation gitHubSimulation = new GitHubSimulation(gitHub);

        // Test the implementation
        gitHubSimulation.performGitHubWorkflow();

    }
}
