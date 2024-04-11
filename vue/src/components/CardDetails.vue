<template>
    
    <h2>Card Details:</h2>

    <table>
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
export default {
    props: ['card']
  
  

}

</script>

<style></style>