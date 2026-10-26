package p3g2.p3g2.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import p3g2.p3g2.excepciones.PotionExpiredException;
import p3g2.p3g2.models.Potion;
import p3g2.p3g2.repositories.IPotionRepository;

/**
 * PotionService
 */
@Service
public class PotionService implements IPotionService {
    private final IPotionRepository potionRepository;

    // constructor
    public PotionService(IPotionRepository potionRepository) {
        this.potionRepository = potionRepository;
    }

    @Override
    public Potion findById(int id) {
        Potion potion = potionRepository.findById(id);
        //Realizo la comprobacion de si la poción está caducada
        if(potion != null && potion.getExpirationDate().before(new Date())){
              throw new PotionExpiredException("La poción " + potion.getName() + " está caducada");
        }
        return  potion;
    }
}
