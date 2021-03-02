package Entity;

import javax.persistence.*;

@Entity
@Table(name = "peoples")
public class People {
    @Id
    @GeneratedValue
    private Long id;
    private String craft;
    private String name;

    public String getCraft() {
        return craft;
    }

    public void setCraft(String craft) {
        this.craft = craft;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "craft='" + craft + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
