// Abstract class representing the Template Method pattern

import java.util.List;

abstract class GitWorkflow {
    List<MyData> myData;
    // Template method defining the workflow
    public void execute() {
        initializeRepository();
        addFiles();
        commitChanges();
        pushChanges();
    }

    // Abstract methods to be implemented by subclasses
    protected abstract void initializeRepository();
    protected abstract void addFiles();
    protected abstract void commitChanges();
    protected abstract void pushChanges();
}
/**
 * MyData
 */ 

// Concrete subclass representing a specific Git workflow
class MyGitWorkflow extends GitWorkflow {
    @Override
    protected void initializeRepository() {
        System.out.println("Khởi tạo kho Git");
    }

    @Override
    protected void addFiles() {
        System.out.println("Thêm các tệp vào vùng chờ");
    }

    @Override
    protected void commitChanges() {
        System.out.println("Commit các thay đổi");
    }

    @Override
    protected void pushChanges() {
        System.out.println("Đẩy các thay đổi lên kho lưu trữ từ xa");
    }
}
class YourGitWorkflow extends GitWorkflow {
    @Override
    protected void initializeRepository() {
        System.out.println("Đang hoạt động Git");
    }

    @Override
    protected void addFiles() {
        System.out.println("Thêm các tệp vào vùng chờ");
    }

    @Override
    protected void commitChanges() {
        System.out.println("Commit các thay đổi");
    }

    @Override
    protected void pushChanges() {
        System.out.println("Đẩy các thay đổi lên kho lưu trữ từ xa");
    }
}
// Main class to test the implementation
public class TemplateMethod {
    public static void main(String[] args) {
        // Instantiate the concrete subclass
        GitWorkflow workflow = new MyGitWorkflow();
        GitWorkflow gitWorkflow = new YourGitWorkflow();
        // Execute the workflow
        workflow.execute();
    }
}


