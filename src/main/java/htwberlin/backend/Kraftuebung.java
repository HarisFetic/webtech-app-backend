package htwberlin.backend;


import jakarta.persistence.*;

@Entity
public class Kraftuebung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int repeat;
    

    public Kraftuebung() {}

    public Kraftuebung(String name, int repeat) {
        this.name = name;
        this.repeat = repeat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRepeat() {
        return repeat;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kraftuebung)) return false;

        Kraftuebung kraftuebung = (Kraftuebung) o;

        if (getRepeat() != kraftuebung.getRepeat()) return false;
        if (getId() != null ? !getId().equals(kraftuebung.getId()) : kraftuebung.getId() != null) return false;
        return getName() != null ? getName().equals(kraftuebung.getName()) : kraftuebung.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getRepeat();
        return result;
    }

    @Override
    public String toString() {
        return "Kraftuebung{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", repeat=" + repeat +
                '}';
    }
}