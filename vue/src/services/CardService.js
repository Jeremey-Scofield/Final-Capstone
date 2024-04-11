import axios from 'axios';

const http = axios.create({
  baseURL: 'https://api.scryfall.com'
});

export default {

    list(string) {
      return http.get('/cards/search');
    },
    random() {
        return http.get('/cards/random');
      }
  
  }