<template>
    
    <div id="detailsHeader">
         <h2>Card Details:</h2>
    </div>

    <table>
        <tr>
            <th>Card Name:</th>
            <td>{{ card.name }}</td>
            <th>Rarity:</th>
            <td>{{ card.rarity }}</td>
        </tr>
        <tr>
            <th>Mana Cost:</th>
            <td>{{ card.mana_cost }}</td>
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
            <td>{{ card.color_identity }}</td>
            <th>Text:</th>
            <td>{{ card.oracle_text }}</td>
        </tr>
        <tr>
            <th>Type:</th>
            <td>{{ card.type_line }}</td>
        
            <th>Flavor Text:</th>
            <td>{{ card.flavor_text }}</td>
        </tr>
        <tr>
            <th>Artist:</th>
            <td>{{ card.artist }}</td>
        </tr>
    </table>
</template>

<script>
export default {
    props: ['card']
  
  

}

</script>

<style></style>