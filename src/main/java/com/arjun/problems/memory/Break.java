package com.arjun.problems.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arjuns on 31/5/17.
 */
public class Break {
    public static void main(String[] args) {
        System.out.println("Free Memory" + Runtime.getRuntime().totalMemory());
        Pipe pipe = new Pipe();
        pipe.setLeak(new Leak(null));
        System.out.println(pipe);
        List<Pipe> pipeList = new ArrayList<>();
        while (true) {
            try {
                pipeList.add(pipe.copy());
                System.out.println(pipe);
                System.out.println("Free Memory " + Runtime.getRuntime().freeMemory());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Pipe {
        private Leak leak;
        private Long[] longgg = new Long[10000000];

        public Pipe() {
        }

        public void setLeak(Leak leak) {
            this.leak = leak;
        }

        public Pipe copy() throws CloneNotSupportedException {
            Pipe copy = new Pipe();
            copy.leak = new Leak(leak);
            return copy;
        }
    }

    static class Leak {
        private Leak leak;

        Leak(Leak leak) {
            this.leak = leak;
        }
    }
}
