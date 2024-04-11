 <template>
  <h1>NavBar</h1>
  
  <!-- <router-link v-bind:to="{ name: 'card-sets' }" v-if="$store.state.token != ''">MyLinkHere</router-link> -->
  
  
  <router-link v-bind:to="{ name: 'view-my-collections' }" v-if="$store.state.token != ''">View My Collections</router-link> 

  <router-link v-bind:to="{ name: 'create-collection' }"  v-if="$store.state.token != ''">Create A Collection</router-link>

  <router-link v-bind:to="{ name: 'modify-collections' }"  v-if="$store.state.token != ''">Modify Collections</router-link>

</template> 

<script></script>

<style>



</style>
