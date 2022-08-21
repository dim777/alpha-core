package tech.ineb.ats.alpha.config.dev;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.jpa.hibernate.properties")
public class HibernateProperties {
    private final String DEFAULT_DIALECT = "org.hibernate.dialect.H2Dialect";
    private final String DEFAULT_HBM2DDL_AUTO = "org.hibernate.dialect.H2Dialect";
    private final Boolean DEFAULT_SHOW_SQL = true;
    private final Integer DEFAULT_MAX_FETCH_DEPTH = 3;
    private final Integer DEFAULT_BATCH_SIZE = 10;
    private final Integer DEFAULT_FETCH_SIZE = 50;

    private String dialect = DEFAULT_DIALECT;
    private Boolean showSql = DEFAULT_SHOW_SQL;
    private Integer maxFetchDepth = DEFAULT_MAX_FETCH_DEPTH;

    @ConfigurationProperties(prefix = "spring.jpa.hibernate.properties.jdbc")
    public class Hbm2Ddl {
        private String auto = DEFAULT_HBM2DDL_AUTO;

        public String getAuto() {
            return auto;
        }

        public void setAuto(String auto) {
            this.auto = auto;
        }
    }

    @ConfigurationProperties(prefix = "spring.jpa.hibernate.properties.jdbc")
    public class Jdbc {
        private Integer batchSize = DEFAULT_BATCH_SIZE;
        private Integer fetchSize = DEFAULT_FETCH_SIZE;

        public Integer getBatchSize() {
            return batchSize;
        }

        public void setBatchSize(Integer batchSize) {
            this.batchSize = batchSize;
        }

        public Integer getFetchSize() {
            return fetchSize;
        }

        public void setFetchSize(Integer fetchSize) {
            this.fetchSize = fetchSize;
        }
    }

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    public Boolean getShowSql() {
        return showSql;
    }

    public void setShowSql(Boolean showSql) {
        this.showSql = showSql;
    }

    public Integer getMaxFetchDepth() {
        return maxFetchDepth;
    }

    public void setMaxFetchDepth(Integer maxFetchDepth) {
        this.maxFetchDepth = maxFetchDepth;
    }
}
