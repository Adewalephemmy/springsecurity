package batchprocessing.gs_batch_processing;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

@org.springframework.context.annotation.Configuration
public class Configuration {
	@Bean
	public FlatFileItemReader<Person> reader() {
	  return new FlatFileItemReaderBuilder<Person>()
	    .name("personItemReader")
	    .resource(new ClassPathResource("sample-data.csv"))
	    .delimited()
	    .names("firstName", "lastName")
	    .targetType(Person.class)
	    .build();
	}
	
	@Bean
	public PersonItemProcessor processor() {
	  return new PersonItemProcessor();
	}
	
	@Bean
	public JdbcBatchItemWriter<Person> writer(DataSource dataSource) {
	  return new JdbcBatchItemWriterBuilder<Person>()
	    .sql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)")
	    .dataSource(dataSource)
	    .beanMapped()
	    .build();
	}
}
