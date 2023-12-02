import axios from 'axios'
import { config } from '../../Constants'
import { parseJwt } from './Helpers'

export const markothApi = {
  authenticate,
  signup,
  numberOfUsers,
  numberOfOrders,
  getUsers,
  deleteUser,
  getOrders,
  deleteOrder,
  createOrder,
  getUserMe
}

function authenticate(username, password) {
  return instance.post('/auth/login', { username, password }, {
    headers: { 'Content-type': 'application/json' }
  })
}

function signup(user) {
  return instance.post('/auth/signup', user, {
    headers: { 'Content-type': 'application/json' }
  })
}

function numberOfUsers() {
  return instance.get('/markoth/users/count')
}

function numberOfOrders() {
  return instance.get('/markoth/products/count')
}

function getUsers(user, username) {
  const url = username ? `/markoth/users/${username}` : '/markoth/users'
  return instance.get(url, {
    headers: { 'Authorization': bearerAuth(user) }
  })
}

function getUser(user, username) {
  const url = username ? `/markoth/users?username=${user.username}` : '/markoth/users'
  return instance.get(url, {
    headers: { 'Authorization': bearerAuth(user) }
  })
}


function deleteUser(user, username) {
  return instance.delete(`/markoth/users/${username}`, {
    headers: { 'Authorization': bearerAuth(user), 'Access-Control-Allow-Headers': '*' }
  })
}

function getOrders(user, text) {
  const url = '/markoth/products'
  return instance.get(url, {
    headers: { 'Authorization': bearerAuth(user) }
  })
}

function deleteOrder(user, orderId) {
  return instance.delete(`/markoth/orders/${orderId}`, {
    headers: { 'Authorization': bearerAuth(user) }
  })
}

function createOrder(user, order) {
  return instance.post('/markoth/orders', order, {
    headers: {
      'Content-type': 'application/json',
      'Authorization': bearerAuth(user)
    }
  })
}

function getUserMe(user) {
  return instance.get('/markoth/users/me', {
    headers: { 'Authorization': bearerAuth(user) }
  })
}

// -- Axios

const instance = axios.create({
  baseURL: config.url.API_BASE_URL
})

instance.interceptors.request.use(function (config) {
  // If token is expired, redirect user to login
  if (config.headers.Authorization) {
    const token = config.headers.Authorization.split(' ')[1]
    const data = parseJwt(token)
    // if (Date.now() > data.exp * 1000) {
      if (false) {
        window.location.href = "/login"
    }
  }
  return config
}, function (error) {
  return Promise.reject(error)
})

// -- Helper functions

function bearerAuth(user) {
  return `Bearer ${user.accessToken}`
}