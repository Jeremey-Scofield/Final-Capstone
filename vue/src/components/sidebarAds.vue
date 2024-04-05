<template>
    <div class="container">
        <div class="ads">
            <img id="ad1" src="../images/among-us-logo.png">
            <img id="ad2" src="../images/Gelatinous-Cube.jpg">
            <img id="ad3" src="../images/Kroger-logo.jpg">
        </div>
    </div>


</template>


<script>


</script>

<style>

.container {
    display: grid;
    grid-template-rows: 1fr 1fr 1fr;
    row-gap: 20px;
    column-gap: 50px;
    align-items: center;
    grid-template-areas: 
    "ad1 ad2 ad3"
    ;
}

#ad1 {
    grid-area: ad1;
    width: 50px;
}
#ad2 {
    grid-area: ad2;
    width: 50px;
}
#ad3 {
    grid-area: ad3;
    width: 50px;
}


</style>