package p3g2.p3g2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import p3g2.p3g2.models.Potion;
import p3g2.p3g2.repositories.IPotionRepository;

/**
 * PotionService
 */
@Service
public class PotionService implements IPotionService {
    private final IPotionRepository potionRepository = null;

    @Override
    public Potion findById(int id) {
        return potionRepository.findById(id);
    }
}
