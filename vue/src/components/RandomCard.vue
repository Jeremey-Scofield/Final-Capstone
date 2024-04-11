<template>
  <div id="randomCard">
    <router-link v-bind:to="{ name: 'RandomCard' }">
      <div id="cardPic">
        <img v-bind:src="card.image_uris.small" />
      </div>
      <div id="cardTitle">
        <h1>{{ card.name }}</h1>
      </div>

      <div id="cardDetails">
        <card-details v-bind:card="this.card" />
      </div>
      
    </router-link>

  </div>
</template>

<script>
import CardService from '../services/CardService';
import CardDetails from '../components/CardDetails.vue';


export default {
components: {
  CardDetails,
},
  data() {
    return {
      card: {
        name: '',
        image_uris: {
          small: '',
          normal: '',
          large: ''
        }
      },

    };
  },
  created() {

    CardService.random()
      .then(response => {
        this.card = response.data;

      });
  }

}

</script>

<style scoped>
#randomCard {
  display: grid;
  grid-template-columns: 2fr 2fr;
  grid-template-areas: 
    "cardPic cardName"
    "cardPic cardDetails";
    
}
#cardPic {
  grid-area: cardPic;
}
#cardTitle {
  grid-area: cardName;
}
#cardDetails {
  grid-area: cardDetails;
}

</style>