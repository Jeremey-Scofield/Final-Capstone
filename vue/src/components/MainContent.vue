<template>
    <div class="main">
        <div class="search">
           <search-bar/>
        </div>
        <div class="random">
          <random-card/>
        </div>
        
        <div class="collections">
        <view-collections />
        </div>

    </div>
</template>

<script>

import SearchBar from "../components/SearchBar.vue";
import RandomCard from "../components/RandomCard.vue";
import ViewCollections from "../components/ViewCollections.vue";

export default {
  components: {
        SearchBar,
        RandomCard,
        ViewCollections
  }

}

</script>

<style>

</style>