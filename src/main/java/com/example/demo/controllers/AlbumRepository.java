package com.example.demo.controllers;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.Album;

public interface AlbumRepository extends CrudRepository<Album, Long> {

}
