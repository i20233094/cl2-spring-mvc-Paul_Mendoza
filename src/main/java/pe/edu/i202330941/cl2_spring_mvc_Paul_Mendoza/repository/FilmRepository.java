package pe.edu.i202330941.cl2_spring_mvc_Paul_Mendoza.repository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import pe.edu.i202330941.cl2_spring_mvc_Paul_Mendoza.entity.Film;


public interface FilmRepository extends CrudRepository<Film, Integer> {

    @Cacheable(value = "films")
    Iterable<Film> findAll();

    @CacheEvict(value = "films", allEntries = true)
    Film save(Film film);

    @CacheEvict(value = "films", allEntries = true)
    void delete(Film film);

}
