<template>
    <div class="cardFront" v-on:click="showCardDetails(true)">
        <h4 class="card-name">{{ cardFront.name }}</h4>
        <img class="card-image" v-bind:src="cardFront.image_uris.small" v-show="!showDetails" />
    </div>
    <div id="cardDetails" v-on:click="showCardDetails(false)" v-show="showDetails">
        <card-details v-bind:card="this.cardFront" />
    </div>

<<<<<<< HEAD
  <div id="toggleButton">
    <button v-on:click="toggleDropdown">Add To Collection</button>
    <select v-model="selectedOption" :items="options" v-if="showCardDetails" v-on:input="addToCollection">
      <option v-for="option in options" :key="option">
        {{ option }}
      </option>
    </select>
  </div>
=======
    <div>
        <button v-on:click="pushCardToCollection">Add To Collection</button>
        <select v-model="selectedOption" :items="options">
            <option v-for="option in options" :key="option.id" :value="option.collectionId">
                {{ option.collectionName }} (ID: {{ option.collectionId }})
            </option>
        </select>
    </div>

    
>>>>>>> 4720d9642ba75f6bb1c6178ac4c6f9a6038559f6
</template>

<script>
import axios from 'axios';
import CardDetails from '../components/CardDetails.vue';
import axios from 'axios';

export default {
    components: {
        CardDetails
    },
<<<<<<< HEAD
    created() {
    this.getCollectionsByUserId();
=======
    data() {
        return {
            showDetails: false,
            options: [],
            collectionId: '',
        }
    },
    created() {
        this.getCollectionsByUserId();
>>>>>>> 4720d9642ba75f6bb1c6178ac4c6f9a6038559f6
    },
    props: ['cardFront'],
    methods: {
        showCardDetails(value) {
            this.showDetails = value;
        },
<<<<<<< HEAD
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
=======
        getCollectionsByUserId() {
            axios.get(`http://localhost:9000/collections/user/${this.$store.state.user.id}`)
                .then(response => {
                    this.options = response.data;
                })
                .catch(error => {
                    console.error("Error fetching collections:", error.message);
                });
        },
        pushCardToCollection() {
            axios.post(`http://localhost:9000/collections/cards/new`, {
                collectionId: this.selectedOption, // Access collection ID from selected option
                cardId: this.cardFront.id
            })
>>>>>>> 4720d9642ba75f6bb1c6178ac4c6f9a6038559f6
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