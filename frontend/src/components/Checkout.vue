<template>
    <div class="checkout container">
        <CheckoutSuccess :checkout-code="checkoutCode" @novoCheckout="novoCheckout" v-if="submitted"/>
        <CheckoutForm @submit="submitCheckout" v-else/>
    </div>
</template>

<script>
import axios from 'axios'
import CheckoutForm from '@/components/CheckoutForm'
import CheckoutSuccess from '@/components/CheckoutSuccess'

export default {
    name: 'Checkout',
    components: {CheckoutSuccess, CheckoutForm},
    data() {
        return {
            submitted: false,
            checkoutCode: ''
        }
    },
    methods: {
        async submitCheckout(checkout) {
            const response = await axios.post('http://localhost:8080/v1/checkout/', checkout)
            if (response.status === 201) {
                this.checkoutCode = response.data.code
                this.submitted = true
            }
        },
        novoCheckout() {
            this.submitted = false
        }
    }
}
</script>