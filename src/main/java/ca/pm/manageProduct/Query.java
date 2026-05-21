package ca.pm.manageProduct;

import org.springframework.http.ResponseEntity;

public interface Query<i, o>{
    ResponseEntity<o> execute(i input);
}
