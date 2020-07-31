package com.example.rxapplication;


import org.junit.Test;

import io.reactivex.Observable;

public class ObservableError {
    @Test
    public void observableException() { // тут одинаковые хешкоды , потому что передаем экземпляр ндапрямую и он его же передает снова другим
//        подписчикам
        Observable observable = Observable.error(new Exception("An Exception"));
        observable.subscribe(x -> System.out.println(x), error -> System.out.println("Ошибка: " + error.hashCode()));
        observable.subscribe(x -> System.out.println(x), error -> System.out.println("Ошибка: " + error.hashCode()));

    }

    @Test
    public  void throwExceptionUsingCallable() { // Тут у нас создаются разные хешкоды
        //  Но когда мы проходим через лямбду мы получаем каждый рах новый экземпляр при достижения своего набллюдателя
        Observable observable = Observable.error(() -> new Exception("An Exception"));
        observable.subscribe(x -> System.out.println(x), error -> System.out.println("Ошибка: " + error.hashCode()));
        observable.subscribe(x -> System.out.println(x), error -> System.out.println("Ошибка: " + error.hashCode()));

    }
}