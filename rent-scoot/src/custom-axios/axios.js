import axios from 'axios'

const instance = axios.create({
    baseUrl: 'http://localhost:8080',
    headers: {
        'Access-Control-Allow-Origin': '*'
    }
})

export default instance