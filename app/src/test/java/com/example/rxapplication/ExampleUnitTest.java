package com.example.rxapplication;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    //*Способы итерации в RxJava*/
    @Test
    public void main0() {
//        Observable.just(1,2,3,4,5).subscribe(System.out::println);//just создает Observable, который выдаст определенное заранее количество значений, после чего завершится.
        Observable<Integer> observable = Observable.just(1, 2, 3, 4);
        observable.subscribe(x -> System.out.println(x));

    }

    @Test
    public void main1() {
        List<Integer> list = Arrays.asList(11, 2, 56, 7);
        Observable<Integer> observable = Observable.fromIterable(list);
        observable.subscribe(System.out::println);

    }

    @Test
    public void main2() {
        Observable<Integer> observable = Observable.create(emitter -> { // Эмиссия элементов
                    emitter.onNext(1); // испускаем элемент
                    emitter.onNext(null); // испускаем элемент

                    emitter.onNext(2);
                    emitter.onNext(3);
                    emitter.onNext(4);
                    emitter.onNext(5);
                    emitter.onNext(6);
                    emitter.onComplete(); // Завершения испускания
                }
        );
        observable.subscribe(x -> System.out.println(x),
                error -> System.out.println("There was: " + error.getLocalizedMessage()),// Возвращается исключения на местонм языке
                // проверяет каждый элемент на исключение
                () -> System.out.println("Completed"));
    }
}