package com.example.reactiveApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class StudentApi {

   @GetMapping
    public Flux<String> get(){
       return Flux.just("Jacek", "Fiora", "Krzysztof", "Franciszek", "Paweł", "Justyna", "Ewelina", "Nadia", "Grzegorz", "Wacław", "Iwona", "Dominika");
   }
}
