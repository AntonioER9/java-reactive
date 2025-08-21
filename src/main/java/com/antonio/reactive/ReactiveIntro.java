package com.antonio.reactive;

import io.reactivex.rxjava3.core.Observable;

public class ReactiveIntro {
    public static void main(String[] args) {
//        Observable<String> courseStream = Observable.just("HTML","CSS","JAVA", "C");
//
//        courseStream.subscribe(
//            item -> System.out.println("Recibido " + item),
//            error -> System.out.println(error.getMessage()),
//                () -> System.out.println("Finalizando...")
//        );

        Observable<String> names = Observable.create( emitter -> {
            emitter.onNext("Fernando");
            emitter.onNext("Antonio");
            emitter.onNext("Juan");
            emitter.onError(new IllegalStateException("Error"));
        });

        names.subscribe(
            item -> System.out.println("Recibido " + item),
            error -> System.out.println(error.getMessage()),
            () -> System.out.println("Finalizando...")
        );

    }
}
