<template>
    <div class="randomCard">
        <router-link v-bind:to="{name: 'RandomCard' }">
<<<<<<< HEAD
          <h1>Random Card:</h1>
          <h1>{{ card.name }}</h1>
          <!-- <img v-bind:src="card.image_uris.small"/> -->
        

        </router-link>
=======
        <img v-bind:src="card.image_uris.small"/>
        <h1>Random Card Goes Here</h1>
        <h1>{{ card.name }}</h1>
    </router-link>
>>>>>>> b653d6c0da73e5383efb0eb89c100c79f7aa49fc
    </div>
</template>

<script>
import CardService from '../services/CardService';

export default {
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
<<<<<<< HEAD
      
=======
    
>>>>>>> b653d6c0da73e5383efb0eb89c100c79f7aa49fc
    CardService.random()
      .then(response => {
        this.card = response.data;
        
      });
  }
}

</script>

<style>

</style>