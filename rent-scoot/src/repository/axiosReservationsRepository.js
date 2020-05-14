import axios from '../custom-axios/axios'
import qs from 'qs'

const reservationsService = {
    fetchUserReservations : (userId) => {
        return axios.get(`/api/manage/reservations/${userId}`)
    },
    fetchReservationById : (reservationId) => {
        return axios.get(`/api/manage/reservations/${reservationId}`)
    },
    createReservation : (reservation) => {
        const data = {
            ...reservation //should be with the attributes of the same name as the endpoint form params
        }
        const formParams = qs.stringify(data);
        return axios.post("/api/rental/reservations",formParams, {
            headers: {
                'Content-Type' : 'application/x-www-form-urlencoded'
            }
        })
    }
}

export default reservationsService;