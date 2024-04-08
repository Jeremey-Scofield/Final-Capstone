<template>
  <div id="register" class="text-center">
    <form v-on:submit.prevent="register">
      <h1>Create Account</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="registration-container">
      <div class="form-input-username">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-email">
        <label for="emailAddress">Email Address</label>
        <input type="emailAddress" id="emailAddress" v-model="user.email" required />
      </div>
      <div class="form-input-password">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <div class="form-input-confirmpassword">
        <label for="confirmPassword">Confirm Password</label>
        <input type="password" id="confirmPassword" v-model="user.confirmPassword" required />
      </div>
      <button type="submit">Create Account</button>
      </div>
      <p><router-link v-bind:to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  data() {
    return {
      user: {
        username: '',
        email: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
.registration-container {
   display: grid;
   grid-template-columns: 1fr 1fr 1fr 1fr;
   grid-template-areas: 
   "username userinput email emailinput"
   "password passwordinput confirmpassword confirmpasswordinput"
   "button . . .";
   justify-items: start;
  
}
label {
  margin-right: 0.5rem;
  
  

}

.form-input-username >label{
grid-area: username;
}
.form-input-username >input{
grid-area: userinput;
background: transparent;

}
.form-input-email>label {
  grid-area: email;
}
.form-input-email>input {
  grid-area: emailinput;
  background: transparent;
}

.form-input-password> label{
  grid-area: password;
}
.form-input-password> input{
  grid-area: passwordinput;
  background: transparent;
  
}

.form-input-confirmpassword>label{
  grid-area: confirmpassword;
}
.form-input-confirmpassword>input{
  grid-area: confirmpasswordinput;
  background: transparent;
}
button{
  grid-area:button;
  margin-top: 10px;
  
}

h1 {
  font-size: 1em;
}

</style>
