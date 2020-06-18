import axios from 'axios'

// const instance = axios.create({
//     baseUrl: 'http://192.168.99.102:8080',
//     headers: {
//         'Access-Control-Allow-Origin': '*'
//     }
// })
const instance = axios.create();
instance.defaults.baseURL = 'http://192.168.99.102:8080';

export default instance