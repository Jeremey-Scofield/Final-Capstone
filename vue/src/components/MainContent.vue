<template>
    <div class="main">
        <div class="search">
           <search-bar/>
        </div>
        <div class="random">
          <random-card/>
        </div>
        <card-sets/>
        <view-collections />

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