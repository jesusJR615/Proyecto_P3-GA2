package p3g2.p3g2.repositories;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import p3g2.p3g2.models.HauntedHouse;
import p3g2.p3g2.models.Monster;
import tools.jackson.databind.ObjectMapper;

@Component
public class MonsterRepositoryJson implements IMonsterRepository {
    private List<Monster> monsters = new ArrayList<>();

   /**
     * Constructor por defecto que carga los datos desde
     * "classpath:json/monsters.json".
     */
    public MonsterRepositoryJson() {
        Resource resource = new ClassPathResource("json/monsters.json");
        readValueJson(resource);
    }

    private void readValueJson(Resource resource) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {

            // Deserializa el JSON en un array de monsters y luego lo convierte en lista
            monsters = new ArrayList<>(
                    Arrays.asList(objectMapper.readValue(resource.getInputStream(), Monster[].class)));

        } catch (IOException e) {
            e.printStackTrace(); // En un proyecto real convendría manejar la excepción de forma más robusta
        }
    }

    // Creo el método findById
    public Monster findById(int id) {
        Monster monster = monsters.stream().filter(h -> h.getId() == id)
                .findFirst().orElse(null);
        return monster;

    }
}
