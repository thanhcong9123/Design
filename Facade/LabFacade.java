package Facade;
class ReportGenerator {
    public void generateReport() {
        System.out.println("Report has been generated.");
    }
    
}
class PullRequestManager
{
    public void createPullRequest(String sourceBranch, String targetBranch) {
        System.out.println("Pull request from '" + sourceBranch + "' to '" + targetBranch + "' has been created.");
    }

    public void mergePullRequest() {
        System.out.println("Pull request has been merged.");
    }

    public void reviewPullRequest() {
        System.out.println("Pull request is under review.");
    }
}
class BranchManager
{
    public void createBranch(String repoName, String branchName) {
        System.out.println("Branch '" + branchName + "' in repository '" + repoName + "' has been created.");
    }

    public void deleteBranch(String repoName, String branchName) {
        System.out.println("Branch '" + branchName + "' in repository '" + repoName + "' has been deleted.");
    }

    public void mergeBranch(String sourceBranch, String targetBranch) {
        System.out.println("Branch '" + sourceBranch + "' has been merged into '" + targetBranch + "'.");
    }
}
class RepositoryManager
{
    public void createRepository(String repoName) {
        System.out.println("Repository '" + repoName + "' has been created.");
    }

    public void deleteRepository(String repoName) {
        System.out.println("Repository '" + repoName + "' has been deleted.");
    }

    public void updateRepository(String repoName) {
        System.out.println("Repository '" + repoName + "' has been updated.");
    }
}
class GitFacade
{
    private ReportGenerator reportGenerator;
    private BranchManager branchManager;
    private RepositoryManager repositoryManager;
    private PullRequestManager pullRequestManager;
    public GitFacade()
    {
        reportGenerator = new ReportGenerator();
        branchManager =  new BranchManager();
        repositoryManager = new RepositoryManager();
        pullRequestManager = new PullRequestManager();
    }
    // Simplified method to create a repository with an initial branch
    public void createRepositoryWithBranch(String repoName, String branchName) {
        repositoryManager.createRepository(repoName);
        branchManager.createBranch(repoName, branchName);
    }

    // Simplified method to handle a pull request
    public void createAndMergePullRequest(String sourceBranch, String targetBranch) {
        pullRequestManager.createPullRequest(sourceBranch, targetBranch);
        pullRequestManager.mergePullRequest();
    }

    // Simplified method to generate a report
    public void generateReport() {
        reportGenerator.generateReport();
    }
}
public  class LabFacade {
    public static void main(String[] args) {
        GitFacade gitFacade = new GitFacade();

        // Test creating a repository with an initial branch
        gitFacade.createRepositoryWithBranch("ExampleRepo", "main");

        // Test handling a pull request
        gitFacade.createAndMergePullRequest("dev", "main");

        // Test generating a report
        gitFacade.generateReport();
    }
}
