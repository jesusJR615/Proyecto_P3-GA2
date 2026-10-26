package p3g2.p3g2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import p3g2.p3g2.models.Monster;
import p3g2.p3g2.repositories.IMonsterRopository;

/**
 * MonsterService
 */
@Service 
public class MonsterService implements IMonsterService{
    private final IMonsterRepository monsterRepository;

    @Autowired 
    public MonsterService(IMonsterRopository monsterRepository){
        this.monsterRepository = monsterRepository;
    }

    @Override 
    public Monster findById(Long id){
        return monsterRepository.findById(id);
    }

    @Override 
    public List<Monster> findAll(){
        return monsterRepository.findAll();
    }

    @Override 
    public void save(Monster monster) {
        monsterRepository.save(monster);
    }
}