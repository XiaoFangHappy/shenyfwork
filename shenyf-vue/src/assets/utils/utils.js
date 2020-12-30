import axios from 'axios'

const  utils = {
  axiosMethod: (config) => {
    axios({
      method: config.method,
      url: config.url,
      params: config.params ? config.params : null,
      data: config.data ? config.data : null,
    }).then(config.callback).catch(config.catch ? config.catch : () => {})
  }
}
const adminServer = axios.create({
  baseURL: process.env.ADMIN_SERVER
})
export  default  utils
