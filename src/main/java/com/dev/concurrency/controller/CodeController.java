package com.dev.concurrency.controller;

import com.dev.concurrency.common.CodeResponse;
import com.dev.concurrency.service.CodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/codes")
@RequiredArgsConstructor
public class CodeController {

    private final CodeService codeService;

    @GetMapping
    public CodeResponse generateCode() throws ExecutionException, InterruptedException {
        return new CodeResponse(codeService.generateCode().get());
    }

}
