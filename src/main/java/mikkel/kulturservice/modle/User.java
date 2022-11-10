package mikkel.kulturservice.modle;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@Data laver getter, setter, toString(), hashCode()
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users") // fordi @DataJpaTest ikke accepterer navnet "User"
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String username;
    private String password;

    public User(String username, String password) {
        this.username=username;
        this.password=password;
    }

    //@OneToMany(mappedBy = "user")
    //private Set<Review> reviews = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "venue_like",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "venue_id")
    )
    @JsonBackReference
    private Set<Venue> venuesLiked = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "band_like",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name ="band_id")
    )
    @JsonBackReference
    private Set<Bande> bandesLiked = new HashSet<>();
}