
package ch1;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;

public class Ch1_3 {

    public static void main(String[] args) {

        Observable<Long> secondIntervals = Observable.interval(1, TimeUnit.SECONDS);

        secondIntervals.subscribe(System.out::println);

        sleep(5000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
