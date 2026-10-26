package p3g2.p3g2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * MonsterController
 */
@RestController 
public class MonsterController {

    @GetMapping("/monster/{id}")
        public Monster fin(@PathVariable int id) {
          
        }
        
    
}