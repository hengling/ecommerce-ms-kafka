<template>
    <div>
        <form @submit.stop.prevent="submit">
            <div class="row">
                <div class="col-md-4 order-md-2 mb-4">
                    <h4 class="d-flex justify-content-between align-items-center mb-3">
                        <span class="text-muted">Your cart</span>
                        <span class="badge badge-secondary badge-pill">3</span>
                    </h4>
                    <ul class="list-group mb-3">
                        <li class="list-group-item d-flex justify-content-between lh-condensed">
                            <div>
                                <h6 class="my-0">Notebook</h6>
                                <small class="text-muted">Notebook</small>
                            </div>
                            <span class="text-muted">R$7.500,00</span>
                            <input name="products" type="hidden" value="notebook">
                        </li>
                        <li class="list-group-item d-flex justify-content-between lh-condensed">
                            <div>
                                <h6 class="my-0">Mouse</h6>
                                <small class="text-muted">Mouse Gamer</small>
                            </div>
                            <span class="text-muted">R$235,00</span>
                            <input name="products" type="hidden" value="mouse">
                        </li>
                        <li class="list-group-item d-flex justify-content-between">
                            <span>Total (USD)</span>
                            <strong>R$7.735,00</strong>
                        </li>
                    </ul>
                </div>
                <div class="col-md-8 order-md-1">
                    <h4 class="mb-3">Endereço de cobrança</h4>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="firstName">Nome</label>
                            <input class="form-control" id="firstName" name="Nome" type="text" value=""
                                   v-model="checkout.firstName" v-validate="'required'">
                            <span v-show="errors.has('Nome')" class="small text-danger">
                                {{ errors.first('Nome') }}
                            </span>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="lastName">Sobrenome</label>
                            <input class="form-control" id="lastName" name="Sobrenome" type="text" value=""
                                   v-model="checkout.lastName" v-validate="'required'">
                            <span v-show="errors.has('Sobrenome')" class="small text-danger">
                                {{ errors.first('Sobrenome') }}
                            </span>
                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="username">Username</label>
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text">@</span>
                            </div>
                            <input class="form-control" id="username" name="Username" placeholder="Username" type="text"
                                   v-model="checkout.username" v-validate="'required'">
                        </div>
                        <span v-show="errors.has('Username')" class="small text-danger">
                            {{ errors.first('Username') }}
                        </span>
                    </div>

                    <div class="mb-3">
                        <label for="email">Email <span class="text-muted">(Optional)</span></label>
                        <input class="form-control" id="email" name="Email" placeholder="you@example.com" type="email"
                               v-model="checkout.email" v-validate="'email'">
                        <span v-show="errors.has('Email')" class="small text-danger">
                                {{ errors.first('Email') }}
                        </span>
                    </div>

                    <div class="mb-3">
                        <label for="address">Endereço</label>
                        <input class="form-control" id="address" name="Endereço" placeholder="Rua 7 de Setembro"
                               type="text"
                               v-model="checkout.address" v-validate="'required'">
                        <span v-show="errors.has('Endereço')" class="small text-danger">
                            {{ errors.first('Endereço') }}
                        </span>
                    </div>

                    <div class="mb-3">
                        <label for="complement">Complemento <span class="text-muted">(Optional)</span></label>
                        <input class="form-control" id="complement" name="complement" v-model="checkout.address2"
                               placeholder="Apartmento ou bloco" type="text">
                    </div>

                    <div class="row">
                        <div class="col-md-5 mb-3">
                            <label for="country">País</label>
                            <select class="custom-select d-block w-100" id="country" name="País"
                                    v-model="checkout.country" v-validate="'required'">
                                <option value="">País...</option>
                                <option>Brasil</option>
                                <option>Argentina</option>
                            </select>
                            <span v-show="errors.has('País')" class="small text-danger">
                                {{ errors.first('País') }}
                            </span>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="state">Estado</label>
                            <select class="custom-select d-block w-100" id="state" name="Estado"
                                    v-model="checkout.state" v-validate="'required'">
                                <option value="">Estado...</option>
                                <option>PA</option>
                                <option>RS</option>
                                <option>SC</option>
                                <option>SP</option>
                            </select>
                            <span v-show="errors.has('Estado')" class="small text-danger">
                                {{ errors.first('Estado') }}
                            </span>
                        </div>
                        <div class="col-md-3 mb-3">
                            <label for="cep">CEP</label>
                            <input class="form-control" id="cep" name="CEP" type="text"
                                   v-model="checkout.zipCode" v-validate="'required'">
                            <span v-show="errors.has('CEP')" class="small text-danger">
                                {{ errors.first('CEP') }}
                            </span>
                        </div>
                    </div>
                    <hr class="mb-4">
                    <div class="custom-control custom-checkbox">
                        <input class="custom-control-input" id="same-address" name="saveAddress" type="checkbox"
                               v-model="checkout.sameAddress">
                        <label class="custom-control-label" for="same-address">Endereço de entrega é o mesmo endereço de
                            cobrança</label>
                    </div>
                    <div class="custom-control custom-checkbox">
                        <input class="custom-control-input" id="save-info" name="saveInfo" type="checkbox"
                               v-model="checkout.saveInfo">
                        <label class="custom-control-label" for="save-info">Salva as informações para a próxima
                            compra</label>
                    </div>
                    <hr class="mb-4">

                    <h4 class="mb-3">Pagamento</h4>

                    <div class="d-block my-3">
                        <div class="custom-control custom-radio">
                            <input checked="" class="custom-control-input" id="credit" name="paymentMethod"
                                   v-model="checkout.paymentMethod"
                                   type="radio" value="CREDIT">
                            <label class="custom-control-label" for="credit">Cartão de crédito</label>
                        </div>
                        <div class="custom-control custom-radio">
                            <input class="custom-control-input" id="debit" name="paymentMethod"
                                   v-model="checkout.paymentMethod"
                                   type="radio" value="DEBIT">
                            <label class="custom-control-label" for="debit">Cartão de débito</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="cc-name">Nome Completo</label>
                            <input class="form-control" id="cc-name" name="Nome Completo" type="text"
                                   v-model="checkout.cardName" v-validate="'required'">
                            <small class="text-muted">Nome completo como impresso no cartão</small>
                            <span v-show="errors.has('Nome Completo')" class="small text-danger">
                                {{ errors.first('Nome Completo') }}
                            </span>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="cc-number">Número</label>
                            <input class="form-control" id="cc-number" name="Número" type="text"
                                   v-model="checkout.cardNumber" v-validate="'required'">
                            <span v-show="errors.has('Número')" class="small text-danger">
                                {{ errors.first('Número') }}
                            </span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-3 mb-3">
                            <label for="cc-expiration">Data de validade</label>
                            <input class="form-control" id="cc-expiration" name="Data de validade" type="text"
                                   v-model="checkout.cardDate" v-validate="'required'">
                            <span v-show="errors.has('Data de validade')" class="small text-danger">
                                {{ errors.first('Data de validade') }}
                            </span>
                        </div>
                        <div class="col-md-3 mb-3">
                            <label for="cc-cvv">CVV</label>
                            <input class="form-control" id="cc-cvv" name="CVV" type="text"
                                   v-model="checkout.cardCvv" v-validate="'required'">
                            <span v-show="errors.has('CVV')" class="small text-danger">
                                {{ errors.first('CVV') }}
                            </span>
                        </div>
                    </div>
                    <hr class="mb-4">
                    <button class="btn btn-primary btn-lg btn-block" type="submit">Comprar</button>
                </div>
            </div>
        </form>

        <footer class="my-5 pt-5 text-muted text-center text-small">
            <p class="mb-1">© 2017-2018 Company Name</p>
            <ul class="list-inline">
                <li class="list-inline-item"><a href="#">Privacy</a></li>
                <li class="list-inline-item"><a href="#">Terms</a></li>
                <li class="list-inline-item"><a href="#">Support</a></li>
            </ul>
        </footer>
    </div>
</template>

<script>
export default {
    name: 'CheckoutForm',
    data() {
        return {
            checkout: {}
        }
    },
    methods: {
        async submit() {
            const isValid = await this.$validator.validate()
            if (isValid) {
                this.$emit('submit', this.checkout)
            }
        }
    }
}
</script>