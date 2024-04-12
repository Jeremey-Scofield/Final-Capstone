<template>
    <div class="container">
        <h1>View Collections</h1>
        <p>Collection 1</p>
        <p>Collection 2</p>
        <p>Collection 3</p>
        <p>Collection 4</p>
     <div class="myCollections" v-if="$store.state.token != ''">
        <h1>MY collections</h1>
         <p>My Collection 1</p>
         <p>My Collection 2</p>
    </div>

    </div>
</template>

<script>

</script>

<style scoped></style>