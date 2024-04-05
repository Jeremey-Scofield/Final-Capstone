<template>
  <div id="capstone-app">
    <div id="header" class="header">
      <h1> MTG Card Collector</h1>
    
      <div id="login">
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
        <router-view />
      </div>
    </div>

    <div id="navBar" class="navBar">
      <p>I am the nav bar</p>
      <nav-bar />
    </div>

    <div id="mainContent" class="mainContent">
      <p>Main Content Area</p>
      <p>search bar</p>
      <p>random card</p>
      <p>sets</p>
      <p>user collections</p>
      <main-content />
    </div>

    <div id="ads" class="ads">
      <h3>Ads go here</h3>
      <sidebar-ads />
    </div>

    <div id="footer" class="footer">
      <bottom-footer />
    </div>

    
      
    
    
  </div>
</template>

<script>

import bottomFooter from "./components/bottomFooter.vue";
export default {
  components: {
    bottomFooter
  }

}

</script>

<style>
#header {
  grid-area: header;
  border-style: solid;
}

#navBar {
  grid-area: navbar;
  border-style: solid;
}

#mainContent {
  grid-area: mainContent;
  text-align: center;
  border-style: solid;
}

#ads {
  grid-area: ads;
  border-style: solid;
}

#footer {
  grid-area: footer;
  border-style: solid;
}

#capstone-app {
    display: grid;
    grid-template-columns: 1fr 4fr 1fr;
    row-gap: 20px;
    column-gap: 50px;
    align-items: center;
    grid-template-areas: 
        "header header header"
        "navbar mainContent ads"
        "footer footer footer";

}



</style>

