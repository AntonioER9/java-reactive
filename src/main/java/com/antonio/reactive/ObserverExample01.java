package com.antonio.reactive;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ObserverExample01 {
    public static void main(String[] args) {
        Observable<String> courseStream = Observable.fromIterable(Arrays.asList("HTML", "CSS", "JAVA", null).stream()
                .filter(Objects::nonNull).collect(Collectors.toSet()));

        Observer<String> observer = new Observer<>() {

            private Disposable disposable;

            @Override
            public void onSubscribe(io.reactivex.rxjava3.disposables.Disposable d) {
                this.disposable = d;
                System.out.println("Suscrito al observable");
            }

            @Override
            public void onNext(String item) {
                if (item.equalsIgnoreCase("JAVA")) {
                    System.out.println("Desuscribiendo...");
                    disposable.dispose();
                } else {
                    System.out.println("Recibido " + item);
                }
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Error: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Finalizando...");
            }
        };

//        courseStream.subscribe(
//                item -> System.out.println("Recibido " + item),
//                error -> System.out.println("Error: " + error.getMessage()),
//                () -> System.out.println("Finalizando...")
//        );

        courseStream.subscribe(observer);

    }
}
