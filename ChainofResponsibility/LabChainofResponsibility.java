package ChainofResponsibility;

interface GitHandler {
    void handle(String command);
}
class AddHandler implements GitHandler {
    private GitHandler nextHandler;

    public void setNextHandler(GitHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handle(String command) {
        if (command.startsWith("git add")) {
            // Handle git add command
            System.out.println("Handling git add command");
        } else if (nextHandler != null) {
            nextHandler.handle(command);
        }
    }
}
class CommitHandler implements GitHandler {
    private GitHandler nextHandler;

    public void setNextHandler(GitHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handle(String command) {
        if (command.startsWith("git commit")) {
            // Handle git commit command
            System.out.println("Handling git commit command");
        } else if (nextHandler != null) {
            nextHandler.handle(command);
        }
    }
}
class PushHandler implements GitHandler {
    private GitHandler nextHandler;

    public void setNextHandler(GitHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handle(String command) {
        if (command.startsWith("git push")) {
            // Handle git push command
            System.out.println("Handling git push command");
        } else if (nextHandler != null) {
            nextHandler.handle(command);
        }
    }
}
public class LabChainofResponsibility {
    public static void main(String[] args) {
         // Constructing the chain
         AddHandler addHandler = new AddHandler();
         CommitHandler commitHandler = new CommitHandler();
         PushHandler pushHandler = new PushHandler();
 
         addHandler.setNextHandler(commitHandler);
         commitHandler.setNextHandler(pushHandler);
 
         // Client code to demonstrate how Git commands are processed through the chain
         addHandler.handle("git add file.txt");
         addHandler.handle("git commit -m 'Added file.txt'");
         addHandler.handle("git push origin master");
    }

}
