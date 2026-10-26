package p3g2.p3g2.repositories;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import p3g2.p3g2.models.HauntedHouse;
import tools.jackson.databind.ObjectMapper;

@Component
public class HauntedHouseRepositoryJson implements IHauntedHouseRepository {
    private List<HauntedHouse> hauntedhouses = new ArrayList<>();

    /**
     * Constructor por defecto que carga los datos desde
     * "classpath:json/houses.json".
     */
    public HauntedHouseRepositoryJson() {
        Resource resource = new ClassPathResource("json/houses.json");
        readValueJson(resource);
    }

    private void readValueJson(Resource resource) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {

            // Deserializa el JSON en un array de hauntedhouses y luego lo convierte en
            // lista
            hauntedhouses = new ArrayList<>(
                    Arrays.asList(objectMapper.readValue(resource.getInputStream(), HauntedHouse[].class)));

        } catch (IOException e) {
            e.printStackTrace(); // En un proyecto real convendría manejar la excepción de forma más robusta
        }
    }

    // Creo el método findById
    public HauntedHouse findById(int id) {
        HauntedHouse haunted_house = hauntedhouses.stream().filter(h -> h.getId() == id)
                .findFirst().orElse(null);
        return haunted_house;

    }

}
