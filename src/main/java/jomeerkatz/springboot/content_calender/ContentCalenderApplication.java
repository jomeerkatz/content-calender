package jomeerkatz.springboot.content_calender;

import jomeerkatz.springboot.content_calender.config.ContentCalenderProperties;
import jomeerkatz.springboot.content_calender.model.Content;
import jomeerkatz.springboot.content_calender.model.Status;
import jomeerkatz.springboot.content_calender.model.Type;
import jomeerkatz.springboot.content_calender.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;

@EnableConfigurationProperties(ContentCalenderProperties.class)
@SpringBootApplication
public class ContentCalenderApplication {

	public static <List> void main(String[] args) {
        SpringApplication.run(ContentCalenderApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner (ContentRepository cr){
        return args -> {
            Content content = new Content(
                    null,
                    "newEntry",
                    "newDesc",
                    Status.IDEA,
                    Type.CONFERENCE_TALK,
                    LocalDateTime.now(),
                    null,
                    ""
            );
            cr.save(content);
        };
    }

}
