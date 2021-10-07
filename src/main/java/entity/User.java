package entity;

import javax.persistence.*;

@Entity
@Table(name = "entity.User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;

    @Column(name = "Name")
    private String name;

    public User(){}
    public User(String toName){
        this.name = toName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
