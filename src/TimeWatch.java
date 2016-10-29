/*
    This class provides a "timer" for a program.
    With it, you can figure out how much time
    has elapsed since another given point in
    time. Usage:

    TimeWatch timeWatch = TimeWatch.start();
    // some code that you want to time
    long elapsedTime = timeWatch.time();

    Tthe TimeWatch.time() function returns
    the elapsed time in seconds. If you want to
    change that to milliseconds or nanoseconds or
    days or hours, etc. you can use
    TimeWatch.time(TimeUnit.MILLISECONDS);
    or any corresponing TimeUnit enum value.

    Code taken and adapted from
    http://stackoverflow.com/a/1770038
*/

// Import the TimeUnit enum
import java.util.concurrent.TimeUnit;

// Define the TimeWatch class
public class TimeWatch {

    // A long that stores the time at which
    // the TimeWatch was created
    long startTime;

    // start() function simply calls the
    // TimeWatch constructor indirectly
    // and return and instance of TimeWatch
    public static TimeWatch start() {
        return new TimeWatch();
    }

    // TimeWatch constructor
    // Calls the reset() function
    private TimeWatch() {
        reset();
    }

    // reset() fucntion
    // Simply resets the startTime variable
    // to the current time of execution
    public TimeWatch reset() {
        startTime = System.nanoTime();
        return this;
    }

    // time() function
    // Returns the time it took from the
    // initialization of the class to the
    // call of this fucntion in seconds
    public long time() {
        long endTime = System.nanoTime();
        TimeUnit unit = TimeUnit.SECONDS;
        return unit.convert(endTime - startTime, TimeUnit.MILLISECONDS);
    }

    // time() function
    // Returns the time it took from the
    // initialization of the class to the
    // call of this fucntion in any time unit
    // desired in the TimeUnit enum
    public long time(TimeUnit unit) {
        return unit.convert(time(), TimeUnit.SECONDS);
    }
};
