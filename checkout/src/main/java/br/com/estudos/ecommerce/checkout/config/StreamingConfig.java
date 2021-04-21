package br.com.estudos.ecommerce.checkout.config;

import br.com.estudos.ecommerce.checkout.streaming.CheckoutCreatedSource;
import br.com.estudos.ecommerce.checkout.streaming.PaymentPaidSink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding({
        CheckoutCreatedSource.class,
        PaymentPaidSink.class
})
public class StreamingConfig {
}
