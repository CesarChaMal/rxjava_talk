/* Compilable code examples can be found at https://github.com/thomasnield/packt_learning_rxjava */

package ch7;

import io.reactivex.Observable;

public class Ch7_3 {
    public static void main(String[] args) {
        Observable.range(1, 10)
                .buffer(3, 1)
                .subscribe(System.out::println);
    }
}