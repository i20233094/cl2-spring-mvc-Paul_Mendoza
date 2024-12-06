package pe.edu.i202330941.cl2_spring_mvc_Paul_Mendoza.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmCategoryPk {

    private Integer filmId;
    private Integer categoryId;

}

