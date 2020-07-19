package horace.velmont.springboot.demo51;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;

import static org.assertj.core.api.Assertions.assertThat;

public class FutureTest {
    @Test
    public void completedFuture() throws Exception {
        CompletableFuture<String> future = CompletableFuture.completedFuture("test");
        assertThat(future.isDone()).isTrue();

        String result = future.get();
        assertThat(result).isEqualTo("test");
        assertThat(future.isCompletedExceptionally()).isFalse();
        assertThat(future.isDone()).isTrue();
    }

    @Test
    public void complete() throws Exception {
        CompletableFuture<String> future = new CompletableFuture<>();
        assertThat(future.isDone()).isFalse();
        future.complete("test");

        assertThat(future.isDone()).isTrue();
        String result = future.get();
        assertThat(result).isEqualTo("test");
        assertThat(future.isCompletedExceptionally()).isFalse();
        assertThat(future.isDone()).isTrue();
    }
}
