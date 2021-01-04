package com.everis.app.controller;


import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.everis.app.entity.Film;
import com.everis.app.service.FilmServiceImpl;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;

@Disabled
@ExtendWith(MockitoExtension.class)
public class FilmControllerTest {
	
	@InjectMocks
	private FilmController controller;
	
	@Mock
	private FilmServiceImpl service;
	
	@Mock
	private List<Film> lstFilms;
	
	
	@BeforeEach
	public void initialize() {
		
		lstFilms = Arrays.asList(
				 new Film("1","bittle2","desc1","direc1","prod1","1999","50"),
				 new Film("2","tittle3","desc2","direc2","prod2","1888","40"),
				 new Film("3","tittle4","desc3","direc3","prod3","1996","30"),
				 new Film("4","tittle5","desc4","direc4","prod4","1995","20"),
				 new Film("5","tittle6","desc5","direc5","prod5","1990","10")
				);	
	}
	
	
	
	@Test
	public void getYearFilm() {
		
		List<Film> listResponse = lstFilms;
	 	Observable<List<Film>> films = Observable.just(listResponse);
		
		
		//when(service.findAllFilmsReleaseDate(1991))
		
		
		   /* Test */
	    TestObserver<Film> cards = controller.findAllFilmsReleaseDate(1991).test();

	    /* Asserts */
	  //  assertEquals(3, cards.size());
	    
	    cards.assertSubscribed()
	    .assertComplete()
	    .assertTerminated()
	    .assertValueCount(3);
	    
		
	}
	
	
	

}
