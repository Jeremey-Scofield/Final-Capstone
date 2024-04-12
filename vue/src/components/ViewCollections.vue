<template>
    <router-link v-bind:to="{ name: 'view-collections' }"></router-link>


    <div class="publicCollections">
        <h1>View Public Collections</h1>
        <!-- <magic-card v-for="card in collection" v-bind:="card" v-bind:key="card_id" /> -->
        <p>Collection 1</p>
        <p>Collection 2</p>
        <p>Collection 3</p>
        <p>Collection 4</p>
     <div class="myCollections" v-if="$store.state.token != ''">
        <h1>MY collections</h1>
         <p>My Collection 1</p>
         <p>My Collection 2</p>
    </div>

    </div>



</template>

<script>
import CollectionService from '../services/CollectionService';
import MagicCard from '../components/MagicCard.vue';
export default {

components: {
    MagicCard
},

data() {
    return {
  collection: { 
    cards: ['card'],
    collection_name: '',
    collection_id: ''

    }
  }
},
created() {

    CollectionService.getAllCollections()
        .then(response => {
        this.collection = response.data;

      });
}

}

</script>

<style scoped></style>