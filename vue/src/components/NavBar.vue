 <template>
  <h1>NavBar</h1>
  
  <div class="navLinks" v-if="$store.state.token != ''">
  
  <router-link v-bind:to="{ name: 'view-my-collections' }" >View My Collections</router-link> 
  <br />
  <button v-on:click="showCollectionForm"> Create Collection </button>

  <div v-if="showCollectForm" id="createCollection">
    <div id="create-collection">
      <form v-on:submit.prevent="createCollection">
        <div>
          Name:<input type="text" id="collection_name" v-model="collection.collection_name" placeholder="Enter Your Collection's Name"/>

          ID: <input type="text" id="user_id" v-model="this.$store.state.user.id" disabled /> 
        </div>

        <button type="submit">Confirm Collection</button>
      </form>
    </div>
  </div>

  <br />


  </div>

  
</template> 

<script>
  import axios from 'axios';

  export default{
    methods: {
      showCollectionForm() {
        this.showCollectForm = !this.showCollectForm;
      },
      createCollection() {
        const collectionName = String(this.collection.collection_name).trim();
        const userId = Number(this.collection.user_id);

        console.log("hello");

        axios.post('http://localhost:9000/collections/new', {
          collectionName: collectionName,
          userId: userId
          }).then((response) => {
          console.log("hello");
          });

        this.collection.collection_name = "";

        this.showCollectForm = !this.showCollectForm;

      }
    },
    data() {
      return {
        showCollectForm: false,
        collection: {
          collection_name: "",
          user_id: this.$store.state.user.id
        }
      };
    }
  };


</script>

<style>



</style>
