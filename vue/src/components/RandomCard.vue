<template>
  <div id="randomCard">
    <div id="title">
      <h1>Random Card:</h1>
    </div>
    <div id="cardPic" v-on:click="showCardDetails(true)">
      <img
        v-bind:src="card.image_uris.small"
        v-bind:alt="card.name"
        v-bind:to="{ name: 'RandomCard' }"
      />
    </div>
    <div id="cardTitle">
      <h1>{{ card.name }}</h1>
    </div>

    <div id="cardDetails" v-show="showDetails">
      <card-details v-bind:card="this.card" />
    </div>
  </div>
  <div id="toggleButton">
    <button v-on:click="toggleDropdown">Add To Collection</button>
    <select v-model="selectedOption" :items="options" v-if="showCollection" v-on:input="addToCollection">
      <option v-for="option in options" :key="option">
        {{ card }}
      </option>
    </select>
  </div>
</template>

<script>
import CardService from "../services/CardService";
import CardDetails from "../components/CardDetails.vue";
import CollectionService from "../services/CollectionService";

export default {
  components: {
    CardDetails,
  },
  data() {
    return {
      showDetails: false,
      card: {
        name: "",
        image_uris: {
          small: "",
          normal: "",
          large: "",
        },
      },
      addedCard: {
        collectionId: "",
        cardId: "",
      },
      showCollection: false,
      selectedOption: null,
      options: ["My Collection"],
    };
  },
  created() {
    CardService.random().then((response) => {
      this.card = response.data;
    });
    CollectionService.addCardToCollection().then((response) => {
      this.addedCard = response.data;
    });
  },
  methods: {
    showCardDetails(value) {
      this.showDetails = value;
    },

    toggleDropdown() {
      this.showCollection = !this.showCollection;
    },
    addToCollection() {
      this.addToCollection.push(this.selectedOption);
      
    }
  },
};
</script>

<style scoped>
#randomCard {
  border-style: dashed;
  border-color: aqua;

  display: grid;
  grid-template-columns: 1fr 2fr;
  grid-template-areas:
    "title title"
    "cardName cardDetails"
    "cardPic cardDetails";
}
#cardPic {
  grid-area: cardPic;
  display: flex;
  flex-direction: column;
  padding: 0;
  margin: 0;
}
#cardTitle {
  grid-area: cardName;
  padding: 0;
  margin: 0;
  font-size: 1.2em;
}
#title {
  grid-area: title;
  align-items: start;
  justify-items: start;
}
#cardTitle > h1 {
  font-size: 1.2em;
}
#cardDetails {
  grid-area: cardDetails;
}
#title {
  font-size: 1.25em;

  padding: 0;
  margin: 0;
}
</style>
