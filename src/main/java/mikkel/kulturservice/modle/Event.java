package mikkel.kulturservice.modle;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String venue;
    //private Date startDate;

    @ManyToOne
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private Bande bande;

    @OneToMany(mappedBy = "event")
    private Set<Review> reviews = new HashSet<>();


}
