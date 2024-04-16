<template>
  <div id="collectionsContainer">
    <div class="publicCollections" v-bind:to="{ name: 'view-collections' }">

      <h1 id="publicTitle">Viewable Card Collections</h1>
      <div id="collectionResults" v-for="collection in collections" v-bind:key="collection.collectionId">
        <h2>View the {{ collection.collectionName }} collection from {{ collection.username }}</h2>
        <router-link v-bind:to="{ name: 'get-cards-in-collection' }">Link to cards in this collection</router-link>
        
      </div>
    </div>

    <div class="userCollections" v-bind:to="{ name: 'userName' }">
      <h1>{{ this.$store.state.user.username }}'s Collections</h1>
      <p>My Collection 1</p>
      <p>My Collection 2</p>
    </div>
  </div>
</template>

<script>
import CollectionService from '../services/CollectionService';



export default {
  props:
    [],
  components: {

  },
  data() {
    return {
      cardCollection: [],


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

    getCardsByCollectionsId(collectionId) {
      CollectionService.getCardsByCollectionsId(this.collections.collectionId)
        .then(response => {
          this.cardCollection = response.data;
        });
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
