<template>
    <div class="sidebar-container">
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

.sidebar-container {
    display: flex;
    row-gap: 10px;
    column-gap: 10px;
    flex-direction: row;
    
}

#ad1 {
    grid-area: ad1;
    width: 100%;
    display: flex;
    
    
}
#ad2 {
    grid-area: ad2;
    width: 100%;
    display: flex;
    
}
#ad3 {
    grid-area: ad3;
    width: 100%;
    display: flex;
    
    
}


</style>