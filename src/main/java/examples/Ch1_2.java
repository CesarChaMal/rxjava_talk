
package examples;

import io.reactivex.Observable;

public class Ch1_2 {

    public static void main(String[] args) {

        Observable<String> myStrings =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        myStrings.map(String::length)
                .filter(i -> i > 4)
                .subscribe(System.out::println);
    }
}
