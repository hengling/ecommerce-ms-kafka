<template>
    <div class="container">
        <div class="row mt-3">
            <div class="col-md-12">
                <h1>Checkout realizado com sucesso!</h1>
                <span>Código do checkout: {{ checkoutCode }}</span>
            </div>
        </div>
        <div class="row mt-5">
            <div class="col-md-12">
                <button class="btn btn-primary" @click="novoCheckout">
                    Novo checkout
                </button>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'CheckoutSuccess',
    props: {
        checkoutCode: {
            required: true,
            type: String
        }
    },
    methods: {
        novoCheckout() {
            this.$emit('novoCheckout')
        }
    }
}
</script>