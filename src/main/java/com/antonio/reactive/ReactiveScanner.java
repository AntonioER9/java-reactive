package com.antonio.reactive;

import io.reactivex.rxjava3.subjects.PublishSubject;

import java.util.Scanner;

public class ReactiveScanner {
    public static void main(String[] args) {

        PublishSubject<String> publishSubject = PublishSubject.create();

        publishSubject.subscribe(
                item -> System.out.println("Received: " + item),
                error -> System.out.println("Error: " + error.getMessage()),
                () -> System.out.println("Done!")
        );

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string: ");
        while (true){
            String string = scanner.nextLine();
            if (string.equalsIgnoreCase("quit")){
                publishSubject.onComplete();
                break;
            }
            publishSubject.onNext(string);
        }

        scanner.close();

    }
}
