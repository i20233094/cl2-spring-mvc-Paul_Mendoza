package pe.edu.i202330941.cl2_spring_mvc_Paul_Mendoza.dto;

public record FilmDto(Integer filmId,
                      String title,
                      String language,
                      Integer rentalDuration,
                      Double rentalRate) {
}
