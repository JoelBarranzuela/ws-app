package com.everis.app.service;


import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.everis.app.config.clientes.IFilmClienteApi;
import com.everis.app.entity.Film;


import io.reactivex.Observable;
import lombok.RequiredArgsConstructor;
import static io.reactivex.schedulers.Schedulers.io;


@RequiredArgsConstructor
@Service
public class FilmServiceImpl implements IFilmService{
	
	
	private final IFilmClienteApi filmApi;
	
	@Override
	public Observable<Film> findAllFilmsReleaseDate(int year) {
	
		return filmApi.getFilms()
				.toObservable()
				.flatMapIterable(list->list)
				.filter(f -> Integer.parseInt(f.getRelease_date()) >= year);
	}

	@Override
	public Observable<Film> finAllFilmsWhereNameStartsWith(String startsWith) {
		
		return filmApi.getFilms()
				.map(films -> films.stream()
								   .filter(f->f.getTitle().startsWith(startsWith))
								   .collect(Collectors.toList()))
				.toObservable()
				.flatMapIterable(list->list)
				.concatMap(f-> Observable.just(f).delay(5,TimeUnit.SECONDS))
				.subscribeOn(io());
				
	}

	
}
