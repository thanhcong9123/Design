package Builder;

public class ConfigurationManager {
    private final DatabaseConfig databaseConfig;
    private final CacheConfig cacheConfig;
    private final LoggerConfig loggerConfig;

    private ConfigurationManager(Builder builder) {
        this.databaseConfig = builder.databaseConfig;
        this.cacheConfig = builder.cacheConfig;
        this.loggerConfig = builder.loggerConfig;
    }

    public static class Builder {
        private DatabaseConfig databaseConfig;
        private CacheConfig cacheConfig;
        private LoggerConfig loggerConfig;

        public Builder databaseConfig(DatabaseConfig databaseConfig) {
            this.databaseConfig = databaseConfig;
            return this;
        }

        public Builder cacheConfig(CacheConfig cacheConfig) {
            this.cacheConfig = cacheConfig;
            return this;
        }

        public Builder loggerConfig(LoggerConfig loggerConfig) {
            this.loggerConfig = loggerConfig;
            return this;
        }

        public ConfigurationManager build() {
            return new ConfigurationManager(this);
        }
    }

    @Override
    public String toString() {
        return "ConfigurationManager{" +
                "databaseConfig=" + databaseConfig +
                ", cacheConfig=" + cacheConfig +
                ", loggerConfig=" + loggerConfig +
                '}';
    }

    public static void main(String[] args) {
        DatabaseConfig dbConfig = new DatabaseConfig.Builder("localhost")
                .port(3306)
                .username("user")
                .password("password")
                .build();

        CacheConfig cacheConfig = new CacheConfig.Builder()
                .enabled(true)
                .cacheSize(512)
                .build();

        LoggerConfig loggerConfig = new LoggerConfig.Builder()
                .level("DEBUG")
                .filePath("/var/log/custom.log")
                .build();

        ConfigurationManager configManager = new ConfigurationManager.Builder()
                .databaseConfig(dbConfig)
                .cacheConfig(cacheConfig)
                .loggerConfig(loggerConfig)
                .build();

        System.out.println(configManager);
    }
}
