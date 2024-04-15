<template>
  <div id="collectionsContainer">
    <div class="publicCollections" v-bind:to="{ name: 'view-collections' }">
      <h1 id="publicTitle">Viewable Card Collections</h1>
      <div id="collectionResults" v-for="collection in collections" v-bind:key="collection.collectionId">
        <h2 v-show="!showCards">View the {{ collection.collectionName }} collection from userId {{ collection.userId }}</h2>
      </div>

      <div id="cards" v-show="showCards">
        <!-- <card-front /> -->

      </div>

    </div>



    <div class="userCollections">
      <h1>**Logged-In User's Name's** collections</h1>
      <p>My Collection 1</p>
      <p>My Collection 2</p>
    </div>



  </div>
</template>

<script>
import CollectionService from '../services/CollectionService';
import CardFront from '../components/CardFront.vue';

export default {
  components: {
    CardFront
  },

  data() {
    return {
      showCards: false,
      collections:
        [{}]
    }
  },
  created() {

    CollectionService.getAllCollections()
      .then(response => {
        this.collections = response.data;

      });
  },
  methods: {
    showCollectionCards(value) {
      this.showCards = value;
    }
  }

}

</script>

<style scoped>
.collectionsContainer {
  border-style: dashed;
  border-color: rgb(252, 34, 26);
}
</style>