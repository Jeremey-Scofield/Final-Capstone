 <template>
  <h1>NavBar</h1>
  
  <div class="navLinks" v-if="$store.state.token != ''">
  
  <router-link v-bind:to="{ name: 'view-my-collections' }" >View My Collections</router-link> 
  <br />
  <router-link v-bind:to="{ name: 'create-collection' }" >Create A Collection</router-link>
  <br />
  <router-link v-bind:to="{ name: 'modify-collections' }" >Modify Collections</router-link>

</div>
</template> 

<script>


</script>

<style>



</style>
