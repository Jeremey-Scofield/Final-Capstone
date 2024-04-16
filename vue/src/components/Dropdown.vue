<!-- <template>
 <div id="random-card">
	<dropdown :on-click="changeCollection" :items='collection'></dropdown>
	<p>Currently selected collection: <span>{{activeCollection}}</span></p>
</div>
    <div>
		<button v-on:click="toggleDropdown">Add To Collection</button>
        <select v-model="selectedOption" :items="options" v-if="showCollection">
          <option
            v-for="option in options"
            :key="option"
          >
            {{ option }}
          </option>
        </select>
	</div>
    </template>

    <script>
    export default {
        data: function () {
            return {
                showMenu: false,
                activeCollection: 'Collection 1',
                collection: [
                    'Collection 1',
                    'Collection 2',
                    'Collection 3',
                    'Collection 4'
                ]
            }
        },
        props: {
            onClick: function,
            items: {
                type: Object,
                default: []
            }
        },
        methods: {
            toggleShow: function () {
                this.showMenu = !this.showMenu;
            },
            changeCollection: function (collection) {
                this.activeCollection = collection;
            },
            itemClicked: function (item) {
                this.toggleShow();
                this.onClick(item);
            }
        }
    }
        // const app = new Vue({
        //             el: '#random-card',
        // data: {

        // },
//         methods: {
           
//         }
// }

    //     })
    // }
</script> -->
