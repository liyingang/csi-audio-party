package com.jit.csi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.jit.csi.mapper")
public class CsiAudioPartyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsiAudioPartyApplication.class, args);
    }

}
