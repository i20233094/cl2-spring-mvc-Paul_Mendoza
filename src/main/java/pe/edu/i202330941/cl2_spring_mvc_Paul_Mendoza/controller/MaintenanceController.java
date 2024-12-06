package pe.edu.i202330941.cl2_spring_mvc_Paul_Mendoza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.i202330941.cl2_spring_mvc_Paul_Mendoza.dto.FilmCreateDto;
import pe.edu.i202330941.cl2_spring_mvc_Paul_Mendoza.dto.FilmDetailDto;
import pe.edu.i202330941.cl2_spring_mvc_Paul_Mendoza.dto.FilmDto;
import pe.edu.i202330941.cl2_spring_mvc_Paul_Mendoza.entity.Language;
import pe.edu.i202330941.cl2_spring_mvc_Paul_Mendoza.repository.LanguageRepository;
import pe.edu.i202330941.cl2_spring_mvc_Paul_Mendoza.service.MaintenanceService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;

    @Autowired
    LanguageRepository languageRepository;

    @GetMapping("/start")
    public String start(Model model) {
        List<FilmDto> films = maintenanceService.findAllFilms();
        model.addAttribute("films", films);
        return "maintenance";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.findDetailById(id);
        model.addAttribute("film", filmDetailDto);
        return "maintenance-detail";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.findDetailById(id);
        model.addAttribute("film", filmDetailDto);
        return "maintenance-edit";
    }

    @PostMapping("/edit-confirm")
    public String edit(@ModelAttribute FilmDetailDto film, Model model) {
        maintenanceService.updateFilm(film);
        return "redirect:/maintenance/start";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        boolean isDeleted = maintenanceService.deleteFilmById(id);
        if (isDeleted) {
            model.addAttribute("message", "Película eliminada correctamente.");
        } else {
            model.addAttribute("error", "No se pudo eliminar la película.");
        }
        return "redirect:/maintenance/start";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("filmCreateDto", new FilmCreateDto(null, "", "",
                null, null, null, null, null, null,
                "", "", new Date()));
        Iterable<Language> languagesIterable = languageRepository.findAll();
        List<Language> languages = StreamSupport.stream(languagesIterable.spliterator(), false)
                .collect(Collectors.toList());
        model.addAttribute("languages", languages);

        return "maintenance-create";
    }

    @PostMapping("/create-confirm")
    public String createConfirm(@ModelAttribute FilmCreateDto filmCreateDto, Model model) {
        boolean isCreated = maintenanceService.createFilm(filmCreateDto);
        if (isCreated) {
            model.addAttribute("message", "Película creada .");
        } else {
            model.addAttribute("error", "No se pudo crear.");
        }
        return "redirect:/maintenance/start";
    }
}