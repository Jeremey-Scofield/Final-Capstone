<template>
  <div id="detailsHeader">
    <h2>Card Details:</h2>
  </div>
  <div id="card-details">
    <div id="card-name">Card Name:</div>
    <div id="card-text">{{ card.name }}</div>
    <div id="artist">Artist:</div>
    <div id="artist-text">{{ card.artist }}</div>
    <div id="mana-cost">Mana Cost:</div>
    <div id="mana-text">{{ card.mana_cost }}</div>
    <div id="rarity">Rarity:</div>
    <div id="rarity-text">{{ card.rarity }}</div>
    <div id="colors">Colors:</div>
    <div id="colors-text">{{ card.colors }}</div>
    <div id="set">Set Name:</div>
    <div id="set-text">{{ card.set_name }}</div>
    <div id="color-identity">ColorIdentity:</div>
    <div id="color-identity-text">{{ card.color_identity }}</div>
    <div id="type">Type:</div>
    <div id="type-text">{{ card.type_line }}</div>
    <div id="flavor">Flavor Text:</div>
    <div id="flavor-text">{{ card.flavor_text }}</div>
    <div id="text">Text:</div>
    <div id="text-text">{{ card.oracle_text }}</div>

    
  </div>
  <div id="toggleButton">
    <button v-on:click="toggleDropdown">Add To Collection</button>
    <select v-model="selectedOption" :items="options" v-if="showCollection" v-on:input="addToCollection">
      <option v-for="option in options" :key="option">
        {{ option }}
      </option>
    </select>
  </div>
</template>

<script>
export default {
  props: ["card"],
  methods: {
    toggleDropdown() {
      this.showCollection = !this.showCollection;
    },
    addToCollection() {
      this.addToCollection.push(this.selectedOption);

    }
  },
};

</script>

<style scoped>
#card-name {
  font-weight: bold;
  grid-area: card-name;
}
#card-text {
  grid-area: card-text;
}
#artist {
  font-weight: bold;
  grid-area: artist;
}
#artist-text {
  grid-area: artist-text;
}
#mana-cost {
  font-weight: bold;
  grid-area: mana-cost;
}
#mana-text {
  grid-area: mana-text;
}
#rarity {
  font-weight: bold;
  grid-area: rarity;
}
#rarity-text {
  grid-area: rarity-text;
}
#colors {
  font-weight: bold;
  grid-area: colors;
}
#colors-text {
  grid-area: colors-text;
}
#set {
  font-weight: bold;
  grid-area: set;
}
#set-text {
  grid-area: set-text;
}
#color-identity {
  font-weight: bold;
  grid-area: color-identity;
}
#color-identity-text {
  grid-area: color-identity-text;
}
#type {
  font-weight: bold;
  grid-area: type;
}
#type-text {
  grid-area: type-text;
}

#flavor {
  font-weight: bold;
  grid-area: flavor;
}
#flavor-text {
  grid-area: flavor-text;
}

#text {
  font-weight: bold;
  grid-area: text;
}

#text-text {
  grid-area: text-text;
}

#card-details {
  display: grid;
  grid-template-columns: auto;
  grid-template-areas:
    "card-name card-text"
    "artist artist-text"
    "mana-cost mana-text"
    "rarity rarity-text"
    "colors colors-text"
    "set set-text"
    "color-identity color-identity-text"
    "type type-text"
    "flavor flavor-text"
    "text text-text";
}


</style>
