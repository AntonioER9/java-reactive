package com.antonio.reactive;

import io.reactivex.rxjava3.core.Observable;

public class ChainningExample {
    public static void main(String[] args) {
        Observable<String> students = Observable.just("Fernando", "Antonio", "Juan");

        students.flatMap(student -> getSubjects(student)).subscribe(
                subject -> System.out.println("Subject: " + subject),
                error -> System.out.println("Error: " + error.getMessage()),
                () -> System.out.println("Done!")
        );


    }

    public static Observable<String> getSubjects(String name) {
        if(name.equalsIgnoreCase("Fernando")) {
            return Observable.just("Java");
        }
        return Observable.empty();
    }
}
