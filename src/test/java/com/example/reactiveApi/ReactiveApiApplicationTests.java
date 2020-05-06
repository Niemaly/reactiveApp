package com.example.reactiveApi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class ReactiveApiApplicationTests {

	@Test
	void contextLoads() {
		Flux.just("Jacek", "Fiora", "Krzysztof", "Franciszek", "Paweł", "Justyna", "Ewelina", "Nadia", "Grzegorz", "Wacław", "Iwona", "Dominika").
				filter(element-> element.startsWith("J")).
		subscribe(System.out::println);                                     // it takes many elements
		//   Mono.just(""); // it takes only one element

	}

}
