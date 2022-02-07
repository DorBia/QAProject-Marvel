package com.qa.marvelqa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MarvelApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void applicationContextTest() {
        MarvelQaApplication.main(new String[]{});
    }
}
