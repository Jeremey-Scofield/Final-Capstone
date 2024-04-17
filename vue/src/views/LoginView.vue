<template>
  <div id="login">
    <form v-on:submit.prevent="login">
      <h1>Please Sign In</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="login-form">
        <div class="form-input-group" id="username">
          <label for="username">Username</label>
          <input type="text" v-model="user.username" required autofocus />
        </div>
        <div class="form-input-group" id="password">
          <label for="password">Password</label>
          <input type="password" v-model="user.password" required />
        </div>
        <div id="buttonDiv">
        <button type="submit">Sign in</button>
      </div>
      </div>
      <p>
        <router-link v-bind:to="{ name: 'register' }">Need an account? Sign up.</router-link>
      </p>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
.form-input-group {
  margin-bottom: 1rem;
}

label {
  margin-right: 0.5rem;
}
#buttonDiv {
  justify-content: center;
  display: flex;
  
}
button {
  min-height: 20px;
  min-width: 75px;
  display: flex;
  
vertical-align: middle;
}

h1 {
  font-size: 1em;
}

.login-form {
  display: flex;
  justify-content: flex-start;
  align-items: baseline;
  column-gap: 5px;

}

#username {
  margin-left: 5px;
display: flex;
}

#password {
  margin-left: 5px;
  margin-right: 5px;
  display: flex;
}

input {
  background: transparent;
  
}

</style>