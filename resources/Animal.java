
public class Animal {
    private String species;
    private String family;
    private String habitat;

    public Animal(String species, String family, String habitat) {
        this.species = species;
        this.family = family;
        this.habitat = habitat;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
}
