<template>
    <div id="searchContainer">
        <div class="form-input">
            <label for="search">Search For A Card By Name: </label>
            <input type="text" id="search" v-model="searchString" v-on:change="search()" placeholder="search card name" />
        </div>

        <div class="search-results">
            <div class="results-cards" >
                <card-front v-for="cardFront in limitedList" v-bind:cardFront="cardFront" v-bind:key="cardFront.name" />
            </div>
        </div>
    </div>
</template> 

<script>
import CardService from '../services/CardService';
import CardFront from '../components/CardFront.vue';

export default {
    components: {
        CardFront
    },
    props:
        ['name', 'cards'],
    methods: {
        search() {
            if (this.searchString) {
                CardService.cardSearch(this.searchString)
                    .then(response => {
                        this.results = response.data;
                    });
            }
        },
        getCardsByUserId(userId){
            
        }
    },
    data() {
        return {
            maxCards: 5,
            searchString: '',
            results:
                { data: [] }
        }
    },
    computed: {
        limitedList() {
            return this.maxCards ? this.results.data.slice(0, this.maxCards) : this.results.data
        }
    },
};
</script>

<style scoped>
.form-input {
    margin-top: 25px;
    margin-bottom: 25px;
}
#searchContainer {
   
}
.search-results {
    display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
    
    
}
.results-cards {
    display: flex;
    
}
input {
    background: transparent;
    border: 2px solid rgb(167, 80, 53);
  border-radius: 4px;
  height: 35px;
  width: 250px;
}
</style>
