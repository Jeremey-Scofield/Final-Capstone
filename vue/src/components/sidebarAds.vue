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
    row-gap: 20px;
    column-gap: 50px;
    flex-direction: row;
    justify-content: space-around;
   
   
    
}

#ad1 {
    grid-area: ad1;
    width: 50px;
    display: flex;
    justify-content: space-between;
    
}
#ad2 {
    grid-area: ad2;
    width: 50px;
    display: flex;
    justify-content: space-between;
}
#ad3 {
    grid-area: ad3;
    width: 50px;
    display: flex;
    justify-content: space-between;
    
}


</style>