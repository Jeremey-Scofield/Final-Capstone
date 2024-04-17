<template>
  <div id="collectionsContainer">
    <div class="publicCollections" v-bind:to="{ name: 'view-collections' }">

      <h1 id="publicTitle">Viewable Card Collections</h1>
      <div id="collectionResults" v-for="collection in collections" v-bind:key="collection.collectionId">
        <h2 v-on:click="getCardsByCollectionsId(collection.collectionId)">View the {{ collection.collectionName }} collection from {{ collection.username }}</h2>
        
        <div id="cardResults" v-for="collectionId in collection" v-bind:key="collectionId" >
        <card-front v-for="cardFront in cardCollection" v-bind:cardFront="cardFront" v-bind:key="cardFront.name" />
        {{ collection.collectionId }}

      </div>
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
      CollectionService.getCardsByCollectionsId(collectionId.collectionId)
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
