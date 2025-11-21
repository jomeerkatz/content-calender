package jomeerkatz.springboot.content_calender.repository;

import jomeerkatz.springboot.content_calender.model.Content;
import org.springframework.data.repository.ListCrudRepository;

// at runtime, spring boot sees it extends ListCrud... (base repositories) and turns it into an implemenation
public interface ContentRepository extends ListCrudRepository<Content, Integer> {
}
