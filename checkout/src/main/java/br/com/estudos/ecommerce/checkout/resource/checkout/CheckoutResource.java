package br.com.estudos.ecommerce.checkout.resource.checkout;

import br.com.estudos.ecommerce.checkout.entity.CheckoutEntity;
import br.com.estudos.ecommerce.checkout.service.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/checkout")
@RequiredArgsConstructor
public class CheckoutResource {

    private final CheckoutService checkoutService;

    @PostMapping
    @CrossOrigin(origins = "http://localhost:8083")
    public ResponseEntity<CheckoutResponse> create(CheckoutRequest checkoutRequest) {
        final CheckoutEntity checkoutEntity = checkoutService.create(checkoutRequest)
                .orElseThrow();

        final CheckoutResponse checkoutResponse = CheckoutResponse.builder()
                .code(checkoutEntity.getCode())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(checkoutResponse);
    }
}