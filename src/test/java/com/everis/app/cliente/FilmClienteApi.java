package com.everis.app.cliente;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.everis.app.config.clientes.IFilmClienteApi;
import com.everis.app.entity.Film;
import com.everis.app.service.FilmServiceImpl;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ExtendWith(MockitoExtension.class)
public class FilmClienteApi {
	
	@InjectMocks
	private FilmServiceImpl service;
	
	@Mock
	private IFilmClienteApi filmApi; 

	@Mock
	private List<Film> filmsa;
	
	
	@BeforeEach
	public void initialize() {
		
		filmsa = Arrays.asList(
				 new Film("1","bittle2","desc1","direc1","prod1","1999","50"),
				 new Film("2","tittle3","desc2","direc2","prod2","1888","40"),
				 new Film("3","tittle4","desc3","direc3","prod3","1996","30"),
				 new Film("4","tittle5","desc4","direc4","prod4","1995","20"),
				 new Film("5","tittle6","desc5","direc5","prod5","1990","10")
				);	
	}
	
	
	@Test
	public void getSizeWhenReleaseDateis1991() {
		

		List<Film> listResponse = filmsa;
		Single<List<Film>> films = Single.just(listResponse);
		
		when(filmApi.getFilms()).thenReturn(films);
		
		Observable<Film> response = service.findAllFilmsReleaseDate(1991);
		Long expectedSize = 3L;
		//response.forEach(film-> log.info(film.getTitle()));
		
		//log.info(response.count().subscribe(c-> log.info(c)));
		
		response.test().assertValueCount(3);

		//assertEquals(expectedSize,3L,"no se puede");
		
				
				
	}
	
	@Test
	public void validateFilmWhenFindAllOfThenWhereFilmsNameStartsWith() {
		
		List<Film> listResponse = filmsa;
		Single<List<Film>> films = Single.just(listResponse);
		
		when(filmApi.getFilms()).thenReturn(films);
		
		TestObserver<Film> testresponse = service.finAllFilmsWhereNameStartsWith("bi").test();
		
		testresponse.awaitTerminalEvent();
		
		
		testresponse
				.assertSubscribed()
				.assertComplete()
				.assertTerminated()
				.assertValueCount(1)
				.assertValue(filmsa.get(0))
				.assertNoErrors();
					
	}


	
}
