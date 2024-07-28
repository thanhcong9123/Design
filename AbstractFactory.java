    // Abstract factory interface
    interface GitRepositoryFactory {
        GitRepository createRepository();
    }

    // Concrete factory for GitHub repositories
    class GitHubRepositoryFactory implements GitRepositoryFactory {
        public GitRepository createRepository() {
            return new GitHubRepository();
        }
    }

    // Concrete factory for Bitbucket repositories
    class BitbucketRepositoryFactory implements GitRepositoryFactory {
        public GitRepository createRepository() {
            return new BitbucketRepository();
        }
    }

    // Abstract product interface
    interface GitRepository {
        void commit();

        void push();
    }

    // Concrete GitHub repository
    class GitHubRepository implements GitRepository {
        public void commit() {
            System.out.println("Cam kết thay đổi đối với kho lưu trữ GitHub");
        }

        public void push() {
            System.out.println("Đẩy các thay đổi vào kho lưu trữ GitHub");
        }
    }

    // Concrete Bitbucket repository
    class BitbucketRepository implements GitRepository {
        public void commit() {
            System.out.println("Cam kết thay đổi đối với kho lưu trữ Bitbucket");
        }

        public void push() {
            System.out.println("Đẩy các thay đổi vào kho lưu trữ Bitbucket");
        }
    }

 