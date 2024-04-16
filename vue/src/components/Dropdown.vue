<!-- <template>
 <div id="random-card">
	<dropdown :on-click="changeCollection" :items='collection'></dropdown>
	<p>Currently selected collection: <span>{{activeCollection}}</span></p>
</div>
    <div>
		<button @click='toggleShow' class='anchor'>Add To Collection</button>
		<div v-if='showMenu' class='menu'>
			<div class='menu-item' v-for='item in this.items' @click='itemClicked(item)'>{{item}}</div>
		</div>
	</div>

    <script>
	data: function() {
		return {
			showMenu: false
		}
	},
	props: {
		onClick: 'function',
		items: {
			type: 'Object',
			default: []
		}
	},
	methods: {
		toggleShow: function() {
			this.showMenu = !this.showMenu;
		},
		itemClicked: function(item) {
			this.toggleShow();
			this.onClick(item);
		}
	}
const app = new Vue({
	el: '#random-card',
	data: {
		activeCollection: 'Collection 1',
		collection: [
			'Collection 1',
			'Collection 2',
			'Collection 3',
			'Collection 4'
		]
	},
	methods: {
		changeCollection: function(collection) {
			this.activeCollection = collection;
		}
	}
})
</script>
</template> -->