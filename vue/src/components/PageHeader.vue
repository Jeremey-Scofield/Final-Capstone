<template>
    <div class="nav">
         <h1> MTG Card Collector</h1>
      <div id="login">
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
        <router-view />
      </div>
    </div>
</template>

<script>

</script>

<style>
.nav {
  display: flex;
}
</style>