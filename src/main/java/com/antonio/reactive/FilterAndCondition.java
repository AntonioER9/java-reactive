package com.antonio.reactive;

import io.reactivex.rxjava3.core.Observable;

public class FilterAndCondition {

    public static void main(String[] args) {

        Observable<Integer> ages = Observable.just(15, 20, 25, 30, 35, 40, 45, 50);

        ages.filter(age -> age > 20).subscribe(System.out::println);

        ages.distinct().subscribe(System.out::println); // Filtra los elementos duplicados, emitiendo solo los elementos únicos

        ages.take(2).subscribe(System.out::println); // Toma los primeros 2 elementos del Observable, emitiendo solo esos elementos

        ages.takeWhile(age -> age > 20).subscribe(System.out::println); // Toma los elementos del Observable mientras se cumpla la condición, emitiendo solo los elementos que cumplen la condición hasta que se encuentre un elemento que no la cumpla

    }
}
