package p3g2.p3g2.models;

/**
 * Monster
 */
public class Monster {
    private int id;
    private String name;
    private String species;
    private int scareLevel;

    public Monster() {

    }

    public Monster(int id, String name, String species, int scareLevel) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.scareLevel = scareLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getScareLevel() {
        return scareLevel;
    }

    public void setScareLevel(int scareLevel) {
        this.scareLevel = scareLevel;
    }

    // sobreescribo el toString
    @Override
    public String toString() {
        return "Monster{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species=" + species + '\'' +
                ", scareLevel=" + scareLevel +
                '}';
    }

}
