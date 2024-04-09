<template>
  <div class="home">
   
    <!-- Todo-link username to welcome paragraph -->
    
    <p>Welcome {{ this.$store.state.user.username }} {{ this.$store.state.user.authorities[0].name }} </p> 
  </div>
</template>

<script>
export default {
};
</script>
