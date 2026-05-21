package ca.pm.manageProduct;

import org.springframework.http.ResponseEntity;

public interface Command<i, o> {
    ResponseEntity<o> execute(i input);
}
