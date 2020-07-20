package horace.velmont.springboot.demo51;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class AsyncFutureTest {
    @Test
    public void runAsync() throws Exception {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> sleep(1000));
        future.thenAccept(v -> log.info("then accept"));
        assertThat(future.isDone()).isFalse();
        Thread.sleep(1100);
    }

    @Test
    public void runAsync_addCallbackAfterComplete() throws Exception {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> sleep(1000));
        Thread.sleep(1100);
        assertThat(future.isDone()).isTrue();
        future.thenAccept(v -> log.info("thenAccept"));
    }

    @Test
    public void supplyAsync_addCallbackAfterComplete() throws Exception {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return "result";
        });
        Thread.sleep(1100);
        assertThat(future.isDone()).isTrue();
        assertThat(future.get()).isEqualTo("result");
        future.thenAccept(v -> log.info("thenAccept"));
    }

    private void sleep(long time) {
        try {
            log.info("sleep : {} ", time);
            Thread.sleep(time);
        } catch (InterruptedException ignored) {

        }
    }
}
