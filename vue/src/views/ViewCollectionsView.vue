<template>
    <div>
        <p>Cards in a collection will show up here</p>
        <card-front v-for="cardFront in limitedList" v-bind:cardFront="cardFront" v-bind:key="cardFront.name" />
    </div>
</template>

<script>
import CardFront from '../components/CardFront.vue';
import CollectionService from '../services/CollectionService';

export default {
    components: {
        CardFront
    },
    created () {
        CollectionService.getCardsByCollectionsId(this.collectionId)
                    .then(response => {
                        this.cards = response.data;
                    });
    }
}
</script>

<style scoped>

</style>