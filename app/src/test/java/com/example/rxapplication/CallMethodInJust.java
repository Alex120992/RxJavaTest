package com.example.rxapplication;

import org.junit.Test;

import io.reactivex.Observable;

public class CallMethodInJust {
    /*Тут у нас не вылавиливается ошибка наблюдателем
     * */
    @Test
    public void ObservableCallMethod() {
        Observable<Integer> observable = Observable.just(ch());
        observable.subscribe(x -> System.out.println(x), error -> System.out.println("Error: " + error.getLocalizedMessage()));
    }

    private int ch() {
        System.out.println("number print");
        return 3 / 0;
    }
    /* тут мы можем выловить ошибку
     * fromCallable не расхоудет в отличие от defer все ресурсы а расходует только одно значение
     * Рекомендуется его применять когда используем методы
     * Значение получается изнутри Observable , поэтому каждый раз оно будет разным, в just оно будет все время одинаковым
     *  __fromCallable выполняет генерацию значения только тогда, когда кто-то подписывается на него.
     * Другими словами, отложенное выполнение также называется отложенной инициализацией.
     * Это что-то очень полезное в программировании, чтобы сэкономить некоторые ресурсы обработки,
     * пока это не понадобится позже.
     * fromCallable дает значение после подписки
     * just создает значение до подписки*/


    @Test
    public void ObservableCallMethod2 (){
        Observable <Integer> observable = Observable.fromCallable(() -> ch1());
        observable.subscribe(x-> System.out.println(x), error -> System.out.println("Error: "+ error.getLocalizedMessage()));
    }

    private  int ch1 (){
        System.out.println("number print");
        return 3/1;
    }
}
