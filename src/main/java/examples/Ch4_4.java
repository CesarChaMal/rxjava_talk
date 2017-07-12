/* Compilable code examples can be found at https://github.com/thomasnield/packt_learning_rxjava */

package examples;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Ch4_4 {
    public static void main(String[] args) {

        //emit every second
        Observable<String> timer1 = Observable.interval(1, TimeUnit.SECONDS)
                .map(i -> i + 1) // emit elapsed seconds
                .map(i -> "Source1: " + i + " seconds");

        //emit every 300 milliseconds
        Observable<String> timer2 =
                Observable.interval(300, TimeUnit.MILLISECONDS)
                        .map(i -> (i + 1) * 300) // emit elapsed milliseconds
                        .map(i -> "Source2: " + i + " milliseconds");

        //merge and subscribe
        Observable.merge(timer1, timer2)
                .subscribe(System.out::println);

        //keep alive for 3 seconds
        sleep(3000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}