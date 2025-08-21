package com.antonio.reactive;

import io.reactivex.rxjava3.core.Observable;

public class Merge {

    public static void main(String[] args) {
        Observable<String> students = Observable.just("Fernando", "Antonio", "Juan");
        Observable<String> teachers = Observable.just("Pedro", "Maria", "Luis");

        Observable.merge(students, teachers).subscribe(System.out::println); // Merge los elementos de ambos Observable, emitiendo los elementos a medida que están disponibles, no es bloqueante

        Observable.concat(students, teachers).subscribe(System.out::println); // Concatena los elementos de ambos Observable, uno tras otro, es bloqueante

        Observable.zip(students, teachers, (student, teacher) -> student.concat(teacher))
                .subscribe(System.out::println); // Combina los elementos de ambos Observable, emitiendo un nuevo elemento por cada combinación de los elementos de ambos Observable, es bloqueante
    }
}
