package pe.edu.i202330941.cl2_spring_mvc_Paul_Mendoza.service;

import pe.edu.i202330941.cl2_spring_mvc_Paul_Mendoza.dto.FilmCreateDto;
import pe.edu.i202330941.cl2_spring_mvc_Paul_Mendoza.dto.FilmDetailDto;
import pe.edu.i202330941.cl2_spring_mvc_Paul_Mendoza.dto.FilmDto;

import java.util.List;

public interface MaintenanceService {

    List<FilmDto> findAllFilms();

    FilmDetailDto findDetailById(Integer id);

    Boolean updateFilm(FilmDetailDto filmDetailDto);

    Boolean createFilm(FilmCreateDto filmCreateDto);
    Boolean deleteFilmById(Integer id);

}
