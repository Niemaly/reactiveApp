package com.example.reactiveApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class InitService {
    private StudentRepo studentRepo;

    @Autowired
    public InitService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void get() {
        studentRepo.deleteAll()
                .thenMany(Flux.just("Jacek", "Fiora", "Krzysztof", "Franciszek", "Paweł", "Justyna",
                        "Ewelina", "Nadia", "Grzegorz", "Wacław", "Iwona", "Dominika"))
                .map(name -> new Student(name))
                .flatMap(studentRepo::save)
                .thenMany(studentRepo.findAll())
                .subscribe(System.out::println);

        studentRepo.save(new Student("Wiesław")).subscribe();

    }
}
