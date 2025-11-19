package jomeerkatz.springboot.content_calender.repository;

import jakarta.annotation.PostConstruct;
import jomeerkatz.springboot.content_calender.model.Content;
import jomeerkatz.springboot.content_calender.model.Status;
import jomeerkatz.springboot.content_calender.model.Type;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// using this class for collecting some content in memory
@Repository
public class ContentCollectionRepository {
    private final List<Content> content = new ArrayList<>();

    public ContentCollectionRepository() {
        //
    }

    public List<Content> findAll() {
        return content;
    }

    public Optional<Content> findSpecificContent(Integer id){
        return content.stream().filter(currentContent -> currentContent.id().equals(id)).findFirst();
    }

    @PostConstruct // execute this method after the bean is fully created and all dependencies are injected
    private void init() {
        Content c = new Content(
                1,
                "Test Content Init",
                "Desc Test",
                Status.COMPLETED,
                Type.CONFERENCE_TALK,
                LocalDateTime.now(),
                null,
                "");
        this.content.add(c);
    }

    public void save(Content content) {
        this.content.removeIf(currenContent -> currenContent.id().equals(content.id()));
         this.content.add(content);
    }

    public boolean existsById(Integer id){
        return this.content.stream().filter(currentContent -> currentContent.id().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        this.content.removeIf(currentContent -> currentContent.id().equals(id));
    }


//    public Content update(Content content, Integer id) {
//        this.content.stream().filter(currentContent -> currentContent.id().equals(id)).findFirst().ifPresent(
//                currentContent -> currentContent.contentType() =
//        );
//    }

}
