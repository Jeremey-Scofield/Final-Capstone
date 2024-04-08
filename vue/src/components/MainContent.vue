<template>
    <div>
        <search-bar/>
        <random-card/>
        <card-sets/>
        <view-collections/>

    </div>
</template>

<script>

import SearchBar from "../components/SearchBar.vue";
import RandomCard from "../components/RandomCard.vue";
import CardSets from "../components/CardSets.vue";
import ViewCollections from "../components/ViewCollections.vue";

export default {
  components: {
        SearchBar,
        RandomCard,
        CardSets,
        ViewCollections
  }

}

</script>

<style>

</style>