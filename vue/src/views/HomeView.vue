<template>
  <div class="home">
   
    <!-- Todo-link username to welcome paragraph -->
    <!-- <p>Welcome {{ this.$store.state.user.username }} {{ this.$store.state.user.authorities[0].name }}</p>  -->
    <p>Welcome {{ this.$store.state.user.username }}!</p> 
  </div>
</template>

<script>
export default {
};
</script>

<style>
.home{
margin-left: 20px;
padding-left: 20px;
}

</style>
