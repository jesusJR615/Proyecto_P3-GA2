package p3g2.p3g2.service;

import p3g2.p3g2.models.Monster;
import java.util.List;
/**
 * IMonsterService
 */
public interface IMonsterService {
    Monster findById(Long id);
    List<Monster> findAll();
    void save(Monster monster);
    
}