package mikkel.kulturservice.modle;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@Data
@Getter
@Setter
@Entity
public class Bande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "bande")
    private Set<Event> events = new HashSet<>();

    @ManyToMany
    @JsonBackReference
    private Set<User> usersLikes = new HashSet<>();
}
