package pe.edu.i202330941.cl2_spring_mvc_Paul_Mendoza.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rentalId;
    private Date rentalDate;
    private Integer customerId;
    private Date returnDate;
    private Integer staffId;
    private Date lastUpdate;

    @ManyToOne
    @JoinColumn(name = "inventory_id", nullable = false)
    private Inventory inventory;

}