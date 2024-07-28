package Builder;

public class LoggerConfig {
    private final String level;
    private final String filePath;

    private LoggerConfig(Builder builder) {
        this.level = builder.level;
        this.filePath = builder.filePath;
    }

    public static class Builder {
        private String level = "INFO"; // Default value
        private String filePath = "/var/log/app.log"; // Default value

        public Builder level(String level) {
            this.level = level;
            return this;
        }

        public Builder filePath(String filePath) {
            this.filePath = filePath;
            return this;
        }

        public LoggerConfig build() {
            return new LoggerConfig(this);
        }
    }

    @Override
    public String toString() {
        return "LoggerConfig{" +
                "level='" + level + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
