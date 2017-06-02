package org.bop.treehole.support.duration;

import lombok.Getter;

import java.util.concurrent.TimeUnit;

/**
 * A simple timer for record time duration
 */
public class Timer {

    private static final long INITIAL_TIME = 0L;

    @Getter
    private long startTime = SystemClock.now();

    @Getter
    private long endTime = INITIAL_TIME;

    private Timer() {
        // no construct
    }

    public static Timer start() {
        return new Timer();
    }

    public long stop() {
        endTime = SystemClock.now();
        return endTime;
    }

    public long getTotalTime() {
        if (endTime == INITIAL_TIME) {
            stop();
        }
        return endTime - startTime;
    }

    public boolean isExpired(long expiredTime, TimeUnit timeUnit) {
        stop();
        return getTotalTime() > timeUnit.toMillis(expiredTime);
    }

    public boolean isNotExpired(long expiredTime, TimeUnit timeUnit) {
        return !isExpired(expiredTime, timeUnit);
    }

    @Override
    public String toString() {
        if (endTime == INITIAL_TIME) {
            stop();
        }
        return String.format("%d", getTotalTime());
    }

    public String formattedStartTime() {
        return formatTimestamp(startTime);
    }

    public String formattedEndTime() {
        if (endTime == INITIAL_TIME) {
            stop();
        }
        return formatTimestamp(endTime);
    }

    private String formatTimestamp(long timestamp) {
        return String.format("%1$tY-%1$tb-%1$td %1$tT %tZ", timestamp);
    }
}
