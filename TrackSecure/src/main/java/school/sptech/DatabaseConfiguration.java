package school.sptech;


import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseConfiguration {
    // Executor de query
    private JdbcTemplate template;

    // Contrutor
    public DatabaseConfiguration() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://10.18.32.12:3306/TrackSecure");
        dataSource.setUsername("capturaDados");
        dataSource.setPassword("SPTech#2024");
        this.template = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getTemplate() {
        return template;
    }


}
