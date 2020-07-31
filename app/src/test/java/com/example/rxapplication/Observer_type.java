package com.example.rxapplication;

import org.junit.Test;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
/*Тоже что и subscrite только в наблюдателе все разделено в отдельны методы*/
public class Observer_type {
    @Test
    public void main() {
       Observable<Integer> observable = Observable.just(1,2,3,4,5,6);

        Observer <Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("There was" + e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("OnComplete");
            }
        };
        observable.subscribe(observer);
    }
}
