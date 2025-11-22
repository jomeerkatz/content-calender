package jomeerkatz.springboot.content_calender.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jomeerkatz.springboot.content_calender.model.Content;
import jomeerkatz.springboot.content_calender.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Profile("production")
@Component
public class DataLoader implements CommandLineRunner {

    private final ContentRepository contentRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public DataLoader(ContentRepository contentRepository, ObjectMapper objectMapper) {
        this.contentRepository = contentRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String ...args) throws Exception {
        try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json")) {
            contentRepository.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<Content>>() {}));
        }
    }
}
