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
        public String getMoString(@PathVariable int id) {
            return monsterService.findById(id);
        }
        
    
}