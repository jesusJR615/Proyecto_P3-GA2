package p3g2.p3g2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import p3g2.p3g2.models.Monster;
import p3g2.p3g2.repositories.IMonsterRepository;

/**
 * MonsterService
 */
@Service
public class MonsterService implements IMonsterService {
    private final IMonsterRepository monsterRepository;

    public MonsterService(IMonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }

    @Override
    public Monster findById(int id) {
        return monsterRepository.findById(id);
    }

}