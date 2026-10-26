package p3g2.p3g2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import p3g2.p3g2.models.HauntedHouse;
import p3g2.p3g2.repositories.IHauntedHouseRepository;

/**
 * HauntedHouseService
 */
@Service
public class HauntedHouseService implements IHauntedHouseService {
    private final IHauntedHouseRepository hauntedRepository;

    public HauntedHouseService(IHauntedHouseRepository hauntedRepository) {
        this.hauntedRepository = hauntedRepository;
    }

    @Override
    public HauntedHouse findById(int id) {
        return hauntedRepository.findById(id);
    }
}
