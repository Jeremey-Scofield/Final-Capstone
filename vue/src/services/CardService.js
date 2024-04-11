import axios from 'axios';

const http = axios.create({
  baseURL: 'https://api.scryfall.com'
});

export default {

    search(string) {
      return http.get('/cards/search');
    },
    random() {
        return http.get('/cards/random');
      }
  
  }