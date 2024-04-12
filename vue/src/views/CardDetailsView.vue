<template>
    <h1>Card Details View</h1>
    <h2> These are the details of a single card.</h2>

    <div class="card" v-bind:key="card.id">
        <h3>{{ card.name }}</h3>
        <img v-bind:src="card.picture" class="picture" />
    </div>

    
    <p>***TODO: if you are logged in - add this card to one of your collections***</p>
    
    <h2>Card Details:</h2>

    <table style="width:50%">
        <tr>
            <th>Card Name:</th>
            <td>{{ card.card_name }}</td>
            <th>Rarity:</th>
            <td>{{ card.rarity }}</td>
        </tr>
        <tr>
            <th>Mana Cost:</th>
            <td>{{ card.manacost }}</td>
            <th>Set:</th>
            <td>{{ card.set }}</td>
        </tr>
        <tr>
            <th>Colors:</th>
            <td>{{ card.colors }}</td>
            <th>Set Name:</th>
            <td>{{ card.set_name }}</td>
        </tr>
        <tr>
            <th>ColorIdentity:</th>
            <td>{{ card.coloridentity }}</td>
            <th>Text:</th>
            <td>{{ card.text }}</td>
        </tr>
        <tr>
            <th>Type:</th>
            <td>{{ card.type }}</td>
        </tr><th>Artist:</th>
            <td>{{ card.artist }}</td>
        <tr>
            <th>Sub-Type:</th>
            <td>{{ card.subtype }}</td>
        </tr>
    </table>
</template>

<script>


</script>

<style></style>