/* Compilable code examples can be found at https://github.com/thomasnield/packt_learning_rxjava */

package examples;

import io.reactivex.Observable;

public class Ch2_11 {
    public static void main(String[] args) {

        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        //first observer
        source.subscribe(s -> System.out.println("Observer 1 Received: " + s));
        //second observer
        source.subscribe(s -> System.out.println("Observer 2 Received: " + s));
    }
}