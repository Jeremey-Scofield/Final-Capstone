<template>
  <div id="collectionsContainer">
    <div class="userCollections">
      <h1>{{ this.$store.state.user.username }}'s Collections</h1>

      <button @click="getCollectionsByUserId">Get My Collections</button>

      <p v-if="newCollections.length > 0">
        Your Collections:
      <ul>
        <button v-for="collection in newCollections" :key="collection.collectionId" class="collection-button"
          @click="getCollectionCards(collection.collectionId)">
          {{ collection.collectionName }}
        </button>
      </ul>
      </p>
      <p v-else-if="this.$store.state.user"> No collections found yet.
      </p>
      <p v-else> Please log in to see your collections.
      </p>
      <div v-if="selectedCollection">
        <h2>Cards in {{ selectedCollection.collectionId }}</h2>
        <div v-if="selectedCollection.cards && selectedCollection.cards.length > 0">
          <div v-for="(card, index) in selectedCollection.cards" :key="card.id">
            <img :src="imageList[index]" alt="Card Image" onError="this.src='placeholder.png'">
          </div>
        </div>
        <p v-else>This collection has no cards yet.</p>
      </div>
    </div>
  </div>
</template>

<script>
import CollectionService from '../services/CollectionService';
import axios from 'axios';

export default {
  props: [],
  components: {},
  data() {
    return {
      newCollections: [],
      selectedCollection: null,
      cardInformation: {},
      imageList: [],
    };
  },
  created() {
    this.getCollectionsByUserId();
  },
  methods: {
    getCollectionsByUserId() {
      axios.get(`http://localhost:9000/collections/user/${this.$store.state.user.id}`)
        .then(response => {
          this.newCollections = response.data;
        })
        .catch(error => {
          console.error("Error fetching collections:", error.message);
        });
    },
    getCollectionCards(collectionId) {
      axios.get(`http://localhost:9000/collections/${collectionId}/cards`)
        .then(response => {
          this.selectedCollection = {
            collectionId,
            collectionName: response.data.collectionName,
            // Assuming response.data is an array of card objects
            cards: response.data,
          };
          this.imageList = []

          response.data.forEach((card) => {

            this.getCardImageUrl(card).then((imageUrl) => {
              this.imageList.push(imageUrl);
            })
          })

        })
    }
    ,
    getCardFromCardId(cardId) {
      return axios.get(`https://api.scryfall.com/cards/${cardId}`)
        .then(response => response.data.image_uris.normal); // Assuming normal-sized image
    },
    getCardImageUrl(cardId) {
      return axios
        .get(`https://api.scryfall.com/cards/${cardId}`)
        .then((response) => response.data.image_uris.small) // Assuming normal-sized image
        .catch(() => {
          return 'placeholder.png'; // Return placeholder image on error
        });
    }

  },
};
</script>

<style scoped>
/* ... your styles ... */
</style>