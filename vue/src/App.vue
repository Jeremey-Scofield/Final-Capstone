<template>

  <div id="capstone-app">
    <div id="header" class="header">
     <page-header/>
    </div>

    <div id="navBar" class="navBar">
  
      <nav-bar />
    </div>

    <div id="mainContent" class="mainContent">
      
      <main-content />
    </div>

    <div id="ads" class="ads">
      <sidebar-ads />
    </div>

    <div id="footer" class="footer">
      <bottom-footer />
    </div>

    
      
    
    
 
</div>
</template>

<script>
import SidebarAds from "./components/SidebarAds.vue";
import BottomFooter from "./components/BottomFooter.vue";
import NavBar from "./components/NavBar.vue";
import MainContent from "./components/MainContent.vue";
import PageHeader from "./components/PageHeader.vue";

export default {
  components: {
    BottomFooter,
    SidebarAds,
    NavBar,
    MainContent,
    PageHeader
  }

}

</script>

<style>
.capstone-app {
  font-family: "IM Fell DW Pica", serif;
  background: linear-gradient(to bottom right, #FFFFFF, #cecece, #979697);
}

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

.im-fell dw pica-regular {
  font-family: "IM Fell DW Pica", serif;
  font-weight: 400;
  font-style: normal;
}

.im-fell dw pica-regular-italic {
  font-family: "IM Fell DW Pica", serif;
  font-weight: 400;
  font-style: italic;
}


</style>

