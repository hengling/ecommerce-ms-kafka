package br.com.estudos.ecommerce.checkout.service;

import br.com.estudos.ecommerce.checkout.entity.CheckoutEntity;
import br.com.estudos.ecommerce.checkout.event.CheckoutCreatedEvent;
import br.com.estudos.ecommerce.checkout.repository.CheckoutRepository;
import br.com.estudos.ecommerce.checkout.resource.checkout.CheckoutRequest;
import br.com.estudos.ecommerce.checkout.streaming.CheckoutCreatedSource;
import lombok.RequiredArgsConstructor;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final CheckoutRepository checkoutRepository;
    private final CheckoutCreatedSource checkoutCreatedSource;

    @Override
    public Optional<CheckoutEntity> create(CheckoutRequest request) {
        final CheckoutEntity checkoutEntity = CheckoutEntity.builder()
                .code(UUID.randomUUID().toString())
                .status(CheckoutEntity.Status.CREATED)
                .build();

        final CheckoutEntity savedCheckout = checkoutRepository.save(checkoutEntity);

        final CheckoutCreatedEvent checkoutCreatedEvent = CheckoutCreatedEvent.newBuilder()
                .setCheckoutCode(savedCheckout.getCode())
                .setStatus(savedCheckout.getStatus().name())
                .build();

        checkoutCreatedSource.output().send(MessageBuilder.withPayload(checkoutCreatedEvent).build());

        return Optional.of(savedCheckout);
    }
}
