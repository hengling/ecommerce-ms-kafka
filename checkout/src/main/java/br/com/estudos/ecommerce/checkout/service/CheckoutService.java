package br.com.estudos.ecommerce.checkout.service;

import br.com.estudos.ecommerce.checkout.entity.CheckoutEntity;
import br.com.estudos.ecommerce.checkout.resource.checkout.CheckoutRequest;

import java.util.Optional;

public interface CheckoutService {

    Optional<CheckoutEntity> create(CheckoutRequest request);

}
