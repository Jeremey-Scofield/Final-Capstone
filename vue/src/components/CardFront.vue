<template>
    <div class="cardFront" v-on:click="showCardDetails(true)">
        <h4 class="card-name">{{ cardFront.name }}</h4>
        <img class="card-image" v-bind:src="cardFront.image_uris.small" v-show="!showDetails" />
    </div>
    <div id="cardDetails" v-on:click="showCardDetails(false)" v-show="showDetails">
        <card-details v-bind:card="this.cardFront" />
    </div>

    <div class = "cardDeleteButton">
        <button v-on:click="pushCardToCollection">Add To Collection</button>
        <select v-model="selectedOption" :items="options">
            <option v-for="option in options" :key="option.id" :value="option.collectionId">
                {{ option.collectionName }} (ID: {{ option.collectionId }})
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
    data() {
        return {
            showDetails: false,
            options: [],
            collectionId: '',
        }
    },
    created() {
        this.getCollectionsByUserId();
    },
    props: ['cardFront'],
    methods: {
        showCardDetails(value) {
            this.showDetails = value;
        },
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
button {
    background-color: rgb(246, 220, 159);
}
select {
    background: transparent;
}
option {
    background: transparent;
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