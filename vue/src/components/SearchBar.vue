<template>
     <!-- <router-link v-bind:to="{ name: 'CardSearch' , params: {searchString}}"></router-link>  -->
        <div class="form-input">
            <label for="search">Search For A Card By Name: </label>
            <input type="text" id="search" v-model="searchString" placeholder="search card name" />
            <p>Search String Is {{ searchString }}</p>
        </div>
        <!-- <div class="search-results" v-bind:to="{ name: 'CardSearch' , params: {searchString}}">
            <div class="card" >
                 <h3>{{ results.data[0].name }}</h3> -->
                    <h3> {{results}} </h3>
                <!-- TODO CURRENTLY BROKEN-->


                
                <!-- <img v-bind:src="card.picture" class="picture" /> 
            </div>
        </div> -->
 
</template> 

<script>
import CardService from '../services/CardService';
import CardDetails from '../components/CardDetails.vue';
export default {
    props: 
      
        ['name', 'cards'],
    methods: {
        viewCardDetails(card) {
            this.$router.push({ name: 'CardDetails', params: { cardId: card.id } });
        },
        search() {
            if (this.searchString) {
                CardService.cardSearch(this.searchString)
                    .then(response => {
                        this.results = response.data;
                    });
            }
        }
        
    },
    data() {
        return {
            searchString: '',
            results:
            {name: ''}
        }
    },
     created() {

    // CardService.cardSearch()
    //   .then(response => {
    //       this.results = response.data;

    //   });
  },
};

</script>

<style>
.form-input {
    margin-top: 25px;
    margin-bottom: 25px;
}
</style>