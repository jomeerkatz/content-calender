package jomeerkatz.springboot.content_calender.controller;

import jomeerkatz.springboot.content_calender.model.Content;
import jomeerkatz.springboot.content_calender.repository.ContentCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {
    private ContentCollectionRepository contentCollectionRepository;

    public ContentController() { }

    @Autowired
    public ContentController(ContentCollectionRepository contentCollectionRepository) {
        this.contentCollectionRepository = contentCollectionRepository;
    }

    @GetMapping("")
    public List<Content> findAll() {
        return contentCollectionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Content findSpecificContentById(@PathVariable Integer id) {
        return contentCollectionRepository.findSpecificContent(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content with the ID not found!"));
    }

    @ResponseStatus(HttpStatus.CREATED) // this an be optimized. example: check if it's really in the db or list
    @PutMapping("")
    public void create(@RequestBody Content content){
        contentCollectionRepository.save(content);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Content content, @PathVariable Integer id) {
        // check if the content with the id even exists
        if (!contentCollectionRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Content with the ID not found!");
        } else {
            contentCollectionRepository.save(content);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @DeleteMapping("/{id}") // return entity can be optimized
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        contentCollectionRepository.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

