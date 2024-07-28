
public class mainRun {

    public static void main(String[] args) {
        // Create GitHub repository using GitHubRepositoryFactory
        GitRepositoryFactory gitHubFactory = new GitHubRepositoryFactory();
        GitRepository gitHubRepo = gitHubFactory.createRepository();
        gitHubRepo.commit();
        gitHubRepo.push();

        // Create Bitbucket repository using BitbucketRepositoryFactory
        GitRepositoryFactory bitbucketFactory = new BitbucketRepositoryFactory();
        GitRepository bitbucketRepo = bitbucketFactory.createRepository();
        bitbucketRepo.commit();
        bitbucketRepo.push();
    }
}
