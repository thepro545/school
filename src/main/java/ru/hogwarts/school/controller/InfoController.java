package ru.hogwarts.school.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RestController
@RequestMapping
public class InfoController {
    @Value("${server.port}")
    private Integer port;

    @GetMapping("/getPort")
    public Integer getPort() {
        return port;
    }

    @GetMapping("/getSum")
    public Integer getSum() {

        List<Integer> sum =  Stream.iterate(1, a -> a +1)
                .limit(10_000_000)
                .collect(Collectors.toList());

        long start = System.currentTimeMillis();
        int sum1 =  sum.stream()
               .parallel()
               .mapToInt(i -> i)
               .reduce(0, (a, b) -> a + b );
        return (int) (System.currentTimeMillis() - start);
    }

}
