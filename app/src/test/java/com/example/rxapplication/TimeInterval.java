package com.example.rxapplication;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class TimeInterval {
    /*Оператор interval выдает последовательность long чисел начиная с 0.
    Мы можем указать временной интервал, через который числа будут приходить. Укажем 1 сек.
    interval is cold Observable
    Запускается в отдельном потоке по -*/
    @Test
    public void observableinterval() throws InterruptedException {
        Observable observable = Observable.interval(1, TimeUnit.SECONDS);
        observable.subscribe(x -> System.out.println("Obser vable1 " + x));
        Thread.sleep(5000);
        observable.subscribe(x -> System.out.println("Observable2 " + x));
        Thread.sleep(5000);
    }
}
