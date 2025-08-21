package com.antonio.reactive;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class TemperatureSensor {
    public static void main(String[] args) {
        Observable<Long> interval = Observable.interval(1, TimeUnit.SECONDS);

        Observable<Double> temperatureStream = interval.map(
                t -> {
                    double temperature = Math.random() * 15;
                    System.out.println(temperature);
                    return temperature;
                }
        );
    }
}
