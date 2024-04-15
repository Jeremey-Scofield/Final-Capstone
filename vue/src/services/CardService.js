import axios from 'axios';

const http = axios.create({
  baseURL: 'https://api.scryfall.com',
  setApiRequestDelayTime: 500
});

export default {
  
  cardSearch(string) {
      return http.get(`/cards/search?q=${string}`);
    },
  random() {
      return http.get('/cards/random');
      }
  
  }