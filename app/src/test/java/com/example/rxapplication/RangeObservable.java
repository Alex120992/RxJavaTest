package com.example.rxapplication;

import android.app.IntentService;

import org.junit.Test;

import io.reactivex.Observable;
/* Ведет счет от указанного значения то количество раз которое указано во втором параметре*/
public class RangeObservable {
     int start = 3, count = 7;
    @Test
    public  void rangeObservable (){
//        Observable observable = Observable.range(0,10);
//        observable.subscribe(x-> System.out.println(x));


        Observable observable = Observable.defer(() -> Observable.range(start, count));
        // defer не создает новый Observable, но позволяет определить каким образом Observable
        // будет создан при появлении подписчиков. Без defer переопределчет результат
        observable.subscribe(x-> System.out.println("1- "+x));
        count = 4;
        observable.subscribe(x-> System.out.println("2- "+x));
            }
}
