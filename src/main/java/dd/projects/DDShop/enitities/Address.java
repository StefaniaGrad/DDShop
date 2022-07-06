package dd.projects.DDShop.enitities;

import javax.persistence.*;

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
    @OneToOne(mappedBy = "defaultDeliveryAddress")
    private User user;
}
