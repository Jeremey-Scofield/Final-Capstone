import axios from 'axios';

const http = axios.create({
  baseURL: 'https://api.scryfall.com',
  setApiRequestDelayTime: 500
});

export default {
<<<<<<< HEAD

    search(string) {
=======
  
  list(string) {
    
>>>>>>> b653d6c0da73e5383efb0eb89c100c79f7aa49fc
      return http.get('/cards/search');
    },
    random() {
        return http.get('/cards/random');
      }
  
  }