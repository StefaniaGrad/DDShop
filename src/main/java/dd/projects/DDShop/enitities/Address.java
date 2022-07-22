package dd.projects.DDShop.enitities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String streetLine;

    private int postalCode;

    private String city;

    private String county;

    private String country;

    public Address(String streetLine, int postalCode, String city, String county, String country) {
        this.streetLine = streetLine;
        this.postalCode = postalCode;
        this.city = city;
        this.county = county;
        this.country = country;
    }

    public Address() {
    }
}
