package com.everis.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.app.entity.Film;
import com.everis.app.service.FilmServiceImpl;

import io.reactivex.Observable;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/film")
public class FilmController {
	
   @Autowired
	 private final FilmServiceImpl service;
	
	 @GetMapping("/releaseDate/{year}")
	 public Observable<Film> findAllFilmsReleaseDate(@PathVariable int year){
		return service.findAllFilmsReleaseDate(year);
  	}
	
	/*
	@GetMapping("/{startsWith}")
	public ResponseEntity<Observable<Film>> finAllFilmsWhereNameStartsWith(@PathVariable String startsWith){
		return new ResponseEntity<>( service.finAllFilmsWhereNameStartsWith(startsWith), HttpStatus.FOUND);  
				
	}
	*/
	
	
	@GetMapping("/{startsWith}")
	public Observable<ResponseEntity<Film>> finAllFilmsWhereNameStartsWith(@PathVariable String startsWith) {
		return 	service.finAllFilmsWhereNameStartsWith(startsWith)
				.map(p-> ResponseEntity.ok(p))
				.defaultIfEmpty(ResponseEntity.notFound().build());
		
	}

}
