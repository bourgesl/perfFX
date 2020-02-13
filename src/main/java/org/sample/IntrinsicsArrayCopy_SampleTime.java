package org.sample;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

@State(Scope.Thread)
@BenchmarkMode(Mode.SampleTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(1)
@Warmup(iterations = 5, time = 2, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
/**
 * Original code from:
 * https://github.com/oracle/graal/issues/963#issue-407371148
 */
public class IntrinsicsArrayCopy_SampleTime {

    static final long SEED = 1666133789L;

    static final int SIZE = 100_000;

    /* members */
    final int[] src = new int[SIZE];
    final int[] target = new int[SIZE];

    @Setup
    public void setup() {
        final Random r = new Random(SEED);
        for (int i = 0; i < SIZE; i++) {
            src[i] = r.nextInt(1000);
        }
    }

    public int[] manualArrayCopy() {
        // LBO: preallocation ALWAYS
        // int[] target = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            target[i] = src[i];
        }

        return target;
    }

    public int[] systemArrayCopy() {
        // LBO: preallocation ALWAYS
        // int[] target = new int[SIZE];
        System.arraycopy(src, 0, target, 0, SIZE);

        return target;
    }

    @Benchmark
    public int[] manual() {
        return manualArrayCopy();
    }

    @Benchmark
    public int[] system() {
        return systemArrayCopy();
    }
}
