
package examples;

import io.reactivex.Observable;

public class Ch1_2A {

    public static void main(String[] args) {

        Observable<String> myStrings =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        Observable<Integer> lengths = myStrings.map(String::length);

        Observable<Integer> filtered = lengths.filter(i -> i > 4);

        filtered.subscribe(System.out::println);
    }
}
