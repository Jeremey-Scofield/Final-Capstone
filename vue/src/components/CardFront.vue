<template>
    <div class="cardFront" v-on:click="showCardDetails(true)">
        <h4 class="card-name">{{ cardFront.name }}</h4>
        <img class="card-image" v-bind:src="cardFront.image_uris.small" v-show="!showDetails" />

    </div>
    <div id="cardDetails" v-on:click="showCardDetails(false)" v-show="showDetails">
        <card-details v-bind:card="this.cardFront" />
    </div>

  <div id="toggleButton">
    <button v-on:click="toggleDropdown">Add To Collection</button>
    <select v-model="selectedOption" :items="options" v-if="showCardDetails" v-on:input="addToCollection">
      <option v-for="option in options" :key="option">
        {{ option }}
      </option>
    </select>
  </div>
</template>
  
<script>
import axios from 'axios';
import CardDetails from '../components/CardDetails.vue';

export default {
    components: {
        CardDetails
    },
    created() {
    this.getCollectionsByUserId();
    },
    props: ['cardFront'],
    methods: {
        showCardDetails(value) {
            this.showDetails = value;
        },
        getCollectionsByUserId(userId) {
            axios.get(`http://localhost/9000/collections/user/${this.$store.state.user.id}`)
                .then(response => {
                    this.options = response.data;
            })
        },
        addToCollection() {
      this.addToCollection.push(this.selectedOption);

    },
    },
    data() {
        return {
            showDetails: false,
            options: []
        }
    }
}
</script>

  
<style scoped>
.cardFront {


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