package jomeerkatz.springboot.content_calender.controller;

import jakarta.validation.Valid;
import jomeerkatz.springboot.content_calender.model.Content;
import jomeerkatz.springboot.content_calender.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {
    private ContentRepository contentRepository;

    public ContentController() { }

    @Autowired
    public ContentController(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @GetMapping("")
    public List<Content> findAll() {
        return contentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Content findSpecificContentById(@PathVariable Integer id) {
        return contentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content with the ID not found!"));
    }

    @ResponseStatus(HttpStatus.CREATED) // this an be optimized. example: check if it's really in the db or list
    @PutMapping("")
    public void create(@Valid @RequestBody Content content){
        contentRepository.save(content);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Content content, @PathVariable Integer id) {
        // check if the content with the id even exists
        if (!contentRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Content with the ID not found!");
        } else {
            contentRepository.save(content);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @DeleteMapping("/{id}") // return entity can be optimized
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        contentRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

