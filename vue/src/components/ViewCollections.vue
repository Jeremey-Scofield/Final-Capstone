<template>
  <div id="collectionsContainer">
    <div class="publicCollections" v-bind:to="{ name: 'view-collections' }">
<<<<<<< HEAD
      <h1 id="publicTitle">Viewable Card Collections</h1>
      <div id="collectionResults" v-for="collection in collections" v-bind:key="collection.collectionId">
        <h2 v-show="!showCards"> View the {{ collection.collectionName }} collection from userId {{ collection.username }}</h2>
      </div>

      <div id="cards" v-show="showCards">
        </div>
=======
      <div class="moreCollections" v-bind:to="{ name: 'userName' }">
        <h1 id="publicTitle">Viewable Card Collections</h1>
        <div id="collectionResults" v-for="collection in collections" v-bind:key="collection.collectionId">
          <h2 v-show="!showCards">View the {{ collection.collectionName }} collection </h2>
          <!-- <h2 v-bind="getUserName(collection.userId)">from user {{ user.username }}</h2> -->
        </div>

        <div id="cards" v-show="showCards">
          <!-- <card-front /> -->
          <!-- <card-front v-for="cardFront in cards" v-bind:cardFront="cardFront" v-bind:key="cardFront.name" /> -->

        </div>
      </div>
>>>>>>> a927845f7de7a6a7a024120e7e4824245e9bd7b5
    </div>

    <div class="userCollections" v-bind:to="{ name: 'userName' }">
      <h1>{{ this.$store.state.user.username }}'s Collections</h1>
      <p>My Collection 1</p>
      <p>My Collection 2</p>
    </div>
  </div>
</template>

<<<<<<< HEAD
  <script>
  import CollectionService from '../services/CollectionService';
  import CardFront from '../components/CardFront.vue';
  import AuthService from '../services/AuthService';

  export default {
    components: {
      CardFront
    },

    data() {
      return {
        // userId: collection.userId,
        user: {},
        showCards: false,
        collections:
          [{}]
      }
    },
    created() {

      CollectionService.getAllCollections()
        .then(response => {
          this.collections = response.data;

        })
    },
    methods: {
      showCollectionCards(value) {
        this.showCards = value;
      },
      getUserById(userId) {
      AuthService.getUserbyId(userId) // Assuming AuthService provides getUserbyId
        .then(response => {
          this.user = response.data;
        })
        .catch(error => {
          console.error('Error fetching user:', error);
        });
    }
    }
=======
<script>
import CollectionService from '../services/CollectionService';
import CardFront from '../components/CardFront.vue';
import AuthService from '../services/AuthService';

export default {
  components: {
    CardFront
  },

  data() {
    return {
     
      user: {},
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
  },
  getUserName(userId) {
    AuthService.getUserbyId(this.collections.userId)
      .then(response => {
        this.user = response.data;
      });
  }
>>>>>>> a927845f7de7a6a7a024120e7e4824245e9bd7b5

  }

  </script>

  <style scoped>
  .collectionsContainer {
    border-style: dashed;
    border-color: rgb(252, 34, 26);
  }
  </style>