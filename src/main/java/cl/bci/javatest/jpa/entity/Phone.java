package cl.bci.javatest.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Entity
@Data
@Table(name = "PHONE")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private int number;

    @Column(name = "city_code")
    private int cityCode;

    @Column(name = "country_code")
    private int countryCode;
}
