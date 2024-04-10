<template>
      
        <div class="form-input">
            <label for="search">Search For A Card By Name: </label>
            <input type="text" id="search" v-model="search.card" />
        </div>
        <div class="search-result-cards">
            <div class="card" v-for="card in cards" v-bind:key="card.id" v-on:click="viewCardDetails(card)">
                <h3>{{ card.name }}</h3>
                <img v-bind:src="card.picture" class="picture" />
            </div>
        </div>
 
</template>

<script>
export default {
    props: ['name', 'cards'],
    methods: {
        viewCardDetails(card) {
            this.$router.push({ name: 'CardDetails', params: { cardId: card.id } });
        }
    },
    data() {
        return {
            search:
            {cardName: ''}
        }
    }
};

</script>

<style>
.form-input {
    margin-top: 25px;
    margin-bottom: 25px;
}
</style>