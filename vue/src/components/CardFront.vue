<template>
    <div class="cardFront" v-on:click="showCardDetails(true)">
        <h4 class="card-name">{{ cardFront.name }}</h4>
        <img class="card-image" v-bind:src="cardFront.image_uris.small" v-show="!showDetails" />

    </div>
    <div id="cardDetails" v-on:click="showCardDetails(false)" v-show="showDetails">
        <card-details v-bind:card="this.cardFront" />
    </div>
</template>
  
<script>
import CardDetails from '../components/CardDetails.vue';

export default {
    components: {
        CardDetails
    },
    props: ['cardFront'],
    methods: {
        showCardDetails(value) {
            this.showDetails = value;
        }
    },
    data() {
        return {


            showDetails: false
        }
    }
}
</script>

  
<style>
.cardFront {
    border-style: solid;
    border-color: rgb(236, 34, 135);

    margin: 2px;
    display: grid;
    grid-template-rows: 0.2fr 1fr;
    grid-template-areas:
        "cardName"
        "cardImg";
    grid-auto-columns: minmax(auto, 200px);
}

.card-image {
    grid-area: cardImg;
    margin-left: auto;
    margin-right: auto;
}

.card-name {
    height: 5vh;
    text-align: center;
    grid-area: cardName;
}
</style>