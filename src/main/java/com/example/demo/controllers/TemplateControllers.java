package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Album;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/templates")
public class TemplateControllers {

  @GetMapping("/album")
  public ModelAndView album() {

    // Refers to the file name of the template
    ModelAndView modelAndView = new ModelAndView("single-album");

    // Add data to the template
    modelAndView.addObject("title", "After Hours");
    modelAndView.addObject("artist", "The Weeknd");

    return modelAndView;
  }

  @GetMapping("/all-albums")
  public ModelAndView allAlbums() {

    ModelAndView modelAndView = new ModelAndView("all-albums");

    Iterable<Album> albums = albumRepository.findAll();
    modelAndView.addObject("album", new Album());
    modelAndView.addObject("albums", albums);

    return modelAndView;
  }

  @Autowired
  private AlbumRepository albumRepository;

  @PostMapping("/albumForm")
  public String saveNewAlbum(@ModelAttribute Album album) {
    albumRepository.save(album);
    return "redirect:/templates/all-albums";
  }

}
