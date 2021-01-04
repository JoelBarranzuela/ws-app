package com.everis.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.everis.app.config.clientes.IFilmClienteApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RestClientConfiguration {

	 @Bean
	 IFilmClienteApi testApi()
	 {
		Retrofit retrofit = new Retrofit.Builder()
										.baseUrl("https://ghibliapi.herokuapp.com")
										.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
										.addConverterFactory(GsonConverterFactory.create())
										.build();
		
		return retrofit.create(IFilmClienteApi.class);
										
	 }
}
