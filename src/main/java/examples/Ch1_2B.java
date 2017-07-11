
package examples;

import io.reactivex.Observable;

public class Ch1_2B {

    public static void main(String[] args) {

            Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                    .map(String::length)
                    .filter(i -> i > 4)
                    .subscribe(System.out::println);
    }
}
