package com.everis.app.config.clientes;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.everis.app.entity.Film;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface IFilmClienteApi {

	
	@GET("/films")
	Single<List<Film>> getFilms();
	
	@GET("/films/{id}")
	Single<Film> getFilmById(@PathVariable("id") String id);
}
