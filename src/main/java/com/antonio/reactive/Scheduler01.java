package com.antonio.reactive;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Scheduler01 {

    public static void main(String[] args) throws InterruptedException {
        Observable.just("hola")
                .subscribeOn(Schedulers.io())
                .doOnNext(s -> System.out.println("Hilo Map: "+ Thread.currentThread().getName()))
                .map(s -> s + " mundo")
                .subscribe(s -> System.out.println("Resultado: " + s + " en el hilo: " + Thread.currentThread().getName()));

        Thread.sleep(1000); // Espera para que el observable complete su trabajo antes de que el programa termine
    }
}
