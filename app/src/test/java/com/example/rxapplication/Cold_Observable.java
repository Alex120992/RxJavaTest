package com.example.rxapplication;

import org.junit.Test;

import io.reactivex.Observable;


/* В холодном наблюдаемом снчала срабатывает один подписчик, только потом другой за 1  раз*/
public class Cold_Observable {
    @Test
    public void main () throws InterruptedException {
        Observable observable = Observable.just (1,2,3,4,5,6);
        observable.subscribe(item->System.out.println(item));

        observable.subscribe(item->System.out.println(item));

    }


}
