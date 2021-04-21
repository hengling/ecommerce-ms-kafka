package br.com.estudos.ecommerce.checkout.listener;

import br.com.estudos.ecommerce.checkout.entity.CheckoutEntity;
import br.com.estudos.ecommerce.checkout.repository.CheckoutRepository;
import br.com.estudos.ecommerce.checkout.streaming.PaymentPaidSink;
import br.com.estudos.ecommerce.payment.event.PaymentCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentPaidListener {

    private final CheckoutRepository checkoutRepository;

    @StreamListener(PaymentPaidSink.INPUT)
    public void handler(PaymentCreatedEvent event) {
         final CheckoutEntity checkoutEntity = checkoutRepository.findByCode(event.getCheckoutCode()).orElseThrow();
         checkoutEntity.setStatus(CheckoutEntity.Status.APPROVED);

         checkoutRepository.save(checkoutEntity);
    }
}
