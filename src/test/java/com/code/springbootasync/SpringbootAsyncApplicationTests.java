package com.code.springbootasync;

import com.code.springbootasync.async.AsyncTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAsyncApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootAsyncApplicationTests.class);

    @Autowired
    private AsyncTask asyncTask;

    @Test
    public void testAsync() throws InterruptedException, ExecutionException {

        asyncTask.dealNoReturnTask();

        Future<String> f = asyncTask.dealHaveReturnTask(1);

        LOGGER.info("主线程执行finished");

        LOGGER.info(f.get());
        assertThat(f.get(), is("success:" + 1));

        asyncTask.testExpection();
    }
}
