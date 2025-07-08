package com.test.memoryleak;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MemoryLeakApp {

    private static final List<byte[]> memoryLeakList = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("App iniciada. PID: " + ProcessHandle.current().pid());
        while (true) {
            // Agrega 1MB cada segundo
            memoryLeakList.add(new byte[1024 * 1024]);
            //System.out.println("Agregando bytes a memoryLeakList, size: " + memoryLeakList.size());
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
