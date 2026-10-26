package p3g2.p3g2.models;

public class HauntedHouse {
    private int id;
    private String name;
    private boolean open; 
    private int scareLevel;

    public HauntedHouse() {

    }

    public HauntedHouse(int id, String name, boolean open, int scareLevel) {
        this.id = id;
        this.name = name;
        this.open = open;
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

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public int getScareLevel() {
        return scareLevel;
    }

    public void setScareLevel(int scareLevel) {
        this.scareLevel = scareLevel;
    }

     //sobreescribo el toString 
    @Override
    public String toString() {
        return "HauntedHouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", open=" + open + '\'' +
                ", scareLevel=" + scareLevel +
                '}';
    }

}

