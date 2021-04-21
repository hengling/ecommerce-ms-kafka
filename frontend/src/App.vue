<template>
    <div id="app">
        <Checkout msg="Welcome to Your Vue.js App"/>
    </div>
</template>

<script>
import Checkout from './components/Checkout.vue'

export default {
    name: 'App',
    components: {
        Checkout
    }
}
</script>