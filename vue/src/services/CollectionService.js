import axios from 'axios';

const http = axios.create({
  baseURL: 'http://localhost:9000',
  setApiRequestDelayTime: 500
});

export default {
  
  getAllCollections() {
      return http.get('/collections');
    },
    getCardsByCollectionsId(collectionId) {
      return http.get(`/collections/${collectionId}/cards`);
  },
  addCardToCollection(cardCollection) {
    return http.post('/collections/cards/new');
  },
  
    
  
  }