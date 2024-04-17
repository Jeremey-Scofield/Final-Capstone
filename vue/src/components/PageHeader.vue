<template>
    <div class="nav">
         <h1> Magic: The Gathering Slytherin Card Collector</h1>
      <div id="login">
        <router-link v-bind:to="{ name: 'home' }">Home | </router-link>
        
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
        <router-view/>
        
      </div>
    </div>
</template>

<script>

</script>

<style scoped>
.nav {
  display: flex;
}
h1 {
  padding-right: 25px;
}
</style>