 <template>
  
  
  <div class="navLinks" v-if="$store.state.token != ''">
  
  <button id="myCollections">View My Collections</button> 
  <br />
  <button id="createCollection" v-on:click="showCollectionForm"> Create Collection </button>


  <div v-if="showCollectForm" id="createCollection">
    <div id="create-collection">
      <form v-on:submit.prevent="createCollection">
        <div>
          Name:<input type="text" id="collection_name" v-model="collection.collection_name" placeholder="New Collection Name"/>

          <!-- ID: <input type="text" id="user_id" v-model="this.$store.state.user.id" disabled />  -->
        </div>

        <button type="submit">Confirm Collection</button>
      </form>
    </div>
  </div>

  <br />

  <div>
        <button v-on:click="deleteCollectionByCollectionId(selectedOption)">Delete Collection </button>
        <select v-model="selectedOption" :items="options">
            <option v-for="option in options" :key="option.id" :value="option.collectionId">
                {{ option.collectionName }} (ID: {{ option.collectionId }})
            </option>
        </select>
    </div>

  </div>
<img src="../images/mtgsymbols-removebg-preview.png" />
  
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
          })
          
          .then((response) => {
          console.log("hello");
          });

        this.collection.collection_name = "";

        this.showCollectForm = !this.showCollectForm;

      },
      getCollectionsByUserId() {
            axios.get(`http://localhost:9000/collections/user/${this.$store.state.user.id}`)
                .then(response => {
                    this.options = response.data;
                })
                .catch(error => {
                    console.error("Error fetching collections:", error.message);
                });
        },
        deleteCollectionByCollectionId(collectionId) {
          axios.delete(`http://localhost:9000/collections/delete/${collectionId}`);

          this.getCollectionsByUserId();

        }
    },
    data() {
      return {
        showCollectForm: false,
        collection: {
          collection_name: "",
          user_id: this.$store.state.user.id
        },
        options: [],
      };
    },
    created() {
      this.getCollectionsByUserId();
    }
  };


</script>

<style scoped>
button {
  margin: 5px;
  width: 140px;
  height: 30px;
  border-radius: 5px;
}
img {
  width: 150px;
  margin-left: auto;
  margin-right: auto;
  display: block;
}
#myCollections {
background-color: rgb(246, 220, 159);
}

#createCollection{
  background-color: rgb(90, 169, 62);
}


</style>
