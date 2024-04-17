<template>
  <div class="headContainer">
    <div id="title">
      <h1> Magic: The Gathering Slytherin Card Collector</h1>
    </div>

    <div id="login">
      <div id="links">
        <router-link v-bind:to="{ name: 'home' }">Home | </router-link>

        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </div>

      <div id="register">
        <router-view />
      </div>
    </div>
  </div>
</template>

<script>

</script>

<style scoped>
.headContainer {
  display: grid;
  
  grid-auto-columns: 1fr;
  grid-template-areas: 
    "title"
    "login";
}
h1{
  font-size: 2.5em;
}
#title {
  grid-area: title;
  place-self: center;
  color: rgb(54, 104, 175);
}

#links {
  grid-area: links;

}

#register {
  grid-area: register;
  
}
#login {
  display: grid;
  grid-area: login;
  grid-auto-columns: 1fr 4fr;
  grid-template-areas: 
    "links register";
}
</style>