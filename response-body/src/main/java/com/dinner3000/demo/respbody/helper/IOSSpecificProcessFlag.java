package com.dinner3000.demo.respbody.helper;

public class IOSSpecificProcessFlag {
    private static ThreadLocal<Boolean> flag = new ThreadLocal<Boolean>();

    public static boolean get() {
        return flag.get();
    }

    public static void set(boolean f) {
        flag.set(f);
    }

    public static void remove(){
        flag.remove();
    }
}
