package jomeerkatz.springboot.content_calender.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

public final record Content(
        @Id
        Integer id,
                      @NotBlank // not empty/null
                      String title,
                      @Column(value="description")
                      String desc,
                      Status status,
                      Type contentType,
                      LocalDateTime dateCreated,
                      LocalDateTime dateUpdated,
                      String url
                      ) {
}
