package mikkel.kulturservice.modle;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//@Data
@Getter
@Setter
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String venue;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date startDate;

    @ManyToOne
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private Bande bande;

    @JsonManagedReference
    public String getBandName(){
        if (this.bande != null){
            return bande.getName();
        }else {
            return null;
        }
    }

    @OneToMany(mappedBy = "event")
    private Set<Review> reviews = new HashSet<>();


}
