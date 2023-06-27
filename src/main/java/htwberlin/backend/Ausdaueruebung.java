package htwberlin.backend;


import jakarta.persistence.*;

@Entity
public class Ausdaueruebung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int time;


    public Ausdaueruebung() {}

    public Ausdaueruebung(String name, int time) {
        this.name = name;
        this.time = time;
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ausdaueruebung)) return false;

        Ausdaueruebung ausdaueruebung = (Ausdaueruebung) o;

        if (getTime() != ausdaueruebung.getTime()) return false;
        if (getId() != null ? !getId().equals(ausdaueruebung.getId()) : ausdaueruebung.getId() != null) return false;
        return getName() != null ? getName().equals(ausdaueruebung.getName()) : ausdaueruebung.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getTime();
        return result;
    }

    @Override
    public String toString() {
        return "Ausdaueruebung{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}