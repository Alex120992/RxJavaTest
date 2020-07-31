package com.example.rxapplication;

import org.junit.Test;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class Hot_Observable {
    @Test
    public void createHot() throws InterruptedException {
        ConnectableObservable observable = Observable.just(1, 2, 3, 4, 5).publish();

        observable.subscribe(item -> System.out.println("Observer 1 - " + item));

        observable.subscribe(item -> System.out.println("Observer 2 - " + item));
        observable.connect(); // после всех подписчиков, если подписчик стоит после connect то он не попадает к наблюдателю
        // все значения синхронизируются в отличие от холодного
    }
    @Test
    public void createHot2() throws InterruptedException {
        ConnectableObservable observable = Observable.just(1, 2, 3, 4, 5).publish();

        observable.subscribe(item -> System.out.println("Observer 1 - " + item));

        observable.subscribe(item -> System.out.println("Observer 2 - " + item));
        observable.connect();
        // после всех подписчиков, если подписчик стоит после connect то он не попадает к наблюдателю
        // все значения синхронизируются в отличие от холодного
    }
}
