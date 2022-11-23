package cl.infoclub.fsj;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan
@PropertySource("classpath:database.properties")
public class AppConfig {

	@Autowired
	Environment environment;

	@Bean
	DataSource dataSource() {
		DriverManagerDataSource dmDataSource = new DriverManagerDataSource();
		dmDataSource.setUrl(environment.getProperty("url"));
		dmDataSource.setUsername(environment.getProperty("dbuser"));
		dmDataSource.setPassword(environment.getProperty("dbpassword"));
		dmDataSource.setDriverClassName(environment.getProperty("driver"));
		return dmDataSource;
	}

}
