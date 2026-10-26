package p3g2.p3g2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import p3g2.p3g2.excepciones.MonsterNotFoundException;
import p3g2.p3g2.models.Monster;
import p3g2.p3g2.service.IMonsterService;

/**
 * MonsterController
 */
@RestController
public class MonsterController {
    private final IMonsterService monsterService;

    // Constructor
    public MonsterController(IMonsterService monsterService) {
        this.monsterService = monsterService;
    }

    @GetMapping("/monster/{id}")
    public Monster findById(@PathVariable int id) {
        Monster monster = monsterService.findById(id);
        // Compruebo si el monster es igual a nulo
        if (monster == null) {
            throw new MonsterNotFoundException("Monstruo no encontrado con id " + id);
        }
        return monster;
    }
}