package com.example.rxapplication;

import org.junit.Test;

import io.reactivex.Observable;

/*Используется в основном для тестирования*/
public class Empty_Never {
    @Test
    public void observableEmpty (){ // Выбрасываетпустое завершение "OnCompleted" Observable и никаких значений
        Observable observable = Observable.empty();
        observable.subscribe(System.out::println, System.out::println,()-> System.out.println("OnCompleted"));
    }
    @Test
    public void observableNever (){ // Гикогда не завершает и даже не вырасывает пустое значсение
        Observable observable = Observable.never();
        observable.subscribe(System.out::println, System.out::println,()-> System.out.println("OnCompleted"));
    }
}
