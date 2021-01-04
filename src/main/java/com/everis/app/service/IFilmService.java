package com.everis.app.service;

import com.everis.app.entity.Film;

import io.reactivex.Observable;

public interface IFilmService {
	
	Observable<Film> findAllFilmsReleaseDate(int year);
	Observable<Film> finAllFilmsWhereNameStartsWith(String startsWith);
}
