package Decorator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Define the base Repository interface
interface Repository {
    void add(String item);
    List<String> getAll();
}

// Implement the base Repository class
class BaseRepository implements Repository {
    private List<String> data = new ArrayList<>();

    @Override
    public void add(String item) {
        data.add(item);
    }

    @Override
    public List<String> getAll() {
        return new ArrayList<>(data);
    }
}

// Define the abstract RepositoryDecorator class
abstract class RepositoryDecorator implements Repository {
    protected Repository repository;

    public RepositoryDecorator(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void add(String item) {
        repository.add(item);
    }

    @Override
    public List<String> getAll() {
        return repository.getAll();
    }
}

// Implement TagDecorator
class TagDecorator extends RepositoryDecorator {
    private Map<String, List<String>> tags = new HashMap<>();

    public TagDecorator(Repository repository) {
        super(repository);
    }

    @Override
    public void add(String item) {
        super.add(item);
    }

    @Override
    public List<String> getAll() {
        return super.getAll();
    }

    public void addTag(String item, String tag) {
        tags.computeIfAbsent(item, k -> new ArrayList<>()).add(tag);
    }

    public List<String> getTags(String item) {
        return tags.getOrDefault(item, new ArrayList<>());
    }
}

// Implement AccessPermissionDecorator
class AccessPermissionDecorator extends RepositoryDecorator {
    private Map<String, List<String>> accessPermissions = new HashMap<>();

    public AccessPermissionDecorator(Repository repository) {
        super(repository);
    }

    @Override
    public void add(String item) {
        super.add(item);
    }

    @Override
    public List<String> getAll() {
        return super.getAll();
    }

    public void grantAccess(String user, String item) {
        accessPermissions.computeIfAbsent(item, k -> new ArrayList<>()).add(user);
    }

    public boolean hasAccess(String user, String item) {
        return accessPermissions.getOrDefault(item, new ArrayList<>()).contains(user);
    }
}

// Test the implementation
public class LadDecorator {
    public static void main(String[] args) {
        // Create a base repository
        Repository baseRepo = new BaseRepository();

        // Decorate the repository with TagDecorator
        TagDecorator taggedRepo = new TagDecorator(baseRepo);
        taggedRepo.add("Item 1");
        taggedRepo.addTag("Item 1", "tag1");
        taggedRepo.addTag("Item 1", "tag2");
        taggedRepo.add("Item 2");
        taggedRepo.addTag("Item 2", "tag3");
        System.out.println("Items with tags: " + taggedRepo.getAll());
        System.out.println("Tags for Item 1: " + taggedRepo.getTags("Item 1"));

        // Decorate the repository with AccessPermissionDecorator
        AccessPermissionDecorator permissionRepo = new AccessPermissionDecorator(baseRepo);
        permissionRepo.add("Item 1");
        permissionRepo.grantAccess("user1", "Item 1");
        permissionRepo.add("Item 3");
        permissionRepo.grantAccess("user3", "Item 3");
        System.out.println("Has access for user1 to Item 1: " + permissionRepo.hasAccess("user1", "Item 1"));
        System.out.println("Has access for user1 to Item 2: " + permissionRepo.hasAccess("user1", "Item 2"));
    }
}

