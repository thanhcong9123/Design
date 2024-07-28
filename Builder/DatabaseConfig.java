package Builder;

public class DatabaseConfig {
    private final String host;
    private final int port;
    private final String username;
    private final String password;

    private DatabaseConfig(Builder builder) {
        this.host = builder.host;
        this.port = builder.port;
        this.username = builder.username;
        this.password = builder.password;
    }

    public static class Builder {
        private final String host;
        private int port = 5432; // Default value
        private String username;
        private String password;

        public Builder(String host) {
            if (host == null || host.isEmpty()) {
                throw new IllegalArgumentException("Host is required");
            }
            this.host = host;
        }

        public Builder port(int port) {
            this.port = port;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public DatabaseConfig build() {
            return new DatabaseConfig(this);
        }
    }

    @Override
    public String toString() {
        return "DatabaseConfig{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
