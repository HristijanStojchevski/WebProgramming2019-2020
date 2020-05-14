import axios from '../custom-axios/axios'
//import qs from 'qs'

const LocationsService = {
    fetchLocations : () => {
        return axios.get("/api/rental/locations");
    },
    searchLocation : (term) => {
        return axios.get(`/api/rental/locations?term=${term}`)
    }
}

export default LocationsService;