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
    Shape shape = Shape.create(shapeRequest.getShape(), shapeRequest.getArea());

    return ResponseEntity.ok(shape);
  }
}
