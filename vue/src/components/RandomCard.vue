<template>
    <div class="randomCard">
        <router-link v-bind:to="{name: 'RandomCard' }">
          <h1>Random Card:</h1>
          <h1>{{ card.name }}</h1>
          <!-- <img v-bind:src="card.image_uris.small"/> -->
        

        </router-link>
    </div>
</template>

<script>
import CardService from '../services/CardService';

export default {
    data() {
    return {
      card: { name: ''},
    
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

<style>

</style>