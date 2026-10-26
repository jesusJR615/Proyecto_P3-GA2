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

import p3g2.p3g2.models.Monster;
import p3g2.p3g2.models.Potion;
import tools.jackson.databind.ObjectMapper;

@Component
public class PotionRepositoryJson implements IPotionRepository {
    private List<Potion> potions = new ArrayList<>();

   /**
     * Constructor por defecto que carga los datos desde
     * "classpath:json/potios.json".
     */
    public PotionRepositoryJson() {
        Resource resource = new ClassPathResource("json/potions.json");
        readValueJson(resource);
    }

    private void readValueJson(Resource resource) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {

            // Deserializa el JSON en un array de potions y luego lo convierte en lista
            potions = new ArrayList<>(
                    Arrays.asList(objectMapper.readValue(resource.getInputStream(), Potion[].class)));

        } catch (IOException e) {
            e.printStackTrace(); // En un proyecto real convendría manejar la excepción de forma más robusta
        }
    }

    // Creo el método findById
    public Potion findById(int id) {
        Potion potion = potions.stream().filter(h -> h.getId() == id)
                .findFirst().orElse(null);
        return potion;

    }

}
