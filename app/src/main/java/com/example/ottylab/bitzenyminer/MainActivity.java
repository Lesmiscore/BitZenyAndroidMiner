package com.example.ottylab.bitzenyminer;

import java.util.HashSet;
import java.util.Set;

public class MainActivity {
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private static Set<OnNotifiedListener> notifiedListeners = new HashSet<>();

    public static void notified(String message) {
        for (OnNotifiedListener listener : notifiedListeners) {
            listener.onNotified(message);
        }
    }

    public static void addListener(OnNotifiedListener listener) {
        notifiedListeners.add(listener);
    }

    interface OnNotifiedListener {
        void onNotified(String message);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native boolean isMiningRunning();

    public native int startMining(String url, String user, String password, int n_threads);

    public native int startBenchmark(int n_threads);

    public native int stopMining();
}
