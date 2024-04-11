<template>
    <div class="randomCard" >
        <router-link v-bind:to="{name: 'RandomCard' }">
        <img v-bind:src="card.image_uris.small"/>
        <h1>Random Card Goes Here</h1>
        <h1>{{ card.name }}</h1>
    </router-link>
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
    
    CardService.random()
      .then(response => {
        this.card = response.data;
        
      });
  }
}

</script>

<style>

</style>