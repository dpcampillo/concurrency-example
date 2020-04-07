package com.dev.concurrency.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class CodeService {

    private AtomicInteger atomicInteger = new AtomicInteger();

    private final ExecutorService executorService;

    public Future<String> generateCode() {
        return executorService.submit(() -> {
            Thread.sleep(5000);
            return "CODE-" + atomicInteger.addAndGet(1);
        });
    }

}
