package roomescape.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import roomescape.payment.PaymentClient;
import roomescape.support.FakePaymentClient;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;

@TestConfiguration
public class TestConfig {

    @Bean
    public Clock clock() {
        Instant fixedInstant = Instant.parse("2024-04-08T00:00:00Z");
        ZoneId zone = ZoneOffset.UTC;

        return Clock.fixed(fixedInstant, zone);
    }

    @Primary
    @Bean
    public PaymentClient paymentClient() {
        return new FakePaymentClient();
    }
}
