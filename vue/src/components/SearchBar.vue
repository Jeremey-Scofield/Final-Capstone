<template>
    <div id="searchContainer">
        <div class="form-input">
            <label for="search">Search For A Card By Name: </label>
            <input type="text" id="search" v-model="searchString" v-on:change="search()" placeholder="search card name" />
        </div>
        <div class="search-results">
            <div class="results-cards">
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

<style>
.form-input {
    margin-top: 25px;
    margin-bottom: 25px;
}
#searchContainer {
    border-style: dashed;
    border-color: rgb(253, 170, 45);
}
.search-results {
    display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
    
    
}
.results-cards {
    display: flex;
    
}

</style>
