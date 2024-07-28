package Builder;

public class CacheConfig {
    private final boolean enabled;
    private final int cacheSize;

    private CacheConfig(Builder builder) {
        this.enabled = builder.enabled;
        this.cacheSize = builder.cacheSize;
    }

    public static class Builder {
        private boolean enabled = false; // Default value
        private int cacheSize = 256; // Default value

        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder cacheSize(int cacheSize) {
            this.cacheSize = cacheSize;
            return this;
        }

        public CacheConfig build() {
            return new CacheConfig(this);
        }
    }

    @Override
    public String toString() {
        return "CacheConfig{" +
                "enabled=" + enabled +
                ", cacheSize=" + cacheSize +
                '}';
    }
}
