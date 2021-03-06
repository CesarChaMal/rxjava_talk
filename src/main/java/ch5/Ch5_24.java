/* Compilable code examples can be found at https://github.com/thomasnield/packt_learning_rxjava */

package ch5;

import io.reactivex.subjects.ReplaySubject;
import io.reactivex.subjects.Subject;

public class Ch5_24 {
    public static void main(String[] args) {
        Subject<String> subject =
                ReplaySubject.create();
        subject.subscribe(s -> System.out.println("Observer 1: " +
                s));
        subject.onNext("Alpha");
        subject.onNext("Beta");
        subject.onNext("Gamma");
        subject.onComplete();
        subject.subscribe(s -> System.out.println("Observer 2: " +
                s));
    }
}