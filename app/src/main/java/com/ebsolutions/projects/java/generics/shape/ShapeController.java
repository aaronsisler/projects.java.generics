package com.ebsolutions.projects.java.generics.shape;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("shapes")
public class ShapeController {

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> post(@Valid @RequestBody ShapeRequest shapeRequest) {

    return ResponseEntity.ok(shapeRequest);
  }

  private void genericMethod() {
    // I have to define the type out here
    // How can we make that dynamic...
    Box<Integer> integerBox = new Box<>();
    integerBox.setContent(10);
    int value = integerBox.getContent(); // No casting needed

    Box<String> stringBox = new Box<>();
    stringBox.setContent("Hello");
    String text = stringBox.getContent(); // No casting needed
  }
}
