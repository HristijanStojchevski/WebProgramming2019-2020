import axios from '../custom-axios/axios'
import qs from 'qs'

const modelAndVehicleService = {
    fetchModels : () => {
        return axios.get("/api/rental/models")
    },
    fetchModelById : (modelId) => {
        return axios.get(`/api/rental/models/${modelId}`)
    },
    fetchAvailableVehicles : (dateStart,dateEnd,timeStart,timeEnd) => {
        return axios.get(`/api/rental/vehicles?dateStart=${dateStart}&dateEnd=${dateEnd}&timeStart${timeStart}&timeEnd=${timeEnd}`)
    }
}

export default modelAndVehicleService;